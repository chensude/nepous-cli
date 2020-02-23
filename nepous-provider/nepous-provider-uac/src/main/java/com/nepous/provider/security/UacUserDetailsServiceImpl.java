package com.nepous.provider.security;

import com.nepous.provider.model.domain.UacUser;
import com.nepous.provider.service.UacUserService;
import com.nepous.security.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Slf4j
@Component
public class UacUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UacUserService uacUserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("登录的用户名："+username);
        Collection<GrantedAuthority> grantedAuthorities;

        UacUser user = uacUserService.selectByLoginName(username);
        if (user == null) {
            throw new BadCredentialsException("用户名不存在或者密码错误");
        }
        user = uacUserService.selectUserInfoByUserId(user.getId());

        grantedAuthorities = uacUserService.loadUserAuthorities(user.getId());

        return new SecurityUser(user.getId(), user.getLoginName(), user.getLoginPwd(),
                user.getUserName(), user.getGroupId(), user.getGroupName(), user.getStatus(), grantedAuthorities);
    }
}
