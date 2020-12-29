package com.oauthServer.service;


import com.common.model.ucenter.SysPermission;
import com.common.model.ucenter.SysRole;
import com.common.model.ucenter.SysUser;
import com.oauthServer.client.UserClient;
import com.oauthServer.domain.UserJwt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ClientDetailsService clientDetailsService;

    @Autowired
    UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //取出身份，如果身份为空说明没有认证
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //没有认证统一采用httpbasic认证，httpbasic中存储了client_id和client_secret，开始认证client_id和client_secret
        if(authentication==null){
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(username);
            if(clientDetails!=null){
                //密码
                String clientSecret = clientDetails.getClientSecret();
                return new User(username,clientSecret,AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            }
        }
        if (StringUtils.isEmpty(username)) {
            return null;
        }
       // 去ucenter拿用户密码返回userdetails给spring security让其去判断密码正确性
       SysUser user=userClient.getUser(username);
        String value="";
        List<SysPermission> permissions= user.getPermissions();
        if(permissions!=null)
        value= permissions.stream().map(per->String.valueOf(per.getPerName())).collect(Collectors.joining(","));
        UserJwt userDetails = new UserJwt(username,
                user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(value));
        userDetails.setNickname(user.getNickname());
        userDetails.setProfileImage(user.getProfileImage());
        userDetails.setType(user.getType());
        return userDetails;
    }
}
