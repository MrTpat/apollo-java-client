package io.apollo.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents a person in the Apollo.io API.
 */
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

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(String emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Double getExtrapolatedEmailConfidence() {
        return extrapolatedEmailConfidence;
    }

    public void setExtrapolatedEmailConfidence(Double extrapolatedEmailConfidence) {
        this.extrapolatedEmailConfidence = extrapolatedEmailConfidence;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public List<Employment> getEmploymentHistory() {
        return employmentHistory;
    }

    public void setEmploymentHistory(List<Employment> employmentHistory) {
        this.employmentHistory = employmentHistory;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", organizationName='" + organizationName + '\'' +
                '}';
    }
}
