package com.common.model.ucenter;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class SysPermission {
    private Integer id;
    private String perName;
    private String perURL;
    private String parentId;
}
