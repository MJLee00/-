package com.ucenter.dao;






import com.common.model.ucenter.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper{

    @Select("select * from user where account = #{account}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roles", column = "id", javaType = List.class,
                many = @Many(select = "com.ucenter.dao.RoleMapper.findByUid")),
            @Result(property = "permissions",column = "id",javaType = List.class,
            many = @Many(select = "com.ucenter.dao.PermissionMapper.findPermissionByRole"))
    })
    public SysUser findByAccount(String account);

}
