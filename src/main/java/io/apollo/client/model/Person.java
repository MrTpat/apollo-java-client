package io.apollo.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * Represents a person in the Apollo.io API.
 */
@Data
public class Person {
    private String id;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    private String name;

    @SerializedName("linkedin_url")
    private String linkedinUrl;

    private String title;

    @SerializedName("email_status")
    private String emailStatus;

    @SerializedName("photo_url")
    private String photoUrl;

    private String twitter;
    private String github;
    private String facebook;

    @SerializedName("extrapolated_email_confidence")
    private Double extrapolatedEmailConfidence;

    private String headline;
    private String email;

    @SerializedName("organization_id")
    private String organizationId;

    @SerializedName("employment_history")
    private List<Employment> employmentHistory;

    private String state;
    private String city;
    private String country;

    @SerializedName("organization_name")
    private String organizationName;

    @SerializedName("organization")
    private Organization organization;
}
