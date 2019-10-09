package com.tianzhu.foundation.module.fnd.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.business.FndLocationsService;
import com.tianzhu.foundation.module.fnd.entity.HrLocationsAll;
import com.tianzhu.foundation.utils.MapKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Maya
 * @since 2019-09-28
 */
@RestController
@RequestMapping("/locations")
public class HrLocationsAllController {

    @Autowired
    FndLocationsService fndLocationsService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult list(@RequestParam(value = "params", required = true) String params) {

        JSONObject queryParams = JSONObject.parseObject(params);

        JSONObject jsonFilter = queryParams.getJSONObject("jsonFilter");
        JSONObject page = queryParams.getJSONObject("page");

        PageInfo pageInfo = fndLocationsService.queryPageInfo(jsonFilter, page);

        return OperationResult.buildSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult save(@RequestBody JSONObject data) {

        Map<String, Object> locationMap = MapKeyUtils.toReplaceKeyLow(data);

        HrLocationsAll location = JSONObject.parseObject(JSONObject.toJSONString(locationMap), HrLocationsAll.class);

        return fndLocationsService.save(location);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult delete(@RequestBody JSONObject data) {

        JSONArray delArray = data.getJSONArray("removeRecords");

        List<Long> ids = new ArrayList<>();

        for(Object o : delArray ){
            ids.add(((JSONObject)o).getLong("LOCATION_ID"));
        }

        return fndLocationsService.delete(ids);
    }

}
