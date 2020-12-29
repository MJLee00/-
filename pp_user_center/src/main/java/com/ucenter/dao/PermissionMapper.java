package com.ucenter.dao;

import com.common.model.ucenter.SysPermission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

    @Select("select p.ID id,p.permission_NAME perName,p.permission_url perURL," +
            "p.parent_id parentId " +
            "from sys_role_permission sp,sys_permission p " +
            "where sp.PID=p.ID  and sp.RID IN(select r.ID from sys_user_role sr,sys_role r " +
            "where sr.RID=r.ID and sr.UID=#{uid})")
    public List<SysPermission> findPermissionByRole(Integer uid);
}
