# File-system-Micro

## Services

Run the Eureka server first, then the services and API gateway:

| Service | Default port |
| --- | ---: |
| Eureka (`Eureka-client`) | 8761 |
| File service | 8081 |
| Folder service | 8082 |
| Search service | 8083 |
| API gateway | 8080 |

The gateway forwards `/api/files/**` to the file service and `/api/folders/**`
to the folder service. For example, use `GET /api/files` and
`GET /api/folders` through the gateway.

For deployments, set `EUREKA_SERVER_URL` on each Eureka client (including the
gateway) to the Eureka server's reachable URL ending in `/eureka/`. Services
use the platform-provided `PORT` when available and keep the defaults above for
local development.