package io.apollo.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * Response object for people search requests.
 */
@Data
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

    /**
     * Represents pagination information in API responses.
     */
    @Data
    public static class Pagination {
        private Integer page;

        @SerializedName("per_page")
        private Integer perPage;

        @SerializedName("total_entries")
        private Integer totalEntries;

        @SerializedName("total_pages")
        private Integer totalPages;
    }

    /**
     * Represents breadcrumb information in API responses.
     */
    @Data
    public static class Breadcrumb {
        private String label;
        private String signal_field_name;
        private String value;
        private Integer displayOrder;
    }
}
