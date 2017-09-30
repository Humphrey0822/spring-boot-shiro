package com.ouyeel.xplat.core.service;

import com.ouyeel.xplat.core.bean.UserInfo;

public interface UserInfoService {

    /**
     * 通过username 查找用户信息
     * @param username
     * @return
     */
    public UserInfo findByUsername(String username);
}
