package com.tianzhu.foundation.module.fnd.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * HR_ORGANIZATION_INFORMATION is used to hold two distinct sets of
organization information. When ORG_INFORMATION_CONTEXT is set to
CLASS this table acts as an intersection table between organizations
and organization classifications. ORGANIZATION_ID identifies the
organization and ORG_INFORMATION1 holds the organization
classification name. This information is maintained by the
organization classifications block of the Organization form. When
ORG_INFORMATION_CONTEXT is set to an information type held in
HR_ORG_INFORMATION_TYPES the ORG_INFORMATION1-20 columns hold details
for the specific information type. This information is maintained by
a predefined protected descriptive flexfield. (Org Developer DF.) 前端控制器
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@RestController
@RequestMapping("/hr-organization-information")
public class HrOrganizationInformationController {

}
