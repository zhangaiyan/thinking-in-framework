package com.aiyan.thinking.in.spring.ioc.overview.dependency.lookup;

import com.aiyan.thinking.in.spring.ioc.overview.annotation.Super;
import com.aiyan.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 *
 * @author zhangchaoyue
 * @date 2021/01/05
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        //配置xml 配置文件
        //启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");

        //按照类型查找
        lookupByType(beanFactory);
        //按照类型查找结合对象
        lookupByCollectionType(beanFactory);
        //通过注解查找对象
        lookupByAnnotation(beanFactory);

        lookupInRealTime(beanFactory);
        lookupInLazy(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注 @Super 所有的 User集合对象:" + userMap);
        }

    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有User集合对象:" + userMap);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("根据类型实时查找:" + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        ObjectFactory objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        System.out.println("延时查找:" + objectFactory.getObject());
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找:" + user);
    }

}
 