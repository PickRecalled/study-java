package com.pickrecalled.study_classlib;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparable 与 Comparator
 */
public class ComparableComparatorTest {

	@Test
	public void goodsComparatorTest() {
		Goods[] goods = new Goods[6];
		goods[0] = new Goods("mac-mouse", 500);
		goods[1] = new Goods("xiaomi-mouse", 99);
		goods[2] = new Goods("huawei-mouse", 200);
		goods[3] = new Goods("dell-mouse", 150);
		goods[4] = new Goods("aaa-mouse", 150);
		goods[5] = new Goods("xiaomi-mouse", 19);
		// 商品名称从低到高排序，名称相同下商品价格从高到低排序
		Arrays.sort(goods, new Comparator<Goods>() {
			@Override
			public int compare(Goods o1, Goods o2) {
				if (o1.getName().equals(o2.getName())) {
					return Double.compare(o1.getPrice(), o2.getPrice());
				} else {
					return o1.getName().compareTo(o2.getName());
				}

			}
		});
		System.out.println(Arrays.toString(goods));
	}

	@Test
	public void stringComparatorTest() {
		String[] str = new String[] { "GG", "CC", "JJ", "AA", "DD", "EE", "BB" };
		// 自定义字符串从大到小排序
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -o1.compareTo(o2);
			}
		});
		System.out.println(Arrays.toString(str));
	}

	@Test
	public void goodsComparableTest() {
		Goods[] goods = new Goods[5];
		goods[0] = new Goods("mac-mouse", 500);
		goods[1] = new Goods("xiaomi-mouse", 99);
		goods[2] = new Goods("huawei-mouse", 200);
		goods[3] = new Goods("dell-mouse", 150);
		goods[4] = new Goods("aaa-mouse", 150);
		Arrays.sort(goods);
		System.out.println(Arrays.toString(goods));
	}

	/**
	 * 测试字符对象串排序
	 */
	@Test
	public void stringComparableTest() {
		String[] str = new String[] { "GG", "CC", "JJ", "AA", "DD", "EE", "BB" };
		Arrays.sort(str);
		System.out.println(Arrays.toString(str));
	}
}
