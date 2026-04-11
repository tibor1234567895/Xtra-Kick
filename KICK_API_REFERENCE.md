# Kick Events and Channel Rewards Reference

This document consolidates the following Kick documentation into one practical reference:

- https://docs.kick.com/events/introduction
- https://docs.kick.com/events/webhook-security
- https://docs.kick.com/events/subscribe-to-events
- https://docs.kick.com/events/event-types
- https://docs.kick.com/apis/channel-rewards

It also cross-checks those pages against Kick's published OpenAPI spec:

- https://api.kick.com/swagger/doc.yaml

Where response bodies were not explicitly shown in the docs, the examples below are schema-based and marked as such.

## Base URLs

- OAuth authorization: `https://id.kick.com/oauth/authorize`
- OAuth token: `https://id.kick.com/oauth/token`
- Public API: `https://api.kick.com`
- OpenAPI spec: `https://api.kick.com/swagger/doc.yaml`

## What This Covers

- Webhook-based Events API
- Event subscription management
- Webhook security and signature verification
- Available event types and payloads
- Channel rewards CRUD and redemption management

## Auth Model

Kick uses OAuth 2.

### App Access Token

Use when your app acts as itself rather than as a specific user.

- Flow: client credentials
- Token URL: `https://id.kick.com/oauth/token`
- OpenAPI security name: `AppAccessToken`
- Can be used for:
  - reading event subscriptions
  - creating event subscriptions
  - deleting event subscriptions
  - reading public-key endpoint does not require auth

Important event-subscription rule:

- When using an app access token, `broadcaster_user_id` is required in the subscription create request body.

Example token request:

```bash
curl -X POST "https://id.kick.com/oauth/token" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  --data-urlencode "grant_type=client_credentials" \
  --data-urlencode "client_id=YOUR_CLIENT_ID" \
  --data-urlencode "client_secret=YOUR_CLIENT_SECRET"
```

Expected token response:

```json
{
  "access_token": "2YotnFZFEjr1zCsicMWpAA",
  "token_type": "Bearer",
  "expires_in": 3600,
  "refresh_token": "tGzv3JOkF0XG5Qx2TlKWIA"
}
```

### User Access Token

Use when acting on behalf of a Kick user.

- Flow: authorization code with PKCE
- Authorization URL: `https://id.kick.com/oauth/authorize`
- Token URL: `https://id.kick.com/oauth/token`
- OpenAPI security name: `UserAccessToken`

Relevant scopes from Kick's spec:

- `events:subscribe`
- `channel:rewards:read`
- `channel:rewards:write`
- `user:read`
- `channel:read`
- `channel:write`
- `chat:write`
- `moderation:ban`
- `moderation:chat_message:manage`
- `kicks:read`
- `streamkey:read`

Important event-subscription rule:

- When using a user access token, `broadcaster_user_id` in the create-subscription body is ignored and inferred from the token.

Example authorize request shape:

```text
GET https://id.kick.com/oauth/authorize
  ?response_type=code
  &client_id=YOUR_CLIENT_ID
  &redirect_uri=https://your-app.example.com/callback
  &scope=events:subscribe channel:rewards:read channel:rewards:write
  &state=RANDOM_CSRF_VALUE
  &code_challenge=PKCE_CHALLENGE
  &code_challenge_method=S256
```

Example token exchange:

```bash
curl -X POST "https://id.kick.com/oauth/token" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  --data-urlencode "grant_type=authorization_code" \
  --data-urlencode "client_id=YOUR_CLIENT_ID" \
  --data-urlencode "client_secret=YOUR_CLIENT_SECRET" \
  --data-urlencode "code=AUTH_CODE" \
  --data-urlencode "redirect_uri=https://your-app.example.com/callback"
```

## Webhook Setup

Kick event delivery is webhook-based.

Configuration happens in the Kick developer settings for your app:

- Go to `https://kick.com/settings/developer`
- Edit the application
- Enable webhooks
- Enter a publicly reachable webhook URL

