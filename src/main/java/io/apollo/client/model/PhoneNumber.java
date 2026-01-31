package io.apollo.client.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a phone number.
 */
public class PhoneNumber {

    private String number;

    @SerializedName("sanitized_number")
    private String sanitizedNumber;

    private String type;

    private Integer position;

    private String status;

    @SerializedName("dnc_status")
    private String dncStatus;

    @SerializedName("dnc_other_info")
    private String dncOtherInfo;

    // Getters and Setters

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSanitizedNumber() {
        return sanitizedNumber;
    }

    public void setSanitizedNumber(String sanitizedNumber) {
        this.sanitizedNumber = sanitizedNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDncStatus() {
        return dncStatus;
    }

    public void setDncStatus(String dncStatus) {
        this.dncStatus = dncStatus;
    }

    public String getDncOtherInfo() {
        return dncOtherInfo;
    }

    public void setDncOtherInfo(String dncOtherInfo) {
        this.dncOtherInfo = dncOtherInfo;
    }
}
