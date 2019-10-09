package com.tianzhu.foundation.module.fnd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianzhu.foundation.module.fnd.entity.PerOrgStructureElements;

/**
 * <p>
 * PER_ORG_STRUCTURE_ELEMENTS holds information on the hierarchical
relationship between organizations in a specific hierarchy version.
Each row stores one parent-child relationship. The parent is
identified by ORGANIZATION_ID_PARENT and the child is identified by
ORGANIZATION_ID_CHILD. An organization can never be its own parent or
child, and the top organization in a hierarchy will never appear in
ORGANIZATION_ID_CHILD. 服务类
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
public interface IPerOrgStructureElementsService extends IService<PerOrgStructureElements> {

}
