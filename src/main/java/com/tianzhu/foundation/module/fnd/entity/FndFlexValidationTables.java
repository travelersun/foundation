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
 * FND_FLEX_VALIDATION_TABLES stores information about key
and descriptive flexfield
validation tables. Each row includes values identifying the table
validated value set and the application owning the value set and the
name of the application table you are using as a validation table
(APPLICATION_TABLE_NAME). Each row also includes the names of the
table columns that contain ID type values, regular values, and
meanings, as well as the size and type of each of those columns,
and additional columns to display for LOVs.
ADDITIONAL_WHERE_CLAUSE contains the WHERE clause that allows the
validation table values to include only a subset of all the values
in the application table. In some cases, application tables can
contain special columns that take advantage of special flexfield
features, such as the ability to use segment qualifiers and
enabled and start date and end date information.
.
{{"bul:1"}}If a column named SUMMARY_FLAG exists in the
validation table, Oracle Application Object Library stores that
column name in SUMMARY_COLUMN_NAME. Otherwise, Oracle Application
Object Library stores N in SUMMARY_COLUMN_NAME.
{{"bul:1"}}If a column named
STRUCTURED_HIERARCHY_LEVEL exists in the validation table, Oracle
Application Object Library stores that column name in
HIERARCHY_LEVEL_COLUMN_NAME. Otherwise, Oracle Application Object
Library stores NULL.
{{"bul:1"}}If a column named COMPILED_VALUE_ATTRIBUTES
exists in the validation table, Oracle Application Object Library
stores that column name in COMPILED_ATTRIBUTE_COLUMN_NAME.
Otherwise, Oracle Application Object Library stores either NULL or
derived default values in COMPILED_ATTRIBUTE_COLUMN_NAME.
{{"bul:1"}}If a
column named ENABLED_FLAG exists in the validation table, Oracle
Application Object Library stores that column name in
ENABLED_COLUMN_NAME. Otherwise, Oracle Application Object Library
stores Y in ENABLED_COLUMN_NAME.
{{"bul:1"}}If columns named
START_DATE_ACTIVE and END_DATE_ACTIVE exist in the validation
table, Oracle Application Object Library stores those c
 * </p>
 *
 * @author Maya
 * @since 2019-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FND_FLEX_VALIDATION_TABLES")
public class FndFlexValidationTables implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("FLEX_VALUE_SET_ID")
    private Long flexValueSetId;

    /**
     * Table name
     */
    @TableField("APPLICATION_TABLE_NAME")
    private String applicationTableName;

    /**
     * Value column name
     */
    @TableField("VALUE_COLUMN_NAME")
    private String valueColumnName;

    /**
     * Value column type
     */
    @TableField("VALUE_COLUMN_TYPE")
    private String valueColumnType;

    /**
     * Size of value column
     */
    @TableField("VALUE_COLUMN_SIZE")
    private Integer valueColumnSize;

    /**
     * The column name COMPILED_VALUE_ATTRIBUTES if the column exists in the validation table
     */
    @TableField("COMPILED_ATTRIBUTE_COLUMN_NAME")
    private String compiledAttributeColumnName;

    /**
     * The column name ENABLED_FLAG if the column exists in the validation table
     */
    @TableField("ENABLED_COLUMN_NAME")
    private String enabledColumnName;

    /**
     * The column name STRUCTURED_HIERARCHY_LEVEL if the column exists in the validation table
     */
    @TableField("HIERARCHY_LEVEL_COLUMN_NAME")
    private String hierarchyLevelColumnName;

    /**
     * he column name START_DATE_ACTIVE if the column exists in the validation table
     */
    @TableField("START_DATE_COLUMN_NAME")
    private String startDateColumnName;

    /**
     * The column name END_DATE_ACTIVE if the column exists in the validation table
     */
    @TableField("END_DATE_COLUMN_NAME")
    private String endDateColumnName;

    /**
     * Flag to indicate whether the parent value is allowed to be stored in the FND_FLEX_VALUES table and displayed in the LOV for a segment using this value set
     */
    @TableField("SUMMARY_ALLOWED_FLAG")
    private String summaryAllowedFlag;

    /**
     * The column name SUMMARY_FLAG if the column exists in the validation table
     */
    @TableField("SUMMARY_COLUMN_NAME")
    private String summaryColumnName;

    /**
     * Hidden ID column name
     */
    @TableField("ID_COLUMN_NAME")
    private String idColumnName;

    /**
     * Size of ID column
     */
    @TableField("ID_COLUMN_SIZE")
    private Integer idColumnSize;

    /**
     * ID column type
     */
    @TableField("ID_COLUMN_TYPE")
    private String idColumnType;

    /**
     * Meaning column name
     */
    @TableField("MEANING_COLUMN_NAME")
    private String meaningColumnName;

    /**
     * Size of meaning column
     */
    @TableField("MEANING_COLUMN_SIZE")
    private Integer meaningColumnSize;

    /**
     * Meaning column type
     */
    @TableField("MEANING_COLUMN_TYPE")
    private String meaningColumnType;

    @TableField("TABLE_APPLICATION_ID")
    private Long tableApplicationId;

    /**
     * Additional columns to display in the LOV list
     */
    @TableField("ADDITIONAL_QUICKPICK_COLUMNS")
    private String additionalQuickpickColumns;

    /**
     * The SQL WHERE clause
     */
    @TableField("ADDITIONAL_WHERE_CLAUSE")
    private String additionalWhereClause;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("CREATED_BY")
    private String createdBy;


}
