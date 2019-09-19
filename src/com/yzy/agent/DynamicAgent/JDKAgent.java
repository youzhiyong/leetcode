package com.yzy.agent.DynamicAgent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description:
 * 1. InvocationHandler
 * 2. Proxy.newProxyInstance
 * Date: 2019-08-28
 *
 * @author youzhiyong
 */
public class JDKAgent implements InvocationHandler {

    private Object targe;

    public JDKAgent(Object targe) {
        this.targe = targe;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK agent: before show method");
        Object res = method.invoke(this.targe, args);
        System.out.println("JDK agent: after show method");
        return res;
    }

    /**
     * 生成代理对象
     * @param interfaceClass 被代理类的接口
     * @param targe 被代理类实例
     * @return
     */
    public static Object getAgent(Class interfaceClass, Object targe) {
        return Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new JDKAgent(targe));
    }

}
