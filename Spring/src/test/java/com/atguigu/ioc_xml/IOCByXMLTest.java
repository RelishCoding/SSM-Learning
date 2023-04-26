package com.atguigu.ioc_xml;

import com.atguigu.ioc_xml.pojo.Clazz;
import com.atguigu.ioc_xml.pojo.Person;
import com.atguigu.ioc_xml.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {
    @Test
    public void testIOC(){
        //获取IOC容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        //Student studenOne = (Student) ioc.getBean("studentOne");
        //Student student = ioc.getBean(Student.class);
        //Student student = ioc.getBean("studentOne", Student.class);
        //Person student = ioc.getBean(Student.class);
        Person person = ioc.getBean(Person.class);
        //System.out.println(student);
        System.out.println(person);
    }

    @Test
    public void testDI(){
        //获取IOC容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
//        Student student = ioc.getBean("studentTwo", Student.class);
//        Student student = ioc.getBean("studentThree", Student.class);
//        Student student = ioc.getBean("studentFour", Student.class);
        /*Student student = ioc.getBean("studentFive", Student.class);
        System.out.println(student);*/
        /*Clazz clazz = ioc.getBean("clazzOne", Clazz.class);
        System.out.println(clazz);*/
        Student student = ioc.getBean("studentSix", Student.class);
        System.out.println(student);
    }
}