Constraints:

- The webhook URL must be publicly accessible
- `localhost` is not valid unless exposed through something like ngrok or Cloudflare Tunnel

Kick sends event payloads as `POST` requests to that webhook URL.

## Webhook Headers

Kick documents these request headers on event delivery:

| Header | Type | Meaning |
| --- | --- | --- |
| `Kick-Event-Message-Id` | ULID | Unique message ID; use as an idempotency key |
| `Kick-Event-Subscription-Id` | ULID | The event subscription that triggered the webhook |
| `Kick-Event-Signature` | Base64 string | Signature used to verify the sender |
| `Kick-Event-Message-Timestamp` | RFC3339 datetime | When Kick sent the event |
| `Kick-Event-Type` | string | Event name such as `chat.message.sent` |
| `Kick-Event-Version` | string | Event version such as `1` |

## Webhook Security

Kick signs webhook requests. Validation uses the `Kick-Event-Signature` header plus Kick's public key.

### Public Key

Kick publishes the key in docs and via API:

- Endpoint: `GET https://api.kick.com/public/v1/public-key`

Expected response:

```json
{
  "message": "OK",
  "data": {
    "public_key": "-----BEGIN PUBLIC KEY-----\n...\n-----END PUBLIC KEY-----"
  }
}
```

### Signature Input

Kick states the signature is created from:

1. `Kick-Event-Message-Id`
2. `Kick-Event-Message-Timestamp`
3. Raw request body

Joined as:

```text
{message_id}.{timestamp}.{raw_body}
```

Do not reserialize parsed JSON before verification. Use the raw body bytes exactly as received.

### Verification Flow

1. Read raw request body
2. Read `Kick-Event-Message-Id`
3. Read `Kick-Event-Message-Timestamp`
4. Build `{id}.{timestamp}.{rawBody}`
5. Base64-decode `Kick-Event-Signature`
6. Verify the signature with the Kick public key
7. Reject requests with invalid signatures
8. Also deduplicate on `Kick-Event-Message-Id`

### Node Example

```js
import crypto from "node:crypto";

export function verifyKickWebhook({
  publicKeyPem,
  messageId,
  timestamp,
  rawBody,
  signatureBase64,
}) {
  const signedPayload = Buffer.from(
    `${messageId}.${timestamp}.${rawBody}`,
    "utf8",
  );

  const signature = Buffer.from(signatureBase64, "base64");

  return crypto.verify(
    "RSA-SHA256",
    signedPayload,
    publicKeyPem,
    signature,
  );
}
```

### Reliability Rule

Kick notes that if a webhook keeps failing to process an event for over a day, Kick automatically unsubscribes the app from that event. The app must then resubscribe.

## Events API

The subscriptions endpoint manages which events Kick sends to your webhook.

Endpoint family:

- `GET /public/v1/events/subscriptions`
- `POST /public/v1/events/subscriptions`
- `DELETE /public/v1/events/subscriptions`

## Event Types

Kick currently documents the following event names, all at version `1`:

| Event name | Version | Description |
| --- | --- | --- |
| `chat.message.sent` | 1 | A chat message was sent |
| `channel.followed` | 1 | A user followed the channel |
| `channel.subscription.renewal` | 1 | A subscription renewed |
| `channel.subscription.gifts` | 1 | Gifted subscriptions occurred |
| `channel.subscription.new` | 1 | A new subscription was created |
| `channel.reward.redemption.updated` | 1 | A reward redemption changed state |
| `livestream.status.updated` | 1 | Stream started or ended |
| `livestream.metadata.updated` | 1 | Stream metadata changed |
| `moderation.banned` | 1 | A user was banned or timed out |
| `kicks.gifted` | 1 | Kicks were gifted |

## Get Event Subscriptions

- Method: `GET`
- URL: `https://api.kick.com/public/v1/events/subscriptions`
- Auth:
  - `UserAccessToken`
  - `AppAccessToken`
- Scope:
  - none explicitly required in the schema for reads
