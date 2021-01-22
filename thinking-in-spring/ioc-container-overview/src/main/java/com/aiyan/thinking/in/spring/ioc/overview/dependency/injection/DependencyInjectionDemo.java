package com.aiyan.thinking.in.spring.ioc.overview.dependency.injection;

import com.aiyan.thinking.in.spring.ioc.overview.annotation.Super;
import com.aiyan.thinking.in.spring.ioc.overview.domain.User;
import com.aiyan.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;
import java.util.Objects;

/**
 * 依赖查找示例
 *
 * @author zhangchaoyue
 * @date 2021/01/05
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        //配置xml 配置文件
        //启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");

        //依赖来源一：自定义 Bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);

        //依赖来源二：依赖注入（内建依赖）
        System.out.println(userRepository.getBeanFactory());

        ObjectFactory<ApplicationContext> userFactory = userRepository.getObjectFactory();

        System.out.println(userFactory.getObject() == beanFactory);

        //依赖查找(错误)
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        //依赖来源三：容器内建 Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean:" + environment);
    }

    private static void whoIsIocContainer(UserRepository userRepository, BeanFactory beanFactory) {

        // ConfigurableApplicationContext <- ApplicationContext <- BeanFactory

        // ConfigurableApplicationContext#getBeanFactory()

        // 这个表达式为什么会不成立 => ApplicationContext中组合了一个BeanFactory
        System.out.println(userRepository.getBeanFactory() == beanFactory);

        // ApplicationContext is BeanFactory
    }
}
 