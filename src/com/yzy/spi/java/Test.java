package com.yzy.spi.java;

import java.util.ServiceLoader;

public class Test {

    public static void main(String[] args) {
        ServiceLoader<JavaSPI> serviceLoader = ServiceLoader.load(JavaSPI.class);
        System.out.println("Java SPI");

        serviceLoader.forEach(JavaSPI::sayHello);
    }

}
