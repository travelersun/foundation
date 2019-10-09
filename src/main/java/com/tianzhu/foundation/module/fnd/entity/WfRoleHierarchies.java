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
 * 角色与职责层次关系结构表
 * </p>
 *
 * @author Maya
 * @since 2019-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WF_ROLE_HIERARCHIES")
public class WfRoleHierarchies implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关系id
     */
    @TableId("RELATIONSHIP_ID")
    private Long relationshipId;

    /**
     * 子级名称
     */
    @TableField("SUB_NAME")
    private String subName;

    /**
     * 上级名称
     */
    @TableField("SUPER_NAME")
    private String superName;

    /**
     * 启用标识Y:N
     */
    @TableField("ENABLED_FLAG")
    private String enabledFlag;

    /**
     * 安全组id
     */
    @TableField("SECURITY_GROUP_ID")
    private Long securityGroupId;

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;


}
