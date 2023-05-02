package com.atguigu.aop;

import com.atguigu.aop.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1,2);
    }
}
