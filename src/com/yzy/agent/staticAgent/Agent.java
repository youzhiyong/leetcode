package com.yzy.agent.staticAgent;

import com.yzy.agent.Apple;
import com.yzy.agent.Fruit;

/**
 * Description:
 * 静态代理，代理类需要实现被代理类的接口， 即被代理类必须要有接口
 * 静态代理只能代理单一的类，不具有通用性
 * Date: 2019-08-28
 *
 * @author youzhiyong
 */
public class Agent implements Fruit {

    private Apple targe;

    public Agent(Apple targe) {
        this.targe = targe;
    }

    @Override
    public void show() {
        System.out.println("static agent: before show method");
        targe.show();
        System.out.println("static agent: after show method");
    }

}
