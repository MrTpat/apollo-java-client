package io.apollo.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Request object for searching people.
 */
@Data
@Builder
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
}
