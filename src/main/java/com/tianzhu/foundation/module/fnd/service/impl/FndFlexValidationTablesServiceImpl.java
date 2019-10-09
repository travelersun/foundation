package com.tianzhu.foundation.module.fnd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianzhu.foundation.module.fnd.entity.FndFlexValidationTables;
import com.tianzhu.foundation.module.fnd.mapper.FndFlexValidationTablesMapper;
import com.tianzhu.foundation.module.fnd.service.IFndFlexValidationTablesService;
import org.springframework.stereotype.Service;

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
table, Oracle Application Object Library stores those c 服务实现类
 * </p>
 *
 * @author Maya
 * @since 2019-09-26
 */
@Service
public class FndFlexValidationTablesServiceImpl extends ServiceImpl<FndFlexValidationTablesMapper, FndFlexValidationTables> implements IFndFlexValidationTablesService {

}
