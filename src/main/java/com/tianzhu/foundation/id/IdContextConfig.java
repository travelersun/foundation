package com.tianzhu.foundation.id;

import org.antframework.idcenter.client.IdersContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class IdContextConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @Value("${idcenter.url:http://idcenter/idcenter}")
    String idcenterUrl;

    @Value("${idcenter.server-name:idcenter}")
    String idcenterServerName;

    @Value("${idcenter.minDuration:600000}")
    long minDuration;

    @Value("${idcenter.maxDuration:900000}")
    long maxDuration;


    @Bean
    @Primary
    public IdersContext idersContext(){

        LoadBalanceServerRequester serverRequester = new LoadBalanceServerRequester(idcenterUrl,restTemplate);
        // 创建客户端
        IdersContext idersContext = new IdersContext(
                serverRequester,    //
                minDuration,             // 最小预留时间（毫秒，服务端不可用时客户端能够维持的最小时间）
                maxDuration);            // 最大预留时间（毫秒，服务端不可用时客户端能够维持的最大时间）
        // 最大预留时间减去最小预留时间的差值就是客户端请求服务端的平均间隔时间，
        // 这个差值也是从客户端获取的id的周期误差时间，建议合理设置。比如以上默认配置应该是适合绝大多数公司的。
        return idersContext;
    }

}
