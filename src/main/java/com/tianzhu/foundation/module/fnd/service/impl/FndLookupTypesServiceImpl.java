package com.tianzhu.foundation.module.fnd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianzhu.foundation.module.fnd.entity.FndLookupTypes;
import com.tianzhu.foundation.module.fnd.mapper.FndLookupTypesMapper;
import com.tianzhu.foundation.module.fnd.service.IFndLookupTypesService;
import org.springframework.stereotype.Service;

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
forms. 服务实现类
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@Service
public class FndLookupTypesServiceImpl extends ServiceImpl<FndLookupTypesMapper, FndLookupTypes> implements IFndLookupTypesService {

}
