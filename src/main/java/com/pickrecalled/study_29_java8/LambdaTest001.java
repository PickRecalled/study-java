package com.pickrecalled.study_29_java8;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式的使用举例
 */
public class LambdaTest001 {
    @Test
    public void test02() {
        System.out.println("------------------ 非Lambda表达式写法 ------------------");
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //当 o1 - o2 = 0 ,返回 0
                //当 o1 - o2 > 0 ,返回 1
                //当 o1 - o2 < 0 ,返回 -1
                return Integer.compare(o1, o2);
            }
        };
        System.out.println("当 o1 - o2 = 0 ,返回 " + comparator.compare(20, 20));
        System.out.println("当 o1 - o2 > 0 ,返回 " + comparator.compare(30, 20));
        System.out.println("当 o1 - o2 < 0 ,返回 " + comparator.compare(10, 20));

        System.out.println("------------------ Lambda表达式写法 ------------------");
        Comparator<Integer> comparatorLambda = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println("当 o1 - o2 = 0 ,返回 " + comparatorLambda.compare(10, 10));
        System.out.println("当 o1 - o2 > 0 ,返回 " + comparatorLambda.compare(20, 10));
        System.out.println("当 o1 - o2 < 0 ,返回 " + comparatorLambda.compare(15, 10));

        System.out.println("------------------ 方法引用 ------------------");
        Comparator<Integer> comparatorLambda2 = Integer::compare;
        System.out.println("当 o1 - o2 = 0 ,返回 " + comparatorLambda2.compare(10, 10));
        System.out.println("当 o1 - o2 > 0 ,返回 " + comparatorLambda2.compare(20, 10));
        System.out.println("当 o1 - o2 < 0 ,返回 " + comparatorLambda2.compare(15, 10));
    }

    @Test
    public void test01() {
        System.out.println("------------------ 非Lambda表达式写法 ------------------");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("lambda test 01");
            }
        };
        runnable.run();

        System.out.println("------------------ Lambda表达式写法 ------------------");
        Runnable runnableLambda = () -> System.out.println("lambda test 01");
        runnableLambda.run();
    }
}
