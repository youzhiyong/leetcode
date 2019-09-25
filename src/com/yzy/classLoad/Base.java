package com.yzy.classLoad;

/**
 * Description:
 * Date: 2019-09-25
 *
 * @author youzhiyong
 */
public class Base {

    private static Log log = new Log("static field-1 ---Base");

    static {

        System.out.println("static block-1 ---Base");

    }

    private Log log2 = new Log(" field-1 ---Base");

    {
        System.out.println("block-1 ---Base");
    }

    private static Log log3 = new Log("static field-2 ---Base");

    private Log log4 = new Log(" field-2 ---Base");

    static {
        System.out.println("static block-2 ---Base");
    }

    {
        System.out.println("block-2 ---Base");
    }

    public Base() {
        System.out.println("Construct ---Base");
    }

}
