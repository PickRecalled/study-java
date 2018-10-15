package com.pickrecalled.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Study01 {

	@Test
	public void testReflectionPerson() throws Exception {
		// 创建运行时类的对象
		Class<Person> clazz = Person.class;
		// 创建class对应的运行时类Person类的对象
		Person person = clazz.newInstance();
		// 获取Person对象里的结构
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			System.out.println("获取Person对象里的属性：" + field);
		}
		// 给public修饰的属性赋值
		Field name = clazz.getField("name");
		name.set(person, "张三");
		System.out.println("当前对象：" + person);

		// 给默认修饰的属性赋值
		Field age = clazz.getDeclaredField("age");
		age.set(person, 34);
		System.out.println("当前对象：" + person);

		// 给protected修饰的属性赋值
		Field email = clazz.getDeclaredField("email");
		email.set(person, "zhangsan@hotmail.com");
		System.out.println("当前对象：" + person);

		// 给private修饰的属性赋值
		Field nickName = clazz.getDeclaredField("nickName");
		nickName.setAccessible(true);
		nickName.set(person, "老张");
		System.out.println("当前对象：" + person);

		// 获取Person对象里的方法
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			System.out.println("获取Person对象里的方法：" + method);
		}

		// 通过Reflection（反射）调用运行时类的指定无参的方法
		Method helloPerson = clazz.getMethod("helloPerson");
		helloPerson.invoke(person);

		// 有参的方法
		Method helloPerson1 = clazz.getMethod("helloPerson", String.class);
		helloPerson1.invoke(person, "老五");

	}

	@Test
	public void testNewPerson() {
		Person person = new Person();
		person.setName("Tom");
		person.setAge(20);
		person.setEmail("tom@gmail.com");
		System.out.println("new 一个对象" + person);
	}

}
