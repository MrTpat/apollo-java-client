package io.apollo.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response object for people search requests.
 */
public class PeopleSearchResponse {

    private List<Person> people;

    @SerializedName("breadcrumbs")
    private List<Breadcrumb> breadcrumbs;

    @SerializedName("partial_results_only")
    private Boolean partialResultsOnly;

    @SerializedName("disable_eu_prospecting")
    private Boolean disableEuProspecting;

    @SerializedName("partial_results_limit")
    private Integer partialResultsLimit;

    private Pagination pagination;

    // Getters and Setters

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Breadcrumb> getBreadcrumbs() {
        return breadcrumbs;
    }

    public void setBreadcrumbs(List<Breadcrumb> breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
    }

    public Boolean getPartialResultsOnly() {
        return partialResultsOnly;
    }

    public void setPartialResultsOnly(Boolean partialResultsOnly) {
        this.partialResultsOnly = partialResultsOnly;
    }

    public Boolean getDisableEuProspecting() {
        return disableEuProspecting;
    }

    public void setDisableEuProspecting(Boolean disableEuProspecting) {
        this.disableEuProspecting = disableEuProspecting;
    }

    public Integer getPartialResultsLimit() {
        return partialResultsLimit;
    }

    public void setPartialResultsLimit(Integer partialResultsLimit) {
        this.partialResultsLimit = partialResultsLimit;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    /**
     * Represents pagination information in API responses.
     */
    public static class Pagination {
        private Integer page;

        @SerializedName("per_page")
        private Integer perPage;

        @SerializedName("total_entries")
        private Integer totalEntries;

        @SerializedName("total_pages")
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

    /**
     * Represents breadcrumb information in API responses.
     */
    public static class Breadcrumb {
        private String label;
        private String signal_field_name;
        private String value;
        private Integer displayOrder;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getSignal_field_name() {
            return signal_field_name;
        }

        public void setSignal_field_name(String signal_field_name) {
            this.signal_field_name = signal_field_name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Integer getDisplayOrder() {
            return displayOrder;
        }

        public void setDisplayOrder(Integer displayOrder) {
            this.displayOrder = displayOrder;
        }
    }
}
