package com.pickrecalled.study_29_java8;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java内置的函数式接口介绍及使用举例
 * 消费型接口 Consumer<T>      void accept(T t)
 * 供给型接口 Supplier<T>      T get()
 * 函数型接口 Function<T, R>   R apply(T t)
 * 断定型接口 Predicate<T>     boolean test(T t)
 */
public class LambdaTest003 {

    @Test
    //断定型接口使用举例,找出带京的城市
    public void test02() {
        System.out.println("------------------ 非Lambda表达式写法 ------------------");
        List<String> list = Arrays.asList("北京", "南京", "天津", "西京", "东京");
        Set<String> result01 = filterPredicate(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(result01);

        System.out.println("------------------ Lambda表达式写法 ------------------");
        Set<String> result02 = filterPredicate(list, s -> s.contains("津"));
        System.out.println(result02);
    }

    public Set<String> filterPredicate(List<String> list, Predicate<String> predicate) {
        Set<String> resultSet = new HashSet<>();
        for (String s : list) {
            if (predicate.test(s)) {
                resultSet.add(s);
            }
        }
        return resultSet;
    }

    @Test
    //消费型接口使用举例
    public void test01() {
        System.out.println("------------------ 非Lambda表达式写法 ------------------");
        happyTime(200.00, new Consumer<Double>() {
            @Override
            public void accept(Double m) {
                System.out.printf("和美女吃晚饭，总消费%s块钱\n", m);
            }
        });
        System.out.println("------------------ Lambda表达式写法1 ------------------");
        happyTime(50.00, (m) -> {
            System.out.printf("自己吃晚饭，总消费%s块钱\n", m);
        });

        System.out.println("------------------ Lambda表达式写法2 ------------------");
        happyTime(50.00, m -> System.out.printf("自己吃晚饭，总消费%s块钱\n", m));
    }

    public void happyTime(Double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }
}
