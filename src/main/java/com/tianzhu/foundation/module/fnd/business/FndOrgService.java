package com.tianzhu.foundation.module.fnd.business;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.FilterHelper;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.entity.FndLookupTypes;
import com.tianzhu.foundation.module.fnd.entity.HrAllOrganizationUnits;
import com.tianzhu.foundation.module.fnd.entity.HrOrganizationInformation;
import com.tianzhu.foundation.module.fnd.mapper.HrAllOrganizationUnitsMapper;
import com.tianzhu.foundation.module.fnd.mapper.HrOrganizationInformationMapper;
import com.tianzhu.foundation.module.fnd.service.impl.HrAllOrganizationUnitsServiceImpl;
import com.tianzhu.foundation.module.fnd.service.impl.HrOrganizationInformationServiceImpl;
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
public class FndOrgService {


    @Autowired
    HrAllOrganizationUnitsMapper hrAllOrganizationUnitsMapper;

    @Autowired
    HrOrganizationInformationMapper hrOrganizationInformationMapper;

    @Autowired
    HrAllOrganizationUnitsServiceImpl hrAllOrganizationUnitsServiceImpl;

    @Autowired
    HrOrganizationInformationServiceImpl hrOrganizationInformationServiceImpl;

    @Autowired
    IdersContext idersContext;

    public final static String orgIder = "organizationId";

    public final static String orgInfoIder = "orginfoId";

    public PageInfo queryPageInfo(JSONObject jsonFilter, JSONObject page) {
        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM HR_ALL_ORGANIZATION_UNITS",jsonFilter.toJSONString());

        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = hrAllOrganizationUnitsMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;
    }

    public OperationResult save(HrAllOrganizationUnits fndOrg) {
        if(fndOrg.getOrganizationId() == null){

            // 获取用户id的提供者
            Ider ider = idersContext.getIder(orgIder);
            // 获取id
            Id id1 = ider.acquire();
            fndOrg.setOrganizationId(id1.getId());
            hrAllOrganizationUnitsServiceImpl.save(fndOrg);

        }else{
            hrAllOrganizationUnitsServiceImpl.updateById(fndOrg);
        }
        return OperationResult.buildSuccessResult("保存成功!");
    }

    public OperationResult delete(List<JSONObject> removeRecords) {

        if(!CollectionUtils.isEmpty(removeRecords)){

            List<Long> ids = new ArrayList<>();

            for ( JSONObject e : removeRecords){

                if(e.getLong("ORGANIZATION_ID") != null ){

                    int orgInfoCount  = hrOrganizationInformationServiceImpl.count(new QueryWrapper<HrOrganizationInformation>().eq("ORGANIZATION_ID",e.getLong("ORGANIZATION_ID")));

                    if(orgInfoCount > 0){
                        return OperationResult.buildFailureResult("组织附加信息有引用,不能删除该组织!");
                    }

                    ids.add(e.getLong("ORGANIZATION_ID"));
                }
            }

            hrAllOrganizationUnitsServiceImpl.removeByIds(ids);

        }

        return OperationResult.buildSuccessResult("操作成功!");
    }

    public PageInfo queryOrgInfo(JSONObject jsonFilter, JSONObject page) {

        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM HR_ORGANIZATION_INFORMATION",jsonFilter.toJSONString());

        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = hrOrganizationInformationMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;
    }

    public OperationResult saveOrgInfo(HrAllOrganizationUnits orgUnit, List<HrOrganizationInformation> insertRecordL, List<HrOrganizationInformation> updateRecordL, List<HrOrganizationInformation> removeRecordL) {

        if(!CollectionUtils.isEmpty(insertRecordL)){
            for(HrOrganizationInformation i : insertRecordL){

                if(i.getOrgInformationId() == null){

                    // 获取用户id的提供者
                    Ider ider = idersContext.getIder(orgInfoIder);
                    // 获取id
                    Id id1 = ider.acquire();
                    i.setOrgInformationId(id1.getId());
                    hrOrganizationInformationServiceImpl.save(i);

                }else {
                    hrOrganizationInformationServiceImpl.updateById(i);
                }

            }

        }

        if(!CollectionUtils.isEmpty(updateRecordL)){
            for(HrOrganizationInformation u : updateRecordL){
                if(u.getOrgInformationId() == null){

                    // 获取用户id的提供者
                    Ider ider = idersContext.getIder(orgInfoIder);
                    // 获取id
                    Id id1 = ider.acquire();
                    u.setOrgInformationId(id1.getId());
                    hrOrganizationInformationServiceImpl.save(u);

                }else {
                    hrOrganizationInformationServiceImpl.updateById(u);
                }
            }

        }

        if(!CollectionUtils.isEmpty(removeRecordL)){
            List<Long> ids = new ArrayList<>();
            for(HrOrganizationInformation r : removeRecordL){
                if(r.getOrgInformationId() != null){
                    ids.add(r.getOrgInformationId());
                }
            }
            hrOrganizationInformationServiceImpl.removeByIds(ids);

        }

        return OperationResult.buildSuccessResult("操作成功!");

    }
}
