package io.apollo.client.exception;

/**
 * Exception thrown when the API rate limit is exceeded.
 */
public class ApolloRateLimitException extends ApolloApiException {

    public ApolloRateLimitException(String message) {
        super(message);
    }
}
