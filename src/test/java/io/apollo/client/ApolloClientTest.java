package io.apollo.client;

import io.apollo.client.config.ApolloConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApolloClientTest {

    @Test
    void testBuilderWithValidApiKey() {
        ApolloClient client = ApolloClient.builder()
            .apiKey("test-api-key")
            .build();

        assertNotNull(client);
    }

    @Test
    void testBuilderWithoutApiKeyThrowsException() {
        assertThrows(IllegalStateException.class, () -> {
            ApolloClient.builder().build();
        });
    }

    @Test
    void testBuilderWithEmptyApiKeyThrowsException() {
        assertThrows(IllegalStateException.class, () -> {
            ApolloClient.builder()
                .apiKey("")
                .build();
        });
    }

    @Test
    void testBuilderWithCustomConfiguration() {
        ApolloClient client = ApolloClient.builder()
            .apiKey("test-api-key")
            .baseUrl("https://custom.api.url/v1")
            .connectTimeout(60)
            .requestTimeout(120)
            .build();

        assertNotNull(client);
    }

    @Test
    void testServicesAreInitialized() {
        ApolloClient client = ApolloClient.builder()
            .apiKey("test-api-key")
            .build();

        assertNotNull(client.people());
        assertNotNull(client.organizations());
        assertNotNull(client.accounts());
        assertNotNull(client.contacts());
    }

    @Test
    void testConfigValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ApolloConfig(null, "http://test.com", 30, 60);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new ApolloConfig("test-key", null, 30, 60);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new ApolloConfig("test-key", "http://test.com", -1, 60);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new ApolloConfig("test-key", "http://test.com", 30, -1);
        });
    }
}
