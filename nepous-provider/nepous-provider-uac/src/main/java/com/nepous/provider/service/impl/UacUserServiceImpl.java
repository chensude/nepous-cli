package com.nepous.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.nepous.provider.mapper.UacUserMapper;
import com.nepous.provider.model.domain.UacAction;
import com.nepous.provider.model.domain.UacUser;
import com.nepous.provider.service.UacActionService;
import com.nepous.provider.service.UacUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class UacUserServiceImpl  extends ServiceImpl<UacUserMapper,UacUser> implements UacUserService {

    @Autowired
    private UacUserMapper uacUserMapper;
    @Autowired
    private UacActionService uacActionService;
    @Override
    public UacUser selectByLoginName(String loginName) {

        QueryWrapper<UacUser> query =
                Wrappers.<UacUser>query();
        query.eq(UacUser.LOGINNAME,loginName);

        return getOne(query);
    }

    @Override
    public UacUser selectUserInfoByUserId(Long id) {
        return uacUserMapper.selectUserInfoByUserId(id);
    }

    @Override
    public Collection<GrantedAuthority> loadUserAuthorities(Long id) {

        List<UacAction> ownAuthList = uacActionService.getOwnActionListByUserId(id);
        List<GrantedAuthority> authList = Lists.newArrayList();
        for(UacAction uacAction: ownAuthList) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(uacAction.getUrl());
            authList.add(simpleGrantedAuthority);
        }
        return authList;
    }
}
