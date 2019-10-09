package com.tianzhu.foundation.module.fnd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianzhu.foundation.module.fnd.entity.FndRespFunctions;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * FND_RESP_FUNCTIONS stores security exclusion rules
for function security menus. Security
exclusion rules are lists of functions and menus inaccessible
to a particular responsibility. Each row includes an action
identifier whose value is dependent on the rule type.
(ACTION_ID=FUNCTION_ID from fnd_form_functions if
RULE_TYPE='F' or ACTION_ID=MENU_ID from FND_MENUS
if RULE_TYPE='M') Mapper 接口
 * </p>
 *
 * @author Maya
 * @since 2019-08-03
 */
public interface FndRespFunctionsMapper extends BaseMapper<FndRespFunctions> {

    List<Map<String,Object>> selectRespFunByRespId(Long respId);

    List<Map<String, Object>> queryPageInfo(Map<String, Object> filter);
}
