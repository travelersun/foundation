package com.tianzhu.foundation.module.fnd.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.business.FndLookupService;
import com.tianzhu.foundation.module.fnd.entity.FndLookupTypes;
import com.tianzhu.foundation.module.fnd.entity.FndLookupValues;
import com.tianzhu.foundation.utils.MapKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * FND_LOOKUP_TYPES stores Oracle Application Object Library
QuickCode types. Each row includes the QuickCode lookup type
and the application the lookup type belongs to. 
Each row also includes the customization level for the
lookup type, the security group the lookup type belongs to, 
and the application view through with the lookup type will be exposed. 
You need one row for each QuickCode lookup type. 
Oracle Application Object Library uses this information to display
LOVs for Oracle Application Object Library forms and other
forms. 前端控制器
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@RestController
@RequestMapping("/lookupTypes")
public class FndLookupTypesController {

    @Autowired
    FndLookupService fndLookupService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult list(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndLookupService.queryPageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult save(@RequestBody JSONObject data) {

        Map<String, Object> fndLookupTypeMap = MapKeyUtils.toReplaceKeyLow(data);

        FndLookupTypes fndLookupType = JSONObject.parseObject(JSONObject.toJSONString(fndLookupTypeMap), FndLookupTypes.class);

        return fndLookupService.save(fndLookupType);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult delete(@RequestBody JSONObject data) {

        JSONArray delArray = data.getJSONArray("removeRecords");

        List<JSONObject> removeRecords = new ArrayList<>();

        for(Object o : delArray ){
            removeRecords.add(((JSONObject)o));
        }

        return fndLookupService.delete(removeRecords);
    }


    @RequestMapping(value = "/value/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult listDictEntry(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndLookupService.queryLookupValuePageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/value/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult saveDictEntry(@RequestBody JSONObject data) {

        Map<String, Object> lookTypeMap = MapKeyUtils.toReplaceKeyLow(data.getJSONObject("lookTypeData"));

        JSONObject body = data.getJSONObject("body");

        JSONArray insertRecords = body.getJSONArray("insertRecords");
        JSONArray updateRecords = body.getJSONArray("updateRecords");
        JSONArray removeRecords = body.getJSONArray("removeRecords");

        List<FndLookupValues> insertRecordL = new ArrayList<>();
        List<FndLookupValues> updateRecordL = new ArrayList<>();
        List<FndLookupValues> removeRecordL = new ArrayList<>();

        FndLookupTypes fndLookupType = JSONObject.parseObject(JSONObject.toJSONString(lookTypeMap), FndLookupTypes.class);

        for(Object i : insertRecords){
            Map<String, Object> it = MapKeyUtils.toReplaceKeyLow((JSONObject)i);
            FndLookupValues ie = JSONObject.parseObject(JSONObject.toJSONString(it), FndLookupValues.class);
            insertRecordL.add(ie);
        }

        for(Object u : updateRecords){
            Map<String, Object> ut = MapKeyUtils.toReplaceKeyLow((JSONObject)u);
            FndLookupValues ue = JSONObject.parseObject(JSONObject.toJSONString(ut), FndLookupValues.class);
            updateRecordL.add(ue);
        }

        for(Object r : removeRecords){
            Map<String, Object> rt = MapKeyUtils.toReplaceKeyLow((JSONObject)r);
            FndLookupValues re = JSONObject.parseObject(JSONObject.toJSONString(rt), FndLookupValues.class);
            removeRecordL.add(re);
        }


        return fndLookupService.saveLookupValue(fndLookupType,insertRecordL,updateRecordL,removeRecordL);
    }

    @RequestMapping(value = "/value/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult deleteDictEntry(@RequestBody JSONObject data) {

        Map<String, Object> lookTypeMap = MapKeyUtils.toReplaceKeyLow(data.getJSONObject("lookTypeData"));

        JSONObject body = data.getJSONObject("body");

        JSONArray insertRecords = body.getJSONArray("insertRecords");
        JSONArray updateRecords = body.getJSONArray("updateRecords");
        JSONArray removeRecords = body.getJSONArray("removeRecords");

        List<FndLookupValues> insertRecordL = new ArrayList<>();
        List<FndLookupValues> updateRecordL = new ArrayList<>();
        List<FndLookupValues> removeRecordL = new ArrayList<>();

        FndLookupTypes fndLookupType = JSONObject.parseObject(JSONObject.toJSONString(lookTypeMap), FndLookupTypes.class);


        for(Object r : removeRecords){
            Map<String, Object> rt = MapKeyUtils.toReplaceKeyLow((JSONObject)r);
            FndLookupValues re = JSONObject.parseObject(JSONObject.toJSONString(rt), FndLookupValues.class);
            removeRecordL.add(re);
        }


        return fndLookupService.saveLookupValue(fndLookupType,insertRecordL,updateRecordL,removeRecordL);
    }

}
