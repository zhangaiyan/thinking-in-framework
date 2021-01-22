package com.aiyan.thinking.in.spring.bean.definition;

import com.aiyan.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangchaoyue
 * @date 2021-01-23
 */
public class BeanGarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);

        applicationContext.refresh();

        applicationContext.getBeansOfType(UserFactory.class);

        applicationContext.close();

        Thread.sleep(5000);

        System.gc();
    }
}
