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
 * PER_ORG_STRUCTURE_ELEMENTS holds information on the hierarchical
relationship between organizations in a specific hierarchy version.
Each row stores one parent-child relationship. The parent is
identified by ORGANIZATION_ID_PARENT and the child is identified by
ORGANIZATION_ID_CHILD. An organization can never be its own parent or
child, and the top organization in a hierarchy will never appear in
ORGANIZATION_ID_CHILD.
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PER_ORG_STRUCTURE_ELEMENTS")
public class PerOrgStructureElements implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ORG_STRUCTURE_ELEMENT_ID")
    private Long orgStructureElementId;

    @TableField("BUSINESS_GROUP_ID")
    private Long businessGroupId;

    @TableField("ORGANIZATION_ID_PARENT")
    private Long organizationIdParent;

    @TableField("ORG_STRUCTURE_VERSION_ID")
    private Long orgStructureVersionId;

    @TableField("ORG_STRUCTURE_ID")
    private Long orgStructureId;

    @TableField("ORGANIZATION_ID_CHILD")
    private Long organizationIdChild;

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

    @TableField("ORDER_RANK")
    private Integer orderRank;

    /**
     * Position Control flag
     */
    @TableField("POSITION_CONTROL_ENABLED_FLAG")
    private String positionControlEnabledFlag;

    @TableField("PARTY_ID")
    private Long partyId;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("CREATED_BY")
    private Date createdBy;

    @TableField("CREATION_DATE")
    private String creationDate;


}
