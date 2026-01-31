package io.apollo.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents an organization in the Apollo.io API.
 */
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

    // Getters and Setters

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

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getAngellistUrl() {
        return angellistUrl;
    }

    public void setAngellistUrl(String angellistUrl) {
        this.angellistUrl = angellistUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public PhoneNumber getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(PhoneNumber primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Integer getAlexaRanking() {
        return alexaRanking;
    }

    public void setAlexaRanking(Integer alexaRanking) {
        this.alexaRanking = alexaRanking;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLinkedinUid() {
        return linkedinUid;
    }

    public void setLinkedinUid(String linkedinUid) {
        this.linkedinUid = linkedinUid;
    }

    public Integer getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(Integer foundedYear) {
        this.foundedYear = foundedYear;
    }

    public String getPubliclyTradedSymbol() {
        return publiclyTradedSymbol;
    }

    public void setPubliclyTradedSymbol(String publiclyTradedSymbol) {
        this.publiclyTradedSymbol = publiclyTradedSymbol;
    }

    public String getPubliclyTradedExchange() {
        return publiclyTradedExchange;
    }

    public void setPubliclyTradedExchange(String publiclyTradedExchange) {
        this.publiclyTradedExchange = publiclyTradedExchange;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCrunchbaseUrl() {
        return crunchbaseUrl;
    }

    public void setCrunchbaseUrl(String crunchbaseUrl) {
        this.crunchbaseUrl = crunchbaseUrl;
    }

    public String getPrimaryDomain() {
        return primaryDomain;
    }

    public void setPrimaryDomain(String primaryDomain) {
        this.primaryDomain = primaryDomain;
    }

    public Object getPersonaCounts() {
        return personaCounts;
    }

    public void setPersonaCounts(Object personaCounts) {
        this.personaCounts = personaCounts;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public Integer getEstimatedNumEmployees() {
        return estimatedNumEmployees;
    }

    public void setEstimatedNumEmployees(Integer estimatedNumEmployees) {
        this.estimatedNumEmployees = estimatedNumEmployees;
    }

    public List<String> getIndustriesList() {
        return industriesList;
    }

    public void setIndustriesList(List<String> industriesList) {
        this.industriesList = industriesList;
    }

    public List<String> getSecondaryIndustries() {
        return secondaryIndustries;
    }

    public void setSecondaryIndustries(List<String> secondaryIndustries) {
        this.secondaryIndustries = secondaryIndustries;
    }

    public Boolean getSnippetsLoaded() {
        return snippetsLoaded;
    }

    public void setSnippetsLoaded(Boolean snippetsLoaded) {
        this.snippetsLoaded = snippetsLoaded;
    }

    public String getIndustry_tag_id() {
        return industry_tag_id;
    }

    public void setIndustry_tag_id(String industry_tag_id) {
        this.industry_tag_id = industry_tag_id;
    }

    public Integer getRetailLocationCount() {
        return retailLocationCount;
    }

    public void setRetailLocationCount(Integer retailLocationCount) {
        this.retailLocationCount = retailLocationCount;
    }

    public String getRawAddress() {
        return rawAddress;
    }

    public void setRawAddress(String rawAddress) {
        this.rawAddress = rawAddress;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", industry='" + industry + '\'' +
                ", estimatedNumEmployees=" + estimatedNumEmployees +
                '}';
    }
}
