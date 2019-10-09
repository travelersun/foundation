package com.tianzhu.foundation.module.fnd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianzhu.foundation.module.fnd.entity.FndFlexValueSets;

import java.util.List;
import java.util.Map;

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
segments. Mapper 接口
 * </p>
 *
 * @author Maya
 * @since 2019-09-26
 */
public interface FndFlexValueSetsMapper extends BaseMapper<FndFlexValueSets> {

    List<Map<String, Object>> queryPageInfo(Map<String, Object> filter);

    List<Map<String, Object>> queryValueSetValuesPageInfo(Map<String, Object> filter);
}