- Query params:
  - `broadcaster_user_id` optional integer filter

Example:

```bash
curl "https://api.kick.com/public/v1/events/subscriptions?broadcaster_user_id=123" \
  -H "Authorization: Bearer YOUR_TOKEN"
```

Expected success response:

```json
{
  "message": "OK",
  "data": [
    {
      "id": "01HZ8X9K2M4N6P8Q0R2S4T6V8W0Y2Z4",
      "app_id": "01J9K2M4N6P8Q0R2S4T6V8W0Y2Z4A6B8",
      "broadcaster_user_id": 123,
      "event": "chat.message.sent",
      "version": 1,
      "method": "webhook",
      "created_at": "2021-01-01T00:00:00Z",
      "updated_at": "2021-01-01T00:00:00Z"
    }
  ]
}
```

Documented response codes:

- `200` OK
- `400` Bad Request
- `401` Unauthorized
- `403` Forbidden
- `500` Internal Server Error

## Create Event Subscriptions

- Method: `POST`
- URL: `https://api.kick.com/public/v1/events/subscriptions`
- Auth:
  - `UserAccessToken` with `events:subscribe`
  - `AppAccessToken`
- Content type: `application/json`
- Notes:
  - subscription limit is `10,000` per event type for a single app
  - for `chat.message.sent`, unverified apps are limited to `1,000`

Request body:

| Field | Type | Required | Notes |
| --- | --- | --- | --- |
| `broadcaster_user_id` | integer | conditional | required for app tokens; ignored for user tokens |
| `events` | array | yes | array of `{ name, version }` |
| `method` | string | no | only documented value is `webhook` |

Example with app token:

```bash
curl -X POST "https://api.kick.com/public/v1/events/subscriptions" \
  -H "Authorization: Bearer YOUR_APP_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "broadcaster_user_id": 123,
    "method": "webhook",
    "events": [
      { "name": "chat.message.sent", "version": 1 },
      { "name": "channel.followed", "version": 1 },
      { "name": "channel.reward.redemption.updated", "version": 1 }
    ]
  }'
```

Expected success response:

```json
{
  "message": "OK",
  "data": [
    {
      "name": "chat.message.sent",
      "version": 1,
      "subscription_id": "01HZ8X9K2M4N6P8Q0R2S4T6V8W0Y2Z4"
    },
    {
      "name": "channel.followed",
      "version": 1,
      "subscription_id": "01HZ8X9K2M4N6P8Q0R2S4T6V8W0Y2Z5"
    },
    {
      "name": "channel.reward.redemption.updated",
      "version": 1,
      "subscription_id": "01HZ8X9K2M4N6P8Q0R2S4T6V8W0Y2Z6"
    }
  ]
}
```

If an individual subscription item fails, Kick's schema indicates an `error` field may be present on that item:

```json
{
  "name": "chat.message.sent",
  "version": 1,
  "error": "subscription limit reached"
}
```

Documented response codes:

- `200` OK
- `400` Bad Request
- `401` Unauthorized
- `403` Forbidden
- `500` Internal Server Error

## Delete Event Subscriptions

- Method: `DELETE`
- URL: `https://api.kick.com/public/v1/events/subscriptions`
- Auth:
  - `UserAccessToken` with `events:subscribe`
  - `AppAccessToken`
- Query params:
  - `id` required, repeatable

Example:

```bash
curl -X DELETE "https://api.kick.com/public/v1/events/subscriptions?id=01HZ8X9K2M4N6P8Q0R2S4T6V8W0Y2Z4&id=01HZ8X9K2M4N6P8Q0R2S4T6V8W0Y2Z5" \
  -H "Authorization: Bearer YOUR_TOKEN"
```

Expected success response:

- HTTP `204 No Content`

Documented response codes:

- `204` No Content
- `400` Bad Request
- `401` Unauthorized
- `403` Forbidden
- `500` Internal Server Error

## Webhook Payload Examples

