package com.nepous.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nepous.core.utils.GlobalConstant;
import com.nepous.provider.mapper.UacActionMapper;
import com.nepous.provider.model.domain.UacAction;
import com.nepous.provider.service.UacActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UacActionServiceImpl extends ServiceImpl<UacActionMapper, UacAction> implements UacActionService {

    @Autowired
    private UacActionMapper uacActionMapper;
    @Override
    public List<UacAction> getOwnActionListByUserId(Long userId) {

        if(userId==null) {
            //抛一个异常
           // throw new UacBizExce
        }

        List<UacAction> uacActionList;
        if(Objects.equals(userId, GlobalConstant.Sys.SUPER_MANAGER_USER_ID)) {
            // 获取全部权限信息
            uacActionList = list();
        }else {
            uacActionList = uacActionMapper.getOwnUacActionListByUserId(userId);
        }
        return uacActionList;
    }
}
