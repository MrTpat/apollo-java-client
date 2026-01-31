package io.apollo.client.config;

/**
 * Configuration for the Apollo.io API client.
 */
public record ApolloConfig(
    String apiKey,
    String baseUrl,
    int connectTimeoutSeconds,
    int requestTimeoutSeconds
) {
    public ApolloConfig {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalArgumentException("API key cannot be null or blank");
        }
        if (baseUrl == null || baseUrl.isBlank()) {
            throw new IllegalArgumentException("Base URL cannot be null or blank");
        }
        if (connectTimeoutSeconds <= 0) {
            throw new IllegalArgumentException("Connect timeout must be positive");
        }
        if (requestTimeoutSeconds <= 0) {
            throw new IllegalArgumentException("Request timeout must be positive");
        }
    }
}