The payloads in this section are based on Kick's event docs. All webhook deliveries also include:

- `Kick-Event-Type`
- `Kick-Event-Version`
- `Kick-Event-Message-Id`
- `Kick-Event-Subscription-Id`
- `Kick-Event-Message-Timestamp`
- `Kick-Event-Signature`

### `chat.message.sent`

Purpose:

- Fired when a message is sent in stream chat

Example payload:

```json
{
  "message_id": "unique_message_id_123",
  "replies_to": {
    "message_id": "unique_message_id_456",
    "content": "This is the parent message!",
    "sender": {
      "is_anonymous": false,
      "user_id": 12345,
      "username": "parent_sender_name",
      "is_verified": false,
      "profile_picture": "https://example.com/parent_sender_avatar.jpg",
      "channel_slug": "parent_sender_channel",
      "identity": null
    }
  },
  "broadcaster": {
    "is_anonymous": false,
    "user_id": 123456789,
    "username": "broadcaster_name",
    "is_verified": true,
    "profile_picture": "https://example.com/broadcaster_avatar.jpg",
    "channel_slug": "broadcaster_channel",
    "identity": null
  },
  "sender": {
    "is_anonymous": false,
    "user_id": 987654321,
    "username": "sender_name",
    "is_verified": false,
    "profile_picture": "https://example.com/sender_avatar.jpg",
    "channel_slug": "sender_channel",
    "identity": {
      "username_color": "#FF5733",
      "badges": [
        { "text": "Moderator", "type": "moderator" },
        { "text": "Sub Gifter", "type": "sub_gifter", "count": 5 },
        { "text": "Subscriber", "type": "subscriber", "count": 3 }
      ]
    }
  },
  "content": "Hello [emote:4148074:HYPERCLAP]",
  "emotes": [
    {
      "emote_id": "4148074",
      "positions": [{ "s": 6, "e": 30 }]
    }
  ],
  "created_at": "2025-01-14T16:08:06Z"
}
```

### `channel.followed`

Purpose:

- Fired when a user follows a channel

Example payload:

```json
{
  "broadcaster": {
    "is_anonymous": false,
    "user_id": 123456789,
    "username": "broadcaster_name",
    "is_verified": true,
    "profile_picture": "https://example.com/broadcaster_avatar.jpg",
    "channel_slug": "broadcaster_channel",
    "identity": null
  },
  "follower": {
    "is_anonymous": false,
    "user_id": 987654321,
    "username": "follower_name",
    "is_verified": false,
    "profile_picture": "https://example.com/sender_avatar.jpg",
    "channel_slug": "follower_channel",
    "identity": null
  }
}
```

### `channel.subscription.renewal`

Purpose:

- Fired when a subscription renews

Example payload:

```json
{
  "broadcaster": { "user_id": 123456789, "username": "broadcaster_name" },
  "subscriber": { "user_id": 987654321, "username": "subscriber_name" },
  "duration": 3,
  "created_at": "2025-01-14T16:08:06Z",
  "expires_at": "2025-02-14T16:08:06Z"
}
```

### `channel.subscription.gifts`

Purpose:

- Fired when subscriptions are gifted

Example payload:

```json
{
  "broadcaster": { "user_id": 123456789, "username": "broadcaster_name" },
  "gifter": {
    "is_anonymous": false,
    "user_id": 987654321,
    "username": "gifter_name",
    "is_verified": false,
    "profile_picture": "https://example.com/sender_avatar.jpg",
    "channel_slug": "gifter_channel",
    "identity": null
  },
  "giftees": [
    {
      "is_anonymous": false,
      "user_id": 561654654,
      "username": "giftee_name",
      "is_verified": true,
      "profile_picture": "https://example.com/broadcaster_avatar.jpg",
      "channel_slug": "giftee_channel",
      "identity": null
    }
  ],
  "created_at": "2025-01-14T16:08:06Z",
  "expires_at": "2025-02-14T16:08:06Z"
}
```

### `channel.subscription.new`

Purpose:

