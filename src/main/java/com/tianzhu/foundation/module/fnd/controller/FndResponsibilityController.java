package com.tianzhu.foundation.module.fnd.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.business.FndLookupService;
import com.tianzhu.foundation.module.fnd.business.FndResponsibilityService;
import com.tianzhu.foundation.module.fnd.entity.FndLookupTypes;
import com.tianzhu.foundation.module.fnd.entity.FndLookupValues;
import com.tianzhu.foundation.module.fnd.entity.FndRespFunctions;
import com.tianzhu.foundation.module.fnd.entity.FndResponsibility;
import com.tianzhu.foundation.utils.MapKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统职责基本表 前端控制器
 * </p>
 *
 * @author Maya
 * @since 2019-10-03
 */
@RestController
@RequestMapping("/responsibility")
public class FndResponsibilityController {

    @Autowired
    FndResponsibilityService fndResponsibilityService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult list(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndResponsibilityService.queryPageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult save(@RequestBody JSONObject data) {

        Map<String, Object> responsibilityMap = MapKeyUtils.toReplaceKeyLow(data);

        FndResponsibility responsibility = JSONObject.parseObject(JSONObject.toJSONString(responsibilityMap), FndResponsibility.class);

        return fndResponsibilityService.save(responsibility);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult delete(@RequestBody JSONObject data) {

        JSONArray delArray = data.getJSONArray("removeRecords");

        List<JSONObject> removeRecords = new ArrayList<>();

        for(Object o : delArray ){
            removeRecords.add(((JSONObject)o));
        }

        return fndResponsibilityService.delete(removeRecords);
    }


    @RequestMapping(value = "/exclusion/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult listDictEntry(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndResponsibilityService.queryRespExclusionPageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/exclusion/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult saveDictEntry(@RequestBody JSONObject data) {

        Map<String, Object> respMap = MapKeyUtils.toReplaceKeyLow(data.getJSONObject("respData"));

        JSONObject body = data.getJSONObject("body");

        JSONArray insertRecords = body.getJSONArray("insertRecords");
        JSONArray updateRecords = body.getJSONArray("updateRecords");
        JSONArray removeRecords = body.getJSONArray("removeRecords");

        List<FndRespFunctions> insertRecordL = new ArrayList<>();
        List<FndRespFunctions> updateRecordL = new ArrayList<>();
        List<FndRespFunctions> removeRecordL = new ArrayList<>();

        FndResponsibility responsibility = JSONObject.parseObject(JSONObject.toJSONString(respMap), FndResponsibility.class);

        for(Object i : insertRecords){
            Map<String, Object> it = MapKeyUtils.toReplaceKeyLow((JSONObject)i);
            FndRespFunctions ie = JSONObject.parseObject(JSONObject.toJSONString(it), FndRespFunctions.class);
            insertRecordL.add(ie);
        }

        for(Object u : updateRecords){
            Map<String, Object> ut = MapKeyUtils.toReplaceKeyLow((JSONObject)u);
            FndRespFunctions ue = JSONObject.parseObject(JSONObject.toJSONString(ut), FndRespFunctions.class);
            updateRecordL.add(ue);
        }

        for(Object r : removeRecords){
            Map<String, Object> rt = MapKeyUtils.toReplaceKeyLow((JSONObject)r);
            FndRespFunctions re = JSONObject.parseObject(JSONObject.toJSONString(rt), FndRespFunctions.class);
            removeRecordL.add(re);
        }


        return fndResponsibilityService.saveRespExclusion(responsibility,insertRecordL,updateRecordL,removeRecordL);
    }

    @RequestMapping(value = "/exclusion/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult deleteDictEntry(@RequestBody JSONObject data) {

        Map<String, Object> respMap = MapKeyUtils.toReplaceKeyLow(data.getJSONObject("respData"));

        JSONObject body = data.getJSONObject("body");

        JSONArray insertRecords = body.getJSONArray("insertRecords");
        JSONArray updateRecords = body.getJSONArray("updateRecords");
        JSONArray removeRecords = body.getJSONArray("removeRecords");

        List<FndRespFunctions> insertRecordL = new ArrayList<>();
        List<FndRespFunctions> updateRecordL = new ArrayList<>();
        List<FndRespFunctions> removeRecordL = new ArrayList<>();

        FndResponsibility responsibility = JSONObject.parseObject(JSONObject.toJSONString(respMap), FndResponsibility.class);


        for(Object r : removeRecords){
            Map<String, Object> rt = MapKeyUtils.toReplaceKeyLow((JSONObject)r);
            FndRespFunctions re = JSONObject.parseObject(JSONObject.toJSONString(rt), FndRespFunctions.class);
            removeRecordL.add(re);
        }


        return fndResponsibilityService.saveRespExclusion(responsibility,insertRecordL,updateRecordL,removeRecordL);
    }

}
