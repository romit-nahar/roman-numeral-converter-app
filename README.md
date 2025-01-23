# Roman Numeral Converter

## Project Overview
A Spring Boot microservice for converting decimal numbers to Roman numerals.

Conversion reference: https://en.wikipedia.org/wiki/Roman_numerals

## Prerequisites
- Java 17
- Gradle 8.x

## Building the Project
```bash
# Clean and build the project
./gradlew clean build

# Run tests
./gradlew test

# Generate test coverage report
./gradlew jacocoTestReport
```

## Running the Application
```bash
# Run the application
./gradlew bootRun

# Access the endpoint
# http://localhost:8080/romannumeral?query=42
```

## Engineering Methodology
- Test-Driven Development (TDD)
- Modular design with separation of concerns
- Comprehensive unit and integration testing
- Continuous integration via JaCoCo test coverage

### Testing Strategies
- JUnit 5 for unit testing
- Mockito for mocking dependencies
- 80% test coverage requirement
- Parameterized tests for input variations

## Package Layout
```
com.example.romannumeral
├── constants        # Constant values and configurations
├── controller       # HTTP request handling
├── model            # Data transfer objects
├── service          # Business logic interfaces/implementations
└── RomanNumeralApplication.java  # Application entry point
```

## Dependencies
- Spring Boot Web
- Project Lombok
- JUnit Jupiter
- Mockito
- Jackson Databind

## Logging
- SLF4J with logback
- Configurable logging levels
- Structured console output

## Performance Considerations
- O(1) time complexity for Roman numeral conversion
- Minimal memory allocation
- Efficient use of Java Stream and Collection APIs

## Limitations
- Supports integers between 1-3999
- ASCII Roman numeral representation only

## License
MIT License