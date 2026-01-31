package io.apollo.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Represents employment history entry for a person.
 */
@Data
public class Employment {
    private String id;

    @SerializedName("created_at")
    private String createdAt;

    private Boolean current;
    private String degree;
    private String description;
    private String emails;

    @SerializedName("end_date")
    private String endDate;

    @SerializedName("grade_level")
    private String gradeLevel;

    private String kind;
    private String major;

    @SerializedName("organization_id")
    private String organizationId;

    @SerializedName("organization_name")
    private String organizationName;

    @SerializedName("raw_address")
    private String rawAddress;

    @SerializedName("start_date")
    private String startDate;

    private String title;

    @SerializedName("updated_at")
    private String updatedAt;

    private String key;
}
