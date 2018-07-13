# Dropwizard-demo

## Prerequisites:
### Java
### Maven
### Postgres

## To build application

`mvn package` It will generate target folder contains Dropwizard jar file.

## To run application

We need to have ruuning postgres server.

Give the database credentials in `dbconf.yml` so that your applcation can get connection to postgres server.

`java -jar target/DropWizardExample-0.0.1-SNAPSHOT.jar server dbconf.yml`

