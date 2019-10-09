package com.tianzhu.foundation.module.fnd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * HR_ORGANIZATION_INFORMATION is used to hold two distinct sets of
organization information. When ORG_INFORMATION_CONTEXT is set to
CLASS this table acts as an intersection table between organizations
and organization classifications. ORGANIZATION_ID identifies the
organization and ORG_INFORMATION1 holds the organization
classification name. This information is maintained by the
organization classifications block of the Organization form. When
ORG_INFORMATION_CONTEXT is set to an information type held in
HR_ORG_INFORMATION_TYPES the ORG_INFORMATION1-20 columns hold details
for the specific information type. This information is maintained by
a predefined protected descriptive flexfield. (Org Developer DF.)
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HR_ORGANIZATION_INFORMATION")
public class HrOrganizationInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ORG_INFORMATION_ID")
    private Long orgInformationId;

    /**
     * Developer descriptive flexfield column
     */
    @TableField("ORG_INFORMATION_CONTEXT")
    private String orgInformationContext;

    @TableField("ORGANIZATION_ID")
    private Long organizationId;

    @TableField("REQUEST_ID")
    private Long requestId;

    @TableField("PROGRAM_APPLICATION_ID")
    private Long programApplicationId;

    @TableField("PROGRAM_ID")
    private Long programId;

    @TableField("PROGRAM_UPDATE_DATE")
    private Date programUpdateDate;

    @TableField("OBJECT_VERSION_NUMBER")
    private Integer objectVersionNumber;

    @TableField("PARTY_ID")
    private Long partyId;

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    /**
     * Developer descriptive flexfield column
     */
    @TableField("ORG_INFORMATION1")
    private String orgInformation1;

    @TableField("ORG_INFORMATION2")
    private String orgInformation2;

    @TableField("ORG_INFORMATION3")
    private String orgInformation3;

    @TableField("ORG_INFORMATION4")
    private String orgInformation4;

    @TableField("ORG_INFORMATION5")
    private String orgInformation5;

    @TableField("ORG_INFORMATION6")
    private String orgInformation6;

    @TableField("ORG_INFORMATION7")
    private String orgInformation7;

    @TableField("ORG_INFORMATION8")
    private String orgInformation8;

    @TableField("ORG_INFORMATION9")
    private String orgInformation9;

    @TableField("ORG_INFORMATION10")
    private String orgInformation10;

    @TableField("ORG_INFORMATION11")
    private String orgInformation11;

    @TableField("ORG_INFORMATION12")
    private String orgInformation12;

    @TableField("ORG_INFORMATION13")
    private String orgInformation13;

    @TableField("ORG_INFORMATION14")
    private String orgInformation14;

    @TableField("ORG_INFORMATION15")
    private String orgInformation15;

    @TableField("ORG_INFORMATION16")
    private String orgInformation16;

    @TableField("ORG_INFORMATION17")
    private String orgInformation17;

    @TableField("ORG_INFORMATION18")
    private String orgInformation18;

    @TableField("ORG_INFORMATION19")
    private String orgInformation19;

    @TableField("ORG_INFORMATION20")
    private String orgInformation20;

    /**
     * Descriptive flexfield structure defining column
     */
    @TableField("ATTRIBUTE_CATEGORY")
    private String attributeCategory;

    /**
     * Descriptive flexfield column.
     */
    @TableField("ATTRIBUTE1")
    private String attribute1;

    @TableField("ATTRIBUTE2")
    private String attribute2;

    @TableField("ATTRIBUTE3")
    private String attribute3;

    @TableField("ATTRIBUTE4")
    private String attribute4;

    @TableField("ATTRIBUTE5")
    private String attribute5;

    @TableField("ATTRIBUTE6")
    private String attribute6;

    @TableField("ATTRIBUTE7")
    private String attribute7;

    @TableField("ATTRIBUTE8")
    private String attribute8;

    @TableField("ATTRIBUTE9")
    private String attribute9;

    @TableField("ATTRIBUTE10")
    private String attribute10;

    @TableField("ATTRIBUTE11")
    private String attribute11;

    @TableField("ATTRIBUTE12")
    private String attribute12;

    @TableField("ATTRIBUTE13")
    private String attribute13;

    @TableField("ATTRIBUTE14")
    private String attribute14;

    @TableField("ATTRIBUTE15")
    private String attribute15;

    @TableField("ATTRIBUTE16")
    private String attribute16;

    @TableField("ATTRIBUTE17")
    private String attribute17;

    @TableField("ATTRIBUTE18")
    private String attribute18;

    @TableField("ATTRIBUTE19")
    private String attribute19;

    @TableField("ATTRIBUTE20")
    private String attribute20;


}
