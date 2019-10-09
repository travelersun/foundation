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
 * FND_PROFILE_OPTIONS stores information about user profile options.
Each row includes names (the actual profile option name and the
more descriptive end-user name) and a description of the profile
option. Each row also includes the LOV definition, if any,
that this profile option uses to ensure that users enter a valid
value for the option, as well as flags that indicate whether users
can see or change its value and flags that indicate whether certain
Oracle Application Object Library routines can manipulate this
option. Each row also includes start and end dates, if any, for
this option. You need one row for each profile option (other than
internally generated profile options). Oracle Application Object
Library uses this information to generate user profiles.
 * </p>
 *
 * @author Maya
 * @since 2019-10-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FND_PROFILE_OPTIONS")
public class FndProfileOptions implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("PROFILE_OPTION_ID")
    private Long profileOptionId;

    @TableField("APPLICATION_ID")
    private Long applicationId;

    /**
     * Name of the profile option
     */
    @TableField("PROFILE_OPTION_NAME")
    private String profileOptionName;

    /**
     * Flag to indicate if user exits or forms can update the profile option
     */
    @TableField("WRITE_ALLOWED_FLAG")
    private String writeAllowedFlag;

    /**
     * Flag to indicate if user exits or forms can read the profile option
     */
    @TableField("READ_ALLOWED_FLAG")
    private String readAllowedFlag;

    /**
     * Flag to indicate if users can update the value for the profile option
     */
    @TableField("USER_CHANGEABLE_FLAG")
    private String userChangeableFlag;

    /**
     * Flag to indicate if users can see the value for the profile option
     */
    @TableField("USER_VISIBLE_FLAG")
    private String userVisibleFlag;

    /**
     * Flag to indicate whether the profile option is enabled at the site level
     */
    @TableField("SITE_ENABLED_FLAG")
    private String siteEnabledFlag;

    /**
     * Flag to indicate whether the profile option should be updatable at the site level
     */
    @TableField("SITE_UPDATE_ALLOWED_FLAG")
    private String siteUpdateAllowedFlag;

    /**
     * Flag to indicate whether the profile option is enabled at the application level
     */
    @TableField("APP_ENABLED_FLAG")
    private String appEnabledFlag;

    /**
     * Flag to indicate whether the profile option should be updatable at the application level
     */
    @TableField("APP_UPDATE_ALLOWED_FLAG")
    private String appUpdateAllowedFlag;

    /**
     * Flag to indicate whether the profile option is enabled at the responsibility level
     */
    @TableField("RESP_ENABLED_FLAG")
    private String respEnabledFlag;

    /**
     * Flag to indicate whether the profile option should be updatable at the responsibility leve
     */
    @TableField("RESP_UPDATE_ALLOWED_FLAG")
    private String respUpdateAllowedFlag;

    /**
     * Flag to indicate whether the profile option is enabled at the user level
     */
    @TableField("USER_ENABLED_FLAG")
    private String userEnabledFlag;

    /**
     * Flag to indicate whether the profile option should be updatable at the user level
     */
    @TableField("USER_UPDATE_ALLOWED_FLAG")
    private String userUpdateAllowedFlag;

    /**
     * The date the profile option becomes active
     */
    @TableField("START_DATE_ACTIVE")
    private Date startDateActive;

    /**
     * The validation criteria for LOV definition of profile option values
     */
    @TableField("SQL_VALIDATION")
    private String sqlValidation;

    /**
     * The date the profile option expires
     */
    @TableField("END_DATE_ACTIVE")
    private Date endDateActive;

    /**
     * HIERARCHY_TYPE
     */
    @TableField("HIERARCHY_TYPE")
    private String hierarchyType;

    /**
     * SERVER_ENABLED_FLAG
     */
    @TableField("SERVER_ENABLED_FLAG")
    private String serverEnabledFlag;

    /**
     * ORG_ENABLED_FLAG
     */
    @TableField("ORG_ENABLED_FLAG")
    private String orgEnabledFlag;

    /**
     * SERVER_UPDATE_ALLOWED_FLAG
     */
    @TableField("SERVER_UPDATE_ALLOWED_FLAG")
    private String serverUpdateAllowedFlag;

    /**
     * ORG_UPDATE_ALLOWED_FLAG
     */
    @TableField("ORG_UPDATE_ALLOWED_FLAG")
    private String orgUpdateAllowedFlag;

    /**
     * Whether the profile is enabled at the server/responsibility level

     */
    @TableField("SERVERRESP_ENABLED_FLAG")
    private String serverrespEnabledFlag;

    /**
     * Whether the profile can be updated at the server/responsibility level
     */
    @TableField("SERVERRESP_UPDATE_ALLOWED_FLAG")
    private String serverrespUpdateAllowedFlag;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("CREATED_BY")
    private String createdBy;


}
