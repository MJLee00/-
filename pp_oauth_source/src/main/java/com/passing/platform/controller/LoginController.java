package com.passing.platform.controller;

import com.alibaba.fastjson.JSONObject;
import com.passing.platform.domain.Teacher;
import com.passing.platform.domain.User;
import com.passing.platform.service.impl.TeacherServiceImpl;
import com.passing.platform.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

@RestController
@Controller
public class LoginController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private TeacherServiceImpl teacherService;


    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public  Object verifiedLogin(HttpServletRequest req, HttpSession session){
        JSONObject jsonObject = new JSONObject();

        Map<String,String> data=new HashMap<String, String>();


        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/ }

        JSONObject receivedObject=(JSONObject) JSONObject.parse(jb.toString());

        String name = receivedObject.getString("account");
        String password = receivedObject.getString("password");
        try {
            boolean res = userService.verifypwd(name, password);
            if (res) {
                int type=userService.getType(name,password);
                data.put("type",String.valueOf(type));
                int id=userService.selectUserIdByAccountAndPwd(name,password);
                data.put("id",String.valueOf(id));
                jsonObject.put("code", 1);
                jsonObject.put("msg", "登录成功");
                jsonObject.put("status", "200");
                jsonObject.put("data",data);
                session.setAttribute("name", name);
                return jsonObject;
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("data","");
                jsonObject.put("msg", "用户名或密码错误");
                jsonObject.put("status", "401");
                return jsonObject;
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "服务器内部错误");
            jsonObject.put("status", "500");
            return jsonObject;
        }

    }

    @ResponseBody
    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    public  Object registerUser(HttpServletRequest req, HttpSession session){
        JSONObject jsonObject = new JSONObject();



        //获得post请求参数
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/ }

        JSONObject receivedObject=(JSONObject) JSONObject.parse(jb.toString());

        String name = receivedObject.getString("userName");
        String password = receivedObject.getString("password");

        try {
            int res = userService.selectUserByAccount(name);
            if (res==0) {
                int type=Integer.parseInt(receivedObject.getString("type"));
                User u=new User();
                u.setAccount(name);u.setPassword(password);u.setType(type);
                boolean isInsert= userService.insertUser(u);
                if(isInsert){
                    jsonObject.put("code", 1);
                    jsonObject.put("msg", "注册成功");
                    jsonObject.put("status", "200");
                    jsonObject.put("data","");
                    session.setAttribute("name", name);
                }
                else{
                    jsonObject.put("code", 0);
                    jsonObject.put("msg", "插入失败");
                    jsonObject.put("status", "409");
                    jsonObject.put("data","");
                    session.setAttribute("name", name);
                }


                return jsonObject;
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("data","");
                jsonObject.put("msg", "用户名已存在");
                jsonObject.put("status", "409");
                return jsonObject;
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "服务器内部错误");
            jsonObject.put("status", "500");
            return jsonObject;
        }

    }

    @ResponseBody
    @RequestMapping(value = "/teacherRegister",method = RequestMethod.POST)
    public  Object registerTeacher(HttpServletRequest req, HttpSession session){
        JSONObject jsonObject = new JSONObject();



        //获得post请求参数
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/ }

        JSONObject receivedObject=(JSONObject) JSONObject.parse(jb.toString());

        String name = receivedObject.getString("phone");
        String password = receivedObject.getString("password");
        String businessName=receivedObject.getString("productName");

        try {
            int res = userService.selectUserByAccount(name);
            if (res==0) {
                int type=Integer.parseInt(receivedObject.getString("type"));
                User u=new User();
                u.setAccount(name);u.setPassword(password);u.setType(type);
                boolean isInsert= userService.insertUser(u);
                int id=u.getId();

                Teacher teacher=new Teacher();
                teacher.setUid(id);teacher.setBusinessname(businessName);
                boolean res1=teacherService.insert(teacher);

                if(isInsert&&res1){
                    jsonObject.put("code", 1);
                    jsonObject.put("msg", "注册成功");
                    jsonObject.put("status", "200");
                    jsonObject.put("data","");
                    session.setAttribute("name", name);
                }
                else{
                    jsonObject.put("code", 0);
                    jsonObject.put("msg", "插入失败");
                    jsonObject.put("status", "409");
                    jsonObject.put("data","");
                    session.setAttribute("name", name);
                }


                return jsonObject;
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("data","");
                jsonObject.put("msg", "用户名已存在");
                jsonObject.put("status", "409");
                return jsonObject;
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "服务器内部错误");
            jsonObject.put("status", "500");
            return jsonObject;
        }

    }
}
