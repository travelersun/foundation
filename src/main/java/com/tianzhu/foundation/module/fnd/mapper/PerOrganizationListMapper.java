package com.tianzhu.foundation.module.fnd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianzhu.foundation.module.fnd.entity.PerOrganizationList;

/**
 * <p>
 * PER_ORGANIZATION_LIST holds the list of organizations that a secure
user can access. This list is created and maintained by the LISTGEN
security process using the definition of the security profile. Rows
are created for all profiles that have the VIEW_ALL_ORGANIZATIONS_FLAG
set to N. Mapper 接口
 * </p>
 *
 * @author Maya
 * @since 2019-10-09
 */
public interface PerOrganizationListMapper extends BaseMapper<PerOrganizationList> {

}