- Fired on first subscription

Example payload:

```json
{
  "broadcaster": { "user_id": 123456789, "username": "broadcaster_name" },
  "subscriber": { "user_id": 987654321, "username": "subscriber_name" },
  "duration": 1,
  "created_at": "2025-01-14T16:08:06Z",
  "expires_at": "2025-02-14T16:08:06Z"
}
```

### `channel.reward.redemption.updated`

Purpose:

- Fired when a channel reward redemption changes

Status values:

- `pending`
- `accepted`
- `rejected`

Example payload:

```json
{
  "id": "01KBHE78QE4HZY1617DK5FC7YD",
  "user_input": "unban me",
  "status": "rejected",
  "redeemed_at": "2025-12-02T22:54:19.323Z",
  "reward": {
    "id": "01KBHE7RZNHB0SKDV1H86CD4F3",
    "title": "Unban Request",
    "cost": 1000,
    "description": "Only good reasons pls"
  },
  "redeemer": {
    "user_id": 123,
    "username": "naughty-user",
    "is_verified": false,
    "profile_picture": "",
    "channel_slug": "naughty_user"
  },
  "broadcaster": {
    "user_id": 333,
    "username": "gigachad",
    "is_verified": true,
    "profile_picture": "",
    "channel_slug": "gigachad"
  }
}
```

### `livestream.status.updated`

Purpose:

- Fired when stream state changes

Example payloads:

```json
{
  "broadcaster": { "user_id": 123456789, "username": "broadcaster_name" },
  "is_live": true,
  "title": "Stream Title",
  "started_at": "2025-01-01T11:00:00+11:00",
  "ended_at": null
}
```

```json
{
  "broadcaster": { "user_id": 123456789, "username": "broadcaster_name" },
  "is_live": false,
  "title": "Stream Title",
  "started_at": "2025-01-01T11:00:00+11:00",
  "ended_at": "2025-01-01T15:00:00+11:00"
}
```

### `livestream.metadata.updated`

Purpose:

- Fired when title, language, mature flag, or category changes

Example payload:

```json
{
  "broadcaster": { "user_id": 123456789, "username": "broadcaster_name" },
  "metadata": {
    "title": "Stream Title",
    "language": "en",
    "has_mature_content": true,
    "category": {
      "id": 123,
      "name": "Category name",
      "thumbnail": "http://example.com/image123"
    }
  }
}
```

### `moderation.banned`

Purpose:

- Fired when a user is banned or timed out

Example payload:

```json
{
  "broadcaster": { "user_id": 123456789, "username": "broadcaster_name" },
  "moderator": { "user_id": 987654321, "username": "moderator_name" },
  "banned_user": { "user_id": 135790135, "username": "banned_user_name" },
  "metadata": {
    "reason": "banned reason",
    "created_at": "2025-01-14T16:08:05Z",
    "expires_at": "2025-01-14T16:10:06Z"
  }
}
```

`expires_at` may be `null` for permanent bans.

### `kicks.gifted`

Purpose:

- Fired when a user gifts Kicks to a channel

Example payload:

```json
{
  "broadcaster": {
    "user_id": 123456789,
    "username": "broadcaster_name",
    "is_verified": true,
    "profile_picture": "https://example.com/broadcaster_avatar.jpg",
    "channel_slug": "broadcaster_channel"
  },
  "sender": {
    "user_id": 987654321,
    "username": "gift_sender",
    "is_verified": false,
    "profile_picture": "https://example.com/sender_avatar.jpg",
    "channel_slug": "gift_sender_channel"
  },
  "gift": {
    "amount": 500,
    "name": "Rage Quit",
    "type": "LEVEL_UP",
    "tier": "MID",
    "message": "w",
    "pinned_time_seconds": 600
  },
  "created_at": "2025-10-20T04:00:08.634Z"
}
```

## Channel Rewards API

This section comes from Kick's `channel-rewards` docs and OpenAPI schema.

Endpoints:

