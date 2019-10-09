package com.tianzhu.foundation.module.fnd.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.business.FndApplicationService;
import com.tianzhu.foundation.module.fnd.entity.FndApplication;
import com.tianzhu.foundation.module.fnd.entity.FndFunctions;
import com.tianzhu.foundation.utils.MapKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统注册的应用 前端控制器
 * </p>
 *
 * @author Maya
 * @since 2019-09-23
 */
@RestController
@RequestMapping("/fndApplication")
public class FndApplicationController {

    @Autowired
    FndApplicationService fndApplicationService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult list(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndApplicationService.queryPageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult save(@RequestBody JSONObject data) {

        Map<String, Object> fndApplicationMap = MapKeyUtils.toReplaceKeyLow(data);

        FndApplication fndApplication = JSONObject.parseObject(JSONObject.toJSONString(fndApplicationMap), FndApplication.class);

        return fndApplicationService.save(fndApplication);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult delete(@RequestBody JSONObject data) {

        JSONArray delArray = data.getJSONArray("removeRecords");

        List<Long> ids = new ArrayList<>();

        for(Object o : delArray ){
            ids.add(((JSONObject)o).getLong("APPLICATION_ID"));
        }

        return fndApplicationService.delete(ids);
    }

}
