package com.pickrecalled.study_generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在集合中使用泛型
 */
public class TestCollectionGeneric {

	@Test
	public void test01() {
		List<Integer> list = new ArrayList<>();
		list.add(234);
		list.add(876);
		System.out.println(list);
	}

	@Test
	public void test02() {
		Integer[] array = { 123, 456, 789, 345 };
		// List<Integer> data = new TestCollectionGeneric().copyFromArrayToList(array);
		List<Integer> data = TestCollectionGeneric.copyFromArrayToList(array);
		System.out.println(data);
	}

	public static <E> List<E> copyFromArrayToList(E[] array) {
		return Arrays.asList(array);
	}
}
