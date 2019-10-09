package com.tianzhu.foundation.module.fnd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianzhu.foundation.module.fnd.entity.PerOrganizationStructures;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * PER_ORGANIZATION_STRUCTURES holds information about organization
hierarchies defined for each Business Group. You can have any number
of hierarchies in one Business Group, but only one hierarchy can have
the PRIMARY_STRUCTURE_FLAG set to Y. Mapper 接口
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
public interface PerOrganizationStructuresMapper extends BaseMapper<PerOrganizationStructures> {

    List<Map<String, Object>> queryPageInfo(Map<String, Object> filter);
}
