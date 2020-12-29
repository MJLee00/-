package com.oauthServer.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Data
@ToString

public class UserJwt extends User {

    private String id;
    private String name;
    private String type;
    private String nickname;
    private String profileImage;
    private String sex;
    private String intro;
    private String phone;
    private String email;
    public UserJwt(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

}
