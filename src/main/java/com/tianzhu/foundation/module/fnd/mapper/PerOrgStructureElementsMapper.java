package com.tianzhu.foundation.module.fnd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianzhu.foundation.module.fnd.entity.PerOrgStructureElements;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * PER_ORG_STRUCTURE_ELEMENTS holds information on the hierarchical
relationship between organizations in a specific hierarchy version.
Each row stores one parent-child relationship. The parent is
identified by ORGANIZATION_ID_PARENT and the child is identified by
ORGANIZATION_ID_CHILD. An organization can never be its own parent or
child, and the top organization in a hierarchy will never appear in
ORGANIZATION_ID_CHILD. Mapper 接口
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
public interface PerOrgStructureElementsMapper extends BaseMapper<PerOrgStructureElements> {

    List<Map<String, Object>> queryPageInfo(Map<String, Object> filter);

    List<Map<String, Object>> querySubList(Long orgStructureId, Long parentOrgId);

    List<Map<String, Object>> queryOrgListByStructId(Long orgStructureId);
}
