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
 * FND_LOOKUP_TYPES stores Oracle Application Object Library
QuickCode types. Each row includes the QuickCode lookup type
and the application the lookup type belongs to. 
Each row also includes the customization level for the
lookup type, the security group the lookup type belongs to, 
and the application view through with the lookup type will be exposed. 
You need one row for each QuickCode lookup type. 
Oracle Application Object Library uses this information to display
LOVs for Oracle Application Object Library forms and other
forms.
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FND_LOOKUP_TYPES")
public class FndLookupTypes implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("APPLICATION_ID")
    private Long applicationId;

    /**
     * QuickCode lookup type
     */
    @TableField("LOOKUP_TYPE")
    private String lookupType;

    @TableField("SECURITY_GROUP_ID")
    private Long securityGroupId;

    @TableField("VIEW_APPLICATION_ID")
    private Long viewApplicationId;

    /**
     * Customization level
     */
    @TableField("CUSTOMIZATION_LEVEL")
    private String customizationLevel;

    /**
     * Assign Leaf Only Flag
     */
    @TableField("ASSIGN_LEAF_ONLY")
    private String assignLeafOnly;

    @TableField("DESCRIPTION")
    private String description;

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;


}
