[![License: AGPL v3](https://img.shields.io/badge/License-AGPL%20v3-blue.svg)](https://www.gnu.org/licenses/agpl-3.0)
[![ko-fi](https://www.ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/S6S0YXPX)

# Catalog and Sellout Management System using Spring - Catalog Module

A catalog and sales order management system is commonly used by companies to manage their catalog and capture their sales data into a centralized database so that a real-time accurate report can be generated instantly. This application can trigger notification such as low on stock which allows the company to act as needed.

In this exercise, we will use the power of Spring + RESTful Web Services to develop the system. We will also architect the application to use a microservice approach which allows for more modular development. We will separate the catalog and sales system into two separate microservices having their own database. Thus, there will be a problem in reporting which we will address using API Composition and Saga Pattern.

Once we are done with the RESTful web services, we will create a simple front end application secured by Keycloak to show some reports.

And finally, we will dockerize the services and managed using Kubernetes. We will also attempt to deploy the application on Amazon Web Services using a docker-compose and Amazon EKS.

Keywords: catalog and sales order management system, spring, microservice, rest api, continuous deployment, docker, kubernetes, saga pattern, api composition, feign, zuul, eureka, ribbon, hystrix, amazon, sleuth, zipkin, grafana, prometheus, keycloak, hateoas, liquibase, flyway, elasticsearch, travis, axon

## What you’ll learn:

 * You will be able to learn the various tools that make programming easier in Spring.
 * You will learn how to design and develop RESTful web services and take advantage of Spring REST JPA.
 * You will learn how to monitor the metrics, threads, etc by using the spring admin server.
 * You will learn how to implement resource localization and documenting RESTful web services using Swagger.
 * You will be able to understand and implement HATEOAS, exception handling, filtering, validation, and versioning of RESTful web services.
 * You will learn how we can monitor and test RESTful web services using actuator and HAL browser.
 * You will learn how to design a database schema and the tools we can use to make the job easier.
 * You will learn the different ways in which we can populate and maintain the database schema and data.
 * You will learn the basics of microservice architecture and how we can apply it to our project.
 * You will learn API Composition VS Saga pattern in action.
 * You will learn how to use the AxonIO framework to implement the Saga pattern.
 * You will learn how to create a configuration server.
 * You will learn client-side load balancing using Ribbon.
 * You will learn how to scale dynamically with Eureka discovery server and Zuul API Gateway.
 * You will learn how to handle fault tolerance using Hystrix.
 * You will learn how to simplify the creation of RESTful API clients using Feign.
 * You will learn how to implement distributed tracing using Sleuth and Zipkin.
 * You will learn how to monitor web services using Grafana and Prometheus.
 * You will learn how to integrate Elasticsearch to implement search.
 * You will learn to create a simple React application.
 * You will learn how to integrate Keycloak to secure web services.
 * You will learn how to containerized the services using docker and run using docker compose.
 * You will learn how to automate the deployment, scaling, and management of containers.
 * You will learn continuous integration using Travis.
 * You will learn container deployment on Amazon EKS.
 
## Course requirements or prerequisites:

 * Amazon web service account
 * Github account
 * Knowledge of the following
 	* GIT
 	* Maven
 	* SpringToolSuite
 	* Experience with Java and Spring
 	* Keycloak
 	* API Composition, Saga Pattern, Event Sourcing, and CQRS
 
## Who this course is for?

 * You want to learn how to develop a catalog and sales management system using Spring technology stack.
 * You want to leverage the microservice architecture in developing a project.

## What you’ll learn:

 * You will be able to learn the various tools that make programming easier in Spring.
 * You will learn how to design and develop RESTful web services and take advantage of Spring REST JPA.
 * You will learn how to monitor the metrics, threads, etc by using the spring admin server.
 * Slack Discussion

## Repositories

 * https://github.com/terawarehouse/terawarehouse-catalog
 * https://github.com/terawarehouse/terawarehouse-inventory
 * https://github.com/terawarehouse/terawarehouse-sales
 * https://github.com/terawarehouse/terawarehouse-reporting
 * https://github.com/terawarehouse/terawarehouse-react

## Liquibase Commands

```
liquibase.bat --driver=org.postgresql.Driver --classpath=C:/java/jar/postgresql-42.2.4.jar --changeLogFile=d:/temp/terawarehouse/sql/schema.xml --url="jdbc:postgresql://localhost/terawarehouse" --username=kerri --password=kerri --changeSetAuthor=czetsuya generateChangeLog
liquibase.bat --driver=org.postgresql.Driver --classpath=C:/java/jar/postgresql-42.2.4.jar --changeLogFile=d:/temp/terawarehouse/sql/data.xml --url="jdbc:postgresql://localhost/terawarehouse" --username=kerri --password=kerri --diffTypes="data" --changeSetAuthor=czetsuya generateChangeLog
```

## Authors

* **Edward P. Legaspi** - *Java Architect* - [czetsuya](https://github.com/czetsuya)