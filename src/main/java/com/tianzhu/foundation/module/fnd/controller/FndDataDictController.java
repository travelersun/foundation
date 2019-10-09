package com.tianzhu.foundation.module.fnd.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.business.FndDataDictService;
import com.tianzhu.foundation.module.fnd.entity.FndDataDict;
import com.tianzhu.foundation.utils.MapKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author Maya
 * @since 2019-09-24
 */
@RestController
@RequestMapping("/fndDataDict")
public class FndDataDictController {

    @Autowired
    FndDataDictService fndDataDictService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult list(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndDataDictService.queryPageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult save(@RequestBody JSONObject data) {

        Map<String, Object> fndDataDictMap = MapKeyUtils.toReplaceKeyLow(data);

        FndDataDict fndDataDict = JSONObject.parseObject(JSONObject.toJSONString(fndDataDictMap), FndDataDict.class);

        return fndDataDictService.save(fndDataDict);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult delete(@RequestBody JSONObject data) {

        JSONArray delArray = data.getJSONArray("removeRecords");

        List<Long> ids = new ArrayList<>();

        for(Object o : delArray ){
            ids.add(((JSONObject)o).getLong("FND_DATA_DICT_ID"));
        }

        return fndDataDictService.delete(ids);
    }

    @RequestMapping(value = "/tree/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult listDictTree(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        Long dataDictId = queryParams.getJSONObject("jsonFilter").getLong("FND_DATA_DICT_ID");

        List<Map<String,Object>> treeInfo = new ArrayList<>();

        if(dataDictId != null){
            treeInfo = fndDataDictService.queryDictTreeInfo(dataDictId,true);
        }else{

            String primaryKey = queryParams.getJSONObject("jsonFilter").getString("PRIMARY_KEY");

            treeInfo = fndDataDictService.queryDictTreeInfoByPrimaryKey(primaryKey,true);
        }

        return OperationResult.buildSuccessResult(treeInfo);
    }

    @RequestMapping(value = "/flat/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult listDictFlat(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        Long dataDictId = queryParams.getJSONObject("jsonFilter").getLong("FND_DATA_DICT_ID");

        List<Map<String,Object>> treeInfo = new ArrayList<>();

        if(dataDictId != null){
            treeInfo = fndDataDictService.queryDictTreeInfo(dataDictId,false);
        }else{

            String primaryKey = queryParams.getJSONObject("jsonFilter").getString("PRIMARY_KEY");

            treeInfo = fndDataDictService.queryDictTreeInfoByPrimaryKey(primaryKey,false);
        }

        return OperationResult.buildSuccessResult(treeInfo);
    }

    @RequestMapping(value = "/entry/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult listDictEntry(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndDataDictService.queryDictEntryPageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/entry/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult saveDictEntry(@RequestBody JSONObject data) {

        Map<String, Object> fndDataDictMap = MapKeyUtils.toReplaceKeyLow(data.getJSONObject("dictData"));

        JSONObject body = data.getJSONObject("body");

        JSONArray insertRecords = body.getJSONArray("insertRecords");
        JSONArray updateRecords = body.getJSONArray("updateRecords");
        JSONArray removeRecords = body.getJSONArray("removeRecords");

        List<FndDataDict> insertRecordL = new ArrayList<>();
        List<FndDataDict> updateRecordL = new ArrayList<>();
        List<FndDataDict> removeRecordL = new ArrayList<>();

        FndDataDict fndDataDict = JSONObject.parseObject(JSONObject.toJSONString(fndDataDictMap), FndDataDict.class);

        for(Object i : insertRecords){
            Map<String, Object> it = MapKeyUtils.toReplaceKeyLow((JSONObject)i);
            FndDataDict ie = JSONObject.parseObject(JSONObject.toJSONString(it), FndDataDict.class);
            insertRecordL.add(ie);
        }

        for(Object u : updateRecords){
            Map<String, Object> ut = MapKeyUtils.toReplaceKeyLow((JSONObject)u);
            FndDataDict ue = JSONObject.parseObject(JSONObject.toJSONString(ut), FndDataDict.class);
            updateRecordL.add(ue);
        }

        for(Object r : removeRecords){
            Map<String, Object> rt = MapKeyUtils.toReplaceKeyLow((JSONObject)r);
            FndDataDict re = JSONObject.parseObject(JSONObject.toJSONString(rt), FndDataDict.class);
            removeRecordL.add(re);
        }


        return fndDataDictService.saveDataDictEntry(fndDataDict,insertRecordL,updateRecordL,removeRecordL);
    }

    @RequestMapping(value = "/entry/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult deleteDictEntry(@RequestBody JSONObject data) {

        Map<String, Object> fndDataDictMap = MapKeyUtils.toReplaceKeyLow(data.getJSONObject("dictData"));

        JSONObject body = data.getJSONObject("body");

        JSONArray insertRecords = body.getJSONArray("insertRecords");
        JSONArray updateRecords = body.getJSONArray("updateRecords");
        JSONArray removeRecords = body.getJSONArray("removeRecords");

        List<FndDataDict> insertRecordL = new ArrayList<>();
        List<FndDataDict> updateRecordL = new ArrayList<>();
        List<FndDataDict> removeRecordL = new ArrayList<>();

        FndDataDict fndDataDict = JSONObject.parseObject(JSONObject.toJSONString(fndDataDictMap), FndDataDict.class);


        for(Object r : removeRecords){
            Map<String, Object> rt = MapKeyUtils.toReplaceKeyLow((JSONObject)r);
            FndDataDict re = JSONObject.parseObject(JSONObject.toJSONString(rt), FndDataDict.class);
            removeRecordL.add(re);
        }


        return fndDataDictService.saveDataDictEntry(fndDataDict,insertRecordL,updateRecordL,removeRecordL);
    }

}
