package com.yzy.others;


import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Description:
 * Date: 2019-03-29
 *
 * @author youzhiyong
 */
public class Test2 {
    private static <T> Predicate<T> notEqual(T t) {
        return (v) -> !Objects.equals(v, t);
    }
    public static void main(String[] args) {
        /*List.of(1, 2, 3)
                .stream()
                .filter(notEqual(1))
                .forEach(System.out::println);*/
    }
}
