# 一、Spring简介

## 1、Spring概述

官网地址：https://spring.io/

> Spring 是最受欢迎的企业级 Java 应用程序开发框架，数以百万的来自世界各地的开发人员使用Spring 框架来创建性能好、易于测试、可重用的代码。
>
> Spring 框架是一个开源的 Java 平台，它最初是由 Rod Johnson 编写的，并且于 2003 年 6 月首次在 Apache 2.0 许可下发布。
>
> Spring 是轻量级的框架，其基础版本只有 2 MB 左右的大小。
>
> Spring 框架的核心特性是可以用于开发任何 Java 应用程序，但是在 Java EE 平台上构建 web 应用程序是需要扩展的。 Spring 框架的目标是使 J2EE 开发变得更容易使用，通过启用基于 POJO 编程模型来促进良好的编程实践。
>

## 2、Spring家族

项目列表：https://spring.io/projects

## 3、Spring Framework

Spring 基础框架，可以视为 Spring 基础设施，基本上任何其他 Spring 项目都是以 Spring Framework为基础的。

### 3.1、Spring Framework特性

- **非侵入式**：使用 Spring Framework 开发应用程序时，Spring 对应用程序本身的结构影响非常

小。对领域模型可以做到零污染；对功能性组件也只需要使用几个简单的注解进行标记，完全不会

破坏原有结构，反而能将组件结构进一步简化。这就使得基于 Spring Framework 开发应用程序

时结构清晰、简洁优雅。

- **控制反转**：IOC——Inversion of Control，翻转资源获取方向。把自己创建资源、向环境索取资源

变成环境将资源准备好，我们享受资源注入。

- **面向切面编程**：AOP——Aspect Oriented Programming，在不修改源代码的基础上增强代码功能

- **容器**：Spring IOC 是一个容器，因为它包含并且管理组件对象的生命周期。组件享受到了容器化

的管理，替程序员屏蔽了组件创建过程中的大量细节，极大的降低了使用门槛，大幅度提高了开发

效率。

- **组件化**：Spring 实现了使用简单的组件配置组合成一个复杂的应用。在 Spring 中可以使用 XML

和 Java 注解组合这些对象。这使得我们可以基于一个个功能明确、边界清晰的组件有条不紊的搭

建超大型复杂应用系统。

- **声明式**：很多以前需要编写代码才能实现的功能，现在只需要声明需求即可由框架代为实现。

- **一站式**：在 IOC 和 AOP 的基础上可以整合各种企业应用的开源框架和优秀的第三方类库。而且 Spring 旗下的

项目已经覆盖了广泛领域，很多方面的功能性需求可以在 Spring Framework 的基础上全部使用 Spring 来实现。

### 3.2、Spring Framework五大功能模块

| **功能模块**            | **功能介绍**                                                |
| ----------------------- | ----------------------------------------------------------- |
| Core Container          | 核心容器，在 Spring 环境下使用任何功能都必须基于 IOC 容器。 |
| AOP&Aspects             | 面向切面编程                                                |
| Testing                 | 提供了对 junit 或 TestNG 测试框架的整合。                   |
| Data Access/Integration | 提供了对数据访问/集成的功能。                               |
| Spring MVC              | 提供了面向Web应用程序的集成功能。                           |

# 二、IOC

## 1、IOC容器

### 1.1、IOC思想

IOC：Inversion of Control，翻译过来是**反转控制**。

#### ①获取资源的传统方式

自己做饭：买菜、洗菜、择菜、改刀、炒菜，全过程参与，费时费力，必须清楚了解资源创建整个过程中的全部细节且熟练掌握。

在应用程序中的组件需要获取资源时，传统的方式是组件**主动**的从容器中获取所需要的资源，在这样的模式下开发人员往往需要知道在具体容器中特定资源的获取方式，增加了学习成本，同时降低了开发效率。

#### ②反转控制方式获取资源

点外卖：下单、等、吃，省时省力，不必关心资源创建过程的所有细节。

反转控制的思想完全颠覆了应用程序组件获取资源的传统方式：反转了资源的获取方向——改由容器主动的将资源推送给需要的组件，开发人员不需要知道容器是如何创建资源对象的，只需要提供接收资源的方式即可，极大的降低了学习成本，提高了开发的效率。这种行为也称为查找的**被动**形式。

#### ③DI

DI：Dependency Injection，翻译过来是**依赖注入**。

DI 是 IOC 的另一种表述方式：即组件以一些预先定义好的方式（例如：setter 方法）接受来自于容器

的资源注入。相对于IOC而言，这种表述更直接。

所以结论是：IOC 就是一种反转控制的思想， 而 DI 是对 IOC 的一种具体实现。

### 1.2、IOC容器在Spring中的实现

Spring 的 IOC 容器就是 IOC 思想的一个落地的产品实现。IOC 容器中管理的组件也叫做 bean。在创建bean 之前，首先需要创建 IOC 容器。Spring 提供了 IOC 容器的两种实现方式：

#### ①BeanFactory

这是 IOC 容器的基本实现，是 Spring 内部使用的接口。面向 Spring 本身，不提供给开发人员使用。

#### ②ApplicationContext

BeanFactory 的子接口，提供了更多高级特性。面向 Spring 的使用者，几乎所有场合都使用

ApplicationContext 而不是底层的 BeanFactory。

#### ③ApplicationContext的主要实现类

![5](img\5.png)

| **类型名**                      | **简介**                                                     |
| ------------------------------- | ------------------------------------------------------------ |
| ClassPathXmlApplicationContext  | 通过读取类路径下的 XML 格式的配置文件创建 IOC 容器对象（用的较多） |
| FileSystemXmlApplicationContext | 通过文件系统路径读取 XML 格式的配置文件创建 IOC 容器对象     |
| ConfigurableApplicationContext  | ApplicationContext 的子接口，包含一些扩展方法refresh() 和 close() ，让 ApplicationContext 具有启动、关闭和刷新上下文的能力。 |
| WebApplicationContext           | 专门为 Web 应用准备，基于 Web 环境创建 IOC 容器对象，并将对象引入存入 ServletContext 域中。 |

## 2、基于XML管理bean

### 2.1、实验一：入门案例

#### ①创建Maven Module

#### ②引入依赖

```xml
<dependencies>
    <!-- 基于Maven依赖传递性，导入spring-context依赖即可导入当前所需所有jar包 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.1</version>
    </dependency>
    <!-- junit测试 -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

![6](img\6.png)

#### ③创建类HelloWorld

```java
public class HelloWorld {
    public void sayHello(){
        System.out.println("helloworld");
    }
}
```

![7](img\7.png)

![8](img\8.png)

#### ⑤在Spring的配置文件中配置bean

```xml
<!--
	配置HelloWorld所对应的bean，即将HelloWorld的对象交给Spring的IOC容器管理
	通过bean标签配置IOC容器所管理的bean
	属性：
		id：设置bean的唯一标识，不能重复
		class：设置bean对象所对应类型的全类名
-->
<bean id="helloworld" class="com.atguigu.spring.bean.HelloWorld"></bean>
```

#### ⑥创建测试类测试

```java
@Test
public void testHelloWorld(){
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    HelloWorld helloworld = (HelloWorld) ioc.getBean("helloworld");
    helloworld.sayHello();
}
```

#### ⑦思路

![9](img\9.png)

#### ⑧注意

Spring 底层默认通过反射技术调用组件类的无参构造器来创建组件对象，这一点需要注意。如果在需要无参构造器时，没有无参构造器，则会抛出下面的异常：

> org.springframework.beans.factory.BeanCreationException: Error creating bean with name
>
> 'helloworld' defined in class path resource [applicationContext.xml]: Instantiation of bean
>
> failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed
>
> to instantiate [com.atguigu.spring.bean.HelloWorld]: No default constructor found; nested
>
> exception is java.lang.NoSuchMethodException: com.atguigu.spring.bean.HelloWorld.\<init>()
>

### 2.2、实验二：获取bean

#### ①方式一：根据bean的id获取

由于 id 属性指定了 bean 的唯一标识，所以根据 bean 标签的 id 属性可以精确获取到一个组件对象。

上个实验中我们使用的就是这种方式。

#### ②方式二：根据bean的类型获取

```java
@Test
public void testHelloWorld(){
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    HelloWorld bean = ioc.getBean(HelloWorld.class);
    bean.sayHello();
}
```

#### ③方式三：根据bean的id和类型

```java
@Test
public void testHelloWorld(){
    ApplicationContext ac = newClassPathXmlApplicationContext("applicationContext.xml");
    HelloWorld bean = ac.getBean("helloworld", HelloWorld.class);
    bean.sayHello();
}
```

#### ④注意

当根据类型获取bean时，要求IOC容器中类型匹配的bean有且只能有一个

当IOC容器中一共配置了多个：

```xml
<bean id="helloworldOne" class="com.atguigu.spring.bean.HelloWorld"></bean>
<bean id="helloworldTwo" class="com.atguigu.spring.bean.HelloWorld"></bean>
```

根据类型获取时会抛出异常：NoUniqueBeanDefinitionException

若没有任何一个类型匹配的bean，此时抛出异常：NoSuchBeanDefinitionException

#### ⑤扩展

如果组件类实现了接口，根据接口类型可以获取 bean 吗？

> 可以，前提是bean唯一

如果一个接口有多个实现类，这些实现类都配置了 bean，根据接口类型可以获取 bean 吗？

> 不行，因为bean不唯一

#### ⑥结论

根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：『对象 **instanceof** 指定的类型』的返回结果，只要返回的是true就可以认定为和类型匹配，能够获取到。

即通过bean的类型、bean所继承的类的类型、bean所实现的接口的类型都可以获取bean

### 2.3、实验三：依赖注入之setter注入

#### ①创建学生类Student

```java
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    public Student() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", sex='" + sex + '\'' +
            '}';
    }
}
```

#### ②配置bean时为属性赋值

```xml
<bean id="studentOne" class="com.atguigu.spring.bean.Student">
    <!-- property标签：通过组件类的setXxx()方法给组件对象设置属性 -->
    <!-- name属性：指定需要赋值的属性名（这个属性名是getXxx()、setXxx()方法定义的，和成员变量无关）-->
    <!-- value属性：设置为属性所赋的值 -->
    <property name="id" value="1001"></property>
    <property name="name" value="张三"></property>
    <property name="age" value="23"></property>
    <property name="sex" value="男"></property>
</bean>
```

#### ③测试

```java
@Test
public void testDIBySet(){
    ApplicationContext ac = new ClassPathXmlApplicationContext("springdi.xml");
    Student studentOne = ac.getBean("studentOne", Student.class);
    System.out.println(studentOne);
    //Student{sid=1001, sname='张三', age=23, gender='男'}
}
```

### 2.4、实验四：依赖注入之构造器注入

#### ①在Student类中添加有参构造

```java
public Student(Integer id, String name, Integer age, String sex) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.sex = sex;
}
```

#### ②配置bean

```xml
<bean id="studentTwo" class="com.atguigu.spring.bean.Student">
    <constructor-arg value="1002"></constructor-arg>
    <constructor-arg value="李四"></constructor-arg>
    <constructor-arg value="33"></constructor-arg>
    <constructor-arg value="女"></constructor-arg>
