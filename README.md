# Apollo.io Java Client

A Java client library for the Apollo.io API, built with Java 25 and using the native Java HTTP Client.

## Features

- API Key authentication
- Type-safe API interactions
- Support for People, Organizations, Accounts, and Contacts endpoints
- Fluent builder pattern for requests
- Comprehensive error handling
- Zero external HTTP client dependencies (uses Java 11+ HttpClient)
- Clean, boilerplate-free code using Lombok

## Installation

### Gradle

Add the following to your `build.gradle`:

```gradle
dependencies {
    implementation 'io.apollo:apollo-java-client:1.0.0'
}
```

### Maven

Add the following to your `pom.xml`:

```xml
<dependency>
    <groupId>io.apollo</groupId>
    <artifactId>apollo-java-client</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

### Initialize the Client

```java
import io.apollo.client.ApolloClient;

ApolloClient client = ApolloClient.builder()
    .apiKey("your-api-key-here")
    .build();
```

### Search for People

```java
import io.apollo.client.model.PeopleSearchRequest;
import io.apollo.client.model.PeopleSearchResponse;

PeopleSearchRequest request = PeopleSearchRequest.builder()
    .keywords("software engineer")
    .personTitles(List.of("Software Engineer", "Senior Software Engineer"))
    .personLocations(List.of("San Francisco, CA"))
    .page(1)
    .perPage(25)
    .build();

PeopleSearchResponse response = client.people().search(request);

response.getPeople().forEach(person -> {
    System.out.println(person.getName() + " - " + person.getTitle());
});
```

### Enrich Person Data

```java
import io.apollo.client.model.Person;

// Enrich by email
Person person = client.people().enrichByEmail("john.doe@example.com");

// Enrich by LinkedIn URL
Person person = client.people().enrichByLinkedIn("https://www.linkedin.com/in/johndoe");

System.out.println("Name: " + person.getName());
System.out.println("Title: " + person.getTitle());
System.out.println("Company: " + person.getOrganizationName());
```

### Work with Organizations

```java
import io.apollo.client.model.Organization;

// Enrich organization by domain
Organization org = client.organizations().enrichByDomain("example.com");

System.out.println("Company: " + org.getName());
System.out.println("Industry: " + org.getIndustry());
System.out.println("Employees: " + org.getEstimatedNumEmployees());
System.out.println("Website: " + org.getWebsiteUrl());
```

### Manage Accounts

```java
import io.apollo.client.service.AccountService.Account;
import io.apollo.client.service.AccountService.AccountSearchResponse;

// Search accounts
Map<String, Object> params = Map.of("q_keywords", "technology");
AccountSearchResponse response = client.accounts().search(params);

// Create an account
Account newAccount = new Account();
newAccount.setName("Acme Corp");
newAccount.setDomain("acme.com");
Account created = client.accounts().create(newAccount);

// Get account by ID
Account account = client.accounts().getById(created.getId());
```

### Manage Contacts

```java
import io.apollo.client.service.ContactService.Contact;

// Create a contact
Contact contact = new Contact();
contact.setFirstName("John");
contact.setLastName("Doe");
contact.setEmail("john.doe@example.com");
contact.setTitle("Software Engineer");
Contact created = client.contacts().create(contact);

// Update contact
created.setTitle("Senior Software Engineer");
client.contacts().update(created.getId(), created);

// Delete contact
client.contacts().delete(created.getId());
```

### Configuration Options

```java
ApolloClient client = ApolloClient.builder()
    .apiKey("your-api-key")
    .baseUrl("https://api.apollo.io/v1")  // Custom base URL (optional)
    .connectTimeout(30)                     // Connection timeout in seconds
    .requestTimeout(60)                     // Request timeout in seconds
    .build();
```

### Error Handling

```java
import io.apollo.client.exception.ApolloApiException;
import io.apollo.client.exception.ApolloRateLimitException;

try {
    Person person = client.people().enrichByEmail("john@example.com");
} catch (ApolloRateLimitException e) {
    System.err.println("Rate limit exceeded. Please retry later.");
} catch (ApolloApiException e) {
    System.err.println("API Error: " + e.getMessage());
    if (e.getStatusCode() != null) {
        System.err.println("Status Code: " + e.getStatusCode());
    }
}
```

### Resource Management

The client implements `AutoCloseable`, so you can use try-with-resources:

```java
try (ApolloClient client = ApolloClient.builder()
        .apiKey("your-api-key")
        .build()) {

    // Use the client
    var response = client.people().search(request);
    // Process response...
}
```

## API Documentation

For detailed API documentation, visit the [Apollo.io API Reference](https://docs.apollo.io/reference/authentication).

## Requirements

- Java 25 or higher
- Gradle 9.3 or higher (for building from source)

## Building from Source

```bash
./gradlew build
```

## Running Tests

```bash
./gradlew test
```

## Running the Example

Set your API key as an environment variable and run the example:

```bash
export APOLLO_API_KEY="your-api-key-here"
./gradlew run --args="io.apollo.client.example.ApolloClientExample"
```

Or compile and run directly with Java:

```bash
./gradlew build
java -cp build/libs/apollo-java-client-1.0.0.jar:~/.gradle/caches/modules-2/files-2.1/com.google.code.gson/gson/2.10.1/*/gson-2.10.1.jar \
  -DAPOLLO_API_KEY="your-api-key-here" \
  io.apollo.client.example.ApolloClientExample
```

## License

MIT License

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Support

For issues and questions:
- GitHub Issues: [Report an issue](https://github.com/yourusername/apollo-java-client/issues)
- Apollo.io Support: [Apollo.io Help Center](https://help.apollo.io/)
