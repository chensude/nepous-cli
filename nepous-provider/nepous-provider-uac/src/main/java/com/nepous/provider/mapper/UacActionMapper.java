package com.nepous.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nepous.provider.model.domain.UacAction;

import java.util.List;

public interface UacActionMapper extends BaseMapper<UacAction> {
    List<UacAction> getOwnUacActionListByUserId(Long userId);
}
