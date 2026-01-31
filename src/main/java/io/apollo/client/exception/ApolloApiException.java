package io.apollo.client.exception;

/**
 * Exception thrown when an Apollo.io API request fails.
 */
public class ApolloApiException extends RuntimeException {

    private final Integer statusCode;
    private final String responseBody;

    public ApolloApiException(String message) {
        super(message);
        this.statusCode = null;
        this.responseBody = null;
    }

    public ApolloApiException(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = null;
        this.responseBody = null;
    }

    public ApolloApiException(String message, int statusCode, String responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    /**
     * Gets the HTTP status code from the failed request, if available.
     *
     * @return the status code, or null if not available
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     * Gets the response body from the failed request, if available.
     *
     * @return the response body, or null if not available
     */
    public String getResponseBody() {
        return responseBody;
    }
}
