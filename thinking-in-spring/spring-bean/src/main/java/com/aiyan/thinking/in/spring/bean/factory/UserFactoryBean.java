package com.aiyan.thinking.in.spring.bean.factory;

import com.aiyan.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author zhangchaoyue
 * @date 2021-01-22
 */
public class UserFactoryBean implements FactoryBean {


    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
