package com.common.model.ucenter.request;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginRequest  {

    String username;
    String password;
    String verifycode;

}
