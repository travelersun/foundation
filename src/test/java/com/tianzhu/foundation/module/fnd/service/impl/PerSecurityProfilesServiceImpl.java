package com.tianzhu.foundation.module.fnd.service.impl;

import com.tianzhu.foundation.module.fnd.entity.PerSecurityProfiles;
import com.tianzhu.foundation.module.fnd.mapper.PerSecurityProfilesMapper;
import com.tianzhu.foundation.module.fnd.service.IPerSecurityProfilesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * PER_SECURITY_PROFILES holds user definitions of security profiles
based on organizations, positions and payrolls that the system will
use to restrict access to specific records in the Oracle HRMS
database. Access to secure database objects in Oracle HRMS is
controlled by means of a security profile that is linked to an Oracle
ID associated with your responsibility. Currently, the secure
database objects are organizations, positions, payrolls and people.
If the VIEW_ALL_FLAG is set to Y, then no security restriction applies
and anyone using this security profile can see all objects within
their product type. If the VIEW_ALL_FLAG is set to N, then any
combination of organization, position and payroll security can apply.
The restrictions of the security profile will determine the list of
people who are visible to the user. Security profiles are used by the
Generate Secure User process to create specific data objects for each
Oracle ID and by the Security List Maintenance process to populate the
secure lists for organization, position, payroll and people. 服务实现类
 * </p>
 *
 * @author Maya
 * @since 2019-10-09
 */
@Service
public class PerSecurityProfilesServiceImpl extends ServiceImpl<PerSecurityProfilesMapper, PerSecurityProfiles> implements IPerSecurityProfilesService {

}
