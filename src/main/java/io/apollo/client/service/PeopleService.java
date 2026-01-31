package io.apollo.client.service;

import io.apollo.client.http.HttpClient;
import io.apollo.client.model.Person;
import io.apollo.client.model.PeopleSearchRequest;
import io.apollo.client.model.PeopleSearchResponse;

/**
 * Service for people-related API operations.
 */
public class PeopleService {

    private final HttpClient httpClient;

    public PeopleService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Searches for people based on the provided criteria.
     *
     * @param request the search request with filters
     * @return the search response containing people and pagination info
     */
    public PeopleSearchResponse search(PeopleSearchRequest request) {
        return httpClient.post("/people/search", request, PeopleSearchResponse.class);
    }

    /**
     * Gets a person by their ID.
     *
     * @param personId the person's ID
     * @return the person details
     */
    public Person getById(String personId) {
        return httpClient.get("/people/" + personId, Person.class);
    }

    /**
     * Enriches a person's data based on their email.
     *
     * @param email the person's email address
     * @return the enriched person details
     */
    public Person enrichByEmail(String email) {
        var request = new EnrichRequest(email, null);
        return httpClient.post("/people/match", request, PersonEnrichResponse.class).getPerson();
    }

    /**
     * Enriches a person's data based on their LinkedIn URL.
     *
     * @param linkedinUrl the person's LinkedIn profile URL
     * @return the enriched person details
     */
    public Person enrichByLinkedIn(String linkedinUrl) {
        var request = new EnrichRequest(null, linkedinUrl);
        return httpClient.post("/people/match", request, PersonEnrichResponse.class).getPerson();
    }

    private record EnrichRequest(String email, String linkedin_url) {}

    private static class PersonEnrichResponse {
        private Person person;

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }
    }
}
