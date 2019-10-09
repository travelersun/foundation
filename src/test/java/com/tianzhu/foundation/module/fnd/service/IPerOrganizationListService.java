package com.tianzhu.foundation.module.fnd.service;

import com.tianzhu.foundation.module.fnd.entity.PerOrganizationList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * PER_ORGANIZATION_LIST holds the list of organizations that a secure
user can access. This list is created and maintained by the LISTGEN
security process using the definition of the security profile. Rows
are created for all profiles that have the VIEW_ALL_ORGANIZATIONS_FLAG
set to N. 服务类
 * </p>
 *
 * @author Maya
 * @since 2019-10-09
 */
public interface IPerOrganizationListService extends IService<PerOrganizationList> {

}
