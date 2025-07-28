# sqs-connect

A small Spring Boot application that demonstrates sending messages to an AWS Simple Queue Service (SQS) queue using the AWS SDK for Java v2.

## Prerequisites

- **Java 17** or later installed and available on your `PATH`.
- **Maven 3.8+** for building the project (or use the provided `mvnw` wrapper).
- AWS credentials with permission to access SQS. The application uses the default
  AWS credential provider chain so credentials can be supplied via environment
  variables, the AWS CLI configuration or other supported methods.

## Building the project

Use Maven to resolve dependencies and build the executable JAR:

```bash
./mvnw package
```

The resulting JAR will be placed in the `target` directory.

## Running the application

You can run the project directly using the Spring Boot Maven plugin or by
executing the built JAR. In both cases ensure your AWS credentials are
available so the application can connect to SQS.

### Run with Maven

```bash
./mvnw spring-boot:run
```

### Run the packaged JAR

```bash
java -jar target/demo-sqs-connect-0.0.1-SNAPSHOT.jar
```

The default AWS region is configured in `src/main/resources/application.yaml` and
can be overridden using the `AWS_REGION` environment variable or by editing that
file.