- `GET /public/v1/channels/rewards`
- `POST /public/v1/channels/rewards`
- `PATCH /public/v1/channels/rewards/{id}`
- `DELETE /public/v1/channels/rewards/{id}`
- `GET /public/v1/channels/rewards/redemptions`
- `POST /public/v1/channels/rewards/redemptions/accept`
- `POST /public/v1/channels/rewards/redemptions/reject`

## Reward Object

Kick's reward schema includes:

| Field | Type | Notes |
| --- | --- | --- |
| `id` | ULID string | reward id |
| `title` | string | max 50 on create/update |
| `description` | string | max 200 on create/update |
| `cost` | integer | minimum 1 |
| `background_color` | hex string | example `#00e701` |
| `is_enabled` | boolean | whether reward is enabled |
| `is_paused` | boolean | returned on reward object |
| `is_user_input_required` | boolean | whether user input is required |
| `should_redemptions_skip_request_queue` | boolean | immediate queue bypass behavior |

## Get Channel Rewards

- Method: `GET`
- URL: `https://api.kick.com/public/v1/channels/rewards`
- Auth:
  - `UserAccessToken`
- Required scopes:
  - `channel:rewards:read` or `channel:rewards:write`

Example:

```bash
curl "https://api.kick.com/public/v1/channels/rewards" \
  -H "Authorization: Bearer YOUR_USER_TOKEN"
```

Expected success response:

```json
{
  "message": "OK",
  "data": [
    {
      "id": "01HZ8X9K2M4N6P8Q0R2S4T6V8W0Y2Z4",
      "title": "Song Request",
      "description": "Request a song by providing a URL",
      "cost": 100,
      "background_color": "#00e701",
      "is_enabled": true,
      "is_paused": false,
      "is_user_input_required": false,
      "should_redemptions_skip_request_queue": false
    }
  ]
}
```

Documented response codes:

- `200` OK
- `400` Bad Request
- `401` Unauthorized
- `500` Internal Server Error

## Create Channel Reward

- Method: `POST`
- URL: `https://api.kick.com/public/v1/channels/rewards`
- Auth:
  - `UserAccessToken`
- Required scope:
  - `channel:rewards:write`

Request body:

| Field | Type | Required | Notes |
| --- | --- | --- | --- |
| `title` | string | yes | max 50 |
| `cost` | integer | yes | minimum 1 |
| `description` | string | no | max 200 |
| `background_color` | string | no | default `#00e701` |
| `is_enabled` | boolean | no | default `true` |
| `is_user_input_required` | boolean | no | default `false` |
| `should_redemptions_skip_request_queue` | boolean | no | default `false` |

Example:

```bash
curl -X POST "https://api.kick.com/public/v1/channels/rewards" \
  -H "Authorization: Bearer YOUR_USER_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Song Request",
    "cost": 100,
    "description": "Request a song by providing a URL",
    "background_color": "#fff111",
    "is_enabled": true,
    "is_user_input_required": true,
    "should_redemptions_skip_request_queue": false
  }'
```

Expected success response:

```json
{
  "message": "OK",
  "data": {
    "id": "01HZ8X9K2M4N6P8Q0R2S4T6V8W0Y2Z4",
    "title": "Song Request",
    "description": "Request a song by providing a URL",
    "cost": 100,
    "background_color": "#fff111",
    "is_enabled": true,
    "is_paused": false,
    "is_user_input_required": true,
    "should_redemptions_skip_request_queue": false
  }
}
```

Documented response codes:

- `200` OK
- `400` Bad Request
- `401` Unauthorized
- `500` Internal Server Error

## Update Channel Reward

- Method: `PATCH`
- URL: `https://api.kick.com/public/v1/channels/rewards/{id}`
- Auth:
  - `UserAccessToken`
- Required scope:
  - `channel:rewards:write`

Kick notes only the app that created the reward can update it.

Request body fields are all optional:

- `title`
- `cost`
- `description`
- `background_color`
- `is_enabled`
- `is_paused`
- `is_user_input_required`
- `should_redemptions_skip_request_queue`

