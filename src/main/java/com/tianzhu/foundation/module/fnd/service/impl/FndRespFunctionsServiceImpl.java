package com.tianzhu.foundation.module.fnd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianzhu.foundation.module.fnd.entity.FndRespFunctions;
import com.tianzhu.foundation.module.fnd.mapper.FndRespFunctionsMapper;
import com.tianzhu.foundation.module.fnd.service.IFndRespFunctionsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * FND_RESP_FUNCTIONS stores security exclusion rules
for function security menus. Security
exclusion rules are lists of functions and menus inaccessible
to a particular responsibility. Each row includes an action
identifier whose value is dependent on the rule type.
(ACTION_ID=FUNCTION_ID from fnd_form_functions if
RULE_TYPE='F' or ACTION_ID=MENU_ID from FND_MENUS
if RULE_TYPE='M') 服务实现类
 * </p>
 *
 * @author Maya
 * @since 2019-08-03
 */
@Service
public class FndRespFunctionsServiceImpl extends ServiceImpl<FndRespFunctionsMapper, FndRespFunctions> implements IFndRespFunctionsService {

}
