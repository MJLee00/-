package com.oauthServer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RibbonTest {
    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testRibbon(){
        //确定要获取的服务名
        String serviceId = "pp-service-source";
        for (int i=0;i<10;i++){
            //ribbon客户端从eurekaServer中获取服务列表,根据服务名获取服务列表
            ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://"+serviceId+"/teacher/getallteacher", Map.class);
            Map body = forEntity.getBody();
            System.out.println(body);
        }

    }


}
