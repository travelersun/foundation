package com.tianzhu.foundation.controller;

import org.antframework.common.util.id.Id;
import org.antframework.idcenter.client.Ider;
import org.antframework.idcenter.client.IdersContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {


    @Autowired
    IdersContext idersContext;


    @PreAuthorize("hasAuthority('SCOPE_scim.userids')")
    @GetMapping("/message")
    public String message() {
        return "secret message";
    }

    @GetMapping("/id/{idcode}")
    public String getId(@PathVariable("idcode") String idcode){

        // 获取用户id的提供者
        Ider ider = idersContext.getIder(idcode);
        // 获取id
        Id id1 = ider.acquire();
        //Id id2 = ider.acquire();
        // 以上获取到的是最原始的id形式，使用方可以根据需要将id格式化为自己需要的格式
        // 下面对id进行格式化，比如：2019022400001
        String formattedId1 = id1.getPeriod().toString() + String.format("%05d", id1.getId());
        return formattedId1;
    }


}
