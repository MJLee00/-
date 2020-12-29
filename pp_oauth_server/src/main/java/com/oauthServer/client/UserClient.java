package com.oauthServer.client;

import com.common.model.ucenter.SysUser;

import org.springframework.cloud.openfeign.FeignClient;
import com.common.model.client.ppServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = ppServiceClient.PP_SERVICE_UCENTER)
public interface UserClient {
    @GetMapping("/ucenter/getuser")
    public SysUser getUser(@RequestParam("account") String account);
}
