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
 * PER_ORGANIZATION_STRUCTURES holds information about organization
hierarchies defined for each Business Group. You can have any number
of hierarchies in one Business Group, but only one hierarchy can have
the PRIMARY_STRUCTURE_FLAG set to Y.
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PER_ORGANIZATION_STRUCTURES")
public class PerOrganizationStructures implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ORGANIZATION_STRUCTURE_ID")
    private Long organizationStructureId;

    @TableField("BUSINESS_GROUP_ID")
    private Long businessGroupId;

    /**
     * Name of organization hierarchy
     */
    @TableField("NAME")
    private String name;

    /**
     * Identifies the primary organization hierarchy for a business group, (Y/N).
     */
    @TableField("PRIMARY_STRUCTURE_FLAG")
    private String primaryStructureFlag;

    @TableField("REQUEST_ID")
    private Long requestId;

    @TableField("PROGRAM_APPLICATION_ID")
    private Long programApplicationId;

    @TableField("PROGRAM_ID")
    private Long programId;

    @TableField("PROGRAM_UPDATE_DATE")
    private Date programUpdateDate;

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

    /**
     * Position Control Structure Flg
     */
    @TableField("POSITION_CONTROL_STRUCTURE_FLG")
    private String positionControlStructureFlg;

    /**
     * OBJECT VERSION NUMBER
     */
    @TableField("OBJECT_VERSION_NUMBER")
    private Integer objectVersionNumber;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    /**
     * General remark
     */
    @TableField("COMMENTS")
    private String comments;

    @TableField("DATE_FROM")
    private Date dateFrom;

    @TableField("DATE_TO")
    private Date dateTo;

    @TableField("VERSION_NUMBER")
    private Integer versionNumber;

}
