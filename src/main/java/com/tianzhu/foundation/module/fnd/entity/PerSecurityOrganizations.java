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
 * Descrete list of organizations to exclude or include from 
per_organization_list during security list maintainence
 * </p>
 *
 * @author Maya
 * @since 2019-10-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PER_SECURITY_ORGANIZATIONS")
public class PerSecurityOrganizations implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * security organization identifier
     */
    @TableId("SECURITY_ORGANIZATION_ID")
    private Long securityOrganizationId;

    /**
     * organization identifier
     */
    @TableField("ORGANIZATION_ID")
    private Long organizationId;

    /**
     * security profile identifier
     */
    @TableField("SECURITY_PROFILE_ID")
    private Long securityProfileId;

    /**
     * entry type include (I) or exclude (E)
     */
    @TableField("ENTRY_TYPE")
    private String entryType;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("OBJECT_VERSION_NUMBER")
    private Integer objectVersionNumber;


}
