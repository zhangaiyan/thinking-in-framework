package com.aiyan.thinking.in.spring.bean.definition;

import com.aiyan.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangchaoyue
 * @date 2021-01-22
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext(" META-INF/bean-instantiation-context.xml");

        User user = beanFactory.getBean("user-by-static-method", User.class);
        User userByInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);
        User userByFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(user);
        System.out.println(userByInstanceMethod);
        System.out.println(userByFactoryBean);
        System.out.println(user == userByInstanceMethod);
        System.out.println(user == userByFactoryBean);
    }
}
