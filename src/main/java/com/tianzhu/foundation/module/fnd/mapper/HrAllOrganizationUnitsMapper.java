package com.tianzhu.foundation.module.fnd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianzhu.foundation.module.fnd.entity.HrAllOrganizationUnits;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * HR_ALL_ORGANIZATION_UNITS holds the definitions that identify business
groups and the organization units within a single business group.
Additional information about classifications and information types for
each organization is held in HR_ORGANIZATION_INFORMATION. Mapper 接口
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
public interface HrAllOrganizationUnitsMapper extends BaseMapper<HrAllOrganizationUnits> {

    List<Map<String, Object>> queryPageInfo(Map<String, Object> filter);
}
