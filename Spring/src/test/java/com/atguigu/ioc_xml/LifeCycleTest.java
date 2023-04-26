package com.atguigu.ioc_xml;

import com.atguigu.ioc_xml.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
    /**
     * 1、实例化
     * 2、依赖注入
     * 3、后置处理器的postProcessBeforeInitialization方法
     * 4、初始化，需要通过bean的init-method属性指定初始化的方法
     * 5、后置处理器的postProcessAfterInitialization方法
     * 6、IOC容器关闭时销毁，需要通过bean的destroy-method属性指定销毁的方法
     *
     * 注意：
     * bean的作用域为单例时，生命周期的前三个步骤会在获取IOC容器时执行
     * bean的作用域为多例时，生命周期的前三个步骤会在获取bean容器时执行
     */
    @Test
    public void test(){
        //ConfigurableApplicationContext是ApplicaionContext的子接口，
        //其中拓展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }
}
