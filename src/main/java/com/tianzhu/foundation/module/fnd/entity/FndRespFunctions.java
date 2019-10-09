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
 * FND_RESP_FUNCTIONS stores security exclusion rules
for function security menus. Security
exclusion rules are lists of functions and menus inaccessible
to a particular responsibility. Each row includes an action
identifier whose value is dependent on the rule type.
(ACTION_ID=FUNCTION_ID from fnd_form_functions if
RULE_TYPE='F' or ACTION_ID=MENU_ID from FND_MENUS
if RULE_TYPE='M')
 * </p>
 *
 * @author Maya
 * @since 2019-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FND_RESP_FUNCTIONS")
public class FndRespFunctions implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("EXCLUSION_ID")
    private Long exclusionId;

    @TableField("APPLICATION_ID")
    private Long applicationId;

    @TableField("RESPONSIBILITY_ID")
    private Long responsibilityId;

    @TableField("ACTION_ID")
    private Long actionId;

    /**
     * Rule type F:function OR M:menu
     */
    @TableField("RULE_TYPE")
    private String ruleType;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("CREATED_BY")
    private String createdBy;


}
