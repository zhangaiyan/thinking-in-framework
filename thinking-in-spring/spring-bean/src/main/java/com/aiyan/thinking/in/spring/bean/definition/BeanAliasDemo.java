package com.aiyan.thinking.in.spring.bean.definition;

import com.aiyan.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangchaoyue
 * @date 2021-01-22
 */
public class BeanAliasDemo {

    public static void main(String[] args) {

        //配置xml 配置文件
        //启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-definitions-context.xml");

        //通过别名 aiyan-user 获取曾用名 user 的bean
        User user = beanFactory.getBean("user", User.class);
        User aiyanUser = beanFactory.getBean("aiyan-user", User.class);

        System.out.println(user == aiyanUser);
    }
}
