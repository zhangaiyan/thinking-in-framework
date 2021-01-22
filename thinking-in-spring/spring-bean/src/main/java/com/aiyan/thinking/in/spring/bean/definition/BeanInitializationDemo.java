package com.aiyan.thinking.in.spring.bean.definition;

import com.aiyan.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.aiyan.thinking.in.spring.bean.factory.UserFactory;
import com.aiyan.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangchaoyue
 * @date 2021-01-22
 */
@Configuration
public class BeanInitializationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);

        applicationContext.refresh();
        // 非延迟初始化在 Spring 应用上下文启动完成后被初始化
        System.out.println("Spring 应用上下文已启动 ...");
        applicationContext.getBeansOfType(UserFactory.class);

        System.out.println("Spring 应用上下文准备关闭 ...");
        applicationContext.close();
        System.out.println("Spring 应用上下文已关闭 ...");
    }

    @Bean(initMethod = "initUserFactory",destroyMethod = "doDestroy")
    @Lazy
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}
