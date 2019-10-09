package com.tianzhu.foundation.module.fnd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianzhu.foundation.module.fnd.entity.HrOrganizationInformation;

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
a predefined protected descriptive flexfield. (Org Developer DF.) 服务类
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
public interface IHrOrganizationInformationService extends IService<HrOrganizationInformation> {

}
