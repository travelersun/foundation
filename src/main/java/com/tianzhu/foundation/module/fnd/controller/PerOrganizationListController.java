package com.tianzhu.foundation.module.fnd.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * PER_ORGANIZATION_LIST holds the list of organizations that a secure
user can access. This list is created and maintained by the LISTGEN
security process using the definition of the security profile. Rows
are created for all profiles that have the VIEW_ALL_ORGANIZATIONS_FLAG
set to N. 前端控制器
 * </p>
 *
 * @author Maya
 * @since 2019-10-09
 */
@RestController
@RequestMapping("/securityProfileOrgList")
public class PerOrganizationListController {

}
