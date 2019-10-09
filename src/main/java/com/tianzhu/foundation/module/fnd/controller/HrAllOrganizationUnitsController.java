package com.tianzhu.foundation.module.fnd.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.business.FndLookupService;
import com.tianzhu.foundation.module.fnd.business.FndOrgService;
import com.tianzhu.foundation.module.fnd.entity.FndLookupTypes;
import com.tianzhu.foundation.module.fnd.entity.FndLookupValues;
import com.tianzhu.foundation.module.fnd.entity.HrAllOrganizationUnits;
import com.tianzhu.foundation.module.fnd.entity.HrOrganizationInformation;
import com.tianzhu.foundation.utils.MapKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * HR_ALL_ORGANIZATION_UNITS holds the definitions that identify business
groups and the organization units within a single business group.
Additional information about classifications and information types for
each organization is held in HR_ORGANIZATION_INFORMATION. 前端控制器
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@RestController
@RequestMapping("/orgUnits")
public class HrAllOrganizationUnitsController {

    @Autowired
    FndOrgService fndOrgService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult list(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndOrgService.queryPageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult save(@RequestBody JSONObject data) {

        Map<String, Object> fndOrgMap = MapKeyUtils.toReplaceKeyLow(data);

        HrAllOrganizationUnits fndOrg = JSONObject.parseObject(JSONObject.toJSONString(fndOrgMap), HrAllOrganizationUnits.class);

        return fndOrgService.save(fndOrg);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult delete(@RequestBody JSONObject data) {

        JSONArray delArray = data.getJSONArray("removeRecords");

        List<JSONObject> removeRecords = new ArrayList<>();

        for(Object o : delArray ){
            removeRecords.add(((JSONObject)o));
        }

        return fndOrgService.delete(removeRecords);
    }


    @RequestMapping(value = "/info/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult listInfoEntry(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndOrgService.queryOrgInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/info/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult saveInfoEntry(@RequestBody JSONObject data) {

        Map<String, Object> orgMap = MapKeyUtils.toReplaceKeyLow(data.getJSONObject("orgData"));

        JSONObject body = data.getJSONObject("body");

        JSONArray insertRecords = body.getJSONArray("insertRecords");
        JSONArray updateRecords = body.getJSONArray("updateRecords");
        JSONArray removeRecords = body.getJSONArray("removeRecords");

        List<HrOrganizationInformation> insertRecordL = new ArrayList<>();
        List<HrOrganizationInformation> updateRecordL = new ArrayList<>();
        List<HrOrganizationInformation> removeRecordL = new ArrayList<>();

        HrAllOrganizationUnits orgUnit = JSONObject.parseObject(JSONObject.toJSONString(orgMap), HrAllOrganizationUnits.class);

        for(Object i : insertRecords){
            Map<String, Object> it = MapKeyUtils.toReplaceKeyLow((JSONObject)i);
            HrOrganizationInformation ie = JSONObject.parseObject(JSONObject.toJSONString(it), HrOrganizationInformation.class);
            insertRecordL.add(ie);
        }

        for(Object u : updateRecords){
            Map<String, Object> ut = MapKeyUtils.toReplaceKeyLow((JSONObject)u);
            HrOrganizationInformation ue = JSONObject.parseObject(JSONObject.toJSONString(ut), HrOrganizationInformation.class);
            updateRecordL.add(ue);
        }

        for(Object r : removeRecords){
            Map<String, Object> rt = MapKeyUtils.toReplaceKeyLow((JSONObject)r);
            HrOrganizationInformation re = JSONObject.parseObject(JSONObject.toJSONString(rt), HrOrganizationInformation.class);
            removeRecordL.add(re);
        }


        return fndOrgService.saveOrgInfo(orgUnit,insertRecordL,updateRecordL,removeRecordL);
    }

    @RequestMapping(value = "/info/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult deleteInfoEntry(@RequestBody JSONObject data) {

        Map<String, Object> orgMap = MapKeyUtils.toReplaceKeyLow(data.getJSONObject("orgData"));

        JSONObject body = data.getJSONObject("body");

        JSONArray insertRecords = body.getJSONArray("insertRecords");
        JSONArray updateRecords = body.getJSONArray("updateRecords");
        JSONArray removeRecords = body.getJSONArray("removeRecords");

        List<HrOrganizationInformation> insertRecordL = new ArrayList<>();
        List<HrOrganizationInformation> updateRecordL = new ArrayList<>();
        List<HrOrganizationInformation> removeRecordL = new ArrayList<>();

        HrAllOrganizationUnits orgUnit = JSONObject.parseObject(JSONObject.toJSONString(orgMap), HrAllOrganizationUnits.class);


        for(Object r : removeRecords){
            Map<String, Object> rt = MapKeyUtils.toReplaceKeyLow((JSONObject)r);
            HrOrganizationInformation re = JSONObject.parseObject(JSONObject.toJSONString(rt), HrOrganizationInformation.class);
            removeRecordL.add(re);
        }


        return fndOrgService.saveOrgInfo(orgUnit,insertRecordL,updateRecordL,removeRecordL);
    }

}