</bean>
```

> 注意：
>
> constructor-arg标签还有两个属性可以进一步描述构造器参数：
>
> - index属性：指定参数所在位置的索引（从0开始）
> - name属性：指定参数名

若只有一个有参构造方法，可直接按顺序为参数赋值，可省略name设置参数名

若能匹配到多个有参构造，会默认以最后一个有参构造方法赋值。此时可通过name属性指定为某参数赋值

#### ③测试

```java
@Test
public void testDIBySet(){
    ApplicationContext ac = new ClassPathXmlApplicationContext("springdi.xml");
    Student studentOne = ac.getBean("studentTwo", Student.class);
    System.out.println(studentOne);
}
```

### 2.5、实验五：特殊值处理

#### ①字面量赋值

> 什么是字面量？
>
> int a = 10;
>
> 声明一个变量a，初始化为10，此时a就不代表字母a了，而是作为一个变量的名字。当我们引用a
>
> 的时候，我们实际上拿到的值是10。
>
> 而如果a是带引号的：'a'，那么它现在不是一个变量，它就是代表a这个字母本身，这就是字面
>
> 量。所以字面量没有引申含义，就是我们看到的这个数据本身。
>
> 字面量包括基本数据类型及其包装类和 String 类型

```xml
<!-- 使用value属性给bean的属性赋值时，Spring会把value属性的值看做字面量 -->
<property name="name" value="张三"/>
```

#### ②null值

```xml
<property name="name">
	<null />
</property>
```

> 注意：
>
> ```xml
> <property name="name" value="null"></property>
> ```
>
> 以上写法，为name所赋的值是字符串null

#### ③xml实体

```xml
<!-- 小于号在XML文档中用来定义标签的开始，不能随便使用 -->
<!-- 解决方案一：使用XML实体来代替 -->
<!-- 
	<对应的实体：&lt;
    >对应的实体：&gt;
-->
<property name="expression" value="a &lt; b"/>
```

#### ④CDATA节

```xml
<property name="expression">
    <!-- 解决方案二：使用CDATA节 -->
    <!-- CDATA中的C代表Character，是文本、字符的含义，CDATA就表示纯文本数据 -->
    <!-- XML解析器看到CDATA节就知道这里是纯文本，就不会当作XML标签或属性来解析 -->
    <!-- 所以CDATA节中写什么符号都随意，CDATA节其中的内容会原样解析 -->
    <!-- CDATA节是xml中一个特殊的标签，因此不能直接写到value属性里面，而应写到单独设置的value子标签中 -->
    <value><![CDATA[a < b]]></value>
</property>
```

### 2.6、实验六：为类类型属性赋值

#### ①创建班级类Clazz

```java
public class Clazz {
    private Integer clazzId;
    private String clazzName;
    public Integer getClazzId() {
        return clazzId;
    }
    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }
    public String getClazzName() {
        return clazzName;
    }
    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }
    @Override
    public String toString() {
        return "Clazz{" +
            "clazzId=" + clazzId +
            ", clazzName='" + clazzName + '\'' +
            '}';
    }
    public Clazz() {
    }
    public Clazz(Integer clazzId, String clazzName) {
        this.clazzId = clazzId;
        this.clazzName = clazzName;
    }
}
```

#### ②修改Student类

在Student类中添加以下代码：

```java
private Clazz clazz;
public Clazz getClazz() {
    return clazz;
}
public void setClazz(Clazz clazz) {
    this.clazz = clazz;
}
//修改toString方法
```

#### ③方式一：引用外部已声明的bean

配置Clazz类型的bean：

```xml
<bean id="clazzOne" class="com.atguigu.spring.bean.Clazz">
    <property name="clazzId" value="1111"></property>
    <property name="clazzName" value="财源滚滚班"></property>
</bean>
```

为Student中的clazz属性赋值：

```xml
<bean id="studentFour" class="com.atguigu.spring.bean.Student">
    <property name="id" value="1004"></property>
    <property name="name" value="赵六"></property>
    <property name="age" value="26"></property>
    <property name="sex" value="女"></property>
    <!-- ref属性：引用IOC容器中某个bean的id，将所对应的bean为属性赋值 -->
    <property name="clazz" ref="clazzOne"></property>
</bean>
```

错误演示：

```xml
<bean id="studentFour" class="com.atguigu.spring.bean.Student">
    <property name="id" value="1004"></property>
    <property name="name" value="赵六"></property>
    <property name="age" value="26"></property>
    <property name="sex" value="女"></property>
    <property name="clazz" value="clazzOne"></property>
</bean>
```

> 如果错把ref属性写成了value属性，会抛出异常： Caused by: java.lang.IllegalStateException:
>
> Cannot convert value of type 'java.lang.String' to required type
>
> 'com.atguigu.spring.bean.Clazz' for property 'clazz': no matching editors or conversion
>
> strategy found
>
> 意思是不能把String类型转换成我们要的Clazz类型，说明我们使用value属性时，Spring只把这个
>
> 属性看做一个普通的字符串，不会认为这是一个bean的id，更不会根据它去找到bean来赋值

#### ④方式二：内部bean

```xml
<bean id="studentFour" class="com.atguigu.spring.bean.Student">
    <property name="id" value="1004"></property>
    <property name="name" value="赵六"></property>
    <property name="age" value="26"></property>
    <property name="sex" value="女"></property>
    <property name="clazz">
        <!-- 在一个bean中再声明一个bean就是内部bean -->
        <!-- 内部bean只能用于给属性赋值，不能在外部通过IOC容器获取，因此可以省略id属性 -->
        <bean id="clazzInner" class="com.atguigu.spring.bean.Clazz">
            <property name="clazzId" value="2222"></property>
            <property name="clazzName" value="远大前程班"></property>
        </bean>
    </property>
</bean>
```

#### ③方式三：级联属性赋值

```xml
<bean id="studentFour" class="com.atguigu.spring.bean.Student">
    <property name="id" value="1004"></property>
    <property name="name" value="赵六"></property>
    <property name="age" value="26"></property>
    <property name="sex" value="女"></property>
    <!-- 一定先引用某个bean为属性赋值，才可以使用级联方式更新属性 -->
    <property name="clazz" ref="clazzOne"></property>
    <property name="clazz.clazzId" value="3333"></property>
    <property name="clazz.clazzName" value="最强王者班"></property>
</bean>
```

### 2.7、实验七：为数组类型属性赋值

#### ①修改Student类

在Student类中添加以下代码：

```java
private String[] hobbies;
public String[] getHobbies() {
    return hobbies;
}
public void setHobbies(String[] hobbies) {
    this.hobbies = hobbies;
}
```

#### ②配置bean

```xml
<bean id="studentFour" class="com.atguigu.spring.bean.Student">
    <property name="id" value="1004"></property>
    <property name="name" value="赵六"></property>
    <property name="age" value="26"></property>
    <property name="sex" value="女"></property>
    <!-- ref属性：引用IOC容器中某个bean的id，将所对应的bean为属性赋值 -->
    <property name="clazz" ref="clazzOne"></property>
    <property name="hobbies">
        <array>
            <value>抽烟</value>
            <value>喝酒</value>
            <value>烫头</value>
        </array>
    </property>
</bean>
```

### 2.8、实验八：为集合类型属性赋值

#### ①为List集合类型属性赋值

在Clazz类中添加以下代码：

```java
private List<Student> students;
public List<Student> getStudents() {
    return students;
}
public void setStudents(List<Student> students) {
    this.students = students;
}
```

配置bean：

```xml
<bean id="clazzTwo" class="com.atguigu.spring.bean.Clazz">
    <property name="clazzId" value="4444"></property>
    <property name="clazzName" value="Javaee0222"></property>
    <property name="students">
        <list>
            <ref bean="studentOne"></ref>
            <ref bean="studentTwo"></ref>
            <ref bean="studentThree"></ref>
        </list>
    </property>
</bean>
```

> 若为Set集合类型属性赋值，只需要将其中的list标签改为set标签即可

#### ②为Map集合类型属性赋值

创建教师类Teacher：

```java
public class Teacher {
    private Integer teacherId;
    private String teacherName;
    public Integer getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public Teacher(Integer teacherId, String teacherName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }
    public Teacher() {
    }
    @Override
    public String toString() {
        return "Teacher{" +
            "teacherId=" + teacherId +
            ", teacherName='" + teacherName + '\'' +
            '}';
    }
}
```

在Student类中添加以下代码：

```java
private Map<String, Teacher> teacherMap;
public Map<String, Teacher> getTeacherMap() {
    return teacherMap;
}
public void setTeacherMap(Map<String, Teacher> teacherMap) {
    this.teacherMap = teacherMap;
}
```

配置bean：

```xml
<bean id="teacherOne" class="com.atguigu.spring.bean.Teacher">
    <property name="teacherId" value="10010"></property>
    <property name="teacherName" value="大宝"></property>
</bean>

<bean id="teacherTwo" class="com.atguigu.spring.bean.Teacher">
    <property name="teacherId" value="10086"></property>
    <property name="teacherName" value="二宝"></property>
</bean>

<bean id="studentFour" class="com.atguigu.spring.bean.Student">
    <property name="id" value="1004"></property>
    <property name="name" value="赵六"></property>
    <property name="age" value="26"></property>
    <property name="sex" value="女"></property>
    <!-- ref属性：引用IOC容器中某个bean的id，将所对应的bean为属性赋值 -->
    <property name="clazz" ref="clazzOne"></property>
    <property name="hobbies">
        <array>
            <value>抽烟</value>
            <value>喝酒</value>
            <value>烫头</value>
        </array>
    </property>
    <property name="teacherMap">
        <map>
            <entry key="10010" value-ref="teacherOne"></entry>
            <entry key="10086" value-ref="teacherTwo"></entry>
        </map>
    </property>
</bean>
```

#### ③引用集合类型的bean

```xml
<!--list集合类型的bean-->
<util:list id="students">
    <ref bean="studentOne"></ref>
    <ref bean="studentTwo"></ref>
    <ref bean="studentThree"></ref>
</util:list>

<!--map集合类型的bean-->
<util:map id="teacherMap">
    <entry key="10010" value-ref="teacherOne"></entry>
    <entry key="10086" value-ref="teacherTwo"></entry>
</util:map>

<bean id="clazzTwo" class="com.atguigu.spring.bean.Clazz">
    <property name="clazzId" value="4444"></property>
    <property name="clazzName" value="Javaee0222"></property>
    <property name="students" ref="students"></property>
</bean>

