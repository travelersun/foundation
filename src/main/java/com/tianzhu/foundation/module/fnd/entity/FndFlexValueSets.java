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
 * FND_FLEX_VALUE_SETS stores information about the value sets used
by both key and descriptive flexfields. Each row includes
the application identifier, the name and description of the
value set, the validation type of value set (F for Table,
I for Independent, D for Dependent, N for None, P for Pair,
U for Special), the data format type, the maximum
and minimum values and precision for number format type value set.
Each row also contains flags that determine what size
values can be in this value set, and whether
flexfield value security and LOV's LongList feature are
enabled for this value set. NUMERIC_MODE_ENABLED_FLAG indicates
whether Oracle Application Object Library should right-justify and
zero-fill values that contain only the characters 0 through 9; it
does not indicate that values in this value set are of type NUMBER.
MAXIMUM_VALUE and MINIMUM_VALUE together do range checks on values.
If the value set is a dependent value
set, PARENT_FLEX_VALUE_SET_ID identifies the independent value set
the current dependent value set depends upon. Also if the value
set is a dependent value set, DEPENDANT_DEFAULT_VALUE and
DEPENDANT_DEFAULT_MEANING contain the default value and
description that Oracle Application Object Library should
automatically create in the dependent value set whenever you create
a new value in the independent value set it depends upon.
You need one row for each value set you
have for your flexfields. Oracle Application Object Library uses
this information to assign groups of valid values to flexfield
segments.
 * </p>
 *
 * @author Maya
 * @since 2019-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FND_FLEX_VALUE_SETS")
public class FndFlexValueSets implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("FLEX_VALUE_SET_ID")
    private Long flexValueSetId;

    /**
     * Value set name
     */
    @TableField("FLEX_VALUE_SET_NAME")
    private String flexValueSetName;

    /**
     * Validation type
     */
    @TableField("VALIDATION_TYPE")
    private String validationType;

    /**
     * Flag to indicate if this is a protected value set
     */
    @TableField("PROTECTED_FLAG")
    private String protectedFlag;

    /**
     * Flag to indicate whether the flexfield security rules for the value set are enabled
     */
    @TableField("SECURITY_ENABLED_FLAG")
    private String securityEnabledFlag;

    /**
     * Flag to indicate whether the LOV LongList feature for the value set is enabled
     */
    @TableField("LONGLIST_FLAG")
    private String longlistFlag;

    /**
     * Format type
     */
    @TableField("FORMAT_TYPE")
    private String formatType;

    @TableField("MAXIMUM_SIZE")
    private Long maximumSize;

    /**
     * Flag to indicate whether values with alphanumeric characters can be in the value set
     */
    @TableField("ALPHANUMERIC_ALLOWED_FLAG")
    private String alphanumericAllowedFlag;

    /**
     * Flag to indicate if all the values in the value set should all be in uppercase
     */
    @TableField("UPPERCASE_ONLY_FLAG")
    private String uppercaseOnlyFlag;

    /**
     * Flag to indicate if Oracle Application Object Library should right-justify and zero-fill values for segments that use the value set
     */
    @TableField("NUMERIC_MODE_ENABLED_FLAG")
    private String numericModeEnabledFlag;

    /**
     * The default value for the dependent value set
     */
    @TableField("DEPENDANT_DEFAULT_VALUE")
    private String dependantDefaultValue;

    /**
     * Descritpion of default value
     */
    @TableField("DEPENDANT_DEFAULT_MEANING")
    private String dependantDefaultMeaning;

    @TableField("PARENT_FLEX_VALUE_SET_ID")
    private Long parentFlexValueSetId;

    /**
     * Minimum value
     */
    @TableField("MINIMUM_VALUE")
    private String minimumValue;

    /**
     * Maximum value
     */
    @TableField("MAXIMUM_VALUE")
    private String maximumValue;

    @TableField("NUMBER_PRECISION")
    private Long numberPrecision;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("CREATED_BY")
    private String createdBy;

    /**
     * Description
     */
    @TableField("DESCRIPTION")
    private String description;


}
