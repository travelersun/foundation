package com.tianzhu.foundation.id;

import com.alibaba.fastjson.JSON;
import org.antframework.idcenter.client.core.Ids;
import org.antframework.idcenter.client.support.ServerRequester;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 负载均衡服务端请求器
 */
public class LoadBalanceServerRequester extends ServerRequester {

    RestTemplate restTemplate;

    public LoadBalanceServerRequester(String serverUrl,RestTemplate restTemplate) {
        super(serverUrl);
        this.restTemplate = restTemplate;
    }

    /**
     * 获取批量id
     *
     * @param iderId       id提供者的id（id编码）
     * @param expectAmount 期望获取到的id个数
     * @return 批量id
     */
    @Override
    public List<Ids> acquireIds(String iderId, int expectAmount) {
        try {

            MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
            paramMap.add("iderId",iderId);
            paramMap.add("expectAmount",expectAmount);

            String resultStr = restTemplate.postForObject(this.acquireIdsUrl,paramMap,String.class);


            AcquireIdsResult result = JSON.parseObject(resultStr, AcquireIdsResult.class);
            if (result == null) {
                throw new RuntimeException("请求id中心失败");
            }
            if (!result.isSuccess()) {
                throw new RuntimeException("从id中心获取批量id失败：" + result.getMessage());
            }
            return convert(result.getIdses());
        } catch (Exception e) {
            return ExceptionUtils.rethrow(e);
        }
    }
}
