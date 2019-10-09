package com.tianzhu.foundation.module.fnd.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.entity.FndFunctions;
import com.tianzhu.foundation.module.fnd.entity.FndMenus;
import com.tianzhu.foundation.module.fnd.entity.WfUserRoleAssignments;
import com.tianzhu.foundation.module.fnd.mapper.*;
import com.tianzhu.foundation.module.fnd.service.impl.WfUserRoleAssignmentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class FndService {


    @Autowired
    WfUserRoleAssignmentsMapper wuram;

    @Autowired
    WfUserRoleAssignmentsServiceImpl wurams;

    @Autowired
    FndMenusMapper fndMenusMapper;

    @Autowired
    FndMenuEntriesMapper fndMenuEntriesMapper;

    @Autowired
    FndFunctionsMapper fndFunctionsMapper;

    @Autowired
    FndRespFunctionsMapper fndRespFunctionsMapper;


    public List<String> getUserDirectResp(String userName) {

        List<Map<String,Object>> directResps = wuram.selectRespByUserId(userName);
        List<String> directResp = new ArrayList<>();

        if(!CollectionUtils.isEmpty(directResps)){
            directResp = directResps.parallelStream().map(e ->  (String)e.get("RESPONSIBILITY_KEY")).collect(Collectors.toList());
        }

        return directResp;
    }

    public List<String> getUserInDirectResp(List<String> scope) {

        List<Map<String,Object>> inDirectResps = wuram.selectRespByRoles(scope);
        List<String> inDirectResp = new ArrayList<>();
        if(!CollectionUtils.isEmpty(inDirectResps)){
            inDirectResp = inDirectResps.parallelStream().map(e ->  (String)e.get("RESPONSIBILITY_KEY")).collect(Collectors.toList());
        }

        return inDirectResp;
    }

    public List<Map<String, Object>> getUserDirectRespForMap(String userName) {

        List<Map<String,Object>> directResps = wuram.selectRespByUserId(userName);
        return directResps;
    }

    public List<Map<String, Object>> getUserInDirectRespForMap(List<String> scope) {

        List<Map<String,Object>> inDirectResps = wuram.selectRespByRoles(scope);

        return inDirectResps;
    }

    public List<Map<String,Object>> getUserRoutes(String userName, List<String> scope) {

        List<Map<String,Object>> directResps = wuram.selectRespByUserId(userName);
        List<Map<String,Object>> inDirectResps = wuram.selectRespByRoles(scope);

        List<Map<String,Object>> allResps = new ArrayList<>();
        allResps.addAll(directResps);
        allResps.addAll(inDirectResps);


        List<Map<String,Object>> userRoutes = new ArrayList();

        for (Map<String,Object> resp : allResps){
            Long topMenuId = (Long)resp.get("MENU_ID");
            Long respId = (Long)resp.get("RESPONSIBILITY_ID");

            List<Map<String,Object>> fndRespFunExclue = fndRespFunctionsMapper.selectRespFunByRespId(respId);

            QueryWrapper<FndMenus> queryWrapper = new QueryWrapper<FndMenus>();
            queryWrapper.eq("MENU_ID",topMenuId);
            FndMenus topMenu= fndMenusMapper.selectOne(queryWrapper);

            Map<String,Object> respTopMenu = new HashMap<>();
            respTopMenu.put("path",topMenu.getPath());
            respTopMenu.put("component",topMenu.getComponent());
            respTopMenu.put("redirect",topMenu.getRedirect());
            respTopMenu.put("name",topMenu.getMenuCode());
            respTopMenu.put("alwaysShow",topMenu.getAlwaysShow());
            JSONObject jsonObject = JSON.parseObject(topMenu.getMeta());

            if(null != jsonObject){
                jsonObject.put("title", StringUtils.hasText(topMenu.getMenuName())?topMenu.getMenuName(): JSONPath.eval(jsonObject,"$.title"));
            }

            respTopMenu.put("meta",jsonObject);

            List<Map<String,Object>> children = getChildrenMenu(topMenuId,fndRespFunExclue);
            respTopMenu.put("children",children);

            userRoutes.add(respTopMenu);
        }

        return userRoutes;
    }

    public List<Map<String, Object>> getChildrenMenu(Long topMenuId,List<Map<String,Object>> fndRespFunExclue) {

        List<Map<String,Object>> userRoutes = new ArrayList();

        List<Map<String,Object>> menuEntries = fndMenuEntriesMapper.selectMenuEntriesByMenuId(topMenuId);

        for(Map<String,Object> menuEntry : menuEntries){
            Long subMenuId = (Long)menuEntry.get("SUB_MENU_ID");
            Long functionId = (Long)menuEntry.get("FUNCTION_ID");
            if(null != functionId ){

                boolean exclueFlag  = false;

                for (Map<String,Object> exclue : fndRespFunExclue){
                    if("F".equals(exclue.get("RULE_TYPE")) && functionId.equals(exclue.get("ACTION_ID"))){
                        exclueFlag = true;
                        break;
                    }

                }

                if(exclueFlag){
                    continue;
                }

                FndFunctions function = fndFunctionsMapper.selectOne(new QueryWrapper<FndFunctions>().eq("FUNCTION_ID",functionId));
                Map<String,Object> subFunction = new HashMap<>();
                subFunction.put("path",function.getPath());
                subFunction.put("component",function.getComponent());
                subFunction.put("redirect",function.getRedirect());
                subFunction.put("name",function.getFunctionCode());
                subFunction.put("hidden",function.getHidden());
                subFunction.put("type",function.getType());
                JSONObject jsonObject = JSON.parseObject(function.getMeta());

                if(null != jsonObject){
                    jsonObject.put("title", StringUtils.hasText(function.getFunctionName())?function.getFunctionName(): JSONPath.eval(jsonObject,"$.title"));
                }

                subFunction.put("meta",jsonObject);

                userRoutes.add(subFunction);

            }else if(null != subMenuId ){

                boolean exclueFlag  = false;

                for (Map<String,Object> exclue : fndRespFunExclue){
                    if("M".equals(exclue.get("RULE_TYPE")) && subMenuId.equals(exclue.get("ACTION_ID"))){
                        exclueFlag = true;
                        break;
                    }

                }

                if(exclueFlag){
                    continue;
                }

                FndMenus menu = fndMenusMapper.selectOne(new QueryWrapper<FndMenus>().eq("MENU_ID",subMenuId));
                Map<String,Object> subMenu = new HashMap<>();
                subMenu.put("path",menu.getPath());
                subMenu.put("component",menu.getComponent());
                subMenu.put("redirect",menu.getRedirect());
                subMenu.put("name",menu.getMenuCode());
                subMenu.put("alwaysShow",menu.getAlwaysShow());
                JSONObject jsonObject = JSON.parseObject(menu.getMeta());

                if(null != jsonObject){
                    jsonObject.put("title", StringUtils.hasText(menu.getMenuName())?menu.getMenuName(): JSONPath.eval(jsonObject,"$.title"));
                }

                subMenu.put("meta",jsonObject);

                List<Map<String,Object>> children = getChildrenMenu(subMenuId,fndRespFunExclue);
                subMenu.put("children",children);

                userRoutes.add(subMenu);
            }

        }

        return userRoutes;

    }

    public OperationResult addUserDirectResp(String userId, JSONArray insertRecords) {

        if(StringUtils.hasText(userId)){
            if(!CollectionUtils.isEmpty(insertRecords)){
                for(Object o : insertRecords){
                    String respKey = (String)((Map)o).get("RESPONSIBILITY_KEY");
                    if(StringUtils.hasText(respKey)){
                        WfUserRoleAssignments e = new WfUserRoleAssignments();
                        e.setUserName(userId);
                        e.setRoleName(respKey);
                        e.setRelationshipId(-1L);
                        e.setAssigningRole(respKey);
                        e.setStartDate(new Date());
                        wurams.save(e);
                    }
                }
            }
        }

        return OperationResult.buildSuccessResult("保存成功!");
    }

    public OperationResult delUserDirectResp(String userId, JSONArray removeRecords) {

        if(StringUtils.hasText(userId)){
            if(!CollectionUtils.isEmpty(removeRecords)){
                for(Object o : removeRecords){
                    String respKey = (String)((Map)o).get("RESPONSIBILITY_KEY");
                    if(StringUtils.hasText(respKey)){
                        wurams.remove(new UpdateWrapper<WfUserRoleAssignments>().eq("USER_NAME",userId).eq("ROLE_NAME",respKey));
                    }
                }
            }
        }

        return OperationResult.buildSuccessResult("删除成功!");

    }
}
