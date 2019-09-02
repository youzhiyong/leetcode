package com.yzy.agent;

import com.yzy.agent.DynamicAgent.CGLIBAgent;
import com.yzy.agent.DynamicAgent.JDKAgent;
import com.yzy.agent.staticAgent.Agent;

/**
 * Description:
 * Date: 2019-08-28
 *
 * @author youzhiyong
 */
public class Test {

    public static void main(String[] args) {
        // 静态代理
        Fruit fruit = new Agent(new Apple());
        fruit.show();

        //动态代理 - JDK
        Fruit fruit1 = (Fruit) JDKAgent.getAgent(Fruit.class, new Apple());
        fruit1.show();

        //动态代理 - CGLIB
        Fruit fruit2 = (Fruit) new CGLIBAgent().getAgent(new Apple());
        fruit2.show();

    }

}
