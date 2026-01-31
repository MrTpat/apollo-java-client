package io.apollo.client.service;

import io.apollo.client.http.HttpClient;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Service for account-related API operations.
 */
public class AccountService {

    private final HttpClient httpClient;

    public AccountService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Searches for accounts based on the provided criteria.
     *
     * @param searchParams search parameters
     * @return the search response containing accounts
     */
    public AccountSearchResponse search(Map<String, Object> searchParams) {
        return httpClient.post("/accounts/search", searchParams, AccountSearchResponse.class);
    }

    /**
     * Gets an account by its ID.
     *
     * @param accountId the account's ID
     * @return the account details
     */
    public Account getById(String accountId) {
        return httpClient.get("/accounts/" + accountId, Account.class);
    }

    /**
     * Creates a new account.
     *
     * @param account the account to create
     * @return the created account
     */
    public Account create(Account account) {
        return httpClient.post("/accounts", account, Account.class);
    }

    /**
     * Updates an existing account.
     *
     * @param accountId the account's ID
     * @param account the account data to update
     * @return the updated account
     */
    public Account update(String accountId, Account account) {
        return httpClient.patch("/accounts/" + accountId, account, Account.class);
    }

    @Data
    public static class AccountSearchResponse {
        private List<Account> accounts;
        private Pagination pagination;
    }

    @Data
    public static class Account {
        private String id;
        private String name;
        private String domain;
        private String ownerId;
    }

    @Data
    public static class Pagination {
        private Integer page;
        private Integer perPage;
        private Integer totalEntries;
        private Integer totalPages;
    }
}