<bean id="studentFour" class="com.atguigu.spring.bean.Student">
    <property name="id" value="1004"></property>
    <property name="name" value="赵六"></property>
    <property name="age" value="26"></property>
    <property name="sex" value="女"></property>
    <!-- ref属性：引用IOC容器中某个bean的id，将所对应的bean为属性赋值 -->
    <property name="clazz" ref="clazzOne"></property>
    <property name="hobbies">
        <array>
            <value>抽烟</value>
            <value>喝酒</value>
            <value>烫头</value>
        </array>
    </property>
    <property name="teacherMap" ref="teacherMap"></property>
</bean>
```

> 使用util:list、util:map标签必须引入相应的命名空间，可以通过 idea 的提示功能选择

### 2.9、实验九：p命名空间

引入p命名空间后，可以通过以下方式为bean的各个属性赋值

```xml
<bean id="studentSix" class="com.atguigu.spring.bean.Student"
      p:id="1006" p:name="小明" p:clazz-ref="clazzOne" p:teacherMap-ref="teacherMap"></bean>
```

### 2.10、实验十：引入外部属性文件

#### ①加入依赖

```xml
<!-- MySQL驱动 -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.16</version>
</dependency>
<!-- 数据源 -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.0.31</version>
</dependency>
```

#### ②创建外部属性文件

![10](img\10.png)

```properties
jdbc.user=root
jdbc.password=atguigu
jdbc.url=jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC
jdbc.driver=com.mysql.cj.jdbc.Driver
```

#### ③引入属性文件

```xml
<!-- 引入外部属性文件 -->
<context:property-placeholder location="jdbc.properties"></context:property-placeholder>
```

#### ④配置bean

```xml
<bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
    <property name="url" value="${jdbc.url}"/>
    <property name="driverClassName" value="${jdbc.driver}"/>
    <property name="username" value="${jdbc.user}"/>
    <property name="password" value="${jdbc.password}"/>
</bean>
```

#### ⑤测试

```java
@Test
public void testDataSource() throws SQLException {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-datasource.xml");
    DataSource dataSource = ac.getBean(DataSource.class);
    Connection connection = dataSource.getConnection();
    System.out.println(connection);
}
```

### 2.11、实验十一：bean的作用域

#### ①概念

在Spring中可以通过配置bean标签的scope属性来指定bean的作用域范围，各取值含义参加下表：

| **取值**          | **含义**                                | **创建对象的时机** |
| ----------------- | --------------------------------------- | ------------------ |
| singleton（默认） | 在IOC容器中，这个bean的对象始终为单实例 | IOC容器初始化时    |
| prototype         | 这个bean在IOC容器中有多个实例           | 获取bean时         |

如果是在WebApplicationContext环境下还会有另外两个作用域（但不常用）：

| **取值** | **含义**             |
| -------- | -------------------- |
| request  | 在一个请求范围内有效 |
| session  | 在一个会话范围内有效 |

#### ②创建类User

```java
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    public User() {
    }
    public User(Integer id, String username, String password, Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", age=" + age +
            '}';
    }
}
```

#### ③配置bean

```xml
<!--
    scope：设置bean的作用域，有两个属性：
    scope="singleton|prototype"
    singleton(单例)(默认值):表示获取该bean所对应的对象都是同一个，IOC容器初始化时创建对象
    singleton（多例）:表示获取该bean所对应的对象都不是同一个，getBean()时创建对象
-->

<bean class="com.atguigu.bean.User" scope="prototype"></bean>
```

#### ④测试

```java
@Test
public void testBeanScope(){
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-scope.xml");
    User user1 = ac.getBean(User.class);
    User user2 = ac.getBean(User.class);
    System.out.println(user1==user2);
}
```

### 2.12、实验十二：bean的生命周期

#### ①具体的生命周期过程

- bean对象创建（调用无参构造器）
- 给bean对象设置属性
- bean对象初始化之前操作（由bean的后置处理器负责）
- bean对象初始化（需在配置bean时指定初始化方法）
- bean对象初始化之后操作（由bean的后置处理器负责）
- bean对象就绪可以使用
- bean对象销毁（需在配置bean时指定销毁方法）
- IOC容器关闭

#### ②修改类User

```java
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    public User() {
        System.out.println("生命周期：1、创建对象");
    }
    public User(Integer id, String username, String password, Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        System.out.println("生命周期：2、依赖注入");
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void initMethod(){
        System.out.println("生命周期：3、初始化");
    }
    public void destroyMethod(){
        System.out.println("生命周期：5、销毁");
    }
    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", age=" + age +
            '}';
    }
}
```

> 注意其中的 initMethod() 和 destroyMethod()，可以通过配置 bean 的 init-method 和destroy-method属性指定为初始化和销毁的方法

#### ③配置bean

```xml
<!-- 使用init-method属性指定初始化方法 -->
<!-- 使用destroy-method属性指定销毁方法 -->
<bean class="com.atguigu.bean.User" scope="prototype" init-method="initMethod"destroy-method="destroyMethod">
    <property name="id" value="1001"></property>
    <property name="username" value="admin"></property>
    <property name="password" value="123456"></property>
    <property name="age" value="23"></property>
</bean>
```

#### ④测试

```java
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
public void testLife(){
    //ConfigurableApplicationContext是ApplicaionContext的子接口，其中拓展了刷新和关闭容器的方法
    //直接用 ClassPathXmlApplicationContext 也可以
    ClassPathXmlApplicationContext ac = newClassPathXmlApplicationContext("spring-lifecycle.xml");
    User bean = ac.getBean(User.class);
    System.out.println("生命周期：4、通过IOC容器获取bean并使用");
    ac.close();
}
```

#### ⑤bean的后置处理器

bean的后置处理器会在生命周期的初始化前后添加额外的操作，需要实现BeanPostProcessor接口，

且配置到IOC容器中，需要注意的是，bean后置处理器不是单独针对某一个bean生效，而是针对IOC容器中所有bean都会执行

创建bean的后置处理器：

```java
package com.atguigu.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		//此方法在bean的生命周期初始化之前执行
        System.out.println("MyBeanPostProcessor-->后置处理器postProcessBeforeInitialization");
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		//此方法在bean的生命周期初始化之后执行
        System.out.println("MyBeanPostProcessor-->后置处理器postProcessAfterInitialization");
        return bean;
    }
}
```

在IOC容器中配置后置处理器：

```xml
<!-- bean的后置处理器要放入IOC容器才能生效 -->
<bean id="myBeanProcessor"class="com.atguigu.spring.process.MyBeanProcessor"></bean>
```

### 2.13、实验十三：FactoryBean

#### ①简介

FactoryBean 是 Spring 提供的一种整合第三方框架的常用机制。和普通的 bean 不同，配置一个 FactoryBean 类型的 bean，在获取 bean 的时候得到的并不是 class 属性中配置的这个类的对象，而是 getObject() 方法的返回值。通过这种机制，Spring 可以帮我们把复杂组件创建的详细过程和繁琐细节都屏蔽起来，只把最简洁的使用界面展示给我们。

将来我们整合 Mybatis 时，Spring就是通过FactoryBean机制来帮我们创建SqlSessionFactory 对象的。

```java
/*
* Copyright 2002-2020 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* https://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.springframework.beans.factory;
import org.springframework.lang.Nullable;

/**
* Interface to be implemented by objects used within a {@link BeanFactory}
which
* are themselves factories for individual objects. If a bean implements this
* interface, it is used as a factory for an object to expose, not directly as a
* bean instance that will be exposed itself.
*
* <p><b>NB: A bean that implements this interface cannot be used as a normal
bean.</b>
* A FactoryBean is defined in a bean style, but the object exposed for bean
* references ({@link #getObject()}) is always the object that it creates.
*
* <p>FactoryBeans can support singletons and prototypes, and can either create
* objects lazily on demand or eagerly on startup. The {@link SmartFactoryBean}
* interface allows for exposing more fine-grained behavioral metadata.
*
* <p>This interface is heavily used within the framework itself, for example
for
* the AOP {@link org.springframework.aop.framework.ProxyFactoryBean} or the
* {@link org.springframework.jndi.JndiObjectFactoryBean}. It can be used for
* custom components as well; however, this is only common for infrastructure
code.
*
* <p><b>{@code FactoryBean} is a programmatic contract. Implementations are not
* supposed to rely on annotation-driven injection or other reflective
facilities.</b>
* {@link #getObjectType()} {@link #getObject()} invocations may arrive early in
the
* bootstrap process, even ahead of any post-processor setup. If you need access
to
* other beans, implement {@link BeanFactoryAware} and obtain them
programmatically.
*
* <p><b>The container is only responsible for managing the lifecycle of the
FactoryBean
* instance, not the lifecycle of the objects created by the FactoryBean.</b>
Therefore,
* a destroy method on an exposed bean object (such as {@link
java.io.Closeable#close()}
* will <i>not</i> be called automatically. Instead, a FactoryBean should
implement
* {@link DisposableBean} and delegate any such close call to the underlying
object.
*
* <p>Finally, FactoryBean objects participate in the containing BeanFactory's
* synchronization of bean creation. There is usually no need for internal
* synchronization other than for purposes of lazy initialization within the
* FactoryBean itself (or the like).
*
* @author Rod Johnson
* @author Juergen Hoeller
* @since 08.03.2003
* @param <T> the bean type
* @see org.springframework.beans.factory.BeanFactory
* @see org.springframework.aop.framework.ProxyFactoryBean
* @see org.springframework.jndi.JndiObjectFactoryBean
*/
public interface FactoryBean<T> {
    /**
    * The name of an attribute that can be
    * {@link org.springframework.core.AttributeAccessor#setAttribute set} on a
    * {@link org.springframework.beans.factory.config.BeanDefinition} so that
    * factory beans can signal their object type when it can't be deduced from
    * the factory bean class.
    * @since 5.2
    */
    String OBJECT_TYPE_ATTRIBUTE = "factoryBeanObjectType";
    
    /**
    * Return an instance (possibly shared or independent) of the object
    * managed by this factory.
    * <p>As with a {@link BeanFactory}, this allows support for both the
    * Singleton and Prototype design pattern.
    * <p>If this FactoryBean is not fully initialized yet at the time of
    * the call (for example because it is involved in a circular reference),
    * throw a corresponding {@link FactoryBeanNotInitializedException}.
    * <p>As of Spring 2.0, FactoryBeans are allowed to return {@code null}
    * objects. The factory will consider this as normal value to be used; it
    * will not throw a FactoryBeanNotInitializedException in this case anymore.
    * FactoryBean implementations are encouraged to throw
    * FactoryBeanNotInitializedException themselves now, as appropriate.
    * @return an instance of the bean (can be {@code null})
    * @throws Exception in case of creation errors
    * @see FactoryBeanNotInitializedException
    */
    @Nullable
    T getObject() throws Exception;
    
