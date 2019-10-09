package com.tianzhu.foundation.module.fnd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianzhu.foundation.module.fnd.entity.FndLookupValues;
import com.tianzhu.foundation.module.fnd.mapper.FndLookupValuesMapper;
import com.tianzhu.foundation.module.fnd.service.IFndLookupValuesService;
import org.springframework.stereotype.Service;

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
Application Object Library forms and other forms. 服务实现类
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@Service
public class FndLookupValuesServiceImpl extends ServiceImpl<FndLookupValuesMapper, FndLookupValues> implements IFndLookupValuesService {

}
