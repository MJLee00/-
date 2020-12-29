package com.common.model.ucenter;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString

public class SysUser  {

    private String id;
    private String name;
    private String type;
    private String nickname;
    private String profileImage;
    private String sex;
    private String intro;
    private String phone;
    private String email;
    private String account;
    private String password;
    private List<SysRole> roles;
    private List<SysPermission> permissions;
}
