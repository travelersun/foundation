package com.tianzhu.foundation.module.fnd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianzhu.foundation.module.fnd.entity.FndLookupValues;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * FND_LOOKUP_VALUES stores Oracle Application Object Library QuickCode
values. Each row includes the QuickCode lookup type, the QuickCode
itself, its meaning, and additional description, as well as values
that indicate whether this QuickCode is currently valid. Each row
also includes a language code that indicates what language the
information is in. You need one row for each QuickCode in each of
the languages installed at your site. Oracle Application Object
Library uses this information to display LOVs for Oracle
Application Object Library forms and other forms. Mapper 接口
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
public interface FndLookupValuesMapper extends BaseMapper<FndLookupValues> {

    List<Map<String, Object>> queryPageInfo(Map<String, Object> filter);
}
