package com.tianzhu.foundation.module.fnd.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.business.FndDataDictService;
import com.tianzhu.foundation.module.fnd.business.FndOrgStructureService;
import com.tianzhu.foundation.module.fnd.entity.FndDataDict;
import com.tianzhu.foundation.module.fnd.entity.PerOrgStructureElements;
import com.tianzhu.foundation.module.fnd.entity.PerOrganizationStructures;
import com.tianzhu.foundation.utils.MapKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * PER_ORGANIZATION_STRUCTURES holds information about organization
hierarchies defined for each Business Group. You can have any number
of hierarchies in one Business Group, but only one hierarchy can have
the PRIMARY_STRUCTURE_FLAG set to Y. 前端控制器
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@RestController
@RequestMapping("/orgStructures")
public class PerOrganizationStructuresController {

    @Autowired
    FndOrgStructureService fndOrgStructureService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult list(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndOrgStructureService.queryPageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult save(@RequestBody JSONObject data) {

        Map<String, Object> orgStructureMap = MapKeyUtils.toReplaceKeyLow(data);

        PerOrganizationStructures orgStructure = JSONObject.parseObject(JSONObject.toJSONString(orgStructureMap), PerOrganizationStructures.class);

        return fndOrgStructureService.save(orgStructure);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult delete(@RequestBody JSONObject data) {

        JSONArray delArray = data.getJSONArray("removeRecords");

        List<Long> ids = new ArrayList<>();

        for(Object o : delArray ){
            ids.add(((JSONObject)o).getLong("ORGANIZATION_STRUCTURE_ID"));
        }

        return fndOrgStructureService.delete(ids);
    }

    @RequestMapping(value = "/element/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult listElementEntry(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndOrgStructureService.queryOrgStructureElementPageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/element/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult saveElementEntry(@RequestBody JSONObject data) {

        Map<String, Object> orgStructureMap = MapKeyUtils.toReplaceKeyLow(data.getJSONObject("orgStructData"));

        JSONObject body = data.getJSONObject("body");

        JSONArray insertRecords = body.getJSONArray("insertRecords");
        JSONArray updateRecords = body.getJSONArray("updateRecords");
        JSONArray removeRecords = body.getJSONArray("removeRecords");

        List<PerOrgStructureElements> insertRecordL = new ArrayList<>();
        List<PerOrgStructureElements> updateRecordL = new ArrayList<>();
        List<PerOrgStructureElements> removeRecordL = new ArrayList<>();

        PerOrganizationStructures orgStructure = JSONObject.parseObject(JSONObject.toJSONString(orgStructureMap), PerOrganizationStructures.class);

        for(Object i : insertRecords){
            Map<String, Object> it = MapKeyUtils.toReplaceKeyLow((JSONObject)i);
            PerOrgStructureElements ie = JSONObject.parseObject(JSONObject.toJSONString(it), PerOrgStructureElements.class);
            insertRecordL.add(ie);
        }

        for(Object u : updateRecords){
            Map<String, Object> ut = MapKeyUtils.toReplaceKeyLow((JSONObject)u);
            PerOrgStructureElements ue = JSONObject.parseObject(JSONObject.toJSONString(ut), PerOrgStructureElements.class);
            updateRecordL.add(ue);
        }

        for(Object r : removeRecords){
            Map<String, Object> rt = MapKeyUtils.toReplaceKeyLow((JSONObject)r);
            PerOrgStructureElements re = JSONObject.parseObject(JSONObject.toJSONString(rt), PerOrgStructureElements.class);
            removeRecordL.add(re);
        }


        return fndOrgStructureService.saveOrgStructureElement(orgStructure,insertRecordL,updateRecordL,removeRecordL);
    }

    @RequestMapping(value = "/element/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult deleteElementEntry(@RequestBody JSONObject data) {

        Map<String, Object> orgStructureMap = MapKeyUtils.toReplaceKeyLow(data.getJSONObject("orgStructData"));

        JSONObject body = data.getJSONObject("body");

        JSONArray insertRecords = body.getJSONArray("insertRecords");
        JSONArray updateRecords = body.getJSONArray("updateRecords");
        JSONArray removeRecords = body.getJSONArray("removeRecords");

        List<PerOrgStructureElements> insertRecordL = new ArrayList<>();
        List<PerOrgStructureElements> updateRecordL = new ArrayList<>();
        List<PerOrgStructureElements> removeRecordL = new ArrayList<>();

        PerOrganizationStructures orgStructure = JSONObject.parseObject(JSONObject.toJSONString(orgStructureMap), PerOrganizationStructures.class);


        for(Object r : removeRecords){
            Map<String, Object> rt = MapKeyUtils.toReplaceKeyLow((JSONObject)r);
            PerOrgStructureElements re = JSONObject.parseObject(JSONObject.toJSONString(rt), PerOrgStructureElements.class);
            removeRecordL.add(re);
        }


        return fndOrgStructureService.saveOrgStructureElement(orgStructure,insertRecordL,updateRecordL,removeRecordL);

    }


    @RequestMapping(value = "/tree/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult listDictTree(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        Long orgStructureId = queryParams.getJSONObject("jsonFilter").getLong("ORGANIZATION_STRUCTURE_ID");

        List<Map<String,Object>> treeInfo = new ArrayList<>();

        if(orgStructureId != null){
            treeInfo = fndOrgStructureService.queryOrgTreeInfoByStructId(orgStructureId);
        }

        return OperationResult.buildSuccessResult(treeInfo);
    }


}
