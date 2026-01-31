package io.apollo.client.service;

import io.apollo.client.http.HttpClient;

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

    public static class AccountSearchResponse {
        private List<Account> accounts;
        private Pagination pagination;

        public List<Account> getAccounts() {
            return accounts;
        }

        public void setAccounts(List<Account> accounts) {
            this.accounts = accounts;
        }

        public Pagination getPagination() {
            return pagination;
        }

        public void setPagination(Pagination pagination) {
            this.pagination = pagination;
        }
    }

    public static class Account {
        private String id;
        private String name;
        private String domain;
        private String ownerId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(String ownerId) {
            this.ownerId = ownerId;
        }
    }

    public static class Pagination {
        private Integer page;
        private Integer perPage;
        private Integer totalEntries;
        private Integer totalPages;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getPerPage() {
            return perPage;
        }

        public void setPerPage(Integer perPage) {
            this.perPage = perPage;
        }

        public Integer getTotalEntries() {
            return totalEntries;
        }

        public void setTotalEntries(Integer totalEntries) {
            this.totalEntries = totalEntries;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }
    }
}
