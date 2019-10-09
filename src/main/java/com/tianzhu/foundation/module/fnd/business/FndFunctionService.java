package com.tianzhu.foundation.module.fnd.business;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianzhu.filtering.ClauseBuilder;
import com.tianzhu.filtering.impl.ClauseBuilderProvider;
import com.tianzhu.filtering.impl.ExpressionBuilderProvider;
import com.tianzhu.filtering.impl.FilterExpressionsProvider;
import com.tianzhu.filtering.impl.FilteredSQLQuery;
import com.tianzhu.filtering.utils.SQLFilterProvider;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.entity.FndFunctions;
import com.tianzhu.foundation.module.fnd.entity.FndMenuEntries;
import com.tianzhu.foundation.module.fnd.mapper.FndFunctionsMapper;
import com.tianzhu.foundation.module.fnd.service.impl.FndFunctionsServiceImpl;
import com.tianzhu.foundation.module.fnd.service.impl.FndMenuEntriesServiceImpl;
import org.antframework.common.util.id.Id;
import org.antframework.idcenter.client.Ider;
import org.antframework.idcenter.client.IdersContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FndFunctionService {

    public static final ClauseBuilder INSTANCE = new ClauseBuilderProvider(new FilterExpressionsProvider(new ExpressionBuilderProvider()), new SQLFilterProvider());


    @Autowired
    FndFunctionsMapper fndFunctionsMapper;

    @Autowired
    FndFunctionsServiceImpl fndFunctionsServiceImpl;

    @Autowired
    FndMenuEntriesServiceImpl fndMenuEntriesServiceImpl;

    @Autowired
    IdersContext idersContext;

    public final static String fndFunctionIder = "functionId";

    public PageInfo<Map<String,Object>> queryPageInfo(JSONObject jsonFilter,JSONObject page){


        FilteredSQLQuery filteredSQLQuery = INSTANCE.filterQuery("select * FROM `FND_FUNCTIONS`",jsonFilter.toJSONString());
        String sql = filteredSQLQuery.query();
        Iterable<String> parameters = filteredSQLQuery.parameters();
        Map<String, Object> values =  filteredSQLQuery.values();

        Map<String,Object> filter = new HashMap<>();

        String wheresql =  sql.substring(sql.lastIndexOf("MAIN_QUERY")+"MAIN_QUERY".length());

        filter.put("wheresql",wheresql);
        filter.putAll(values);

        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = fndFunctionsMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;

    }

    public OperationResult save(FndFunctions fndFunction) {

        if(fndFunction.getFunctionId() == null ){
            // 获取用户id的提供者
            Ider ider = idersContext.getIder(fndFunctionIder);
            // 获取id
            Id id1 = ider.acquire();
            fndFunction.setFunctionId(id1.getId());
            fndFunctionsServiceImpl.save(fndFunction);
        }else{
            fndFunctionsServiceImpl.updateById(fndFunction);
        }
        return OperationResult.buildSuccessResult("保存成功!");
    }

    public OperationResult delete(List<Long> ids) {

        if(!CollectionUtils.isEmpty(ids)){
            List menuEntyies = fndMenuEntriesServiceImpl.list(new QueryWrapper<FndMenuEntries>().in("FUNCTION_ID",ids));

            if(!CollectionUtils.isEmpty(menuEntyies)){
                return OperationResult.buildFailureResult("菜单树包含要删除的功能,不能将功能删除!");
            }


            fndFunctionsServiceImpl.removeByIds(ids);
        }

        return OperationResult.buildSuccessResult("删除成功!");
    }

}
