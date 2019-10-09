package com.tianzhu.foundation.module.fnd.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * FND_RESP_FUNCTIONS stores security exclusion rules
for function security menus. Security
exclusion rules are lists of functions and menus inaccessible
to a particular responsibility. Each row includes an action
identifier whose value is dependent on the rule type.
(ACTION_ID=FUNCTION_ID from fnd_form_functions if
RULE_TYPE='F' or ACTION_ID=MENU_ID from FND_MENUS
if RULE_TYPE='M') 前端控制器
 * </p>
 *
 * @author Maya
 * @since 2019-10-03
 */
@RestController
@RequestMapping("/resp-functions")
public class FndRespFunctionsController {

}
