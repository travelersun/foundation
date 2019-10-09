package com.tianzhu.foundation.module.fnd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianzhu.foundation.module.fnd.entity.HrLocationsAll;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
public interface HrLocationsAllMapper extends BaseMapper<HrLocationsAll> {

    List<Map<String, Object>> queryPageInfo(Map<String, Object> filter);
}
