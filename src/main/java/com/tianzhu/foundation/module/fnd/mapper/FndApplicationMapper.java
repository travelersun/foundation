package com.tianzhu.foundation.module.fnd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianzhu.foundation.module.fnd.entity.FndApplication;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统注册的应用 Mapper 接口
 * </p>
 *
 * @author Maya
 * @since 2019-09-23
 */
public interface FndApplicationMapper extends BaseMapper<FndApplication> {

    List<Map<String, Object>> queryPageInfo(Map<String, Object> filter);
}