    /**
    * Return the type of object that this FactoryBean creates,
    * or {@code null} if not known in advance.
    * <p>This allows one to check for specific types of beans without
    * instantiating objects, for example on autowiring.
    * <p>In the case of implementations that are creating a singleton object,
    * this method should try to avoid singleton creation as far as possible;
    * it should rather estimate the type in advance.
    * For prototypes, returning a meaningful type here is advisable too.
    * <p>This method can be called <i>before</i> this FactoryBean has
    * been fully initialized. It must not rely on state created during
    * initialization; of course, it can still use such state if available.
    * <p><b>NOTE:</b> Autowiring will simply ignore FactoryBeans that return
    * {@code null} here. Therefore it is highly recommended to implement
    * this method properly, using the current state of the FactoryBean.
    * @return the type of object that this FactoryBean creates,
    * or {@code null} if not known at the time of the call
    * @see ListableBeanFactory#getBeansOfType
    */
    @Nullable
    Class<?> getObjectType();
    
    /**
    * Is the object managed by this factory a singleton? That is,
    * will {@link #getObject()} always return the same object
    * (a reference that can be cached)?
    * <p><b>NOTE:</b> If a FactoryBean indicates to hold a singleton object,
    * the object returned from {@code getObject()} might get cached
    * by the owning BeanFactory. Hence, do not return {@code true}
    * unless the FactoryBean always exposes the same reference.
    * <p>The singleton status of the FactoryBean itself will generally
    * be provided by the owning BeanFactory; usually, it has to be
    * defined as singleton there.
    * <p><b>NOTE:</b> This method returning {@code false} does not
    * necessarily indicate that returned objects are independent instances.
    * An implementation of the extended {@link SmartFactoryBean} interface
    * may explicitly indicate independent instances through its
    * {@link SmartFactoryBean#isPrototype()} method. Plain {@link FactoryBean}
    * implementations which do not implement this extended interface are
    * simply assumed to always return independent instances if the
    * {@code isSingleton()} implementation returns {@code false}.
    * <p>The default implementation returns {@code true}, since a
    * {@code FactoryBean} typically manages a singleton instance.
    * @return whether the exposed object is a singleton
    * @see #getObject()
    * @see SmartFactoryBean#isPrototype()
    */
    default boolean isSingleton() {
        return true;
    }
}
```

#### ②创建类UserFactoryBean

```java
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

public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
```

#### ③配置bean

```xml
<bean id="user" class="com.atguigu.bean.UserFactoryBean"></bean>
```

#### ④测试

```java
@Test
public void testUserFactoryBean(){
    //获取IOC容器
    ApplicationContext ac = new ClassPathXmlApplicationContext("springfactorybean.xml");
    User user = ac.getBean(User.class);
    System.out.println(user);
}
```

### 2.14、实验十四：基于xml的自动装配

> 自动装配：
>
> 根据指定的策略，在 IOC 容器中匹配某一个 bean，自动为指定的 bean 中所依赖的类类型或接口类型属性赋值
>

#### ①场景模拟

创建类 UserController

```java
public class UserController {
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void saveUser(){
        userService.saveUser();
    }
}
```

创建接口 UserService

```java
public interface UserService {
	void saveUser();
}
```

创建类 UserServiceImpl 实现接口 UserService

```java
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
```

创建接口 UserDao

```java
public interface UserDao {
	void saveUser();
}
```

创建类 UserDaoImpl 实现接口UserDao

```java
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
```

配置 bean（未设置自动装配）：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="userController" class="com.atguigu.ioc_xml.controller.UserController">
        <property name="userService" ref="userService"></property>
    </bean>

    <bean id="userService" class="com.atguigu.ioc_xml.service.impl.UserServiceImpl">
        <property name="userDao" ref="userDao"></property>
    </bean>

    <bean id="userDao" class="com.atguigu.ioc_xml.dao.impl.UserDaoImpl"></bean>
</beans>
```

测试：

```java
public class AutowireByXMLTest {
    @Test
    public void testAutowire(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
```

#### ②配置bean

> 通过使用 bean 标签的 autowire 属性设置自动装配的策略
>
> 自动装配方式：
>
> 1. no、default：表示不装配，即bean中的属性不会自动匹配某个bean为属性赋值，此时属性使用默认值
>
> 2. byType：根据要赋值的属性的类型，在 IOC 容器中匹配某个兼容类型的bean，为属性自动赋值
>
> * 若在 IOC 中，没有任何一个兼容类型的bean能够为属性赋值，则该属性不装配，即属性使用默认值null
>
>   * 若在 IOC 中，有多个兼容类型的bean能够为属性赋值，则抛出异常 NoUniqueBeanDefinitionException
>
>  * 总结：当使用byType实现自动装配时，IOC容器中有且只有一个类型匹配的bean能够为属性赋值

```xml
<bean id="userController"class="com.atguigu.autowire.xml.controller.UserController" autowire="byType"></bean>

<bean id="userService"class="com.atguigu.autowire.xml.service.impl.UserServiceImpl" autowire="byType"></bean>

<bean id="userDao" class="com.atguigu.autowire.xml.dao.impl.UserDaoImpl"></bean>
```

> 3. 自动装配方式：byName
>
> byName：将要赋值的属性的属性名，作为 bean 的 id 在 IOC 容器中匹配相对应的bean进行赋值
>
> 当类型匹配的bean有多个时，此时可以使用 byName 实现自动装配

```xml
<bean id="userController" class="com.atguigu.ioc_xml.controller.UserController" autowire="byName">
    <!--<property name="userService" ref="userService"></property>-->
</bean>

<bean id="userService" class="com.atguigu.ioc_xml.service.impl.UserServiceImpl" autowire="byName">
    <!--<property name="userDao" ref="userDao"></property>-->
</bean>

<bean id="service" class="com.atguigu.ioc_xml.service.impl.UserServiceImpl" autowire="byName">
    <!--<property name="userDao" ref="userDao"></property>-->
</bean>

<bean id="userDao" class="com.atguigu.ioc_xml.dao.impl.UserDaoImpl"></bean>

<bean id="dao" class="com.atguigu.ioc_xml.dao.impl.UserDaoImpl"></bean>
```

#### ③测试

```java
@Test
public void testAutoWireByXML(){
    ApplicationContext ac = new ClassPathXmlApplicationContext("autowire-xml.xml");
    UserController userController = ac.getBean(UserController.class);
    userController.saveUser();
}
```

## 3、基于注解管理bean

### 3.1、实验一：标记与扫描

#### ①注解

和 XML 配置文件一样，注解本身并不能执行，注解本身仅仅只是做一个标记，具体的功能是框架检测到注解标记的位置，然后针对这个位置按照注解标记的功能来执行具体操作。

本质上：所有一切的操作都是 Java 代码来完成的，XML 和注解只是告诉框架中的 Java 代码如何执行。

举例：元旦联欢会要布置教室，蓝色的地方贴上元旦快乐四个字，红色的地方贴上拉花，黄色的地方贴上气球。

![11](img\11.png)

班长做了所有标记，同学们来完成具体工作。墙上的标记相当于我们在代码中使用的注解，后面同学们做的工作，相当于框架的具体操作。

#### ②扫描

Spring 为了知道程序员在哪些地方标记了什么注解，就需要通过扫描的方式，来进行检测。然后根据注解进行后续操作。

#### ③新建Maven Module

```xml
<dependencies>
    <!-- 基于Maven依赖传递性，导入spring-context依赖即可导入当前所需所有jar包 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.1</version>
    </dependency>
    <!-- junit测试 -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

#### ④创建Spring配置文件

![12](img\12.png)

#### ⑤标识组件的常用注解

> @Component：将类标识为普通组件 
>
> @Controller：将类标识为控制层组件 
>
> @Service：将类标识为业务层组件 
>
> @Repository：将类标识为持久层组件

问：以上四个注解有什么关系和区别？

![13](img\13.png)

通过查看源码我们得知，@Controller、@Service、@Repository这三个注解只是在@Component注解的基础上起了三个新的名字。

对于 Spring 使用 IOC 容器管理这些组件来说没有区别。所以 @Controller、@Service、@Repository这三个注解只是给开发人员看的，让我们能够便于分辨组件的作用。

注意：虽然它们本质上一样，但是为了代码的可读性，为了程序结构严谨我们肯定不能随便胡乱标记。

#### ⑥创建组件

创建控制层组件

```java
@Controller
public class UserController {
}
```

创建接口UserService

```java
public interface UserService {
}
```

创建业务层组件UserServiceImpl

```java
@Service
public class UserServiceImpl implements UserService {
}
```

创建接口UserDao

```java
public interface UserDao {
}
```

创建持久层组件UserDaoImpl

```java
@Repository
public class UserDaoImpl implements UserDao {
}
```

#### ⑦扫描组件

情况一：最基本的扫描方式

```xml
<context:component-scan base-package="com.atguigu.spring"></context:component-scan>
```

情况二：指定要排除的组件

```xml
<context:component-scan base-package="com.atguigu">
    <!-- context:exclude-filter标签：排除扫描,指定排除规则 -->
    <!--
        type：设置排除扫描的方式
        type=“annotation | assignable”
        type="annotation"：根据注解的类型进行排除，expression中需要设置要排除的注解的全类名
        type="assignable"：根据类的类型进行排除，expression中需要设置要排除的类的全类名
    -->
    <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    <!--<context:exclude-filter type="assignable" expression="com.atguigu.controller.UserController"/>-->
</context:component-scan>
```

情况三：仅扫描指定组件

```xml
<context:component-scan base-package="com.atguigu" use-default-filters="false">
    <!-- context:include-filter标签：包含扫描，指定在原有扫描规则的基础上追加的规则 -->
    <!-- 注意：此时必须在context:component-scan标签中设置use-default-filters="false"，因为默认规则即扫描指定包下所有类 -->
    <!--use-default-filters="true"（默认）：所设置的包下所有的类都需要扫描，此时可以使用扫描排除
        use-default-filters="false"，所设置的包下所有的类都不需要扫描，此时可以使用包含扫描 -->
    <!--
        type：设置排除或包含的依据
        type="annotation"，根据注解排除，expression中设置要排除的注解的全类名
        type="assignable"，根据类型排除，expression中设置要排除的类型的全类名
     -->
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    <!--<context:include-filter type="assignable" expression="com.atguigu.controller.UserController"/>-->
</context:component-scan>
```

#### ⑧测试

```java
@Test
public void testAutowireByAnnotation(){
    ApplicationContext ac = new
        ClassPathXmlApplicationContext("applicationContext.xml");
    UserController userController = ac.getBean(UserController.class);
    System.out.println(userController);
    UserService userService = ac.getBean(UserService.class);
    System.out.println(userService);
    UserDao userDao = ac.getBean(UserDao.class);
    System.out.println(userDao);
}
```

#### ⑨组件所对应的bean的id

在我们使用 XML 方式管理 bean 的时候，每个 bean 都有一个唯一标识，便于在其他地方引用。现在使用注解后，每个组件仍然应该有一个唯一标识。

> 默认情况：通过注解+扫描所配置的 bean 的 id，默认值为类的小驼峰，即类名的首字母小写的结果。例如：UserController类对应的 bean 的 id 就是 userController。
>
> 自定义bean的id：可通过标识组件的注解的 value 属性值设置 bean 的自定义的 id
>
> 如：@Service("userService")//默认为userServiceImpl public class UserServiceImpl implements  UserService {}
>

### 3.2、实验二：基于注解的自动装配

#### ①场景模拟

> 参考基于 xml 的自动装配
>
> 在 UserController 中声明 UserService 对象
>
> 在 UserServiceImpl 中声明 UserDao 对象

#### ②@Autowired注解

@Autowired 是一个实现自动装配功能的注解

在成员变量上直接标记 @Autowired 注解即可完成自动装配，不需要提供 setXxx() 方法。以后我们在项目中的正式用法就是这样。

```java
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    public void saveUser(){
        userService.saveUser();
    }
}
```

```java
public interface UserService {
    void saveUser();
}

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    
    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
