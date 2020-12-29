package com.oauthServer.client;


import com.common.model.rdatatype.Rdatatype;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator.
 */

@FeignClient(value = "SOURCE-SERVER") //指定远程调用的服务名
public interface SourceServerClient {
    //根据页面id查询页面信息，远程调用cms请求数据
    @GetMapping("/teacher/getallteacher")//用GetMapping标识远程调用的http的方法类型
    public Rdatatype findTeachers();


}
