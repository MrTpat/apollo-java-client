package io.apollo.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * Represents an organization in the Apollo.io API.
 */
@Data
public class Organization {
    private String id;
    private String name;

    @SerializedName("website_url")
    private String websiteUrl;

    @SerializedName("blog_url")
    private String blogUrl;

    @SerializedName("angellist_url")
    private String angellistUrl;

    @SerializedName("linkedin_url")
    private String linkedinUrl;

    @SerializedName("twitter_url")
    private String twitterUrl;

    @SerializedName("facebook_url")
    private String facebookUrl;

    @SerializedName("primary_phone")
    private PhoneNumber primaryPhone;

    private List<String> languages;

    @SerializedName("alexa_ranking")
    private Integer alexaRanking;

    private String phone;

    @SerializedName("linkedin_uid")
    private String linkedinUid;

    @SerializedName("founded_year")
    private Integer foundedYear;

    @SerializedName("publicly_traded_symbol")
    private String publiclyTradedSymbol;

    @SerializedName("publicly_traded_exchange")
    private String publiclyTradedExchange;

    @SerializedName("logo_url")
    private String logoUrl;

    @SerializedName("crunchbase_url")
    private String crunchbaseUrl;

    @SerializedName("primary_domain")
    private String primaryDomain;

    @SerializedName("persona_counts")
    private Object personaCounts;

    private String industry;
    private List<String> keywords;

    @SerializedName("estimated_num_employees")
    private Integer estimatedNumEmployees;

    @SerializedName("industries")
    private List<String> industriesList;

    @SerializedName("secondary_industries")
    private List<String> secondaryIndustries;

    @SerializedName("snippets_loaded")
    private Boolean snippetsLoaded;

    private String industry_tag_id;

    @SerializedName("retail_location_count")
    private Integer retailLocationCount;

    @SerializedName("raw_address")
    private String rawAddress;

    private String street_address;
    private String city;
    private String state;
    private String country;

    @SerializedName("postal_code")
    private String postalCode;
}
