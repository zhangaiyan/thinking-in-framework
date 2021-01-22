package com.aiyan.thinking.in.spring.bean.factory;

import com.aiyan.thinking.in.spring.ioc.overview.domain.User;

/**
 * @author zhangchaoyue
 * @date 2021-01-22
 */
public interface UserFactory {

    /**
     * 创建 User 对象
     *
     * @return User 对象
     */
    default User createUser() {
        return User.createUser();
    }
}
