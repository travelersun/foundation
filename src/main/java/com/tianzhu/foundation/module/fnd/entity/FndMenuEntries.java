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
 * 系统菜单入口表
 * </p>
 *
 * @author Maya
 * @since 2019-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FND_MENU_ENTRIES")
public class FndMenuEntries implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ENTRY_ID")
    private Long entryId;

    @TableField("MENU_ID")
    private Long menuId;

    /**
     * 进入序号
     */
    @TableField("ENTRY_SEQUENCE")
    private Integer entrySequence;

    @TableField("SUB_MENU_ID")
    private Long subMenuId;

    @TableField("FUNCTION_ID")
    private Long functionId;

    @TableField("GRANT_FLAG")
    private String grantFlag;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("CREATED_BY")
    private String createdBy;


}
