package com.tianzhu.foundation.module.fnd.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.business.FndFunctionService;
import com.tianzhu.foundation.module.fnd.entity.FndFunctions;
import com.tianzhu.foundation.utils.MapKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/function")
public class FndFunctionController {

    @Autowired
    FndFunctionService fndFunctionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult list(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndFunctionService.queryPageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult save(@RequestBody JSONObject data) {

        Map<String, Object> fndFunctionMap = MapKeyUtils.toReplaceKeyLow(data);

        FndFunctions fndFunction = JSONObject.parseObject(JSONObject.toJSONString(fndFunctionMap), FndFunctions.class);

        return fndFunctionService.save(fndFunction);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult delete(@RequestBody JSONObject data) {

        JSONArray delArray = data.getJSONArray("removeRecords");

        List<Long> ids = new ArrayList<>();

        for(Object o : delArray ){
            ids.add(((JSONObject)o).getLong("FUNCTION_ID"));
        }

        return fndFunctionService.delete(ids);
    }

}
