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
 * FND_PROFILE_OPTION_VALUES stores values for user profile options.
Each row includes values that identify the profile option, the
profile level, the user, responsibility, application or site for
whom the profile value is set (LEVEL_VALUE). Each row also include
the actual value for the option (always a CHAR string). If the
option is set for a responsibility, LEVEL_VALUE_APPLICATION_ID
identifies the application that has the responsibility. You need
one row for each profile option setting (at each level, for each
user, and so on). Oracle Application Object Library uses this
information to operate applications according to user profiles.
 * </p>
 *
 * @author Maya
 * @since 2019-10-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FND_PROFILE_OPTION_VALUES")
public class FndProfileOptionValues implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("APPLICATION_ID")
    private Long applicationId;

    @TableField("PROFILE_OPTION_ID")
    private Long profileOptionId;

    @TableField("LEVEL_ID")
    private Long levelId;

    /**
     * The value of the profile level
     */
    @TableField("LEVEL_VALUE")
    private Integer levelValue;

    @TableField("LEVEL_VALUE_APPLICATION_ID")
    private Long levelValueApplicationId;

    /**
     * Used in the Server/Responsibility level of the SERVRESP hierarchy to store the server_id or a default value
     */
    @TableField("LEVEL_VALUE2")
    private Integer levelValue2;

    /**
     * The value of the profile option
     */
    @TableField("PROFILE_OPTION_VALUE")
    private String profileOptionValue;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("CREATED_BY")
    private String createdBy;


}
