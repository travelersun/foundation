package com.tianzhu.foundation.module.fnd.business;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianzhu.filtering.ClauseBuilder;
import com.tianzhu.filtering.impl.ClauseBuilderProvider;
import com.tianzhu.filtering.impl.ExpressionBuilderProvider;
import com.tianzhu.filtering.impl.FilterExpressionsProvider;
import com.tianzhu.filtering.impl.FilteredSQLQuery;
import com.tianzhu.filtering.utils.SQLFilterProvider;
import com.tianzhu.foundation.model.FilterHelper;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.entity.FndApplication;
import com.tianzhu.foundation.module.fnd.entity.FndFlexValidationTables;
import com.tianzhu.foundation.module.fnd.entity.FndFlexValueSets;
import com.tianzhu.foundation.module.fnd.mapper.FndApplicationMapper;
import com.tianzhu.foundation.module.fnd.mapper.FndFlexValidationTablesMapper;
import com.tianzhu.foundation.module.fnd.mapper.FndFlexValueSetsMapper;
import com.tianzhu.foundation.module.fnd.service.impl.FndApplicationServiceImpl;
import com.tianzhu.foundation.module.fnd.service.impl.FndFlexValidationTablesServiceImpl;
import com.tianzhu.foundation.module.fnd.service.impl.FndFlexValueSetsServiceImpl;
import org.antframework.common.util.id.Id;
import org.antframework.idcenter.client.Ider;
import org.antframework.idcenter.client.IdersContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FndFlexValueSetsService {

    @Autowired
    FndFlexValueSetsMapper fndFlexValueSetsMapper;

    @Autowired
    FndFlexValidationTablesMapper fndFlexValidationTablesMapper;

    @Autowired
    FndFlexValueSetsServiceImpl fndFlexValueSetsServiceImpl;

    @Autowired
    FndFlexValidationTablesServiceImpl fndFlexValidationTablesServiceImpl;

    @Autowired
    IdersContext idersContext;

    public final static String fndFlexValueSetsIder = "fndFlexValueSetId";

    public static final ClauseBuilder INSTANCE = new ClauseBuilderProvider(new FilterExpressionsProvider(new ExpressionBuilderProvider()), new SQLFilterProvider());


    public PageInfo<Map<String,Object>> queryPageInfo(JSONObject jsonFilter, JSONObject page){


        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM FND_FLEX_VALUE_SETS",jsonFilter.toJSONString());


        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = fndFlexValueSetsMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;

    }

    public OperationResult save(FndFlexValueSets fndFlexValueSets) {

        if(fndFlexValueSets.getFlexValueSetId() == null ){
            // 获取用户id的提供者
            Ider ider = idersContext.getIder(fndFlexValueSetsIder);
            // 获取id
            Id id1 = ider.acquire();
            fndFlexValueSets.setFlexValueSetId(id1.getId());
            fndFlexValueSetsServiceImpl.save(fndFlexValueSets);
        }else{
            fndFlexValueSetsServiceImpl.updateById(fndFlexValueSets);
        }
        return OperationResult.buildSuccessResult("保存成功!",fndFlexValueSets.getFlexValueSetId());
    }

    public OperationResult delete(List<Long> ids) {

        if(!CollectionUtils.isEmpty(ids)){
            fndFlexValueSetsServiceImpl.removeByIds(ids);
            fndFlexValidationTablesServiceImpl.removeByIds(ids);
        }

        return OperationResult.buildSuccessResult("删除成功!");
    }


    public PageInfo queryPageInfoForvalidationTable(JSONObject jsonFilter, JSONObject page) {

        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM FND_FLEX_VALIDATION_TABLES",jsonFilter.toJSONString());

        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = fndFlexValidationTablesMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;
    }

    public OperationResult save(FndFlexValueSets fndFlexValueSets, FndFlexValidationTables fndFlexValidationTables) {

        OperationResult r1 = save(fndFlexValueSets);

        if(fndFlexValidationTables != null){
            fndFlexValidationTables.setFlexValueSetId((Long)r1.getData());
            fndFlexValidationTablesServiceImpl.saveOrUpdate(fndFlexValidationTables);
        }

        return OperationResult.buildSuccessResult("保存成功!");
    }

    public PageInfo queryDefinePageInfo(JSONObject jsonFilter, JSONObject page) {

        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM FND_FLEX_VALUE_SETS",jsonFilter.toJSONString());


        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = fndFlexValueSetsMapper.queryPageInfo(filter);

        for(Map<String,Object> e : items){

            if("TABLE".equals(e.get("VALIDATION_TYPE"))){
                e.put("validationTables",fndFlexValidationTablesServiceImpl.getById((Long)e.get("FLEX_VALUE_SET_ID")));
            }
        }

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;

    }

    public PageInfo queryValuePageInfo(JSONObject jsonFilter, JSONObject page, JSONObject innerParams) {

        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM FND_FLEX_VALUE_SETS",jsonFilter.toJSONString());


        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = fndFlexValueSetsMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        for(Map<String,Object> e : items){

            if("TABLE".equals(e.get("VALIDATION_TYPE"))){

                FndFlexValidationTables fndFlexValidationTables = fndFlexValidationTablesServiceImpl.getById((Long)e.get("FLEX_VALUE_SET_ID"));

                if(fndFlexValidationTables != null){

                    StringBuffer sql = new StringBuffer();

                    sql.append(" SELECT ");

                    String valueCol = fndFlexValidationTables.getValueColumnName();
                    String meanCol = fndFlexValidationTables.getMeaningColumnName();
                    String idCol = fndFlexValidationTables.getIdColumnName();

                    String whereOrderBy = fndFlexValidationTables.getAdditionalWhereClause();

                    sql.append(valueCol);
                    if(StringUtils.isNotBlank(meanCol)){
                        sql.append(" , ");
                        sql.append(meanCol);
                    }
                    if(StringUtils.isNotBlank(idCol)){
                        sql.append(" , ");
                        sql.append(idCol);
                    }

                    sql.append(" FROM ");

                    sql.append(fndFlexValidationTables.getApplicationTableName());

                    if(StringUtils.isNotBlank(whereOrderBy)){
                        sql.append("  ");
                        sql.append(whereOrderBy);
                    }

                    Map<String,Object> queryMap = new HashMap<>();


                    JSONObject innerPage = null;

                    JSONObject innerJsonFilter = null;

                    if(innerParams != null){
                        queryMap.putAll(innerParams);
                        innerPage = innerParams.getJSONObject("page");
                        innerJsonFilter = innerParams.getJSONObject("jsonFilter");

                    }

                    if(innerJsonFilter != null){
                        FilteredSQLQuery filteredSQLQuery = INSTANCE.filterQuery(sql.toString(),innerJsonFilter.toJSONString());
                        Iterable<String> parameters = filteredSQLQuery.parameters();
                        Map<String, Object> values =  filteredSQLQuery.values();
                        queryMap.put("sql",filteredSQLQuery.query());
                        queryMap.putAll(values);

                    }else{
                        queryMap.put("sql",sql.toString());
                    }


                    List<Map<String,Object>> values = new ArrayList<>();

                    if(innerPage != null){
                        PageHelper.startPage(innerPage.getIntValue("currentPage"), innerPage.getIntValue("pageSize"));
                        values = fndFlexValueSetsMapper.queryValueSetValuesPageInfo(queryMap);
                        PageInfo<Map<String,Object>>  innerPageInfo= new PageInfo<>(values);
                        e.put("data",innerPageInfo);
                        PageHelper.clearPage();
                    }else{
                        values = fndFlexValueSetsMapper.queryValueSetValuesPageInfo(queryMap);
                        PageInfo<Map<String,Object>>  innerPageInfo= new PageInfo<>(values);
                        e.put("data",innerPageInfo);
                    }

                }else {
                    e.put("data",new PageInfo(new ArrayList()));
                }
            }
        }



        return pageInfo;
    }
}
