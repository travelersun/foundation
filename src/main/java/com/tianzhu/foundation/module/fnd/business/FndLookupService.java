package com.tianzhu.foundation.module.fnd.business;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.FilterHelper;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.entity.FndLookupTypes;
import com.tianzhu.foundation.module.fnd.entity.FndLookupValues;
import com.tianzhu.foundation.module.fnd.mapper.FndLookupTypesMapper;
import com.tianzhu.foundation.module.fnd.mapper.FndLookupValuesMapper;
import com.tianzhu.foundation.module.fnd.service.impl.FndLookupTypesServiceImpl;
import com.tianzhu.foundation.module.fnd.service.impl.FndLookupValuesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FndLookupService {



    @Autowired
    FndLookupTypesMapper fndLookupTypesMapper;

    @Autowired
    FndLookupValuesMapper fndLookupValuesMapper;

    @Autowired
    FndLookupTypesServiceImpl fndLookupTypesServiceImpl;

    @Autowired
    FndLookupValuesServiceImpl fndLookupValuesServiceImpl;


    public PageInfo queryPageInfo(JSONObject jsonFilter, JSONObject page) {

        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM FND_LOOKUP_TYPES",jsonFilter.toJSONString());

        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = fndLookupTypesMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;
    }


    public OperationResult save(FndLookupTypes fndLookupTypes) {

        if(fndLookupTypes.getApplicationId() != null && fndLookupTypes.getLookupType() != null){

            List<FndLookupTypes> exist  = fndLookupTypesServiceImpl.list(new QueryWrapper<FndLookupTypes>().eq("APPLICATION_ID",fndLookupTypes.getApplicationId())
                    .eq("LOOKUP_TYPE",fndLookupTypes.getLookupType()));

            if(!CollectionUtils.isEmpty(exist)){
                fndLookupTypesServiceImpl.update(fndLookupTypes,
                        new UpdateWrapper<FndLookupTypes>()
                        .eq("APPLICATION_ID",fndLookupTypes.getApplicationId())
                        .eq("LOOKUP_TYPE",fndLookupTypes.getLookupType()));
            }else {
                fndLookupTypesServiceImpl.save(fndLookupTypes);
            }

        }else{
            return OperationResult.buildFailureResult("数据不完整!");
        }
        return OperationResult.buildSuccessResult("保存成功!");
    }

    public OperationResult delete(List<JSONObject> removeRecords) {

        if(!CollectionUtils.isEmpty(removeRecords)){

            for ( JSONObject e : removeRecords){

                if(e.getLong("APPLICATION_ID") != null && e.getString("LOOKUP_TYPE") != null){

                    List<FndLookupValues> lookupValues = fndLookupValuesServiceImpl.list(new QueryWrapper<FndLookupValues>().eq("LOOKUP_TYPE",e.getString("LOOKUP_TYPE")));

                    if(!CollectionUtils.isEmpty(lookupValues)){
                        return OperationResult.buildFailureResult("值列表有引用，不能删除!");
                    }

                    fndLookupTypesServiceImpl.remove(new QueryWrapper<FndLookupTypes>().eq("APPLICATION_ID",e.getLong("APPLICATION_ID"))
                            .eq("LOOKUP_TYPE",e.getString("LOOKUP_TYPE")));
                }
            }

        }

        return OperationResult.buildSuccessResult("操作成功!");
    }



    public PageInfo queryLookupValuePageInfo(JSONObject jsonFilter, JSONObject page) {

        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM FND_LOOKUP_VALUES",jsonFilter.toJSONString());

        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = fndLookupValuesMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;
    }

    public OperationResult saveLookupValue(FndLookupTypes fndLookupTypes, List<FndLookupValues> insertRecordL, List<FndLookupValues> updateRecordL, List<FndLookupValues> removeRecordL) {

        if(!CollectionUtils.isEmpty(insertRecordL)){
            for(FndLookupValues i : insertRecordL){

                if(fndLookupTypes.getApplicationId() != null && fndLookupTypes.getLookupType() != null && i.getLookupCode() != null){

                    List<FndLookupValues> exist  = fndLookupValuesServiceImpl.list(new QueryWrapper<FndLookupValues>().eq("LOOKUP_TYPE",fndLookupTypes.getLookupType())
                            .eq("LOOKUP_CODE",i.getLookupCode()));

                    if(!CollectionUtils.isEmpty(exist)){
                        fndLookupValuesServiceImpl.update(i,
                                new UpdateWrapper<FndLookupValues>().eq("LOOKUP_TYPE",fndLookupTypes.getLookupType())
                                        .eq("LOOKUP_CODE",i.getLookupCode()));
                    }else {
                        fndLookupValuesServiceImpl.save(i);
                    }

                }

            }

        }

        if(!CollectionUtils.isEmpty(updateRecordL)){
            for(FndLookupValues u : updateRecordL){
                if(fndLookupTypes.getApplicationId() != null && fndLookupTypes.getLookupType() != null && u.getLookupCode() != null){

                    List<FndLookupValues> exist  = fndLookupValuesServiceImpl.list(new QueryWrapper<FndLookupValues>()
                            .eq("LOOKUP_TYPE",fndLookupTypes.getLookupType())
                            .eq("LOOKUP_CODE",u.getLookupCode()));

                    if(!CollectionUtils.isEmpty(exist)){
                        fndLookupValuesServiceImpl.update(u,
                                new UpdateWrapper<FndLookupValues>()
                                        .eq("LOOKUP_TYPE",fndLookupTypes.getLookupType())
                                        .eq("LOOKUP_CODE",u.getLookupCode()));
                    }else {
                        fndLookupValuesServiceImpl.save(u);
                    }

                }
            }

        }

        if(!CollectionUtils.isEmpty(removeRecordL)){
            for(FndLookupValues r : removeRecordL){
                if(fndLookupTypes.getApplicationId() != null && fndLookupTypes.getLookupType() != null && r.getLookupCode() != null){
                    fndLookupValuesServiceImpl.remove(new QueryWrapper<FndLookupValues>().eq("LOOKUP_TYPE",fndLookupTypes.getLookupType())
                            .eq("LOOKUP_CODE",r.getLookupCode()));
                }
            }

        }

        return OperationResult.buildSuccessResult("操作成功!");

    }

}
