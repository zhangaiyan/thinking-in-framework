package com.aiyan.thinking.in.spring.bean.definition;

import com.aiyan.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author zhangchaoyue
 * @date 2021-01-22
 */
// 3.通过 @Import 来进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        // 1.命名 Bean 的注册方式
        registerUserBeanDefinition(applicationContext,"aiyan");
        // 2.非命名 Bean 的注册方式
        registerUserBeanDefinition(applicationContext);

        // 启动应用上下文
        applicationContext.refresh();
        // 按照类型依赖查找
        System.out.println("Config 类型的所有 Beans：" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有 Beans：" + applicationContext.getBeansOfType(User.class));

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    /**
     * Java API Bean 的注册方式
     *
     * @param registry
     * @param beanName
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id", 1L)
                .addPropertyValue("name", "艾焱");

        if (StringUtils.hasText(beanName)) {
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命名方式
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    /**
     * 命名 Bean 的注册方式
     *
     * @param registry
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {

        registerUserBeanDefinition(registry, null);
    }

    // 2.定义当前类作为 Spring Bean（组件）
    @Component
    public static class Config {

        // 1.通过 @Bean 方式定义,别名是真正名称的映射
        @Bean(name = {"user", "aiyan-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("艾焱");
            return user;
        }
    }
}
