package com.aiyan.thinking.in.spring.bean.definition;

import com.aiyan.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.aiyan.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangchaoyue
 * @date 2021-01-23
 */
public class SingletonBeanRegistrationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        DefaultUserFactory defaultUserFactory = new DefaultUserFactory();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();

        beanFactory.registerSingleton("userFactory", defaultUserFactory);

        applicationContext.refresh();

        applicationContext.getBeansOfType(UserFactory.class);

        UserFactory userFactoryByLookUp = applicationContext.getBean("userFactory", UserFactory.class);
        System.out.println("userFactory == useruserFactoryByLookUp:" + (userFactoryByLookUp == defaultUserFactory));

        applicationContext.close();
    }
}
