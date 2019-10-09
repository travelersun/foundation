package com.tianzhu.foundation.model;

import com.tianzhu.filtering.ClauseBuilder;
import com.tianzhu.filtering.impl.ClauseBuilderProvider;
import com.tianzhu.filtering.impl.ExpressionBuilderProvider;
import com.tianzhu.filtering.impl.FilterExpressionsProvider;
import com.tianzhu.filtering.impl.FilteredSQLQuery;
import com.tianzhu.filtering.utils.SQLFilterProvider;

import java.util.HashMap;
import java.util.Map;

public class FilterHelper {

    public static final ClauseBuilder INSTANCE = new ClauseBuilderProvider(new FilterExpressionsProvider(new ExpressionBuilderProvider()), new SQLFilterProvider());


    public static Map<String,Object> filterQuery(String mainQuery,String jsonFilter){
        FilteredSQLQuery filteredSQLQuery = INSTANCE.filterQuery(mainQuery,jsonFilter);
        String sql = filteredSQLQuery.query();
        Iterable<String> parameters = filteredSQLQuery.parameters();
        Map<String, Object> values =  filteredSQLQuery.values();

        Map<String,Object> filter = new HashMap<>();
        String wheresql =  sql.substring(sql.lastIndexOf("MAIN_QUERY")+"MAIN_QUERY".length());

        filter.put("wheresql",wheresql);
        filter.putAll(values);

        return filter;
    }

}
