package com.tianzhu.foundation.module.fnd.business;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.FilterHelper;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.entity.PerOrgStructureElements;
import com.tianzhu.foundation.module.fnd.entity.PerOrganizationStructures;
import com.tianzhu.foundation.module.fnd.mapper.PerOrgStructureElementsMapper;
import com.tianzhu.foundation.module.fnd.mapper.PerOrganizationStructuresMapper;
import com.tianzhu.foundation.module.fnd.service.impl.PerOrgStructureElementsServiceImpl;
import com.tianzhu.foundation.module.fnd.service.impl.PerOrganizationStructuresServiceImpl;
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
public class FndOrgStructureService {


    @Autowired
    PerOrganizationStructuresMapper perOrganizationStructuresMapper;

    @Autowired
    PerOrgStructureElementsMapper perOrgStructureElementsMapper;

    @Autowired
    PerOrganizationStructuresServiceImpl perOrganizationStructuresServiceImpl;

    @Autowired
    PerOrgStructureElementsServiceImpl perOrgStructureElementsServiceImpl;

    @Autowired
    IdersContext idersContext;

    public final static String orgStructureIder = "orgstructureId";

    public final static String orgStructureEleIder = "orgstructureleId";


    public PageInfo queryPageInfo(JSONObject jsonFilter, JSONObject page) {

        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM PER_ORGANIZATION_STRUCTURES",jsonFilter.toJSONString());

        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = perOrganizationStructuresMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;
    }

    public OperationResult save(PerOrganizationStructures orgStructure) {
        if(orgStructure.getOrganizationStructureId() == null ){
            // 获取用户id的提供者
            Ider ider = idersContext.getIder(orgStructureIder);
            // 获取id
            Id id1 = ider.acquire();
            orgStructure.setOrganizationStructureId(id1.getId());
            perOrganizationStructuresServiceImpl.save(orgStructure);
        }else{
            perOrganizationStructuresServiceImpl.updateById(orgStructure);
        }
        return OperationResult.buildSuccessResult("保存成功!");
    }

    public OperationResult delete(List<Long> ids) {

        if(!CollectionUtils.isEmpty(ids)){

            int eleCount = perOrgStructureElementsServiceImpl.count(new QueryWrapper<PerOrgStructureElements>().in("ORG_STRUCTURE_ID",ids));

            if(eleCount > 0){
                return OperationResult.buildFailureResult("组织层级结构元组有引用,不能将该结构删除!");
            }
            perOrganizationStructuresServiceImpl.removeByIds(ids);
        }

        return OperationResult.buildSuccessResult("删除成功!");
    }

    public PageInfo queryOrgStructureElementPageInfo(JSONObject jsonFilter, JSONObject page) {

        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM PER_ORG_STRUCTURE_ELEMENTS",jsonFilter.toJSONString());

        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = perOrgStructureElementsMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;
    }

    public OperationResult saveOrgStructureElement(PerOrganizationStructures orgStructure, List<PerOrgStructureElements> insertRecordL, List<PerOrgStructureElements> updateRecordL, List<PerOrgStructureElements> removeRecordL) {

        if(!CollectionUtils.isEmpty(insertRecordL)){
            for(PerOrgStructureElements i : insertRecordL){
                // 获取用户id的提供者
                Ider ider = idersContext.getIder(orgStructureEleIder);
                // 获取id
                Id id1 = ider.acquire();
                i.setOrgStructureElementId(id1.getId());
                i.setOrgStructureId(orgStructure.getOrganizationStructureId());
                perOrgStructureElementsServiceImpl.save(i);
            }

        }

        if(!CollectionUtils.isEmpty(updateRecordL)){
            for(PerOrgStructureElements u : updateRecordL){
                u.setOrgStructureId(orgStructure.getOrganizationStructureId());
                perOrgStructureElementsServiceImpl.updateById(u);
            }

        }

        if(!CollectionUtils.isEmpty(removeRecordL)){

            List<Long> ids = new ArrayList<>();
            for(PerOrgStructureElements r : removeRecordL){

                int eleCount = perOrgStructureElementsServiceImpl.count(new QueryWrapper<PerOrgStructureElements>().eq("ORGANIZATION_ID_PARENT",r.getOrganizationIdParent()));

                if(eleCount > 0){
                    return OperationResult.buildFailureResult("组织层级结构元组有引用,不能将父元组删除!");
                }

                ids.add(r.getOrgStructureElementId());

            }

            perOrgStructureElementsServiceImpl.removeByIds(ids);

        }

        return OperationResult.buildSuccessResult("操作成功!");

    }

    public List<Map<String, Object>> queryOrgTreeInfo(Long orgStructureId , Long parentOrgId, boolean isFlatChild) {

        List<Map<String,Object>> result = new ArrayList<>();

        List<Map<String,Object>> orgList = perOrgStructureElementsMapper.querySubList(orgStructureId,parentOrgId);

        result.addAll(orgList);

        if(isFlatChild){
            if(!CollectionUtils.isEmpty(orgList)){
                for(Map<String,Object> sub : orgList){
                    if(sub.get("ORGANIZATION_ID_CHILD") != null){
                        result.addAll(queryOrgTreeInfo(orgStructureId,(Long) sub.get("ORGANIZATION_ID_CHILD"),true));
                    }
                }
            }
        }

        return result;

    }

    public List<Map<String, Object>> queryOrgTreeInfoByStructId(Long orgStructureId) {

        List<Map<String,Object>> result = new ArrayList<>();

        List<Map<String,Object>> orgList = perOrgStructureElementsMapper.queryOrgListByStructId(orgStructureId);

        result.addAll(orgList);

        return result;
    }
}
