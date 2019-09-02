package com.yzy.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 * Date: 2019-08-30
 *
 * @author youzhiyong
 */
public class TestMap {

    public static void main(String[] args) {

        //Map<Integer, String> map = new ConcurrentHashMap<>();
        Map<Integer, String> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        for (int i=0; i < 100; i++) {
            list.add(i);
        }

        System.out.println(list.size());

        list.parallelStream().forEach((item) -> {
            //System.out.println("key:" + item);
            map.put(item, item + "test");
        });

        System.out.println(map.keySet().size());

    }



}
