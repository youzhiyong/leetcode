package com.yzy.classLoad;

/**
 * Description:
 * Date: 2019-09-25
 *
 * @author youzhiyong
 */
public class Extend extends Base {

    private static Log log = new Log("static field-1 ---Extend");

    static {

        System.out.println("static block-1 ---Extend");

    }

    private Log log2 = new Log(" field-1 ---Extend");

    {
        System.out.println("block-1 ---Extend");
    }

    private static Log log3 = new Log("static field-2 ---Extend");

    private Log log4 = new Log(" field-2 ---Extend");

    static {
        System.out.println("static block-2 ---Extend");
    }

    {
        System.out.println("block-2 ---Extend");
    }

    public Extend() {
        System.out.println("Construct ---Extend");
    }

}