```

```java
public interface UserDao {
	void saveUser();
}	
```

```java
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
```

#### ③@Autowired注解其他细节

> @Autowired 注解能够标识的位置
>
> * 标识在成员变量上，此时不需要设置成员变量的set方法
> * 标识在 set 方法上
> * 标识在为当前成员变量赋值的有参构造上

```java
@Controller
public class UserController {
    private UserService userService;
    
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    public void saveUser(){
        userService.saveUser();
    }
}
```

```java
@Controller
public class UserController {
    private UserService userService;
    
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }
    
    public void saveUser(){
        userService.saveUser();
    }
}
```

#### ④@Autowired工作流程

![14](img\14.png)

- 首先根据所需要的组件类型到 IOC 容器中查找
  - 能够找到唯一的 bean：直接执行装配
  - 如果完全找不到匹配这个类型的 bean：装配失败
  - 和所需类型匹配的 bean 不止一个
    - 没有@Qualifier注解：根据 @Autowired 标记位置成员变量的变量名作为 bean 的 id 进行匹配
      - 能够找到：执行装配
      - 找不到：装配失败
    - 使用 @Qualifier 注解：根据 @Qualifier 注解中指定的名称作为 bean 的 id 进行匹配
      - 能够找到：执行装配
      - 找不到：装配失败

```
@Autowired注解的原理
a>默认通过byType的方式，在IOC容器中通过类型匹配某个bean为属性赋值
b>若有多个类型匹配的bean，此时会自动转换为byName的方式实现自动装配的效果
即将要赋值的属性的属性名作为bean的id匹配某个bean为属性赋值
c>若byType和byName的方式都无法实现自装配，即IOC容器中有多个类型匹配的bean
且这些bean的id和要复制的属性的属性名都不一致，此时抛异常：NoUniqueBeanDefinitionException
d>此时可以在要赋值的属性上，添加一个注解@Qualifier
通过该注解的value属性值，指定某个bean的id，将这个bean为属性赋值
```

```xml
<bean id="service" class="com.atguigu.ioc_annotation.service.impl.UserServiceImpl"></bean>

<bean id="dao" class="com.atguigu.ioc_annotation.dao.impl.UserDaoImpl"></bean>
```

```java
@Controller
public class UserController {
    @Autowired
    //@Qualifier("userServiceImpl")
    @Qualifier("service")
    private UserService userService;
    
    public void saveUser(){
        userService.saveUser();
    }
}
```

```java
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    //@Qualifier("userDaoImpl")
    @Qualifier("dao")
    private UserDao userDao;

    public void saveUser() {
        userDao.saveUser();
    }
}
```

> 注意：若IOC容器中没有任何一个类型匹配的bean，此时抛出异常：NoSuchBeanDefinitionException
>
> 在@Autowired中有个属性required，默认值为true，要求必须完成自动装配，因此在自动装配无法找到相应的bean时，会装配失败
>
> 可以将属性required的值设置为false，则表示能装配则装配，无法装配则使用属性的默认值
>
> 但是实际开发时，基本上所有需要装配组件的地方都是必须装配的，用不上这个属性。

# 三、AOP

## 1、场景模拟

### 1.1、声明接口

声明计算器接口Calculator，包含加减乘除的抽象方法

```java
public interface Calculator {
    int add(int i, int j);
    int sub(int i, int j);
    int mul(int i, int j);
    int div(int i, int j);
}
```

### 1.2、创建实现类

![15](img\15.png)

```java
public class CalculatorPureImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
    
    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
    
    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
    
    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
}
```

### 1.3、创建带日志功能的实现类

![16](img\16.png)

```java
public class CalculatorLogImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
        int result = i + j;
        System.out.println("方法内部 result = " + result);
        System.out.println("[日志] add 方法结束了，结果是：" + result);
        return result;
    }
    
    @Override
    public int sub(int i, int j) {
        System.out.println("[日志] sub 方法开始了，参数是：" + i + "," + j);
        int result = i - j;
        System.out.println("方法内部 result = " + result);
        System.out.println("[日志] sub 方法结束了，结果是：" + result);
        return result;
    }
    
    @Override
    public int mul(int i, int j) {
        System.out.println("[日志] mul 方法开始了，参数是：" + i + "," + j);
        int result = i * j;
        System.out.println("方法内部 result = " + result);
        System.out.println("[日志] mul 方法结束了，结果是：" + result);
        return result;
    }
    
    @Override
    public int div(int i, int j) {
        System.out.println("[日志] div 方法开始了，参数是：" + i + "," + j);
        int result = i / j;
        System.out.println("方法内部 result = " + result);
        System.out.println("[日志] div 方法结束了，结果是：" + result);
        return result;
    }
}
```

### 1.4、提出问题

#### ①现有代码缺陷

针对带日志功能的实现类，我们发现有如下缺陷：

- 对核心业务功能有干扰，导致程序员在开发核心业务功能时分散了精力
- 附加功能分散在各个业务功能方法中，不利于统一维护

#### ②解决思路

解决这两个问题，核心就是：解耦。我们需要把附加功能从业务功能代码中抽取出来。

#### ③困难

解决问题的困难：要抽取的代码在方法内部，靠以前把子类中的重复代码抽取到父类的方式没法解决。所以需要引入新的技术。

## 2、代理模式

### 2.1、概念

#### ①介绍

二十三种设计模式中的一种，属于结构型模式。它的作用就是通过提供一个代理类，让我们在调用目标方法的时候，不再是直接对目标方法进行调用，而是通过代理类**间接**调用。让不属于目标方法核心逻辑的代码从目标方法中剥离出来——**解耦**。调用目标方法时先调用代理对象的方法，减少对目标方法的调用和打扰，同时让附加功能能够集中在一起也有利于统一维护。

![17](img\17.png)

使用代理后：

![18](img\18.png)

#### ②生活中的代理

- 广告商找大明星拍广告需要经过经纪人
- 合作伙伴找大老板谈合作要约见面时间需要经过秘书
- 房产中介是买卖双方的代理

#### ③相关术语

- 代理：将非核心逻辑剥离出来以后，封装这些非核心逻辑的类、对象、方法。
- 目标：被代理“套用”了非核心逻辑代码的类、对象、方法。

### 2.2、静态代理

创建静态代理类：

```java
public class CalculatorStaticProxy implements Calculator {
    // 将被代理的目标对象声明为成员变量
    private Calculator target;
    
    public CalculatorStaticProxy(Calculator target) {
        this.target = target;
    }
    
    @Override
    public int add(int i, int j) {
        // 附加功能由代理类中的代理方法来实现
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
        // 通过目标对象来实现核心业务逻辑
        int addResult = target.add(i, j);
        System.out.println("[日志] add 方法结束了，结果是：" + addResult);
        return addResult;
    }
}
```

测试：

```java
public class ProxyTest {
    @Test
    public void testProxy(){
        CalculatorStaticProxy proxy=new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1,2);
    }
}
```

> 静态代理确实实现了解耦，但是由于代码都写死了，完全不具备任何的灵活性。就拿日志功能来说，将来其他地方也需要附加日志，那还得再声明更多个静态代理类，那就产生了大量重复的代码，日志功能还是分散的，没有统一管理。
>
> 提出进一步的需求：将日志功能集中到一个代理类中，将来有任何日志需求，都通过这一个代理类来实现。这就需要使用动态代理技术了。
>

### 2.3、动态代理

动态代理有两种：

1. jdk动态代理，要求必须有接口，最终生成的代理类和目标类实现相同的接口，在com.sun.proxy包下，类名称为$proxy2

2. cglib动态代理，最终生成的代理类会自动继承目标类，并且和目标类在相同的包下 

![19](img\19.png)

生产代理对象的工厂类：

```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target;
    
    public ProxyFactory(Object target) {
        this.target = target;
    }
    
    public Object getProxy(){
        /**
         * newProxyInstance()方法：创建一个代理实例
         * 其中有三个参数：
         * 1、ClassLoader loader：指定加载动态生成的代理类的类加载器
         * 2、Class<?>[] interfaces：获取目标对象实现的所有接口的class对象所组成的数组
         * 3、InvocationHandler invocationHandler：设置代理对象实现目标对象方法的过程，
         	即代理类中如何重写接口中的抽象方法
         */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 * proxy：代理对象
                 * method：代理对象需要实现的方法，即其中需要重写的方法
                 * args：method所对应方法（即要执行的方法）的参数列表
                 */
                Object result = null;
                try {
                	System.out.println("[动态代理][日志] "+method.getName()+"，参数："+ Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("[动态代理][日志] "+method.getName()+"，结 果："+ result);
                } catch (Exception e) {
                	e.printStackTrace();
                    System.out.println("[动态代理][日志] "+method.getName()+"，异常："+e.getMessage());
                } finally {
                	System.out.println("[动态代理][日志] "+method.getName()+"，方法执行完毕");
                }
                return result;
            }   
        };    
        return Proxy.newProxyInstance(classLoader, interfaces,invocationHandler);
    }
}                                     
```

### 2.4、测试

```java
@Test
public void testDynamicProxy(){
    ProxyFactory factory = new ProxyFactory(new CalculatorLogImpl());
    Calculator proxy = (Calculator) factory.getProxy();
    proxy.add(1,2);
    //proxy.div(1,0);
}
```

## 3、AOP概念及相关术语

### 3.1、概述

AOP（Aspect Oriented Programming）是一种设计思想，是软件设计领域中的面向切面编程，它是面向对象编程的一种补充和完善，它以通过预编译方式和运行期动态代理方式实现在不修改源代码的情况下给程序动态统一添加额外功能的一种技术。

### 3.2、相关术语

#### ①横切关注点

从每个方法中抽取出来的同一类非核心业务。在同一个项目中，我们可以使用多个横切关注点对相关方法进行多个不同方面的增强。

这个概念不是语法层面天然存在的，而是根据附加功能的逻辑上的需要：有十个附加功能，就有十个横切关注点。![20](img\20.png)

#### ②通知

每一个横切关注点上要做的事情都需要写一个方法来实现，这样的方法就叫通知方法。

- 前置通知：在被代理的目标方法**前**执行
- 返回通知：在被代理的目标方法**成功结束**后执行（**寿终正寝**）
- 异常通知：在被代理的目标方法**异常结束**后执行（**死于非命**）
- 后置通知：在被代理的目标方法**最终结束**后执行（**盖棺定论**）
- 环绕通知：使用try...catch...finally结构围绕**整个**被代理的目标方法，包括上面四种通知对应的所有位置![21](img\21.png)

#### ③切面

封装通知方法的类。![22](img\22.png)

#### ④目标

被代理的目标对象。

#### ⑤代理

向目标对象应用通知之后创建的代理对象。

#### ⑥连接点

这也是一个纯逻辑概念，不是语法定义的。

把方法排成一排，每一个横切位置看成x轴方向，把方法从上到下执行的顺序看成y轴，x轴和y轴的交叉点就是连接点。

![23](img\23.png)

#### ⑦切入点

定位连接点的方式。

每个类的方法中都包含多个连接点，所以连接点是类中客观存在的事物（从逻辑上来说）。

如果把连接点看作数据库中的记录，那么切入点就是查询记录的 SQL 语句。

Spring 的 AOP 技术可以通过切入点定位到特定的连接点。

切点通过 org.springframework.aop.Pointcut 接口进行描述，它使用类和方法作为连接点的查询条件。

### 3.3、作用

- 简化代码：把方法中固定位置的重复的代码**抽取**出来，让被抽取的方法更专注于自己的核心功能，提高内聚性。

- 代码增强：把特定的功能封装到切面类中，看哪里有需要，就往上套，被**套用**了切面逻辑的方法就被切面给增强了。

## 4、基于注解的AOP

### 4.1、技术说明

![24](img\24.png)

- 动态代理（InvocationHandler）：JDK原生的实现方式，需要被代理的目标类必须实现接口。因为这个技术要求**代理对象和目标对象实现同样的接口**（兄弟两个拜把子模式）。

- cglib：通过**继承被代理的目标类**（认干爹模式）实现代理，所以不需要目标类实现接口。

- AspectJ：本质上是静态代理，**将代理逻辑“织入”被代理的目标类编译得到的字节码文件**，所以最终效果是动态的。weaver 就是织入器。Spring 只是借用了 AspectJ 中的注解。

### 4.2、准备工作

#### ①添加依赖

在IOC所需依赖基础上再加入下面依赖即可：

```xml
<!-- spring-aspects会帮我们传递过来aspectjweaver -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>5.3.1</version>
</dependency>
```

#### ②准备被代理的目标资源

接口：

```java
public interface Calculator {
    int add(int i, int j);
    int sub(int i, int j);
    int mul(int i, int j);
    int div(int i, int j);
}
```

实现类：

```java
@Component
public class CalculatorPureImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
    
    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
    
    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
    
    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
}
```

### 4.3、创建切面类并配置

```java
// @Aspect表示这个类是一个切面类，将当前组件标识为切面
@Aspect
// @Component注解保证这个切面类能够放入IOC容器
@Component
public class LogAspect {
    //@Before("execution(public int com.atguigu.aop.annotation.CalculatorImpl.add(int,int))")
    @Before("execution(public int com.atguigu.aop.annotation.CalculatorImpl.*(..))")
	public void beforeMethod(JoinPoint joinPoint){
        //System.out.println("LoggerAspect,前置通知");
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->前置通知，方法名："+methodName+"，参数："+args);
	}
    