Example:

```bash
curl -X PATCH "https://api.kick.com/public/v1/channels/rewards/01HZ8X9K2M4N6P8Q0R2S4T6V8W0Y2Z4" \
  -H "Authorization: Bearer YOUR_USER_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Updated Title",
    "description": "Updated description",
    "cost": 250,
    "is_paused": true
  }'
```

Expected success response:

```json
{
  "message": "OK",
  "data": {
    "id": "01HZ8X9K2M4N6P8Q0R2S4T6V8W0Y2Z4",
    "title": "Updated Title",
    "description": "Updated description",
    "cost": 250,
    "background_color": "#00e701",
    "is_enabled": true,
    "is_paused": true,
    "is_user_input_required": false,
    "should_redemptions_skip_request_queue": false
  }
}
```

Documented response codes:

- `200` OK
- `400` Bad Request
- `401` Unauthorized
- `500` Internal Server Error

## Delete Channel Reward

- Method: `DELETE`
- URL: `https://api.kick.com/public/v1/channels/rewards/{id}`
- Auth:
  - `UserAccessToken`
- Required scope:
  - `channel:rewards:write`

Kick notes only the app that created the reward can delete it.

Example:

```bash
curl -X DELETE "https://api.kick.com/public/v1/channels/rewards/01HZ8X9K2M4N6P8Q0R2S4T6V8W0Y2Z4" \
  -H "Authorization: Bearer YOUR_USER_TOKEN"
```

Expected success response:

- HTTP `200` with standard message/data wrapper, or `204` depending on future implementation. The OpenAPI-backed docs page advertises operation success but does not show an explicit example body.

Documented response codes:

- `200` OK
- `400` Bad Request
- `401` Unauthorized
- `500` Internal Server Error

## Get Channel Reward Redemptions

- Method: `GET`
- URL: `https://api.kick.com/public/v1/channels/rewards/redemptions`
- Auth:
  - `UserAccessToken`
- Required scopes:
  - `channel:rewards:read` or `channel:rewards:write`

Query params:

| Param | Type | Required | Notes |
| --- | --- | --- | --- |
| `reward_id` | ULID | no | filter by reward |
| `status` | string | no | `pending`, `accepted`, `rejected` |
| `id` | array of ULID | no | if used, cannot be combined with other filters |
| `cursor` | base64 string | no | pagination |

Example:

```bash
curl "https://api.kick.com/public/v1/channels/rewards/redemptions?reward_id=01KCTMJ2X3DXT814CVX8FR9T1D&status=pending" \
  -H "Authorization: Bearer YOUR_USER_TOKEN"
```

Expected success response:

```json
{
  "message": "OK",
  "data": [
    {
      "reward": {
        "id": "01KCTMJ2X3DXT814CVX8FR9T1D",
        "title": "Unban Request",
        "description": "Request to have your ban lifted",
        "cost": 100,
        "can_manage": true
      },
      "redemptions": [
        {
          "id": "01KCTMJ2X3DXT814CVX8FR9T1E",
          "redeemed_at": "2025-12-19T06:26:36Z",
          "redeemer": {
            "user_id": 123
          },
          "status": "pending",
          "user_input": "sorry mr strimer"
        }
      ]
    }
  ],
  "pagination": {
    "next_cursor": "BASE64_CURSOR"
  }
}
```

Documented response codes:

- `200` OK
- `400` Bad Request
- `401` Unauthorized
- `500` Internal Server Error

## Accept Channel Reward Redemptions

- Method: `POST`
- URL: `https://api.kick.com/public/v1/channels/rewards/redemptions/accept`
- Auth:
  - `UserAccessToken`
- Required scope:
  - `channel:rewards:write`

Request body:

```json
{
  "ids": [
    "01KEWZ2RKYZZFGD154K50Y3F8D",
    "01KEWZ2YC27070XWMHKFJR6C87"
  ]
}
```

Rules:

