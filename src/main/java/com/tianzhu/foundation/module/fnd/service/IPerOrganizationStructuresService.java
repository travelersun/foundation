package com.tianzhu.foundation.module.fnd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianzhu.foundation.module.fnd.entity.PerOrganizationStructures;

/**
 * <p>
 * PER_ORGANIZATION_STRUCTURES holds information about organization
hierarchies defined for each Business Group. You can have any number
of hierarchies in one Business Group, but only one hierarchy can have
the PRIMARY_STRUCTURE_FLAG set to Y. 服务类
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
public interface IPerOrganizationStructuresService extends IService<PerOrganizationStructures> {

}
