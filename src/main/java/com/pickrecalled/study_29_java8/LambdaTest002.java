package com.pickrecalled.study_29_java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Lambda表达式使用
 * <p>
 * 1.举例：(o1,o2) -> Integer.compare(o1,o2)
 * 2.格式：
 *  “->”：Lambda操作符 或 箭头操作符
 *  “->左边”：Lambda形参列表（其实就是接口中抽象方法的形参列表）
 *  “->右边”：Lambda体（其实就是重写抽象方法的方法体）
 *
 * 3.Lambda表达式的使用，按语法格式分有6种情况:
 *  (1)无参，无返回值
 *  (2)Lambda 需要一个参数，但是没有返回值
 *  (3)数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
 *  (4)Lambda 若只需要一个参数时，参数的小括号可以省略
 *  (5)Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
 *  (6)当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
 *
 * 4.Lambda表达式的本质：就是作为接口的实例，通俗来说就是接口具体实现类的对象。同时对接口也是有要求的，
 * 那就是必需是涵数式接口。
 */
public class LambdaTest002 {

    @Test
    //语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
    public void test06() {
        System.out.println("------------------ Lambda表达式写法 ------------------");
        Comparator<Integer> comparatorLambda = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(comparatorLambda.compare(30, 15));

        System.out.println("------------------ Lambda表达式return与大括号若有，都可以省略写法 ------------------");
        Comparator<Integer> comparatorLambda2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(comparatorLambda2.compare(30, 15));
    }

    @Test
    //语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    public void test05() {
        System.out.println("------------------ 非Lambda表达式写法 ------------------");
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("o1:" + o1);
                System.out.println("o2:" + o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(10, 20));

        System.out.println("------------------ Lambda表达式写法 ------------------");
        Comparator<Integer> comparatorLambda = (o1, o2) -> {
            System.out.println("o1:" + o1);
            System.out.println("o2:" + o2);
            return o1.compareTo(o2);
        };
        System.out.println(comparatorLambda.compare(30, 15));
    }

    @Test
    //语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
    public void test04() {
        System.out.println("------------------ Lambda表达式类型推断写法 ------------------");
        Consumer<String> consumer01 = (s) -> System.out.println(s);
        consumer01.accept("编译器可以从Consumer接口中的泛型推断Lambda形参列表中参数的类型");

        System.out.println("------------------ Lambda表达式参数的小括号可以省略写法 ------------------");
        Consumer<String> consumer02 = s -> System.out.println(s);
        consumer02.accept("一个参数时，参数的小括号可以省略");
    }

    @Test
    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    public void test03() {
        System.out.println("------------------ Lambda表达式写法 ------------------");
        Consumer<String> consumerLambda = (String s) -> System.out.println(s);
        consumerLambda.accept("Consumer接口是什么？Consumer英文翻译消费者，也就是说consumer接口就是一个消费型的接口，通过传入参数，然后输出值");

        System.out.println("------------------ Lambda表达式类型推断写法 ------------------");
        Consumer<String> consumer01 = (s) -> System.out.println(s);
        consumer01.accept("编译器可以从Consumer接口中的泛型推断Lambda形参列表中参数的类型");

        //以前的类型推断
        List<String> list = new ArrayList<>();
        int[] intArr1 = new int[]{12, 13, 14};
        //上面的写法可以类型推断为下面的写法，不需要new
        int[] intArr2 = {12, 13, 14};
    }

    @Test
    //语法格式二：Lambda 需要一个参数，但是没有返回值
    public void test02() {
        System.out.println("------------------ 非Lambda表达式写法 ------------------");
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Consumer接口是什么？");

        System.out.println("------------------ Lambda表达式写法 ------------------");
        Consumer<String> consumerLambda = (String s) -> System.out.println(s);
        consumerLambda.accept("Consumer英文翻译消费者，也就是说consumer接口就是一个消费型的接口，通过传入参数，然后输出值");

        System.out.println("------------------ 方法引用写法 ------------------");
        Consumer<String> consumerReference = System.out::println;
        consumerReference.accept("将Lambda表达式替换为方法引用的写法");
    }


    @Test
    //语法格式一：无参，无返回值
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
