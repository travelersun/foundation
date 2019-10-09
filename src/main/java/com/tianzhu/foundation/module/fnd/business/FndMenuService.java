package com.tianzhu.foundation.module.fnd.business;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.FilterHelper;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.entity.FndMenuEntries;
import com.tianzhu.foundation.module.fnd.entity.FndMenus;
import com.tianzhu.foundation.module.fnd.mapper.FndMenuEntriesMapper;
import com.tianzhu.foundation.module.fnd.mapper.FndMenusMapper;
import com.tianzhu.foundation.module.fnd.service.impl.FndMenuEntriesServiceImpl;
import com.tianzhu.foundation.module.fnd.service.impl.FndMenusServiceImpl;
import org.antframework.common.util.id.Id;
import org.antframework.idcenter.client.Ider;
import org.antframework.idcenter.client.IdersContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FndMenuService {

    @Autowired
    FndMenusMapper fndMenusMapper;

    @Autowired
    FndMenusServiceImpl fndMenusServiceImpl;

    @Autowired
    FndMenuEntriesMapper fndMenuEntriesMapper;

    @Autowired
    FndMenuEntriesServiceImpl fndMenuEntriesServiceImpl;

    @Autowired
    IdersContext idersContext;

    public final static String fndMenuIder = "menuId";

    public final static String fndMenuEntryIder = "entryId";

    public PageInfo<Map<String,Object>> queryPageInfo(JSONObject jsonFilter, JSONObject page){


        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM FND_MENUS",jsonFilter.toJSONString());

        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = fndMenusMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;

    }

    public List<Map<String,Object>> queryMenuEntryTreeInfo(Long menuId) {

        List<Map<String,Object>> result = new ArrayList<>();

        List<Map<String,Object>> menuList = fndMenuEntriesMapper.querySubList(menuId);

        result.addAll(menuList);

        if(!CollectionUtils.isEmpty(menuList)){
            for(Map<String,Object> sub : menuList){
                if(sub.get("SUB_MENU_ID") != null){
                    result.addAll(queryMenuEntryTreeInfo((Long) sub.get("SUB_MENU_ID")));
                }
            }
        }

        return result;

    }

    public OperationResult save(FndMenus fndMenu) {

        if(fndMenu.getMenuId() == null ){
            // 获取用户id的提供者
            Ider ider = idersContext.getIder(fndMenuIder);
            // 获取id
            Id id1 = ider.acquire();
            fndMenu.setMenuId(id1.getId());
            fndMenusServiceImpl.save(fndMenu);
        }else{
            fndMenusServiceImpl.updateById(fndMenu);
        }
        return OperationResult.buildSuccessResult("保存成功!");
    }

    public OperationResult delete(List<Long> ids) {

        if(!CollectionUtils.isEmpty(ids)){

            List menuEntyies = fndMenuEntriesServiceImpl.list(new QueryWrapper<FndMenuEntries>().in("SUB_MENU_ID",ids));

            if(!CollectionUtils.isEmpty(menuEntyies)){
                return OperationResult.buildFailureResult("菜单树包含要删除的菜单,不能将菜单删除!");
            }


            fndMenusServiceImpl.removeByIds(ids);
        }

        return OperationResult.buildSuccessResult("删除成功!");
    }

    public PageInfo<Map<String,Object>> queryMenuEntryPageInfo(JSONObject jsonFilter, JSONObject page){


        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM FND_MENU_ENTRIES",jsonFilter.toJSONString());

        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = fndMenuEntriesMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;

    }

    public OperationResult saveMenuEntry(FndMenus fndMenu, List<FndMenuEntries> insertRecordL, List<FndMenuEntries> updateRecordL, List<FndMenuEntries> removeRecordL) {


        if(!CollectionUtils.isEmpty(insertRecordL)){
            for(FndMenuEntries i : insertRecordL){
                // 获取用户id的提供者
                Ider ider = idersContext.getIder(fndMenuEntryIder);
                // 获取id
                Id id1 = ider.acquire();
                i.setEntryId(id1.getId());
                i.setMenuId(fndMenu.getMenuId());
                fndMenuEntriesServiceImpl.save(i);
            }

        }

        if(!CollectionUtils.isEmpty(updateRecordL)){
            for(FndMenuEntries u : updateRecordL){
                if(u.getEntryId() == null){
                   continue;
                }
                u.setMenuId(fndMenu.getMenuId());
                fndMenuEntriesMapper.updateById(u);
            }

        }

        if(!CollectionUtils.isEmpty(removeRecordL)){
            for(FndMenuEntries r : removeRecordL){
                if(r.getEntryId() == null){
                    continue;
                }
                fndMenuEntriesServiceImpl.removeById(r.getEntryId());
            }

        }

        return OperationResult.buildSuccessResult("操作成功!");
    }
}
