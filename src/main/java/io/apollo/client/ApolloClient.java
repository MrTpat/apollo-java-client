package io.apollo.client;

import io.apollo.client.config.ApolloConfig;
import io.apollo.client.http.HttpClient;
import io.apollo.client.service.*;

/**
 * Main client for interacting with the Apollo.io API.
 *
 * <p>Usage example:
 * <pre>{@code
 * ApolloClient client = ApolloClient.builder()
 *     .apiKey("your-api-key")
 *     .build();
 *
 * // Use the client to access various services
 * var people = client.people().search(searchRequest);
 * }</pre>
 */
public class ApolloClient implements AutoCloseable {

    private final ApolloConfig config;
    private final HttpClient httpClient;

    // Service instances
    private PeopleService peopleService;
    private OrganizationService organizationService;
    private AccountService accountService;
    private ContactService contactService;

    private ApolloClient(ApolloConfig config) {
        this.config = config;
        this.httpClient = new HttpClient(config);
    }

    /**
     * Creates a new builder for configuring an ApolloClient instance.
     *
     * @return a new builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Gets the People service for people-related API operations.
     *
     * @return the PeopleService instance
     */
    public PeopleService people() {
        if (peopleService == null) {
            peopleService = new PeopleService(httpClient);
        }
        return peopleService;
    }

    /**
     * Gets the Organization service for organization-related API operations.
     *
     * @return the OrganizationService instance
     */
    public OrganizationService organizations() {
        if (organizationService == null) {
            organizationService = new OrganizationService(httpClient);
        }
        return organizationService;
    }

    /**
     * Gets the Account service for account-related API operations.
     *
     * @return the AccountService instance
     */
    public AccountService accounts() {
        if (accountService == null) {
            accountService = new AccountService(httpClient);
        }
        return accountService;
    }

    /**
     * Gets the Contact service for contact-related API operations.
     *
     * @return the ContactService instance
     */
    public ContactService contacts() {
        if (contactService == null) {
            contactService = new ContactService(httpClient);
        }
        return contactService;
    }

    @Override
    public void close() {
        httpClient.close();
    }

    /**
     * Builder for creating ApolloClient instances.
     */
    public static class Builder {
        private String apiKey;
        private String baseUrl = "https://api.apollo.io/v1";
        private int connectTimeout = 30;
        private int requestTimeout = 60;

        /**
         * Sets the API key for authentication.
         *
         * @param apiKey the Apollo.io API key
         * @return this builder instance
         */
        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /**
         * Sets a custom base URL for the API (useful for testing).
         *
         * @param baseUrl the base URL
         * @return this builder instance
         */
        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        /**
         * Sets the connection timeout in seconds.
         *
         * @param seconds timeout in seconds
         * @return this builder instance
         */
        public Builder connectTimeout(int seconds) {
            this.connectTimeout = seconds;
            return this;
        }

        /**
         * Sets the request timeout in seconds.
         *
         * @param seconds timeout in seconds
         * @return this builder instance
         */
        public Builder requestTimeout(int seconds) {
            this.requestTimeout = seconds;
            return this;
        }

        /**
         * Builds the ApolloClient instance.
         *
         * @return a new ApolloClient instance
         * @throws IllegalStateException if required configuration is missing
         */
        public ApolloClient build() {
            if (apiKey == null || apiKey.isBlank()) {
                throw new IllegalStateException("API key is required");
            }

            ApolloConfig config = new ApolloConfig(apiKey, baseUrl, connectTimeout, requestTimeout);
            return new ApolloClient(config);
        }
    }
}
