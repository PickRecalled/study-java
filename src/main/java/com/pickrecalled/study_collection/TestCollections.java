package com.pickrecalled.study_collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCollections {

	@Test
	public void test01() {
		// 源数据
		List<Integer> src = new ArrayList<>();
		src.add(123);
		src.add(564);
		src.add(23);
		src.add(-68);
		src.add(879);

		// 目录数据
		// 错误的写法
		// List<Integer> dest = new ArrayList<>(src.size());
		// System.out.println(dest.size());//0
		// 正确的写法
		List dest = Arrays.asList(new Object[src.size()]);
		// List<Integer> dest = new ArrayList<>();
		// 将src中的内容复制到dest中
		Collections.copy(dest, src);

		System.out.println(dest);
	}
}
