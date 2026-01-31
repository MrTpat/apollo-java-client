package io.apollo.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Request object for searching people.
 */
public class PeopleSearchRequest {

    @SerializedName("q_keywords")
    private String keywords;

    @SerializedName("person_titles")
    private List<String> personTitles;

    @SerializedName("person_locations")
    private List<String> personLocations;

    @SerializedName("person_seniorities")
    private List<String> personSeniorities;

    @SerializedName("contact_email_status")
    private List<String> contactEmailStatus;

    @SerializedName("q_organization_domains")
    private List<String> organizationDomains;

    @SerializedName("organization_locations")
    private List<String> organizationLocations;

    @SerializedName("organization_ids")
    private List<String> organizationIds;

    @SerializedName("organization_num_employees_ranges")
    private List<String> organizationNumEmployeesRanges;

    private Integer page;

    @SerializedName("per_page")
    private Integer perPage;

    // Getters and Setters

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public List<String> getPersonTitles() {
        return personTitles;
    }

    public void setPersonTitles(List<String> personTitles) {
        this.personTitles = personTitles;
    }

    public List<String> getPersonLocations() {
        return personLocations;
    }

    public void setPersonLocations(List<String> personLocations) {
        this.personLocations = personLocations;
    }

    public List<String> getPersonSeniorities() {
        return personSeniorities;
    }

    public void setPersonSeniorities(List<String> personSeniorities) {
        this.personSeniorities = personSeniorities;
    }

    public List<String> getContactEmailStatus() {
        return contactEmailStatus;
    }

    public void setContactEmailStatus(List<String> contactEmailStatus) {
        this.contactEmailStatus = contactEmailStatus;
    }

    public List<String> getOrganizationDomains() {
        return organizationDomains;
    }

    public void setOrganizationDomains(List<String> organizationDomains) {
        this.organizationDomains = organizationDomains;
    }

    public List<String> getOrganizationLocations() {
        return organizationLocations;
    }

    public void setOrganizationLocations(List<String> organizationLocations) {
        this.organizationLocations = organizationLocations;
    }

    public List<String> getOrganizationIds() {
        return organizationIds;
    }

    public void setOrganizationIds(List<String> organizationIds) {
        this.organizationIds = organizationIds;
    }

    public List<String> getOrganizationNumEmployeesRanges() {
        return organizationNumEmployeesRanges;
    }

    public void setOrganizationNumEmployeesRanges(List<String> organizationNumEmployeesRanges) {
        this.organizationNumEmployeesRanges = organizationNumEmployeesRanges;
    }

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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final PeopleSearchRequest request = new PeopleSearchRequest();

        public Builder keywords(String keywords) {
            request.keywords = keywords;
            return this;
        }

        public Builder personTitles(List<String> titles) {
            request.personTitles = titles;
            return this;
        }

        public Builder personLocations(List<String> locations) {
            request.personLocations = locations;
            return this;
        }

        public Builder personSeniorities(List<String> seniorities) {
            request.personSeniorities = seniorities;
            return this;
        }

        public Builder contactEmailStatus(List<String> status) {
            request.contactEmailStatus = status;
            return this;
        }

        public Builder organizationDomains(List<String> domains) {
            request.organizationDomains = domains;
            return this;
        }

        public Builder organizationLocations(List<String> locations) {
            request.organizationLocations = locations;
            return this;
        }

        public Builder organizationIds(List<String> ids) {
            request.organizationIds = ids;
            return this;
        }

        public Builder organizationNumEmployeesRanges(List<String> ranges) {
            request.organizationNumEmployeesRanges = ranges;
            return this;
        }

        public Builder page(Integer page) {
            request.page = page;
            return this;
        }

        public Builder perPage(Integer perPage) {
            request.perPage = perPage;
            return this;
        }

        public PeopleSearchRequest build() {
            return request;
        }
    }
}
