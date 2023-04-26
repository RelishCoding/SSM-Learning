package com.atguigu.ioc_xml;

import com.atguigu.ioc_xml.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {
    @Test
    public void testFactoryBean(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
    }
}
