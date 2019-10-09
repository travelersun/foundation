package com.tianzhu.foundation.module.fnd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianzhu.foundation.module.fnd.entity.FndDataDict;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author Maya
 * @since 2019-09-24
 */
public interface FndDataDictMapper extends BaseMapper<FndDataDict> {

    List<Map<String, Object>> queryPageInfo(Map<String, Object> filter);

    List<Map<String, Object>> querySubList(Long dataDictId);
}