    @After("execution(* com.atguigu.aop.annotation.CalculatorImpl.*(..))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Logger-->后置通知，方法名："+methodName);
	}
    
    @AfterReturning(value = "execution(*com.atguigu.aop.annotation.CalculatorImpl.*(..))", returning = "result")
	public void afterReturningMethod(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Logger-->返回通知，方法名："+methodName+"，结果："+result);
	}
    
    @AfterThrowing(value = "execution(*com.atguigu.aop.annotation.CalculatorImpl.*(..))", throwing = "ex")
	public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Logger-->异常通知，方法名："+methodName+"，异常："+ex);
	}
    
    @Around("execution(* com.atguigu.aop.annotation.CalculatorImpl.*(..))")
	public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		Object result = null;
        try {
            System.out.println("环绕通知-->目标对象方法执行之前");
            //目标对象（连接点）方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知-->目标对象方法返回值之后");
		} catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->目标对象方法出现异常时");
		} finally {
			System.out.println("环绕通知-->目标对象方法执行完毕");
		}
		return result;
	}
}
```

在Spring的配置文件中配置：

```xml
<!--
    基于注解的AOP的实现：
    1、将目标对象和切面交给IOC容器管理（注解+扫描）
    2、开启AspectJ的自动代理，为目标对象自动生成代理
    3、将切面类通过注解@Aspect标识
-->
<context:component-scan base-package="com.atguigu.aop.annotation"></context:component-scan>

<!--开启基于注解的AOP-->
<aop:aspectj-autoproxy />
```

> AOP的注意事项：
>
> 1、切面类和目标类都需要交给IOC容器管理
>
> 2、切面类必须通过@Aspect注解标识为一个切面
>
> 3、在Spring配置文件中设置<aop:aspectj-autoproxy />开启基于注解的AOP

### 4.4、各种通知

- 前置通知：使用@Before注解标识，在被代理的目标方法**前**执行
- 返回通知：使用@AfterReturning注解标识，在被代理的目标方法**成功结束**后执行（**寿终正寝**），即在返回值之后执行
- 异常通知：使用@AfterThrowing注解标识，在被代理的目标方法**异常结束**后执行（**死于非命**），即在目标对象方法的catch字句中执行
- 后置通知：使用@After注解标识，在被代理的目标方法**最终结束**后执行（**盖棺定论**），即在目标对象方法的finally字句中执行
- 环绕通知：使用@Around注解标识，使用try...catch...finally结构围绕**整个**被代理的目标方法，包括上面四种通知对应的所有位置

> 各种通知的执行顺序：
>
> - Spring版本5.3.x以前：
>   - 前置通知
>   - 目标操作
>   - 后置通知
>   - 返回通知或异常通知
> - Spring版本5.3.x以后：
>   - 前置通知
>   - 目标操作
>   - 返回通知或异常通知
>   - 后置通知

### 4.5、切入点表达式语法

#### ①作用

![25](img\25.png)

#### ②语法细节

- 用*号代替“权限修饰符”和“返回值”部分表示“权限修饰符”和“返回值”不限
- 在包名的部分，一个 \* 号只能代表包的层次结构中的一层，表示这一层是任意的。
  - 例如：\*.Hello匹配com.Hello，不匹配com.atguigu.Hello
- 在包名的部分，使用 \*.. 表示包名任意、包的层次深度任意
- 在类名的部分，类名部分整体用 \* 号代替，表示类名任意
- 在类名的部分，可以使用 \* 号代替类名的一部分
  - 例如：\*Service匹配所有名称以Service结尾的类或接口
- 在方法名部分，可以使用 \* 号表示方法名任意
- 在方法名部分，可以使用 \* 号代替方法名的一部分
  - 例如：\*Operation匹配所有方法名以Operation结尾的方法
- 在方法参数列表部分，使用 (..) 表示参数列表任意
- 在方法参数列表部分，使用 (int,..) 表示参数列表以一个int类型的参数开头
- 在方法参数列表部分，基本数据类型和对应的包装类型是不一样的
  - 切入点表达式中使用 int 和实际方法中 Integer 是不匹配的
- 在方法返回值部分，如果想要明确指定一个返回值类型，那么必须同时写明权限修饰符
  - 例如：execution(public int *..*Service.\*(.., int)) 正确
  - 例如：execution(\* int *..*Service.*(.., int)) 错误

![26](img\26.png)

> 切入点表达式：设置在标识通知的注解的value属性中，语法：
>
> execution(public int com.atguigu.aop.annotation.CalculatorImpl.add(int,int)
>
> execution(* com.atguigu.aop.annotation.CalculatorImpl.*(..)
>
> 第一个*表示任意的访问修饰符和返回值类型
>
> 第二个*表示类中任意的方法
>
> ..表示任意的参数列表
>
> 类的地方也可以使用*，表示包下所有的类

### 4.6、重用切入点表达式

#### ①声明

@Pointcut声明一个公共的切入点表达式

```java
@Pointcut("execution(* com.atguigu.aop.annotation.*.*(..))")
public void pointCut(){}
```

#### ②在同一个切面中使用

```java
@Before("pointCut()")
public void beforeMethod(JoinPoint joinPoint){
    String methodName = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    System.out.println("Logger-->前置通知，方法名："+methodName+"，参数："+args);
}
```

#### ③在不同切面中使用

```java
@Before("com.atguigu.aop.CommonPointCut.pointCut()")
public void beforeMethod(JoinPoint joinPoint){
    String methodName = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    System.out.println("Logger-->前置通知，方法名："+methodName+"，参数："+args);
}
```

### 4.7、获取通知的相关信息

#### ①获取连接点信息

在通知方法的参数位置，设置JoinPoint类型的参数，就可以获取连接点所对应方法的信息

```java
//@Before("execution(public int com.atguigu.aop.annotation.CalculatorImpl.*(..))")
@Before("pointCut()")
public void beforeMethod(JoinPoint joinPoint){
	//获取连接点所对应方法的签名信息
    Signature signature = joinPoint.getSignature();
    //String methodName = joinPoint.getSignature().getName();
    //获取连接点所对应方法的参数
    String args = Arrays.toString(joinPoint.getArgs());
    System.out.println("Logger-->前置通知，方法名："+signature.getName()+"，参数："+args);
    //System.out.println("Logger-->前置通知，方法名："+methodName+"，参数："+args);
}
```

#### ②获取目标方法的返回值

在返回通知中若要获取目标对象方法的返回值，只需要通过@AfterReturning注解的returning属性，就可以将通知方法的某个参数指定为接收目标对象的返回值的参数。

即 @AfterReturning中的属性returning，用来将通知方法的某个形参，接收目标方法的返回值

```java
//@AfterReturning(value = "execution(* com.atguigu.aop.annotation.CalculatorImpl.*(..))", returning = "result")
@AfterReturning(value = "pointCut()",returning = "result")
public void afterReturningMethod(JoinPoint joinPoint, Object result){
    //System.out.println("LoggerAspect，返回通知");
    String methodName = joinPoint.getSignature().getName();
    System.out.println("Logger-->返回通知，方法名："+methodName+"，结果："+result);
}
```

#### ③获取目标方法的异常

在异常通知中若要获取目标对象方法的异常，只需要通过@AfterThrowing注解的throwing属性，就可以将通知方法的某个参数指定为接收目标对象出现的异常的参数。

即 @AfterThrowing中的属性throwing，用来将通知方法的某个形参，接收目标方法的异常

```java
//@AfterThrowing(value = "execution(* com.atguigu.aop.annotation.CalculatorImpl.*(..))", throwing = "ex")
@AfterThrowing(value = "pointCut()",throwing = "ex")
public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex){
    String methodName = joinPoint.getSignature().getName();
    System.out.println("Logger-->异常通知，方法名："+methodName+"，异常："+ex);
}
```

### 4.8、环绕通知

```java
//@Around("execution(* com.atguigu.aop.annotation.CalculatorImpl.*(..))")
@Around("pointCut()")
//环绕通知的方法的返回值一定要和目标对象方法的返回值一致
public Object aroundMethod(ProceedingJoinPoint joinPoint){
    String methodName = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    Object result = null;
    try {
        System.out.println("环绕通知-->前置通知：目标对象方法执行之前");
        //目标方法的执行，目标方法的返回值一定要返回给外界调用者
        result = joinPoint.proceed();
        System.out.println("环绕通知-->返回通知：目标对象方法返回值之后");
    } catch (Throwable throwable) {
        throwable.printStackTrace();
        System.out.println("环绕通知-->异常通知：目标对象方法出现异常时");
    } finally {
        System.out.println("环绕通知-->后置t目标对象方法执行完毕");
    }
    return result;
}
```

### 4.9、切面的优先级

相同目标方法上同时存在多个切面时，切面的优先级控制切面的**内外嵌套**顺序。

- 优先级高的切面：外面
- 优先级低的切面：里面

可以通过@Order注解的value属性设置优先级，默认值为Integer的最大值
* @Order注解的value属性值越小，优先级越高

![27](img\27.png)

```java
@Component
@Aspect
@Order(1)
public class validateAspect {
    //@Before("execution(* com.atguigu.aop.annotation.CalculatorImpl.*(..))")
    @Before("com.atguigu.aop.annotation.LoggerAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect-->前置通知");
    }
}
```

## 5、基于XML的AOP（了解）

### 5.1、准备工作

参考基于注解的 AOP 环境

### 5.2、实现

```xml
<context:component-scan base-package="com.atguigu.aop.xml"></context:componentscan>
<aop:config>
    <!--配置切面类-->
    <aop:aspect ref="loggerAspect">
        <aop:pointcut id="pointCut" expression="execution(*com.atguigu.aop.xml.CalculatorImpl.*(..))"/>
        <aop:before method="beforeMethod" pointcut-ref="pointCut"></aop:before>
        <aop:after method="afterMethod" pointcut-ref="pointCut"></aop:after>
        <aop:after-returning method="afterReturningMethod" returning="result"pointcut-ref="pointCut"></aop:after-returning>
        <aop:after-throwing method="afterThrowingMethod" throwing="ex" pointcut-ref="pointCut"></aop:after-throwing>
        <aop:around method="aroundMethod" pointcut-ref="pointCut"></aop:around>
    </aop:aspect>
    <aop:aspect ref="validateAspect" order="1">
        <aop:before method="validateBeforeMethod" pointcut-ref="pointCut">
        </aop:before>
    </aop:aspect>
