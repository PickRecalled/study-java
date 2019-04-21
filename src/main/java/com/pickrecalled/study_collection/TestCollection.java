package com.pickrecalled.study_collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCollection {

	@Test
	public void test01() {
		List list = Arrays.asList(new int[] { 123, 345 });
		System.out.println(list.size());// 1
		System.out.println(list);
	}
}
