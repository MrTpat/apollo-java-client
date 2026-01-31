package io.apollo.client.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.apollo.client.config.ApolloConfig;
import io.apollo.client.exception.ApolloApiException;
import io.apollo.client.exception.ApolloRateLimitException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * HTTP client wrapper for making requests to the Apollo.io API.
 */
public class HttpClient implements AutoCloseable {

    private final ApolloConfig config;
    private final java.net.http.HttpClient client;
    private final Gson gson;

    public HttpClient(ApolloConfig config) {
        this.config = config;
        this.client = java.net.http.HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(config.connectTimeoutSeconds()))
            .build();
        this.gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    }

    /**
     * Sends a GET request to the specified path.
     *
     * @param path the API path (relative to base URL)
     * @param responseType the expected response type
     * @return the deserialized response
     * @throws ApolloApiException if the request fails
     */
    public <T> T get(String path, Class<T> responseType) {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(config.baseUrl() + path))
            .header("Content-Type", "application/json")
            .header("Cache-Control", "no-cache")
            .header("X-Api-Key", config.apiKey())
            .timeout(Duration.ofSeconds(config.requestTimeoutSeconds()))
            .GET()
            .build();

        return executeRequest(request, responseType);
    }

    /**
     * Sends a POST request to the specified path.
     *
     * @param path the API path (relative to base URL)
     * @param body the request body object
     * @param responseType the expected response type
     * @return the deserialized response
     * @throws ApolloApiException if the request fails
     */
    public <T> T post(String path, Object body, Class<T> responseType) {
        String jsonBody = gson.toJson(body);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(config.baseUrl() + path))
            .header("Content-Type", "application/json")
            .header("Cache-Control", "no-cache")
            .header("X-Api-Key", config.apiKey())
            .timeout(Duration.ofSeconds(config.requestTimeoutSeconds()))
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();

        return executeRequest(request, responseType);
    }

    /**
     * Sends a PATCH request to the specified path.
     *
     * @param path the API path (relative to base URL)
     * @param body the request body object
     * @param responseType the expected response type
     * @return the deserialized response
     * @throws ApolloApiException if the request fails
     */
    public <T> T patch(String path, Object body, Class<T> responseType) {
        String jsonBody = gson.toJson(body);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(config.baseUrl() + path))
            .header("Content-Type", "application/json")
            .header("Cache-Control", "no-cache")
            .header("X-Api-Key", config.apiKey())
            .timeout(Duration.ofSeconds(config.requestTimeoutSeconds()))
            .method("PATCH", HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();

        return executeRequest(request, responseType);
    }

    /**
     * Sends a PUT request to the specified path.
     *
     * @param path the API path (relative to base URL)
     * @param body the request body object
     * @param responseType the expected response type
     * @return the deserialized response
     * @throws ApolloApiException if the request fails
     */
    public <T> T put(String path, Object body, Class<T> responseType) {
        String jsonBody = gson.toJson(body);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(config.baseUrl() + path))
            .header("Content-Type", "application/json")
            .header("Cache-Control", "no-cache")
            .header("X-Api-Key", config.apiKey())
            .timeout(Duration.ofSeconds(config.requestTimeoutSeconds()))
            .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();

        return executeRequest(request, responseType);
    }

    /**
     * Sends a DELETE request to the specified path.
     *
     * @param path the API path (relative to base URL)
     * @param responseType the expected response type
     * @return the deserialized response
     * @throws ApolloApiException if the request fails
     */
    public <T> T delete(String path, Class<T> responseType) {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(config.baseUrl() + path))
            .header("Content-Type", "application/json")
            .header("Cache-Control", "no-cache")
            .header("X-Api-Key", config.apiKey())
            .timeout(Duration.ofSeconds(config.requestTimeoutSeconds()))
            .DELETE()
            .build();

        return executeRequest(request, responseType);
    }

    private <T> T executeRequest(HttpRequest request, Class<T> responseType) {
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 429) {
                throw new ApolloRateLimitException("Rate limit exceeded");
            }

            if (response.statusCode() >= 400) {
                String errorMessage = String.format(
                    "API request failed with status %d: %s",
                    response.statusCode(),
                    response.body()
                );
                throw new ApolloApiException(errorMessage, response.statusCode(), response.body());
            }

            return gson.fromJson(response.body(), responseType);

        } catch (IOException e) {
            throw new ApolloApiException("Network error during API request", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApolloApiException("Request was interrupted", e);
        }
    }

    @Override
    public void close() {
        // HttpClient doesn't need explicit cleanup in Java 11+
    }
}
