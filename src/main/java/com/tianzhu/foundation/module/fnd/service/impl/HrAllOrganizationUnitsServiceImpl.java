package com.tianzhu.foundation.module.fnd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianzhu.foundation.module.fnd.entity.HrAllOrganizationUnits;
import com.tianzhu.foundation.module.fnd.mapper.HrAllOrganizationUnitsMapper;
import com.tianzhu.foundation.module.fnd.service.IHrAllOrganizationUnitsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * HR_ALL_ORGANIZATION_UNITS holds the definitions that identify business
groups and the organization units within a single business group.
Additional information about classifications and information types for
each organization is held in HR_ORGANIZATION_INFORMATION. 服务实现类
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@Service
public class HrAllOrganizationUnitsServiceImpl extends ServiceImpl<HrAllOrganizationUnitsMapper, HrAllOrganizationUnits> implements IHrAllOrganizationUnitsService {

}
