package com.tianzhu.foundation.module.fnd.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.business.FndApplicationService;
import com.tianzhu.foundation.module.fnd.business.FndFlexValueSetsService;
import com.tianzhu.foundation.module.fnd.entity.FndApplication;
import com.tianzhu.foundation.module.fnd.entity.FndFlexValidationTables;
import com.tianzhu.foundation.module.fnd.entity.FndFlexValueSets;
import com.tianzhu.foundation.utils.MapKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * FND_FLEX_VALUE_SETS stores information about the value sets used
by both key and descriptive flexfields. Each row includes
the application identifier, the name and description of the
value set, the validation type of value set (F for Table,
I for Independent, D for Dependent, N for None, P for Pair,
U for Special), the data format type, the maximum
and minimum values and precision for number format type value set.
Each row also contains flags that determine what size
values can be in this value set, and whether
flexfield value security and LOV's LongList feature are
enabled for this value set. NUMERIC_MODE_ENABLED_FLAG indicates
whether Oracle Application Object Library should right-justify and
zero-fill values that contain only the characters 0 through 9; it
does not indicate that values in this value set are of type NUMBER.
MAXIMUM_VALUE and MINIMUM_VALUE together do range checks on values.
If the value set is a dependent value
set, PARENT_FLEX_VALUE_SET_ID identifies the independent value set
the current dependent value set depends upon. Also if the value
set is a dependent value set, DEPENDANT_DEFAULT_VALUE and
DEPENDANT_DEFAULT_MEANING contain the default value and
description that Oracle Application Object Library should
automatically create in the dependent value set whenever you create
a new value in the independent value set it depends upon.
You need one row for each value set you
have for your flexfields. Oracle Application Object Library uses
this information to assign groups of valid values to flexfield
segments. 前端控制器
 * </p>
 *
 * @author Maya
 * @since 2019-09-26
 */
@RestController
@RequestMapping("/flexValueSets")
public class FndFlexValueSetsController {

    @Autowired
    FndFlexValueSetsService fndFlexValueSetsService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ResponseBody
    public OperationResult list(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndFlexValueSetsService.queryPageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/validationTable/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult validationTableList(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndFlexValueSetsService.queryPageInfoForvalidationTable(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/define/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult defineList(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndFlexValueSetsService.queryDefinePageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/value/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult valueList(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");

        JSONObject innerParams = queryParams.getJSONObject("innerParams");

        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndFlexValueSetsService.queryValuePageInfo(jsonFilter, page,innerParams);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult save(@RequestBody JSONObject data) {

        Map<String, Object> fndFlexValueSetsMap = MapKeyUtils.toReplaceKeyLow(data);

        JSONObject validationTables = data.getJSONObject("validationTables");

        FndFlexValueSets fndFlexValueSets = JSONObject.parseObject(JSONObject.toJSONString(fndFlexValueSetsMap), FndFlexValueSets.class);

        if(validationTables != null ){
            Map<String, Object> fndFlexValidationTablesMap = MapKeyUtils.toReplaceKeyLow(validationTables);
            FndFlexValidationTables fndFlexValidationTables = JSONObject.parseObject(JSONObject.toJSONString(fndFlexValidationTablesMap), FndFlexValidationTables.class);
            return fndFlexValueSetsService.save(fndFlexValueSets,fndFlexValidationTables);
        }else {
            return fndFlexValueSetsService.save(fndFlexValueSets);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult delete(@RequestBody JSONObject data) {

        JSONArray delArray = data.getJSONArray("removeRecords");

        List<Long> ids = new ArrayList<>();

        for(Object o : delArray ){
            String PROTECTED_FLAG = ((JSONObject)o).getString("PROTECTED_FLAG");

            if("Y".equals(PROTECTED_FLAG)){
                return OperationResult.buildFailureResult("不能删除保护模式的值集!");
            }

            ids.add(((JSONObject)o).getLong("FLEX_VALUE_SET_ID"));
        }

        return fndFlexValueSetsService.delete(ids);
    }

}
