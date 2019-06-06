package com.yzy.java8.stream;

/**
 * Description:
 * Date: 2019-06-06

 函数接口	    抽象方法	        功能	                参数	    返回类型
 Predicate      test(T t)           判断真假                T           boolean
 Consumer       accept(T t)         消费消息                T           void
 Function       R apply(T t)        将T映射为R（转换功能）  T           R
 Supplier       T get()             生产消息                None        T
 UnaryOperator  T apply(T t)        一元操作                T           T
 BinaryOperator apply(T t, U u)     二元操作                (T，T)      (T)

 都是java.util.function包中的接口

 * @author youzhiyong
 */
public class StreamTest {
}