</aop:config>
```

# 四、声明式事务

## 1、JdbcTemplate

### 1.1、简介

Spring 框架对 JDBC 进行封装，使用 JdbcTemplate 方便实现对数据库操作

### 1.2、准备工作

#### ①加入依赖

```xml
<dependencies>
    <!-- 基于Maven依赖传递性，导入spring-context依赖即可导入当前所需所有jar包 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.20</version>
    </dependency>
    <!-- Spring 持久化层支持jar包 -->
    <!-- Spring 在执行持久化层操作、与持久化层技术进行整合过程中，需要使用orm、jdbc、tx三个jar包 -->
    <!-- 导入 orm 包就可以通过 Maven 的依赖传递性把其他两个也导入 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-orm</artifactId>
        <version>5.3.18</version>
    </dependency>
    <!-- Spring 测试相关 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>5.3.18</version>
    </dependency>
    <!-- junit测试 -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
    <!-- MySQL驱动 -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.31</version>
    </dependency>
    <!-- 数据源 -->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.2.15</version>
    </dependency>
</dependencies>
```

#### ②创建jdbc.properties

```properties
jdbc.user=root
jdbc.password=atguigu
jdbc.url=jdbc:mysql://localhost:3306/ssm
jdbc.driver=com.mysql.cj.jdbc.Driver
```

#### ③配置Spring的配置文件

```xml
<!-- 导入外部属性文件 -->
<context:property-placeholder location="classpath:jdbc.properties" />

<!-- 配置数据源 -->
<bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
    <property name="url" value="${jdbc.url}"/>
    <property name="driverClassName" value="${jdbc.driver}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
</bean>

<!-- 配置 JdbcTemplate -->
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
    <!-- 装配数据源 -->
    <property name="dataSource" ref="druidDataSource"/>
</bean>
```

### 1.3、测试

#### ①在测试类装配 JdbcTemplate

```java
//指定当前测试类在Spring的测试环境中执行，此时就可以通过注入的方式直接获取IOC容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JDBCTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
}
```

#### ②测试增删改功能

```java
@Test
//测试增删改功能
public void testUpdate(){
	String sql="insert into t_user values(null,?,?,?,?,?)";
    int result = jdbcTemplate.update(sql,"root","123",23,"女","123@qq.com");
    System.out.println(result);
}
```

#### ③查询一条数据为实体类对象

```java
@Test
//查询一条数据为一个实体类对象
public void testSelectEmpById(){
    String sql = "select * from t_emp where id = ?";
    Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
    System.out.println(emp);
}
```

#### ④查询多条数据为一个list集合

```java
@Test
//查询多条数据为一个list集合
public void testSelectList(){
    String sql = "select * from t_emp";
    List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
    list.forEach(emp -> System.out.println(emp));
}
```

#### ⑤查询单行单列的值

```java
@Test
//查询单行单列的值
public void selectCount(){
    String sql = "select count(id) from t_emp";
    Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
    System.out.println(count);
}
```

## 2、声明式事务概念

### 2.1、编程式事务

事务功能的相关操作全部通过自己编写代码来实现：

```java
Connection conn = ...;
try {
    // 开启事务：关闭事务的自动提交
    conn.setAutoCommit(false);
    // 核心操作
    // 提交事务
    conn.commit();
}catch(Exception e){
    // 回滚事务
    conn.rollBack();
}finally{
    // 释放数据库连接
    conn.close();
}
```

编程式的实现方式存在缺陷：

- 细节没有被屏蔽：具体操作过程中，所有细节都需要程序员自己来完成，比较繁琐。
- 代码复用性不高：如果没有有效抽取出来，每次实现功能都需要自己编写代码，代码就没有得到复用。

### 2.2、声明式事务

既然事务控制的代码有规律可循，代码的结构基本是确定的，所以框架就可以将固定模式的代码抽取出来，进行相关的封装。

封装起来后，我们只需要在配置文件中进行简单的配置即可完成操作。

- 好处1：提高开发效率
- 好处2：消除了冗余的代码
- 好处3：框架会综合考虑相关领域中在实际开发环境下有可能遇到的各种问题，进行了健壮性、性能等各个方面的优化

所以，我们可以总结下面两个概念：

- **编程式**：**自己写代码**实现功能
- **声明式**：通过**配置**让**框架**实现功能

## 3、基于注解的声明式事务

### 3.1、准备工作

#### ①加入依赖

```xml
<dependencies>
    <!-- 基于Maven依赖传递性，导入spring-context依赖即可导入当前所需所有jar包 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.20</version>
    </dependency>
    
    <!-- Spring 持久化层支持jar包 -->
    <!-- Spring 在执行持久化层操作、与持久化层技术进行整合过程中，需要使用orm、jdbc、tx三个jar包 -->
    <!-- 导入 orm 包就可以通过 Maven 的依赖传递性把其他两个也导入 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-orm</artifactId>
        <version>5.3.18</version>
    </dependency>
    
    <!-- Spring 测试相关 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>5.3.18</version>
    </dependency>
    
    <!-- junit测试 -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
    
    <!-- MySQL驱动 -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.31</version>
    </dependency>
    
    <!-- 数据源 -->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.2.15</version>
    </dependency>
</dependencies>
```

#### ②创建jdbc.properties

```properties
jdbc.user=root
jdbc.password=atguigu
jdbc.url=jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC
jdbc.driver=com.mysql.cj.jdbc.Driver
```

#### ③配置Spring的配置文件

```xml
<!--扫描组件-->
<context:component-scan base-package="com.atguigu.spring.tx.annotation">
</context:component-scan>

<!-- 导入外部属性文件 -->
<context:property-placeholder location="classpath:jdbc.properties" />

<!-- 配置数据源 -->
<bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
    <property name="url" value="${jdbc.url}"/>
    <property name="driverClassName" value="${jdbc.driver}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
</bean>

<!-- 配置 JdbcTemplate -->
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
    <!-- 装配数据源 -->
    <property name="dataSource" ref="druidDataSource"/>
