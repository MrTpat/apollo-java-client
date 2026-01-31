package io.apollo.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Represents a phone number.
 */
@Data
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
}
