package com.pickrecalled.study_collection;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TestIterator {

	@Test
	public void test02() {
		String[] str1 = new String[] { "MM", "MM", "MM" };

		// 普通for循环
		for (int i = 0; i < str1.length; i++) {
			str1[i] = "GG";
		}

		for (int i = 0; i < str1.length; i++) {
			System.out.println(str1[i]);
		}

		System.out.println("-----------------");

		// 增加for循环
		String[] str2 = new String[] { "MM", "MM", "MM" };
		for (String str : str2) {
			str = "GG";
		}
		for (int i = 0; i < str2.length; i++) {
			System.out.println(str2[i]);
		}

	}

	@Test
	public void test01() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add(new Date());
		coll.add("789");
		coll.add(40.00);

		Iterator iterator = coll.iterator();
		// while ((iterator.next()) != null) {
		// System.out.println(iterator.next());
		// }

		while (coll.iterator().hasNext()) {
			System.out.println(coll.iterator().next());
		}
	}
}
