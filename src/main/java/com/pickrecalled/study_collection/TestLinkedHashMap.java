package com.pickrecalled.study_collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class TestLinkedHashMap {

	@Test
	public void test01() {
		HashMap hashMap = new HashMap();
		hashMap.put(123, "bb");
		hashMap.put(345, "dd");
		hashMap.put(12, "aa");
		hashMap.put(567, "cc");
		System.out.println("hashMap" + hashMap);

		LinkedHashMap likedHashMap = new LinkedHashMap();
		likedHashMap.put(123, "bb");
		likedHashMap.put(345, "dd");
		likedHashMap.put(12, "aa");
		likedHashMap.put(567, "cc");

		System.out.println("likedHashMap" + likedHashMap);
	}
}
