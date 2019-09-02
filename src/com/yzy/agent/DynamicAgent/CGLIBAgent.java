package com.yzy.agent.DynamicAgent;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description:
 * Date: 2019-08-28
 *
 * 需要 cglib2.2.2.jar 和 asm-3.3.1.jar 两个包
 *
 * @author youzhiyong
 */
public class CGLIBAgent implements MethodInterceptor {

    private Object targe;

    public Object getAgent(Object targe) {
        this.targe = targe;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.targe.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB agent: before show method");
        Object res = methodProxy.invokeSuper(o, objects);
        System.out.println("CGLIB agent: after show method");
        return res;
    }
}
