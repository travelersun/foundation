package com.tianzhu.foundation.module.fnd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianzhu.foundation.module.fnd.entity.FndLookupTypes;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * FND_LOOKUP_TYPES stores Oracle Application Object Library
QuickCode types. Each row includes the QuickCode lookup type
and the application the lookup type belongs to. 
Each row also includes the customization level for the
lookup type, the security group the lookup type belongs to, 
and the application view through with the lookup type will be exposed. 
You need one row for each QuickCode lookup type. 
Oracle Application Object Library uses this information to display
LOVs for Oracle Application Object Library forms and other
forms. Mapper 接口
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
public interface FndLookupTypesMapper extends BaseMapper<FndLookupTypes> {

    List<Map<String, Object>> queryPageInfo(Map<String, Object> filter);
}
