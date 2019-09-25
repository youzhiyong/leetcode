spring相关知识点
一、spring bean的生命周期
Bean的完整生命周期从 spring 容器开始实例化 bean 开始，到销毁。可以从三点来理解
1、 bean自身的方法：包括构造方法、 set 方法、 init-method 指定的方法、 destroy-method 指定的方法
2、 Bean级生命周期接口方法：如 BeanNameAware 、 BeanFactoryAware、InitializingBean 等这些接口方法由 bean类实现。
3、 容器级生命周期接口方法：有InstantiationAwareBeanPostProcessor 、 BeanPostProcessor 等。一般称为后处理 器。他们一般不由bean 本身实现，独立存在，注册到 spring 容器中。 Spring 通过接口反射预先知道，当 spring 容器创建任何 bean 时，这些后处理器都会发生作用。所以他们是全局的，用户可以通过编码对只感兴趣的 bean 进行处理。

Bean级生命周期接口和容器级生命周期接口是个性和共性辩证统一的思想，前者解决 bean 的个性化处理问题，而后者解决容器中某些 bean 共性化处理问题。

二、BeanFactory和FactoryBean的区别
BeanFactory是个Factory，也就是IOC容器或对象工厂.它的职责包括：实例化、定位、配置应用程序中的对象及建立这些对象间的依赖
    主要方法：
　　boolean containsBean(String beanName) 判断工厂中是否包含给定名称的bean定义，若有则返回true
　　Object getBean(String) 返回给定名称注册的bean实例。根据bean的配置情况，如果是singleton模式将返回一个共享实例，否则将返回一个新建的实例，如果没有找到指定bean,该方法可能会抛出异常
　　Object getBean(String, Class) 返回以给定名称注册的bean实例，并转换为给定class类型
　　Class getType(String name) 返回给定名称的bean的Class,如果没有找到指定的bean实例，则排除NoSuchBeanDefinitionException异常
　　boolean isSingleton(String) 判断给定名称的bean定义是否为单例模式
　　String[] getAliases(String name) 返回给定bean名称的所有别名 
FactoryBean是个Bean。在Spring中，所有的Bean都是由BeanFactory(也就是IOC容器)来进行管理的，但对FactoryBean而言，这个Bean不是简单的Bean，而是一个能生产或者修饰对象生成的工厂Bean,它的实现与设计模式中的工厂模式和修饰器模式类似
    主要方法：
    TgetObject()：返回由FactoryBean创建的Bean实例，如果isSingleton()返回true，则该实例会放到Spring容器中单实例缓存池中；
    booleanisSingleton()：返回由FactoryBean创建的Bean实例的作用域是singleton还是prototype；
    Class<T>getObjectType()：返回FactoryBean创建的Bean类型。
FactoryBean仍然是一个bean，但不同于普通bean，它的实现类最终也需要注册到BeanFactory中。
FactoryBean也是一种简单工厂模式的接口类，但是生产的是单一类型的对象，与BeanFactory生产多种类型对象不同。

个人理解：FactoryBean相当于是对原有Bean进行增强改造，相当于一个特定的代理类(表述为代理类不是很准确)

案例：比如在一个原有的bean中的每个方法前后打印日志，就可以通过FactoryBean来实现

实际案例：
Mybatis中的SqlSessionFactoryBean  就是一个典型的FactoryBean，他对SqlSessionFactory的创建做了很多前置工作，相当于改造并增强了SqlSessionFactory。
这里需要注意的是SqlSessionFactory并不是spring中的BeanFactory，他只是mybatis中定义的一个普通工厂bean,用于生产SqlSession对象