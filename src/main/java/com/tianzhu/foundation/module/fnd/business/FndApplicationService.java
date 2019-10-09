package com.tianzhu.foundation.module.fnd.business;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.FilterHelper;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.entity.FndApplication;
import com.tianzhu.foundation.module.fnd.mapper.FndApplicationMapper;
import com.tianzhu.foundation.module.fnd.service.impl.FndApplicationServiceImpl;
import org.antframework.common.util.id.Id;
import org.antframework.idcenter.client.Ider;
import org.antframework.idcenter.client.IdersContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FndApplicationService {

    @Autowired
    FndApplicationMapper fndApplicationMapper;

    @Autowired
    FndApplicationServiceImpl fndApplicationServiceImpl;

    @Autowired
    IdersContext idersContext;

    public final static String fndApplicationIder = "applicationId";

    public PageInfo<Map<String,Object>> queryPageInfo(JSONObject jsonFilter, JSONObject page){


        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM FND_APPLICATION",jsonFilter.toJSONString());


        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = fndApplicationMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;

    }

    public OperationResult save(FndApplication fndApplication) {

        if(fndApplication.getApplicationId() == null ){
            // 获取用户id的提供者
            Ider ider = idersContext.getIder(fndApplicationIder);
            // 获取id
            Id id1 = ider.acquire();
            fndApplication.setApplicationId(id1.getId());
            fndApplicationServiceImpl.save(fndApplication);
        }else{
            fndApplicationServiceImpl.updateById(fndApplication);
        }
        return OperationResult.buildSuccessResult("保存成功!");
    }

    public OperationResult delete(List<Long> ids) {

        if(!CollectionUtils.isEmpty(ids)){
            fndApplicationServiceImpl.removeByIds(ids);
        }

        return OperationResult.buildSuccessResult("删除成功!");
    }
}
