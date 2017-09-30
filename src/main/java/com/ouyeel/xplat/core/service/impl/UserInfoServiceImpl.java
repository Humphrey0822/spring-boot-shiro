package com.ouyeel.xplat.core.service.impl;

import com.ouyeel.xplat.core.bean.UserInfo;
import com.ouyeel.xplat.core.repository.UserInfoRepository;
import com.ouyeel.xplat.core.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoRepository.findByUsername(username);
    }
}