- max 25 redemption ids per request
- ids must be unique

Example:

```bash
curl -X POST "https://api.kick.com/public/v1/channels/rewards/redemptions/accept" \
  -H "Authorization: Bearer YOUR_USER_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "ids": [
      "01KEWZ2RKYZZFGD154K50Y3F8D",
      "01KEWZ2YC27070XWMHKFJR6C87"
    ]
  }'
```

Expected success response:

- Kick states the response only includes redemptions that failed to be accepted.

```json
{
  "message": "OK",
  "data": [
    {
      "id": "01KERB68MZZ04551D6X5TNRFYV",
      "reason": "NOT_OWNED"
    }
  ]
}
```

Failure reason enum from schema:

- `UNKNOWN`
- `NOT_PENDING`
- `NOT_FOUND`
- `NOT_OWNED`

If all requested redemptions succeed, expect:

```json
{
  "message": "OK",
  "data": []
}
```

## Reject Channel Reward Redemptions

- Method: `POST`
- URL: `https://api.kick.com/public/v1/channels/rewards/redemptions/reject`
- Auth:
  - `UserAccessToken`
- Required scope:
  - `channel:rewards:write`

Request body:

```json
{
  "ids": [
    "01KEWZ2RKYZZFGD154K50Y3F8D",
    "01KEWZ2YC27070XWMHKFJR6C87"
  ]
}
```

Rules:

- max 25 redemption ids per request
- ids must be unique

Example:

```bash
curl -X POST "https://api.kick.com/public/v1/channels/rewards/redemptions/reject" \
  -H "Authorization: Bearer YOUR_USER_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "ids": [
      "01KEWZ2RKYZZFGD154K50Y3F8D",
      "01KEWZ2YC27070XWMHKFJR6C87"
    ]
  }'
```

Expected success response:

- Same pattern as accept: only failed rejects are returned

```json
{
  "message": "OK",
  "data": [
    {
      "id": "01KERB68MZZ04551D6X5TNRFYV",
      "reason": "NOT_PENDING"
    }
  ]
}
```

If all requested redemptions succeed, expect:

```json
{
  "message": "OK",
  "data": []
}
```

## Common Response Shapes

Kick's spec commonly wraps JSON responses like this:

```json
{
  "message": "OK",
  "data": {}
}
```

Or:

```json
{
  "message": "OK",
  "data": [],
  "pagination": {
    "next_cursor": "..."
  }
}
```

Error responses are commonly documented as:

```json
{
  "message": "Bad Request",
  "data": {}
}
```

Exact error payloads may vary by endpoint.

## Practical Usage Summary

### If You Want Real-Time Channel Events

1. Configure a public webhook URL in Kick developer settings
2. Obtain either an app token or user token
3. Create subscriptions with `POST /public/v1/events/subscriptions`
4. Verify every webhook with `Kick-Event-Signature`
5. Deduplicate using `Kick-Event-Message-Id`
6. Resubscribe if Kick disables subscriptions after repeated webhook failures

### If You Want To Manage Channel Rewards

1. Obtain a user access token
2. Request `channel:rewards:read` and/or `channel:rewards:write`
3. Use reward CRUD endpoints
4. Use redemption list plus accept/reject endpoints
5. Optionally subscribe to `channel.reward.redemption.updated` for realtime changes

## Notes and Caveats

- The docs are explicit that reward update/delete is restricted to the app that created the reward.
- The events docs are more detailed for payload examples than the OpenAPI schema.
- Some response examples in this file are inferred from Kick's published schema where the docs did not include full example bodies.
- Delete reward response shape is the least explicit area in the published docs; verify against a live integration if you need exact production behavior there.

## Sources

- https://docs.kick.com/events/introduction
- https://docs.kick.com/events/webhook-security
- https://docs.kick.com/events/subscribe-to-events
- https://docs.kick.com/events/event-types
- https://docs.kick.com/apis/channel-rewards
- https://api.kick.com/swagger/doc.yaml
