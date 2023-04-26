package com.atguigu.ioc_xml.factory;

import com.atguigu.ioc_xml.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean是一个接口，需要创建一个类实现该接口
 * 其中有三个方法：
 * getObject()：通过一个对象交给IOC容器管理
 * getObjectType()：设置所提供对象的类型
 * isSingleton()：所提供的对象是否是单例
 * 当把FactoryBean的实现类设置为bean时，会将当前类中getObject()方法所返回的对象交给IOC容器管理
 */
public class UserFactoryBean implements FactoryBean {
    public Object getObject() throws Exception {
        return new User();
    }

    public Class<?> getObjectType() {
        return User.class;
    }
}
