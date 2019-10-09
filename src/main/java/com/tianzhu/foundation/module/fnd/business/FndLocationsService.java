package com.tianzhu.foundation.module.fnd.business;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianzhu.foundation.model.FilterHelper;
import com.tianzhu.foundation.model.OperationResult;
import com.tianzhu.foundation.module.fnd.entity.HrLocationsAll;
import com.tianzhu.foundation.module.fnd.mapper.HrLocationsAllMapper;
import com.tianzhu.foundation.module.fnd.service.impl.HrLocationsAllServiceImpl;
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
public class FndLocationsService {

    @Autowired
    HrLocationsAllMapper hrLocationsAllMapper;

    @Autowired
    HrLocationsAllServiceImpl hrLocationsAllServiceImpl;

    @Autowired
    IdersContext idersContext;

    public final static String fndLocationsIder = "locationId";

    public PageInfo<Map<String,Object>> queryPageInfo(JSONObject jsonFilter, JSONObject page){


        Map<String,Object> filter = FilterHelper.filterQuery("SELECT * FROM HR_LOCATIONS_ALL",jsonFilter.toJSONString());


        PageHelper.startPage(page.getIntValue("currentPage"), page.getIntValue("pageSize"));

        List<Map<String,Object>> items = hrLocationsAllMapper.queryPageInfo(filter);

        PageInfo<Map<String,Object>>  pageInfo= new PageInfo<>(items);

        PageHelper.clearPage();

        return pageInfo;

    }

    public OperationResult save(HrLocationsAll location) {

        if(location.getLocationId() == null ){
            // 获取用户id的提供者
            Ider ider = idersContext.getIder(fndLocationsIder);
            // 获取id
            Id id1 = ider.acquire();
            location.setLocationId(id1.getId());
            hrLocationsAllServiceImpl.save(location);
        }else{
            hrLocationsAllServiceImpl.updateById(location);
        }
        return OperationResult.buildSuccessResult("保存成功!");
    }

    public OperationResult delete(List<Long> ids) {

        if(!CollectionUtils.isEmpty(ids)){
            hrLocationsAllServiceImpl.removeByIds(ids);
        }

        return OperationResult.buildSuccessResult("删除成功!");
    }

}
