package com.tianzhu.foundation.module.fnd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianzhu.foundation.module.fnd.entity.FndMenuEntries;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统菜单入口表 Mapper 接口
 * </p>
 *
 * @author Maya
 * @since 2019-08-03
 */
public interface FndMenuEntriesMapper extends BaseMapper<FndMenuEntries> {

    List<Map<String,Object>> selectMenuEntriesByMenuId(Long menuId);

    List<Map<String, Object>> queryPageInfo(Map<String, Object> filter);

    List<Map<String, Object>> querySubList(Long menuId);
}
