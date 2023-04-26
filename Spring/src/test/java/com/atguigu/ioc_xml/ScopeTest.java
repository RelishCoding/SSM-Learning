package com.atguigu.ioc_xml;

import com.atguigu.ioc_xml.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void testScope(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = ioc.getBean("student", Student.class);
        Student student2 = ioc.getBean("student", Student.class);
        System.out.println(student1==student2);
    }
}
