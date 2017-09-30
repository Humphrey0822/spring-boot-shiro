package com.ouyeel.xplat.core.repository;

import com.ouyeel.xplat.core.bean.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {

    /**
     * 通过username查找用户信息
     * @param username 用户名
     * @return 用户信息
     */
    public UserInfo findByUsername(String username);
}
