# Quarkus Kafka Stream Service

A stream processing service built with Java 17 and Quarkus that consumes data from a Kafka topic, performs data transformation, and sends the results back to Kafka or persists them to a database (H2/PostgreSQL) based on configuration.

## Key Features

- **Kafka Consumption**: Consumes JSON messages from an input topic.
- **Data Transformation**: Converts payloads to uppercase and appends processing timestamps.
- **Flexible Routing**:
  - `kafka` mode (default): Sends transformation results to an output topic.
  - `db` mode: Persists transformation results to a database.
- **Reactive Messaging**: Built using SmallRye Reactive Messaging.

## Prerequisites

Before running the application, ensure you have:

- **Java 17** or later
- **Maven 3.8+**
- **Apache Kafka** (running on localhost:9092 or accessible host)

## Configuration

The application is configurable via Environment Variables. Key variables include:

| Environment Variable | Description | Default |
|---------------------|-----------|---------|
| `KAFKA_BOOTSTRAP_SERVERS` | Kafka broker address | `localhost:9092` |
| `KAFKA_INPUT_TOPIC` | Input Kafka topic | `input-topic` |
| `KAFKA_OUTPUT_TOPIC` | Output Kafka topic (for Kafka mode) | `processed-topic` |
| `APP_OUTPUT_MODE` | Output mode: `kafka` or `db` | `kafka` |

## How to Run

### 1. Prepare Kafka

Ensure your Kafka broker is running. If using a local distribution (KRaft):

```bash
# Example (Windows PowerShell)
$env:KAFKA_HOME = "C:\path\to\kafka"
& "$env:KAFKA_HOME\bin\windows\kafka-server-start.bat" "$env:KAFKA_HOME\config\kraft\server.properties"
```

Create the required topics:
```bash
kafka-topics.bat --bootstrap-server localhost:9092 --create --topic input-topic
kafka-topics.bat --bootstrap-server localhost:9092 --create --topic processed-topic
```

### 2. Run the Service (Development Mode)

Use Maven to run the application in Quarkus development mode (hot-reload enabled):

```bash
mvn quarkus:dev
```

To change configuration at runtime (e.g., to switch output to database):

**Windows PowerShell:**
```powershell
$env:APP_OUTPUT_MODE = "db"
mvn quarkus:dev
```

**Linux/Mac:**
```bash
APP_OUTPUT_MODE=db mvn quarkus:dev
```

### 3. Send Dummy Data

You can use `kafka-console-producer` to send test data to the `input-topic`:

```json
{"id": "event-1", "payload": "hello world"}
```

Success criteria:
- **Kafka Mode**: Check `processed-topic`; the payload should be transformed to `"HELLO WORLD"` with a `processedAt` timestamp.
- **DB Mode**: Data is saved to the `ProcessedRecord` table (H2 in-memory by default).

## Testing

The project includes unit tests using an in-memory connector to simulate Kafka, allowing tests to run without an external Kafka broker.

Run all tests via:

```bash
mvn test
```

## Project Structure

- `src/main/java/com/example/stream/service/ProcessorService.java`: Core logic for consumption, transformation, and routing.
- `src/main/java/com/example/stream/model/MyEvent.java`: JSON Data Model (POJO).
- `src/main/java/com/example/stream/db/ProcessedRecord.java`: Database Entity (Panache/Hibernate).
- `src/main/resources/application.properties`: Quarkus configuration.
