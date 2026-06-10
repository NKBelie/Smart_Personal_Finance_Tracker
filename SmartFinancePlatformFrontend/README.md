# SmartFinacePlatformFrontend

A separate React frontend for the Smart Finance Platform backend.

## Setup

1. Open the `SmartFinacePlatformFrontend` folder.
2. Run `npm install`.
3. Run `npm run dev`.

## Local development

The frontend uses Vite and proxies `/api` requests to `http://localhost:8080`.

- Register: `POST /api/auth/register`
- Login: `GET /api/auth/me` with HTTP Basic auth header

## Notes

The app is a starting point for a SPA with registration, login, and a simple dashboard.
