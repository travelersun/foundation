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
 * 系统菜单基本表
 * </p>
 *
 * @author Maya
 * @since 2019-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FND_MENUS")
public class FndMenus implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("MENU_ID")
    private Long menuId;

    /**
     * 菜单名称
     */
    @TableField("MENU_NAME")
    private String menuName;

    /**
     * 菜单代码
     */
    @TableField("MENU_CODE")
    private String menuCode;

    @TableField("PATH")
    private String path;

    /**
     * 菜单类型
     */
    @TableField("TYPE")
    private String type;

    @TableField("REDIRECT")
    private String redirect;

    @TableField("COMPONENT")
    private String component;

    @TableField("ALWAYS_SHOW")
    private Integer alwaysShow;

    @TableField("DESCRIPTION")
    private String description;

    @TableField("META")
    private String meta;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("CREATED_BY")
    private String createdBy;


}
