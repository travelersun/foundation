package com.tianzhu.foundation.module.fnd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianzhu.foundation.module.fnd.entity.PerOrganizationStructures;
import com.tianzhu.foundation.module.fnd.mapper.PerOrganizationStructuresMapper;
import com.tianzhu.foundation.module.fnd.service.IPerOrganizationStructuresService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * PER_ORGANIZATION_STRUCTURES holds information about organization
hierarchies defined for each Business Group. You can have any number
of hierarchies in one Business Group, but only one hierarchy can have
the PRIMARY_STRUCTURE_FLAG set to Y. 服务实现类
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@Service
public class PerOrganizationStructuresServiceImpl extends ServiceImpl<PerOrganizationStructuresMapper, PerOrganizationStructures> implements IPerOrganizationStructuresService {

}
