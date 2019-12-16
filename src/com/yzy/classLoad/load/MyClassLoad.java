package com.yzy.classLoad.load;

/**
 * Description:
 * Date: 2019-12-16
 *
 * @author youzhiyong
 */
public class MyClassLoad extends ClassLoader {


    public MyClassLoad() {
        super();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
