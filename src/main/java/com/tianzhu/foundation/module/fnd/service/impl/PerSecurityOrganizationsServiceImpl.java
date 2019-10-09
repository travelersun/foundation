package com.tianzhu.foundation.module.fnd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianzhu.foundation.module.fnd.entity.PerSecurityOrganizations;
import com.tianzhu.foundation.module.fnd.mapper.PerSecurityOrganizationsMapper;
import com.tianzhu.foundation.module.fnd.service.IPerSecurityOrganizationsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Descrete list of organizations to exclude or include from 
per_organization_list during security list maintainence 服务实现类
 * </p>
 *
 * @author Maya
 * @since 2019-10-09
 */
@Service
public class PerSecurityOrganizationsServiceImpl extends ServiceImpl<PerSecurityOrganizationsMapper, PerSecurityOrganizations> implements IPerSecurityOrganizationsService {

}
