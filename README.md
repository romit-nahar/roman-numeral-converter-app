Project Overview
A Spring Boot microservice for converting decimal numbers to Roman numerals.

Conversion reference: https://en.wikipedia.org/wiki/Roman_numerals
Prerequisites
1. Java 17
2. Gradle 8.x

Building the Project
# Clean and build the project
./gradlew clean build

# Run tests
./gradlew test

# Generate test coverage report
./gradlew jacocoTestReport

Running the Application
# Run the application
./gradlew bootRun

# Access the endpoint
http://localhost:8080/romannumeral?query=42

# Engineering Methodology

1. Test-Driven Development (TDD)
2. Modular design with separation of concerns
3. Comprehensive unit and integration testing
4. Continuous integration via JaCoCo test coverage

# Testing Strategies

1. JUnit 5 for unit testing
2. Mockito for mocking dependencies
3. 80% test coverage requirement
4. Parameterized tests for input variations

# Package Layout
com.example.romannumeral

├── constants        # Constant values and configurations

├── controller       # HTTP request handling

├── model            # Data transfer objects

├── service          # Business logic interfaces/implementations

└── RomanNumeralApplication.java  # Application entry point

# Dependencies

1. Spring Boot Web
2. Project Lombok
3. JUnit Jupiter
4. Mockito
5. Jackson Databind

# Logging

1. SLF4J with logback
2. Configurable logging levels
3. Structured console output

# Performance Considerations

1. O(1) time complexity for Roman numeral conversion
2. Minimal memory allocation
3. Efficient use of Java Stream and Collection APIs

# Limitations

1. Supports integers between 1-3999
2. ASCII Roman numeral representation only
