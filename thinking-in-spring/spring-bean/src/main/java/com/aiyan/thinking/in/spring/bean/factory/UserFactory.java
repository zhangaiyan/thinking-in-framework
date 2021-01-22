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

    /**
     * 初始化 UserFactory
     */
    void initUserFactory();

    /**
     * UserFactory 销毁前执行逻辑
     */
    void doDestroy();
}
