package com.tianzhu.foundation.module.fnd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * PER_ORGANIZATION_LIST holds the list of organizations that a secure
user can access. This list is created and maintained by the LISTGEN
security process using the definition of the security profile. Rows
are created for all profiles that have the VIEW_ALL_ORGANIZATIONS_FLAG
set to N.
 * </p>
 *
 * @author Maya
 * @since 2019-10-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PER_ORGANIZATION_LIST")
public class PerOrganizationList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("SECURITY_PROFILE_ID")
    private Long securityProfileId;

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

    @TableField("USER_ID")
    private String userId;


}
