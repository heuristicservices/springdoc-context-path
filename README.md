Generate Spring Boot Application jar

    mvn clean install

Generate Java and nginx containers

    docker-compose build


Demonstration of bug:

1. Run Spring Boot application jar from local machine:

       java -jar target/springdoc-context-path-1.0-SNAPSHOT.jar
2. Navigate to `http://localhost:8080/petstore/v3/api-docs/swagger-config` to view `petstore` server context prepended to URL:

       {"configUrl":"/petstore/v3/api-docs/swagger-config","oauth2RedirectUrl":"http://localhost:8080/petstore/swagger-ui/oauth2-redirect.html","url":"/petstore/v3/api-docs","validatorUrl":""}
3. Stop application and run `docker compose up` which uses nginx `X-Forwarded-Prefix` header `/api`.
4. Navigate to `http://localhost:8080/api/petstore/v3/api-docs/swagger-config` which the application correctly routes. This displays the following:

       {"configUrl":"/api/v3/api-docs/swagger-config","oauth2RedirectUrl":"http://localhost:8080/api/swagger-ui/oauth2-redirect.html","url":"/api/v3/api-docs","validatorUrl":""}
5. The application prepends the URL with the `X-Forwarded-Prefix` value, however the server context is now missing within the `JSON` response.