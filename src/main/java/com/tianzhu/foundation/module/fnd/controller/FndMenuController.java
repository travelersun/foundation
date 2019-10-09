package com.tianzhu.foundation.module.fnd.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.business.FndMenuService;
import com.tianzhu.foundation.module.fnd.entity.FndMenuEntries;
import com.tianzhu.foundation.module.fnd.entity.FndMenus;
import com.tianzhu.foundation.utils.MapKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")
public class FndMenuController {

    @Autowired
    FndMenuService fndMenuService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult list(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndMenuService.queryPageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult save(@RequestBody JSONObject data) {

        Map<String, Object> fndMenuMap = MapKeyUtils.toReplaceKeyLow(data);

        FndMenus fndMenu = JSONObject.parseObject(JSONObject.toJSONString(fndMenuMap), FndMenus.class);

        return fndMenuService.save(fndMenu);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult delete(@RequestBody JSONObject data) {

        JSONArray delArray = data.getJSONArray("removeRecords");

        List<Long> ids = new ArrayList<>();

        for(Object o : delArray ){
            ids.add(((JSONObject)o).getLong("MENU_ID"));
        }

        return fndMenuService.delete(ids);
    }

    @RequestMapping(value = "/tree/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult listMenuTree(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        Long menuId = queryParams.getJSONObject("jsonFilter").getLong("MENU_ID");

        List<Map<String,Object>> treeInfo = fndMenuService.queryMenuEntryTreeInfo(menuId);

        return OperationResult.buildSuccessResult(treeInfo);
    }

    @RequestMapping(value = "/entry/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult listMenuEntry(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndMenuService.queryMenuEntryPageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/entry/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult saveMenuEntry(@RequestBody JSONObject data) {

        Map<String, Object> fndMenuMap = MapKeyUtils.toReplaceKeyLow(data.getJSONObject("menuData"));

        JSONObject body = data.getJSONObject("body");

        JSONArray insertRecords = body.getJSONArray("insertRecords");
        JSONArray updateRecords = body.getJSONArray("updateRecords");
        JSONArray removeRecords = body.getJSONArray("removeRecords");

        List<FndMenuEntries> insertRecordL = new ArrayList<>();
        List<FndMenuEntries> updateRecordL = new ArrayList<>();
        List<FndMenuEntries> removeRecordL = new ArrayList<>();

        FndMenus fndMenu = JSONObject.parseObject(JSONObject.toJSONString(fndMenuMap), FndMenus.class);

        for(Object i : insertRecords){
            Map<String, Object> it = MapKeyUtils.toReplaceKeyLow((JSONObject)i);
            FndMenuEntries ie = JSONObject.parseObject(JSONObject.toJSONString(it), FndMenuEntries.class);
            insertRecordL.add(ie);
        }

        for(Object u : updateRecords){
            Map<String, Object> ut = MapKeyUtils.toReplaceKeyLow((JSONObject)u);
            FndMenuEntries ue = JSONObject.parseObject(JSONObject.toJSONString(ut), FndMenuEntries.class);
            updateRecordL.add(ue);
        }

        for(Object r : removeRecords){
            Map<String, Object> rt = MapKeyUtils.toReplaceKeyLow((JSONObject)r);
            FndMenuEntries re = JSONObject.parseObject(JSONObject.toJSONString(rt), FndMenuEntries.class);
            removeRecordL.add(re);
        }


        return fndMenuService.saveMenuEntry(fndMenu,insertRecordL,updateRecordL,removeRecordL);
    }

    @RequestMapping(value = "/entry/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult deleteMenuEntry(@RequestBody JSONObject data) {

        Map<String, Object> fndMenuMap = MapKeyUtils.toReplaceKeyLow(data.getJSONObject("menuData"));

        JSONObject body = data.getJSONObject("body");

        JSONArray insertRecords = body.getJSONArray("insertRecords");
        JSONArray updateRecords = body.getJSONArray("updateRecords");
        JSONArray removeRecords = body.getJSONArray("removeRecords");

        List<FndMenuEntries> insertRecordL = new ArrayList<>();
        List<FndMenuEntries> updateRecordL = new ArrayList<>();
        List<FndMenuEntries> removeRecordL = new ArrayList<>();

        FndMenus fndMenu = JSONObject.parseObject(JSONObject.toJSONString(fndMenuMap), FndMenus.class);


        for(Object r : removeRecords){
            Map<String, Object> rt = MapKeyUtils.toReplaceKeyLow((JSONObject)r);
            FndMenuEntries re = JSONObject.parseObject(JSONObject.toJSONString(rt), FndMenuEntries.class);
            removeRecordL.add(re);
        }


        return fndMenuService.saveMenuEntry(fndMenu,insertRecordL,updateRecordL,removeRecordL);
    }

}
