package io.apollo.client.example;

import io.apollo.client.ApolloClient;
import io.apollo.client.exception.ApolloApiException;
import io.apollo.client.exception.ApolloRateLimitException;
import io.apollo.client.model.Organization;
import io.apollo.client.model.PeopleSearchRequest;
import io.apollo.client.model.PeopleSearchResponse;
import io.apollo.client.model.Person;

import java.util.List;

/**
 * Example usage of the Apollo.io Java Client.
 */
public class ApolloClientExample {

    public static void main(String[] args) {
        // Get API key from environment variable
        String apiKey = System.getenv("APOLLO_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            System.err.println("Please set APOLLO_API_KEY environment variable");
            System.exit(1);
        }

        // Create the client using try-with-resources for automatic cleanup
        try (ApolloClient client = ApolloClient.builder()
                .apiKey(apiKey)
                .build()) {

            // Example 1: Search for people
            System.out.println("=== Example 1: Search for People ===");
            searchForPeople(client);

            // Example 2: Enrich person by email
            System.out.println("\n=== Example 2: Enrich Person by Email ===");
            enrichPersonByEmail(client);

            // Example 3: Enrich organization by domain
            System.out.println("\n=== Example 3: Enrich Organization by Domain ===");
            enrichOrganizationByDomain(client);

        } catch (ApolloRateLimitException e) {
            System.err.println("Rate limit exceeded. Please retry later.");
        } catch (ApolloApiException e) {
            System.err.println("API Error: " + e.getMessage());
            if (e.getStatusCode() != null) {
                System.err.println("Status Code: " + e.getStatusCode());
            }
        }
    }

    private static void searchForPeople(ApolloClient client) {
        PeopleSearchRequest request = PeopleSearchRequest.builder()
                .keywords("software engineer")
                .personTitles(List.of("Software Engineer", "Senior Software Engineer"))
                .page(1)
                .perPage(5)
                .build();

        PeopleSearchResponse response = client.people().search(request);

        System.out.println("Found " + response.getPeople().size() + " people:");
        response.getPeople().forEach(person -> {
            System.out.printf("  - %s | %s | %s%n",
                    person.getName(),
                    person.getTitle(),
                    person.getOrganizationName());
        });

        if (response.getPagination() != null) {
            System.out.printf("Page %d of %d (Total: %d entries)%n",
                    response.getPagination().getPage(),
                    response.getPagination().getTotalPages(),
                    response.getPagination().getTotalEntries());
        }
    }

    private static void enrichPersonByEmail(ApolloClient client) {
        // Replace with a real email for testing
        String email = "example@example.com";

        try {
            Person person = client.people().enrichByEmail(email);

            System.out.println("Person Details:");
            System.out.println("  Name: " + person.getName());
            System.out.println("  Title: " + person.getTitle());
            System.out.println("  Company: " + person.getOrganizationName());
            System.out.println("  LinkedIn: " + person.getLinkedinUrl());
            System.out.println("  Location: " + person.getCity() + ", " + person.getState());
        } catch (ApolloApiException e) {
            System.err.println("Could not enrich person: " + e.getMessage());
        }
    }

    private static void enrichOrganizationByDomain(ApolloClient client) {
        // Replace with a real domain for testing
        String domain = "example.com";

        try {
            Organization org = client.organizations().enrichByDomain(domain);

            System.out.println("Organization Details:");
            System.out.println("  Name: " + org.getName());
            System.out.println("  Industry: " + org.getIndustry());
            System.out.println("  Website: " + org.getWebsiteUrl());
            System.out.println("  Employees: " + org.getEstimatedNumEmployees());
            System.out.println("  Founded: " + org.getFoundedYear());
            System.out.println("  Location: " + org.getCity() + ", " + org.getState() + ", " + org.getCountry());
        } catch (ApolloApiException e) {
            System.err.println("Could not enrich organization: " + e.getMessage());
        }
    }
}
