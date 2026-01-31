package io.apollo.client.service;

import io.apollo.client.http.HttpClient;
import io.apollo.client.model.Organization;
import lombok.Data;

/**
 * Service for organization-related API operations.
 */
public class OrganizationService {

    private final HttpClient httpClient;

    public OrganizationService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Gets an organization by its ID.
     *
     * @param organizationId the organization's ID
     * @return the organization details
     */
    public Organization getById(String organizationId) {
        return httpClient.get("/organizations/" + organizationId, Organization.class);
    }

    /**
     * Enriches an organization's data based on its domain.
     *
     * @param domain the organization's domain (e.g., "example.com")
     * @return the enriched organization details
     */
    public Organization enrichByDomain(String domain) {
        var request = new EnrichRequest(domain);
        return httpClient.post("/organizations/enrich", request, OrganizationEnrichResponse.class).getOrganization();
    }

    private record EnrichRequest(String domain) {}

    @Data
    private static class OrganizationEnrichResponse {
        private Organization organization;
    }
}
