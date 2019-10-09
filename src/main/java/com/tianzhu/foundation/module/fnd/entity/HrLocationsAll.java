package com.tianzhu.foundation.module.fnd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HR_LOCATIONS_ALL")
public class HrLocationsAll implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("LOCATION_ID")
    private Long locationId;

    @TableField("LOCATION_CODE")
    private String locationCode;

    @TableField("BUSINESS_GROUP_ID")
    private Long businessGroupId;

    @TableField("DESCRIPTION")
    private String description;

    @TableField("SCOPE")
    private String scope;

    @TableField("INACTIVE_DATE")
    private Date inactiveDate;

    @TableField("LEGAL_ADDRESS_FLAG")
    private String legalAddressFlag;

    @TableField("STYLE")
    private String style;

    @TableField("TIMEZONE_CODE")
    private String timezoneCode;

    @TableField("ADDRESS_LINE_1")
    private String addressLine1;

    @TableField("ADDRESS_LINE_2")
    private String addressLine2;

    @TableField("ADDRESS_LINE_3")
    private String addressLine3;

    @TableField("COUNTRY")
    private String country;

    @TableField("PROVINCE")
    private String province;

    @TableField("TOWN_OR_CITY")
    private String townOrCity;

    @TableField("POST_CODE")
    private String postCode;

    @TableField("AREA_CODE")
    private String areaCode;

    @TableField("FAX")
    private String fax;

    @TableField("TELEPHONE_NUMBER_1")
    private String telephoneNumber1;

    @TableField("TELEPHONE_NUMBER_2")
    private String telephoneNumber2;

    @TableField("TELEPHONE_NUMBER_3")
    private String telephoneNumber3;

    @TableField("TAX_NAME")
    private String taxName;

    @TableField("REGION_1")
    private String region1;

    @TableField("REGION_2")
    private String region2;

    @TableField("REGION_3")
    private String region3;

    @TableField("CONTACT")
    private String contact;

    @TableField("SHIP_TO_LOCATION_ID")
    private Long shipToLocationId;

    @TableField("SHIP_TO_SITE_FLAG")
    private String shipToSiteFlag;

    @TableField("RECEIVING_SITE_FLAG")
    private String receivingSiteFlag;

    @TableField("BILL_TO_SITE_FLAG")
    private String billToSiteFlag;

    @TableField("IN_ORGANIZATION_FLAG")
    private String inOrganizationFlag;

    @TableField("OFFICE_SITE_FLAG")
    private String officeSiteFlag;

    @TableField("ECE_TP_LOCATION_CODE")
    private String eceTpLocationCode;

    @TableField("GEOMETRY")
    private String geometry;

    @TableField("INVENTORY_ORGANIZATION_ID")
    private Long inventoryOrganizationId;

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("OBJECT_VERSION_NUMBER")
    private Integer objectVersionNumber;

    @TableField("LOC_INFORMATION13")
    private String locInformation13;

    @TableField("LOC_INFORMATION14")
    private String locInformation14;

    @TableField("LOC_INFORMATION15")
    private String locInformation15;

    @TableField("LOC_INFORMATION16")
    private String locInformation16;

    @TableField("LOC_INFORMATION17")
    private String locInformation17;

    @TableField("LOC_INFORMATION18")
    private String locInformation18;

    @TableField("LOC_INFORMATION19")
    private String locInformation19;

    @TableField("LOC_INFORMATION20")
    private String locInformation20;

    @TableField("ATTRIBUTE_CATEGORY")
    private String attributeCategory;

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

    @TableField("GLOBAL_ATTRIBUTE_CATEGORY")
    private String globalAttributeCategory;

    @TableField("GLOBAL_ATTRIBUTE1")
    private String globalAttribute1;

    @TableField("GLOBAL_ATTRIBUTE2")
    private String globalAttribute2;

    @TableField("GLOBAL_ATTRIBUTE3")
    private String globalAttribute3;

    @TableField("GLOBAL_ATTRIBUTE4")
    private String globalAttribute4;

    @TableField("GLOBAL_ATTRIBUTE5")
    private String globalAttribute5;

    @TableField("GLOBAL_ATTRIBUTE6")
    private String globalAttribute6;

    @TableField("GLOBAL_ATTRIBUTE7")
    private String globalAttribute7;

    @TableField("GLOBAL_ATTRIBUTE8")
    private String globalAttribute8;

    @TableField("GLOBAL_ATTRIBUTE9")
    private String globalAttribute9;

    @TableField("GLOBAL_ATTRIBUTE10")
    private String globalAttribute10;

    @TableField("GLOBAL_ATTRIBUTE11")
    private String globalAttribute11;

    @TableField("GLOBAL_ATTRIBUTE12")
    private String globalAttribute12;

    @TableField("GLOBAL_ATTRIBUTE13")
    private String globalAttribute13;

    @TableField("GLOBAL_ATTRIBUTE14")
    private String globalAttribute14;

    @TableField("GLOBAL_ATTRIBUTE15")
    private String globalAttribute15;

    @TableField("GLOBAL_ATTRIBUTE16")
    private String globalAttribute16;

    @TableField("GLOBAL_ATTRIBUTE17")
    private String globalAttribute17;

    @TableField("GLOBAL_ATTRIBUTE18")
    private String globalAttribute18;

    @TableField("GLOBAL_ATTRIBUTE19")
    private String globalAttribute19;

    @TableField("GLOBAL_ATTRIBUTE20")
    private String globalAttribute20;


}
