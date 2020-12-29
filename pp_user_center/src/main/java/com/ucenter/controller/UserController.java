package com.ucenter.controller;


import com.common.model.ucenter.SysUser;
import com.ucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ucenter")
public class UserController  {
    @Autowired
    private UserService userService;

    @GetMapping("/getuser")
    public SysUser getUser(@RequestParam("account") String account){return userService.findUserByAccount(account);}
}
