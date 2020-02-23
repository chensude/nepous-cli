package com.nepous.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nepous.provider.model.domain.UacUser;

public interface UacUserMapper extends BaseMapper<UacUser> {
    UacUser selectUserInfoByUserId(Long id);
}
