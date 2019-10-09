package com.tianzhu.foundation.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.business.FndService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    FndService fndService;

    @GetMapping("/userinfo")
    public Object userinfo(@AuthenticationPrincipal Jwt jwt) {

        Map<String, Object> info = new HashMap<>();

        Map<String, Object> claims = jwt.getClaims();

        info.put("userId",claims.get("user_id"));
        info.put("name",claims.get("user_name"));
        info.put("email",claims.get("email"));
        info.put("roles",claims.get("scope"));
        info.put("claims",claims);
        info.put("avatar","");
        info.put("introduction","");

        return info;
    }

    @GetMapping("/userToken")
    public Object userToken(@AuthenticationPrincipal Jwt jwt) {

        Map<String, Object> info = new HashMap<>();

        info.put("tokenValue",jwt.getTokenValue());

        return info;
    }

    @GetMapping("/userRoles")
    public Object userRoles(@AuthenticationPrincipal Jwt jwt) {

        Map<String, Object> info = new HashMap<>();

        Map<String, Object> claims = jwt.getClaims();

        String userName = (String) claims.get("user_name");
        String userId = (String) claims.get("user_id");

        List<String> scope = JSONObject.parseArray(JSON.toJSONString(claims.get("scope")),String.class);

        List<String> resp1 =  fndService.getUserDirectResp(userId);
        if(CollectionUtils.isEmpty(resp1)){
            resp1 =  fndService.getUserDirectResp(userName);
        }

        List<String> resp2 =  fndService.getUserInDirectResp(scope);
        List<String> resp =  new ArrayList<>();
        resp.addAll(resp1);
        resp.addAll(resp2);

        info.put("scope",claims.get("scope"));
        info.put("resp",resp);

        return info;
    }

    @GetMapping("/routes")
    public List<Map<String,Object>> userRoutes(@AuthenticationPrincipal Jwt jwt) {


        Map<String, Object> claims = jwt.getClaims();

        String userName = (String) claims.get("user_name");
        String userId = (String) claims.get("user_id");

        List<String> scope = JSONObject.parseArray(JSON.toJSONString(claims.get("scope")),String.class);


        List<Map<String,Object>> routes = fndService.getUserRoutes(userId,scope);

        if(CollectionUtils.isEmpty(routes)){
            routes =  routes = fndService.getUserRoutes(userName,scope);
        }


        return routes;
    }

    @GetMapping("/{userId}/directResp")
    public Map<String, Object> userDirectResp(@PathVariable(name = "userId") String userId) {

        Map<String, Object> info = new HashMap<>();

        List<Map<String, Object>> resp1 =  fndService.getUserDirectRespForMap(userId);

        info.put("list",resp1);

        info.put("total",resp1.size());

        return info;
    }

    @PostMapping("/{userId}/directResp")
    public OperationResult addUserDirectResp(@PathVariable(name = "userId") String userId, @RequestBody JSONObject data) {

        JSONArray insertRecords = data.getJSONArray("insertRecords");

        return fndService.addUserDirectResp(userId,insertRecords);
    }

    @DeleteMapping("/{userId}/directResp")
    public OperationResult delUserDirectResp(@PathVariable(name = "userId") String userId , @RequestBody JSONObject data) {


        JSONArray removeRecords = data.getJSONArray("removeRecords");


        return fndService.delUserDirectResp(userId,removeRecords);
    }





}
