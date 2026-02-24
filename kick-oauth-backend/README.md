# Kick OAuth Backend Proxy

Minimal OAuth proxy for Kick token operations.

## Endpoints
- `GET /healthz`
- `POST /v1/kick/oauth/exchange`
- `POST /v1/kick/oauth/refresh`
- `POST /v1/kick/oauth/revoke`
- `POST /v1/kick/oauth/introspect`

## Setup
1. Copy `.env.example` to `.env` and fill values.
2. Install dependencies: `npm install`
3. Start server: `npm start`

## Notes
- Keep `KICK_CLIENT_SECRET` only on backend.
- Configure Kick dev dashboard redirect URI to `https://localhost/callback`.
