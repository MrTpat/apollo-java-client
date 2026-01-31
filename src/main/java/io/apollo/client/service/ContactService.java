package io.apollo.client.service;

import io.apollo.client.http.HttpClient;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Service for contact-related API operations.
 */
public class ContactService {

    private final HttpClient httpClient;

    public ContactService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Searches for contacts based on the provided criteria.
     *
     * @param searchParams search parameters
     * @return the search response containing contacts
     */
    public ContactSearchResponse search(Map<String, Object> searchParams) {
        return httpClient.post("/contacts/search", searchParams, ContactSearchResponse.class);
    }

    /**
     * Gets a contact by its ID.
     *
     * @param contactId the contact's ID
     * @return the contact details
     */
    public Contact getById(String contactId) {
        return httpClient.get("/contacts/" + contactId, Contact.class);
    }

    /**
     * Creates a new contact.
     *
     * @param contact the contact to create
     * @return the created contact
     */
    public Contact create(Contact contact) {
        return httpClient.post("/contacts", contact, Contact.class);
    }

    /**
     * Updates an existing contact.
     *
     * @param contactId the contact's ID
     * @param contact the contact data to update
     * @return the updated contact
     */
    public Contact update(String contactId, Contact contact) {
        return httpClient.patch("/contacts/" + contactId, contact, Contact.class);
    }

    /**
     * Deletes a contact.
     *
     * @param contactId the contact's ID
     */
    public void delete(String contactId) {
        httpClient.delete("/contacts/" + contactId, Void.class);
    }

    @Data
    public static class ContactSearchResponse {
        private List<Contact> contacts;
        private Pagination pagination;
    }

    @Data
    public static class Contact {
        private String id;
        private String firstName;
        private String lastName;
        private String email;
        private String title;
        private String accountId;
    }

    @Data
    public static class Pagination {
        private Integer page;
        private Integer perPage;
        private Integer totalEntries;
        private Integer totalPages;
    }
}
