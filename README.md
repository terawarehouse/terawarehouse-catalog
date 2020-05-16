[![patreon](https://c5.patreon.com/external/logo/become_a_patron_button.png)](https://www.patreon.com/bePatron?u=12280211)
[![License: AGPL v3](https://img.shields.io/badge/License-AGPL%20v3-blue.svg)](https://www.gnu.org/licenses/agpl-3.0)

# Catalog Module

Is a microservice that is a part of the Catalog and Sellout Management System.

## Features

 - It's a REST API that exposes the endpoints for managing the catalog and user resources. 
 - It is powered by and use Spring Cloud to fetch the configuration from a remote server and join a client server registration.
 - It saves the data in an SQL database.

## Dockerized

```
docker build -t czetsuya/terawarehouse-catalog .
docker run -d -p 8761:8761 czetsuya/terawarehouse-catalog
```

Catalog should be accessible at http://localhost:8001

## Repositories

 - https://github.com/terawarehouse
 
## Authors

 * **Edward P. Legaspi** - *Java Architect* - [czetsuya](https://github.com/czetsuya)
