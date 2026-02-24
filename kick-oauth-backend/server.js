import "dotenv/config";
import express from "express";
import rateLimit from "express-rate-limit";
import pino from "pino";
import pinoHttp from "pino-http";
import { z } from "zod";

const app = express();
const logger = pino({ level: process.env.LOG_LEVEL || "info" });

const PORT = Number(process.env.PORT || 8080);
const KICK_CLIENT_ID = process.env.KICK_CLIENT_ID;
const KICK_CLIENT_SECRET = process.env.KICK_CLIENT_SECRET;

if (!KICK_CLIENT_ID || !KICK_CLIENT_SECRET) {
  logger.error("KICK_CLIENT_ID and KICK_CLIENT_SECRET are required");
  process.exit(1);
}

app.disable("x-powered-by");
app.use(express.json({ limit: "32kb" }));
app.use(pinoHttp({ logger }));

const authLimiter = rateLimit({
  windowMs: 60_000,
  max: 120,
  standardHeaders: true,
  legacyHeaders: false,
});

app.use("/v1/kick/oauth", authLimiter);

const exchangeSchema = z.object({
  code: z.string().min(1),
  codeVerifier: z.string().min(43).max(128),
  redirectUri: z.string().url().refine((value) => value.startsWith("https://"), "redirectUri must be HTTPS"),
});

const refreshSchema = z.object({
  refreshToken: z.string().min(1),
});

const revokeSchema = z.object({
  token: z.string().min(1),
  tokenTypeHint: z.enum(["access_token", "refresh_token"]).optional(),
});

const introspectSchema = z.object({
  token: z.string().min(1),
});

function toForm(data) {
  const form = new URLSearchParams();
  for (const [key, value] of Object.entries(data)) {
    if (value !== undefined && value !== null && value !== "") {
      form.append(key, String(value));
    }
  }
  return form;
}

function mapKickOAuthError(body, status) {
  const raw = typeof body === "object" && body !== null ? body : {};
  const error = typeof raw.error === "string" ? raw.error : "oauth_error";
  const errorDescription =
    typeof raw.error_description === "string" ? raw.error_description : "Kick OAuth request failed";

  let code = "upstream_error";
  if (error === "invalid_grant") code = "invalid_grant";
  else if (error === "invalid_scope") code = "invalid_scope";
  else if (status >= 500) code = "upstream_unavailable";

  return {
    status,
    code,
    message: errorDescription,
  };
}

async function postKickForm(url, payload) {
  const response = await fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
      Accept: "application/json",
    },
    body: toForm(payload),
  });

  const text = await response.text();
  let parsed;
  try {
    parsed = text ? JSON.parse(text) : {};
  } catch {
    parsed = {};
  }

  if (!response.ok) {
    const mapped = mapKickOAuthError(parsed, response.status);
    const error = new Error(mapped.message);
    error.status = mapped.status;
    error.code = mapped.code;
    throw error;
  }

  return parsed;
}

app.get("/healthz", (_req, res) => {
  res.status(200).json({ ok: true });
});

app.post("/v1/kick/oauth/exchange", async (req, res) => {
  const parsed = exchangeSchema.safeParse(req.body);
  if (!parsed.success) {
    return res.status(400).json({ code: "invalid_request", message: parsed.error.issues[0]?.message || "Invalid payload" });
  }

  try {
    const data = await postKickForm("https://id.kick.com/oauth/token", {
      grant_type: "authorization_code",
      code: parsed.data.code,
      redirect_uri: parsed.data.redirectUri,
      code_verifier: parsed.data.codeVerifier,
      client_id: KICK_CLIENT_ID,
      client_secret: KICK_CLIENT_SECRET,
    });

    return res.status(200).json({
      access_token: data.access_token,
      refresh_token: data.refresh_token,
      expires_in: data.expires_in,
      token_type: data.token_type,
      scope: data.scope,
    });
  } catch (error) {
    req.log.warn({ err: { code: error.code, status: error.status, message: error.message } }, "exchange failed");
    return res.status(error.status || 502).json({ code: error.code || "upstream_error", message: error.message || "OAuth exchange failed" });
  }
});

app.post("/v1/kick/oauth/refresh", async (req, res) => {
  const parsed = refreshSchema.safeParse(req.body);
  if (!parsed.success) {
    return res.status(400).json({ code: "invalid_request", message: parsed.error.issues[0]?.message || "Invalid payload" });
  }

  try {
    const data = await postKickForm("https://id.kick.com/oauth/token", {
      grant_type: "refresh_token",
      refresh_token: parsed.data.refreshToken,
      client_id: KICK_CLIENT_ID,
      client_secret: KICK_CLIENT_SECRET,
    });

    return res.status(200).json({
      access_token: data.access_token,
      refresh_token: data.refresh_token,
      expires_in: data.expires_in,
      token_type: data.token_type,
      scope: data.scope,
    });
  } catch (error) {
    req.log.warn({ err: { code: error.code, status: error.status, message: error.message } }, "refresh failed");
    return res.status(error.status || 502).json({ code: error.code || "upstream_error", message: error.message || "OAuth refresh failed" });
  }
});

app.post("/v1/kick/oauth/revoke", async (req, res) => {
  const parsed = revokeSchema.safeParse(req.body);
  if (!parsed.success) {
    return res.status(400).json({ code: "invalid_request", message: parsed.error.issues[0]?.message || "Invalid payload" });
  }

  try {
    await postKickForm("https://id.kick.com/oauth/revoke", {
      token: parsed.data.token,
      token_type_hint: parsed.data.tokenTypeHint,
      client_id: KICK_CLIENT_ID,
      client_secret: KICK_CLIENT_SECRET,
    });

    return res.status(200).json({ revoked: true });
  } catch (error) {
    req.log.warn({ err: { code: error.code, status: error.status, message: error.message } }, "revoke failed");
    return res.status(error.status || 502).json({ code: error.code || "upstream_error", message: error.message || "OAuth revoke failed" });
  }
});

app.post("/v1/kick/oauth/introspect", async (req, res) => {
  const parsed = introspectSchema.safeParse(req.body);
  if (!parsed.success) {
    return res.status(400).json({ code: "invalid_request", message: parsed.error.issues[0]?.message || "Invalid payload" });
  }

  try {
    const data = await postKickForm("https://api.kick.com/public/v1/token/introspect", {
      token: parsed.data.token,
      client_id: KICK_CLIENT_ID,
      client_secret: KICK_CLIENT_SECRET,
    });

    return res.status(200).json({
      active: Boolean(data.active),
      exp: data.exp,
      client_id: data.client_id,
      user_id: data.user_id,
      username: data.username,
      scope: data.scope,
    });
  } catch (error) {
    req.log.warn({ err: { code: error.code, status: error.status, message: error.message } }, "introspect failed");
    return res.status(error.status || 502).json({ code: error.code || "upstream_error", message: error.message || "OAuth introspect failed" });
  }
});

app.use((err, req, res, _next) => {
  req.log.error({ err }, "unhandled error");
  return res.status(500).json({ code: "internal_error", message: "Unexpected server error" });
});

app.listen(PORT, () => {
  logger.info({ port: PORT }, "Kick OAuth backend running");
});
