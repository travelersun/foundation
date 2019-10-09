package com.tianzhu.foundation.module.fnd.business;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.FilterHelper;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.entity.FndDataDict;
import com.tianzhu.foundation.module.fnd.entity.FndMenuEntries;
import com.tianzhu.foundation.module.fnd.mapper.FndDataDictMapper;
import com.tianzhu.foundation.module.fnd.service.impl.FndDataDictServiceImpl;
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
public class FndDataDictService {

    @Autowired
    FndDataDictMapper fndDataDictMapper;

    @Autowired
    FndDataDictServiceImpl fndDataDictServiceImpl;

    @Autowired
    IdersContext idersContext;

    public final static String fndDataDictIder = "dataDictId";

    public PageInfo queryPageInfo(JSONObject jsonFilter, JSONObject page) {

        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM FND_DATA_DICT",jsonFilter.toJSONString());

        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = fndDataDictMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;
    }

    public OperationResult save(FndDataDict fndDataDict) {

        if(fndDataDict.getFndDataDictId() == null ){
            // 获取用户id的提供者
            Ider ider = idersContext.getIder(fndDataDictIder);
            // 获取id
            Id id1 = ider.acquire();
            fndDataDict.setFndDataDictId(id1.getId());
            fndDataDictServiceImpl.save(fndDataDict);
        }else{
            fndDataDictServiceImpl.updateById(fndDataDict);
        }
        return OperationResult.buildSuccessResult("保存成功!");
    }

    public OperationResult delete(List<Long> ids) {

        if(!CollectionUtils.isEmpty(ids)){

            List dataEntyies = fndDataDictServiceImpl.list(new QueryWrapper<FndDataDict>().in("PARANT_DATA_DICT_ID",ids));

            if(!CollectionUtils.isEmpty(dataEntyies)){
                return OperationResult.buildFailureResult("自相矛盾字典包含要删除的字典引用,不能将父字典删除!");
            }
            fndDataDictServiceImpl.removeByIds(ids);
        }

        return OperationResult.buildSuccessResult("删除成功!");
    }

    public List<Map<String, Object>> queryDictTreeInfo(Long dataDictId , boolean isFlatChild) {

        List<Map<String,Object>> result = new ArrayList<>();

        List<Map<String,Object>> dictList = fndDataDictMapper.querySubList(dataDictId);

        result.addAll(dictList);

        if(isFlatChild){
            if(!CollectionUtils.isEmpty(dictList)){
                for(Map<String,Object> sub : dictList){
                    if(sub.get("FND_DATA_DICT_ID") != null){
                        result.addAll(queryDictTreeInfo((Long) sub.get("FND_DATA_DICT_ID"),true));
                    }
                }
            }
        }

        return result;

    }

    public PageInfo queryDictEntryPageInfo(JSONObject jsonFilter, JSONObject page) {
        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM FND_DATA_DICT",jsonFilter.toJSONString());

        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = fndDataDictMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;
    }

    public OperationResult saveDataDictEntry(FndDataDict fndDataDict, List<FndDataDict> insertRecordL, List<FndDataDict> updateRecordL, List<FndDataDict> removeRecordL) {

        if(!CollectionUtils.isEmpty(insertRecordL)){
            for(FndDataDict i : insertRecordL){
                // 获取用户id的提供者
                Ider ider = idersContext.getIder(fndDataDictIder);
                // 获取id
                Id id1 = ider.acquire();
                i.setFndDataDictId(id1.getId());
                i.setParantDataDictId(fndDataDict.getFndDataDictId());
                fndDataDictServiceImpl.save(i);
            }

        }

        if(!CollectionUtils.isEmpty(updateRecordL)){
            for(FndDataDict u : updateRecordL){
                u.setParantDataDictId(fndDataDict.getFndDataDictId());
                fndDataDictServiceImpl.updateById(u);
            }

        }

        if(!CollectionUtils.isEmpty(removeRecordL)){

            List<Long> ids = new ArrayList<>();
            for(FndDataDict r : removeRecordL){
                if(r.getFndDataDictId() == null){
                    continue;
                }
                ids.add(r.getFndDataDictId());
            }

            delete(ids);

        }

        return OperationResult.buildSuccessResult("操作成功!");
    }

    public List<Map<String, Object>> queryDictTreeInfoByPrimaryKey(String primaryKey,boolean isFlatChild) {

        FndDataDict d = fndDataDictServiceImpl.getOne(new QueryWrapper<FndDataDict>().eq("PRIMARY_KEY",primaryKey));

        if(d != null){
            return queryDictTreeInfo(d.getFndDataDictId(),isFlatChild);
        }else{
            return new ArrayList<>();
        }

    }
}
