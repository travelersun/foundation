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
 * 用户直接职责授权关系表
 * </p>
 *
 * @author Maya
 * @since 2019-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WF_USER_ROLE_ASSIGNMENTS")
public class WfUserRoleAssignments implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @TableId("USER_NAME")
    private String userName;

    /**
     * 角色/职责名称
     */
    @TableField("ROLE_NAME")
    private String roleName;

    /**
     * 关系id,-1表示直接关系
     */
    @TableField("RELATIONSHIP_ID")
    private Long relationshipId;

    /**
     * 授予的角色
     */
    @TableField("ASSIGNING_ROLE")
    private String assigningRole;

    /**
     * 授予开始时间
     */
    @TableField("START_DATE")
    private Date startDate;

    /**
     * 授予结束时间
     */
    @TableField("END_DATE")
    private Date endDate;

    /**
     * 用户开始时间
     */
    @TableField("USER_START_DATE")
    private Date userStartDate;

    /**
     * 角色/职责开始时间
     */
    @TableField("ROLE_START_DATE")
    private Date roleStartDate;

    /**
     * 授予角色开始时间
     */
    @TableField("ASSIGNING_ROLE_START_DATE")
    private Date assigningRoleStartDate;

    /**
     * 用户结束时间
     */
    @TableField("USER_END_DATE")
    private Date userEndDate;

    /**
     * 角色结束时间
     */
    @TableField("ROLE_END_DATE")
    private Date roleEndDate;

    /**
     * 授予角色结束时间
     */
    @TableField("ASSIGNING_ROLE_END_DATE")
    private Date assigningRoleEndDate;

    /**
     * 生效开始时间
     */
    @TableField("EFFECTIVE_START_DATE")
    private Date effectiveStartDate;

    /**
     * 生效结束时间
     */
    @TableField("EFFECTIVE_END_DATE")
    private Date effectiveEndDate;

    /**
     * 用户来源的系统
     */
    @TableField("USER_ORIG_SYSTEM")
    private String userOrigSystem;

    /**
     * 用户来源的系统用户id
     */
    @TableField("USER_ORIG_SYSTEM_ID")
    private String userOrigSystemId;

    /**
     * 角色来源系统
     */
    @TableField("ROLE_ORIG_SYSTEM")
    private String roleOrigSystem;

    /**
     * 来源角色的角色id
     */
    @TableField("ROLE_ORIG_SYSTEM_ID")
    private String roleOrigSystemId;

    /**
     * 授予原因
     */
    @TableField("ASSIGNMENT_REASON")
    private String assignmentReason;

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;


}
