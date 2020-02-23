package com.nepous.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nepous.provider.model.domain.UacUser;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface UacUserService extends IService<UacUser> {

    UacUser selectByLoginName(String username);

    UacUser selectUserInfoByUserId(Long id);

    Collection<GrantedAuthority> loadUserAuthorities(Long id);
}
