package com.tianzhu.foundation.module.fnd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianzhu.foundation.module.fnd.entity.WfUserRoleAssignments;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户直接职责授权关系表 Mapper 接口
 * </p>
 *
 * @author Maya
 * @since 2019-08-03
 */
public interface WfUserRoleAssignmentsMapper extends BaseMapper<WfUserRoleAssignments> {

    List<Map<String,Object>> selectRespByRoles(List<String> roles);

    List<Map<String,Object>> selectRespByUserId(String userId);

}
