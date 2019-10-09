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
import com.tianzhu.foundation.module.fnd.entity.FndRespFunctions;
import com.tianzhu.foundation.module.fnd.entity.FndResponsibility;
import com.tianzhu.foundation.module.fnd.mapper.FndRespFunctionsMapper;
import com.tianzhu.foundation.module.fnd.mapper.FndResponsibilityMapper;
import com.tianzhu.foundation.module.fnd.service.impl.FndRespFunctionsServiceImpl;
import com.tianzhu.foundation.module.fnd.service.impl.FndResponsibilityServiceImpl;
import org.antframework.common.util.id.Id;
import org.antframework.idcenter.client.Ider;
import org.antframework.idcenter.client.IdersContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FndResponsibilityService {

    @Autowired
    FndResponsibilityMapper fndResponsibilityMapper;

    @Autowired
    FndRespFunctionsMapper fndRespFunctionsMapper;

    @Autowired
    FndResponsibilityServiceImpl fndResponsibilityServiceImpl;

    @Autowired
    FndRespFunctionsServiceImpl fndRespFunctionsServiceImpl;

    @Autowired
    IdersContext idersContext;

    public final static String respIder = "respId";

    public final static String respExcluIder = "respexcluId";


    public PageInfo queryPageInfo(JSONObject jsonFilter, JSONObject page) {

        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM FND_RESPONSIBILITY",jsonFilter.toJSONString());

        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = fndResponsibilityMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;
    }


    public OperationResult save(FndResponsibility responsibility) {

        if(responsibility.getResponsibilityId() == null){

            // 获取用户id的提供者
            Ider ider = idersContext.getIder(respIder);
            // 获取id
            Id id1 = ider.acquire();
            responsibility.setResponsibilityId(id1.getId());
            fndResponsibilityServiceImpl.save(responsibility);

        }else{
            fndResponsibilityServiceImpl.updateById(responsibility);
        }
        return OperationResult.buildSuccessResult("保存成功!");
    }

    public OperationResult delete(List<JSONObject> removeRecords) {

        if(!CollectionUtils.isEmpty(removeRecords)){

            for ( JSONObject e : removeRecords){

                if(e.getLong("RESPONSIBILITY_ID") != null ){

                    int excluCount = fndRespFunctionsServiceImpl.count(new QueryWrapper<FndRespFunctions>().eq("RESPONSIBILITY_ID",e.getLong("RESPONSIBILITY_ID")));

                    if(excluCount > 0){
                        return OperationResult.buildFailureResult("职责排除项有引用，不能删除!");
                    }

                    fndResponsibilityServiceImpl.removeById(e.getLong("RESPONSIBILITY_ID"));
                }
            }

        }

        return OperationResult.buildSuccessResult("操作成功!");
    }



    public PageInfo queryRespExclusionPageInfo(JSONObject jsonFilter, JSONObject page) {

        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM FND_RESP_FUNCTIONS",jsonFilter.toJSONString());

        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = fndRespFunctionsMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;
    }

    public OperationResult saveRespExclusion(FndResponsibility responsibility, List<FndRespFunctions> insertRecordL, List<FndRespFunctions> updateRecordL, List<FndRespFunctions> removeRecordL) {

        if(!CollectionUtils.isEmpty(insertRecordL)){
            for(FndRespFunctions i : insertRecordL){

                if(i.getExclusionId() == null){

                    // 获取用户id的提供者
                    Ider ider = idersContext.getIder(respExcluIder);
                    // 获取id
                    Id id1 = ider.acquire();
                    i.setExclusionId(id1.getId());
                    fndRespFunctionsServiceImpl.save(i);

                }else{
                    fndRespFunctionsServiceImpl.updateById(i);
                }

            }

        }

        if(!CollectionUtils.isEmpty(updateRecordL)){
            for(FndRespFunctions u : updateRecordL){
                if(u.getExclusionId() == null){

                    // 获取用户id的提供者
                    Ider ider = idersContext.getIder(respExcluIder);
                    // 获取id
                    Id id1 = ider.acquire();
                    u.setExclusionId(id1.getId());
                    fndRespFunctionsServiceImpl.save(u);

                }else{
                    fndRespFunctionsServiceImpl.updateById(u);
                }
            }

        }

        if(!CollectionUtils.isEmpty(removeRecordL)){
            for(FndRespFunctions r : removeRecordL){
                if(r.getExclusionId() != null ){
                    fndRespFunctionsServiceImpl.removeById(r.getExclusionId());
                }
            }

        }

        return OperationResult.buildSuccessResult("操作成功!");

    }

}
