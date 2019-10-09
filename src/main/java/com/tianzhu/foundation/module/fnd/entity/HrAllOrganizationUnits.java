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
 * HR_ALL_ORGANIZATION_UNITS holds the definitions that identify business
groups and the organization units within a single business group.
Additional information about classifications and information types for
each organization is held in HR_ORGANIZATION_INFORMATION.
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HR_ALL_ORGANIZATION_UNITS")
public class HrAllOrganizationUnits implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ORGANIZATION_ID")
    private Long organizationId;

    @TableField("BUSINESS_GROUP_ID")
    private Long businessGroupId;

    /**
     * 组织名称
     */
    @TableField("NAME")
    private String name;

    @TableField("COST_ALLOCATION_KEYFLEX_ID")
    private Long costAllocationKeyflexId;

    @TableField("LOCATION_ID")
    private Long locationId;

    /**
     * 开始时间
     */
    @TableField("DATE_FROM")
    private Date dateFrom;

    /**
     * 截止时间
     */
    @TableField("DATE_TO")
    private Date dateTo;

    /**
     * 是内部组织还是外部组织
     */
    @TableField("INTERNAL_EXTERNAL_FLAG")
    private String internalExternalFlag;

    /**
     * 内部组织地址行
     */
    @TableField("INTERNAL_ADDRESS_LINE")
    private String internalAddressLine;

    /**
     * 组织类型
     */
    @TableField("TYPE")
    private String type;

    @TableField("REQUEST_ID")
    private Long requestId;

    @TableField("PROGRAM_APPLICATION_ID")
    private Long programApplicationId;

    @TableField("PROGRAM_ID")
    private Long programId;

    /**
     * 程序更新时间
     */
    @TableField("PROGRAM_UPDATE_DATE")
    private Date programUpdateDate;

    /**
     * 版本号
     */
    @TableField("OBJECT_VERSION_NUMBER")
    private Integer objectVersionNumber;

    @TableField("PARTY_ID")
    private Long partyId;

    /**
     * 备注
     */
    @TableField("COMMENTS")
    private String comments;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    /**
     * Descriptive flexfield structure defining column
     */
    @TableField("ATTRIBUTE_CATEGORY")
    private String attributeCategory;

    /**
     * Descriptive flexfield column
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

    @TableField("ATTRIBUTE21")
    private String attribute21;

    @TableField("ATTRIBUTE22")
    private String attribute22;

    @TableField("ATTRIBUTE23")
    private String attribute23;

    @TableField("ATTRIBUTE24")
    private String attribute24;

    @TableField("ATTRIBUTE25")
    private String attribute25;

    @TableField("ATTRIBUTE26")
    private String attribute26;

    @TableField("ATTRIBUTE27")
    private String attribute27;

    @TableField("ATTRIBUTE28")
    private String attribute28;

    @TableField("ATTRIBUTE29")
    private String attribute29;

    @TableField("ATTRIBUTE30")
    private String attribute30;


}
