package com.oauthServer;



import com.common.model.rdatatype.Rdatatype;
import com.oauthServer.client.SourceServerClient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestFeign {
    @Autowired
    SourceServerClient sourceServerClient; //接口代理对象，由Feign生成代理对象

    @Test
    public void testRibbon(){
        //发起远程调用
        Rdatatype data = sourceServerClient.findTeachers();
        System.out.println(data);

    }


}
