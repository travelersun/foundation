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
 * FND_LOOKUP_VALUES stores Oracle Application Object Library QuickCode
values. Each row includes the QuickCode lookup type, the QuickCode
itself, its meaning, and additional description, as well as values
that indicate whether this QuickCode is currently valid. Each row
also includes a language code that indicates what language the
information is in. You need one row for each QuickCode in each of
the languages installed at your site. Oracle Application Object
Library uses this information to display LOVs for Oracle
Application Object Library forms and other forms.
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FND_LOOKUP_VALUES")
public class FndLookupValues implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * QuickCode lookup type
     */
    @TableField("LOOKUP_TYPE")
    private String lookupType;

    /**
     * QuickCode code
     */
    @TableField("LOOKUP_CODE")
    private String lookupCode;

    @TableField("SECURITY_GROUP_ID")
    private Long securityGroupId;

    @TableField("VIEW_APPLICATION_ID")
    private Long viewApplicationId;

    /**
     * QuickCode meaning
     */
    @TableField("MEANING")
    private String meaning;

    /**
     * Description
     */
    @TableField("DESCRIPTION")
    private String description;

    /**
     * Enabled flag
     */
    @TableField("ENABLED_FLAG")
    private String enabledFlag;

    /**
     * The date when the QuickCode becomes active
     */
    @TableField("START_DATE_ACTIVE")
    private Date startDateActive;

    /**
     * The date when the QuickCode becomes inactive
     */
    @TableField("END_DATE_ACTIVE")
    private Date endDateActive;

    /**
     * Optional additional category for lookup values
     */
    @TableField("TAG")
    private String tag;

    /**
     * Leaf Node Flag
     */
    @TableField("LEAF_NODE")
    private String leafNode;

    /**
     * Attribute category
     */
    @TableField("ATTRIBUTE_CATEGORY")
    private String attributeCategory;

    /**
     * Attribute
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

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;


}
