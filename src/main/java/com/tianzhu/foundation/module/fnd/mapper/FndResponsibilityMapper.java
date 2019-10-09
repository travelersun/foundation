package com.tianzhu.foundation.module.fnd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianzhu.foundation.module.fnd.entity.FndResponsibility;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统职责基本表 Mapper 接口
 * </p>
 *
 * @author Maya
 * @since 2019-08-03
 */
public interface FndResponsibilityMapper extends BaseMapper<FndResponsibility> {

    List<Map<String, Object>> queryPageInfo(Map<String, Object> filter);
}
