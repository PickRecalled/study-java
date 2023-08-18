package com.pickrecalled.study_29_java8.method_references;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * 方法引用测试
 */
public class MethodReferencesTest {

    @Test
    public void test01() {

        System.out.println("------------------ Lambda表达式写法 ------------------");
        Consumer<String> consumerLambda = str -> System.out.println("str的内容:" + str);
        consumerLambda.accept("方法引用测试01");

        System.out.println("------------------ 方法引用写法 ------------------");
        Consumer<String> consumerMethodRef = System.out::println;
        consumerMethodRef.accept("方法引用测试02");
    }
}
