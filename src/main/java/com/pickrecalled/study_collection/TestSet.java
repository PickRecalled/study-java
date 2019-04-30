package com.pickrecalled.study_collection;

import com.pickrecalled.study_reflection.Person;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestSet {

	@Test
	public void test01() {
		Set set = new LinkedHashSet();
		set.add(456);
		set.add(123);
		set.add("AA");
		set.add("CC");
		set.add(new Person("ZhangSan", 11, "zhangsan@163.com", "XiaoSan"));
		set.add(129);

		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
