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
 * 系统职责基本表
 * </p>
 *
 * @author Maya
 * @since 2019-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FND_RESPONSIBILITY")
public class FndResponsibility implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 职责id
     */
    @TableId("RESPONSIBILITY_ID")
    private Long responsibilityId;

    /**
     * 职责所属应用id
     */
    @TableField("APPLICATION_ID")
    private Long applicationId;

    @TableField("RESPONSIBILITY_NAME")
    private String responsibilityName;

    /**
     * 职责key值
     */
    @TableField("RESPONSIBILITY_KEY")
    private String responsibilityKey;

    /**
     * 职责的顶层菜单id
     */
    @TableField("MENU_ID")
    private Long menuId;

    /**
     * 职责所属请求组
     */
    @TableField("REQUEST_GROUP_ID")
    private Long requestGroupId;

    /**
     * 职责所属数据组
     */
    @TableField("DATA_GROUP_ID")
    private Long dataGroupId;

    /**
     * 职责所属数据组的应用id
     */
    @TableField("DATA_GROUP_APPLICATION_ID")
    private Long dataGroupApplicationId;

    /**
     * 职责所属安全组(SECURITY_GROUP)id
     */
    @TableField("GROUP_APPLICATION_ID")
    private Long groupApplicationId;

    /**
     * The date the responsibility becomes active
     */
    @TableField("START_DATE")
    private Date startDate;

    /**
     * The date the responsibility expires
     */
    @TableField("END_DATE")
    private Date endDate;

    /**
     * 职责版本号
     */
    @TableField("VERSION")
    private String version;

    @TableField("RESPONSIBILITY_DESCRIPTION")
    private String responsibilityDescription;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("CREATED_BY")
    private String createdBy;


}