</bean>
```

#### ④创建表

```mysql
CREATE TABLE `t_book` (
    `book_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `book_name` varchar(20) DEFAULT NULL COMMENT '图书名称',
    `price` int(11) DEFAULT NULL COMMENT '价格',
    `stock` int(10) unsigned DEFAULT NULL COMMENT '库存（无符号）',
    PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
insert into `t_book`(`book_id`,`book_name`,`price`,`stock`) values (1,'斗破苍穹',80,100),(2,'斗罗大陆',50,100);
CREATE TABLE `t_user` (
    `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username` varchar(20) DEFAULT NULL COMMENT '用户名',
    `balance` int(10) unsigned DEFAULT NULL COMMENT '余额（无符号）',
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
insert into `t_user`(`user_id`,`username`,`balance`) values (1,'admin',50);
```

#### ⑤创建组件

创建BookController：

```java
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    
    public void buyBook(Integer bookId, Integer userId){
        bookService.buyBook(bookId, userId);
    }
}
```

创建接口BookService：

```java
public interface BookService {
	void buyBook(Integer bookId, Integer userId);
}
```

创建实现类BookServiceImpl：

```java
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(userId, price);
    }
}
```

创建接口BookDao：

```java
public interface BookDao {
    Integer getPriceByBookId(Integer bookId);
    void updateStock(Integer bookId);
    void updateBalance(Integer userId, Integer price);
}
```

创建实现类BookDaoImpl：

```java
@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Integer getPriceByBookId(Integer bookId) {
        String sql = "select price from t_book where book_id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, bookId);
    }
    @Override
    public void updateStock(Integer bookId) {
        String sql = "update t_book set stock = stock - 1 where book_id = ?";
        jdbcTemplate.update(sql, bookId);
    }
    
    @Override
    public void updateBalance(Integer userId, Integer price) {
        String sql = "update t_user set balance = balance - ? where user_id =?";
        jdbcTemplate.update(sql, price, userId);
    }
}
```

### 3.2、测试无事务情况

#### ①创建测试类

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxByAnnotationTest {
    @Autowired
    private BookController bookController;
    
    @Test
    public void testBuyBook(){
        bookController.buyBook(1, 1);
    }
}
```

#### ②模拟场景

用户购买图书，先查询图书的价格，再更新图书的库存和用户的余额

假设用户 id 为 1 的用户，购买 id 为 1 的图书

用户余额为 50，而图书价格为 80

购买图书之后，用户的余额为 -30，数据库中余额字段设置了无符号，因此无法将 -30 插入到余额字段

此时执行sql语句会抛出SQLException

#### ③观察结果

因为没有添加事务，图书的库存更新了，但是用户的余额没有更新

显然这样的结果是错误的，购买图书是一个完整的功能，更新库存和更新余额要么都成功要么都失败

### 3.3、加入事务

#### ①添加事务配置

在 Spring 的配置文件中添加配置：

```xml
<!-- 配置事务管理器 -->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"></property>
</bean>

<!--
    开启事务的注解驱动
    通过注解@Transactional所标识的方法或标识的类中所有的方法，都会被事务管理器管理事务
    transaction-manager属性设置事务管理器的id
	transaction-manager属性的默认值是transactionManager，如果事务管理器bean的id正好就是这个默认值，则可以省略这个属性
-->
<tx:annotation-driven transaction-manager="transactionManager" />
```

注意：导入的名称空间需要 **tx** **结尾**的那个。

![28](img\28.png)

#### ②添加事务注解

因为 service 层表示业务逻辑层，一个方法表示一个完成的功能，因此处理事务一般在 service 层处理

在 BookServiceImpl 的 buybook() 添加注解@Transactional

#### ③观察结果

由于使用了 Spring 的声明式事务，更新库存和更新余额都没有执行

> 声明式事务的配置步骤：
>
> 1、在Spring的配置文件中配置事务管理器
>
> 2、开启事务的注解驱动
>
> 在需要被事务管理的方法上，添加@Transactional注解，该方法就会被事务管理

### 3.4、@Transactional注解标识的位置

@Transactional 标识在方法上，只会影响该方法

@Transactional 标识的类上，会影响类中所有的方法

### 3.5、事务属性：只读

#### ①介绍

对一个查询操作来说，如果我们把它设置成只读，就能够明确告诉数据库，这个操作不涉及写操作。这样数据库就能够针对查询操作来进行优化。

#### ②使用方式

```java
@Transactional(readOnly = true)
public void buyBook(Integer bookId, Integer userId) {
    //查询图书的价格
    Integer price = bookDao.getPriceByBookId(bookId);
    //更新图书的库存
    bookDao.updateStock(bookId);
    //更新用户的余额
    bookDao.updateBalance(userId, price);
    //System.out.println(1/0);
}
```

#### ③注意

对增删改操作设置只读会抛出下面异常：

Caused by: java.sql.SQLException: Connection is read-only. Queries leading to data modification

are not allowed

### 3.6、事务属性：超时

#### ①介绍

事务在执行过程中，有可能因为遇到某些问题，导致程序卡住，从而长时间占用数据库资源。而长时间占用资源，大概率是因为程序运行出现了问题（可能是Java程序或MySQL数据库或网络连接等等）。

此时这个很可能出问题的程序应该被回滚，撤销它已做的操作，事务结束，把资源让出来，让其他正常程序可以执行。

概括来说就是一句话：**超时回滚，释放资源**。

#### ②使用方式

```java
@Transactional(timeout = 3)
public void buyBook(Integer bookId, Integer userId) {
    try {
        TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    //查询图书的价格
    Integer price = bookDao.getPriceByBookId(bookId);
    //更新图书的库存
    bookDao.updateStock(bookId);
    //更新用户的余额
    bookDao.updateBalance(userId, price);
    //System.out.println(1/0);
}
```

#### ③观察结果

执行过程中抛出异常：

org.springframework.transaction.**TransactionTimedOutException**: Transaction timed out:

deadline was Fri Jun 04 16:25:39 CST 2022

### 3.7、事务属性：回滚策略

#### ①介绍

声明式事务默认只针对运行时异常回滚，编译时异常不回滚。

可以通过 @Transactional 中相关属性设置回滚策略

- rollbackFor 属性：需要设置一个 Class 类型的对象
- rollbackForClassName 属性：需要设置一个字符串类型的全类名
- noRollbackFor 属性：需要设置一个 Class 类型的对象
- rollbackFor 属性：需要设置一个字符串类型的全类名

#### ②使用方式

```java
@Transactional(noRollbackFor = ArithmeticException.class)
//@Transactional(noRollbackForClassName = "java.lang.ArithmeticException")
public void buyBook(Integer bookId, Integer userId) {
    //查询图书的价格
    Integer price = bookDao.getPriceByBookId(bookId);
    //更新图书的库存
    bookDao.updateStock(bookId);
    //更新用户的余额
    bookDao.updateBalance(userId, price);
    System.out.println(1/0);
}
```

#### ③观察结果

虽然购买图书功能中出现了数学运算异常（ArithmeticException），但是我们设置的回滚策略是，当出现ArithmeticException不发生回滚，因此购买图书的操作正常执行

### 3.8、事务属性：事务隔离级别

#### ①介绍

数据库系统必须具有隔离并发运行各个事务的能力，使它们不会相互影响，避免各种并发问题。一个事务与其他事务隔离的程度称为隔离级别。SQL标准中规定了多种事务隔离级别，不同隔离级别对应不同的干扰程度，隔离级别越高，数据一致性就越好，但并发性越弱。

隔离级别一共有四种：

- 读未提交：READ UNCOMMITTED

允许Transaction01读取Transaction02未提交的修改。

- 读已提交：READ COMMITTED、

要求Transaction01只能读取Transaction02已提交的修改。

- 可重复读：REPEATABLE READ

确保Transaction01可以多次从一个字段中读取到相同的值，即Transaction01执行期间禁止其它事务对这个字段进行更新。

- 串行化：SERIALIZABLE

确保Transaction01可以多次从一个表中读取到相同的行，在Transaction01执行期间，禁止其它事务对这个表进行添加、更新、删除操作。可以避免任何并发问题，但性能十分低下。

各个隔离级别解决并发问题的能力见下表：

| **隔离级别**     | **脏读** | **不可重复读** | **幻读** |
| ---------------- | -------- | -------------- | -------- |
| READ UNCOMMITTED | 有       | 有             | 有       |
| READ COMMITTED   | 无       | 有             | 有       |
| REPEATABLE READ  | 无       | 无             | 有       |
| SERIALIZABLE     | 无       | 无             | 无       |

各种数据库产品对事务隔离级别的支持程度：

| **隔离级别**     | **Oracle** | **MySQL** |
| ---------------- | ---------- | --------- |
| READ UNCOMMITTED | ×          | √         |
| READ COMMITTED   | √(默认)    | √         |
| REPEATABLE READ  | ×          | √(默认)   |
| SERIALIZABLE     | √          | √         |

MySQL虽然默认事务隔离级别是REPEATABLE READ，但不会出现幻读问题

#### ②使用方式

```java
@Transactional(isolation = Isolation.DEFAULT)//使用数据库默认的隔离级别
@Transactional(isolation = Isolation.READ_UNCOMMITTED)//读未提交
@Transactional(isolation = Isolation.READ_COMMITTED)//读已提交
@Transactional(isolation = Isolation.REPEATABLE_READ)//可重复读
@Transactional(isolation = Isolation.SERIALIZABLE)//串行化
```

### 3.9、事务属性：事务传播行为

#### ①介绍

当事务方法被另一个事务方法调用时，必须指定事务应该如何传播。例如：方法可能继续在现有事务中运行，也可能开启一个新事务，并在自己的事务中运行。

#### ②测试

创建接口 CheckoutService：

```java
public interface CheckoutService {
	void checkout(Integer[] bookIds, Integer userId);
}
```

创建实现类 CheckoutServiceImpl：

```java
@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private BookService bookService;
    
    @Override
    @Transactional
    //一次购买多本图书
    public void checkout(Integer[] bookIds, Integer userId) {
        for (Integer bookId : bookIds) {
            bookService.buyBook(bookId, userId);
        }
    }
}
```

在 BookController 中添加方法：

```java
@Autowired
private CheckoutService checkoutService;

public void checkout(Integer[] bookIds, Integer userId){
    checkoutService.checkout(bookIds, userId);
}
```

在数据库中将用户的余额修改为100元

#### ③观察结果

可以通过 @Transactional 中的 propagation 属性设置事务传播行为

修改 BookServiceImpl 中 buyBook() 上，注解 @Transactional 的 propagation 属性

* @Transactional(propagation = Propagation.REQUIRED)，默认情况，表示如果当前线程上有已经开启的事务可用，那么就在这个事务中运行。经过观察，购买图书的方法 buyBook() 在 checkout() 中被调用，checkout() 上有事务注解，因此在此事务中执行。所购买的两本图书的价格为 80  和 50，而用户的余额为 100，因此在购买第二本图书时余额不足失败，导致整个checkout()回滚，即只要有一本书买不了，就都买不了

* @Transactional(propagation = Propagation.REQUIRES_NEW)，表示不管当前线程上是否有已经开启的事务，都要开启新事务。同样的场景，每次购买图书都是在 buyBook() 的事务中执行，因此第一本图书购买成功，事务结束，第二本图书购买失败，只在第二次的 buyBook() 中回滚，购买第一本图书不受影响，能买几本就买几本

## 4、基于XML的声明式事务

### 4.1、场景模拟

参考基于注解的声明式事务

### 4.2、修改Spring配置文件

将 Spring 配置文件中去掉 tx:annotation-driven 标签，并添加配置：

```xml
<aop:config>
    <!-- 配置事务通知和切入点表达式 -->
    <aop:advisor advice-ref="txAdvice" pointcut="execution(*com.atguigu.spring.tx.xml.service.impl.*.*(..))"></aop:advisor>
</aop:config>

<!-- tx:advice标签：配置事务通知 -->
<!-- id属性：给事务通知标签设置唯一标识，便于引用 -->
<!-- transaction-manager属性：关联事务管理器 -->
<tx:advice id="txAdvice" transaction-manager="transactionManager">
    <tx:attributes>
        <!-- tx:method标签：配置具体的事务方法 -->
        <!-- name属性：指定方法名，可以使用星号代表多个字符 -->
        <tx:method name="get*" read-only="true"/>
        <tx:method name="query*" read-only="true"/>
        <tx:method name="find*" read-only="true"/>
        <!-- read-only属性：设置只读属性 -->
        <!-- rollback-for属性：设置回滚的异常 -->
        <!-- no-rollback-for属性：设置不回滚的异常 -->
        <!-- isolation属性：设置事务的隔离级别 -->
        <!-- timeout属性：设置事务的超时属性 -->
        <!-- propagation属性：设置事务的传播行为 -->
        <tx:method name="save*" read-only="false" rollback-for="java.lang.Exception" propagation="REQUIRES_NEW"/>
        <tx:method name="update*" read-only="false" rollback-for="java.lang.Exception" propagation="REQUIRES_NEW"/>
        <tx:method name="delete*" read-only="false" rollback-for="java.lang.Exception" propagation="REQUIRES_NEW"/>
    </tx:attributes>
</tx:advice>
```

> 注意：基于xml实现的声明式事务，必须引入aspectJ的依赖
>
> ```xml
> <dependency>
>     <groupId>org.springframework</groupId>
>     <artifactId>spring-aspects</artifactId>
>     <version>5.3.24</version>
> </dependency>
> ```
