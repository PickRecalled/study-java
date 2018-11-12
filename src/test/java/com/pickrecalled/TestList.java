package com.pickrecalled;

import java.util.*;

public class TestList {
	public static void main(String[] args) {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("status", "0");
		map1.put("cNo", "FYBXD20181106029");
		list.add(map1);

		Map<String, Object> map2 = new HashMap<>();
		map2.put("status", "2");
		map2.put("cNo", "FYBXD20181106029");
		list.add(map2);

		Map<String, Object> map3 = new HashMap<>();
		map3.put("status", "0");
		map3.put("cNo", "FYBXD20181106023");
		list.add(map3);

		long st = System.currentTimeMillis();
		Set<Integer> exchange = new HashSet<>();
		Iterator<Map<String, Object>> it = list.iterator();
		while (it.hasNext()) {
			Map<String, Object> next = it.next();
			if (null != exchange && !exchange.isEmpty() && exchange.size() > 0 && exchange.contains(next.get("cNo").hashCode()) && !"0".equals(next.get("status"))) it.remove();
			exchange.add(next.get("cNo").hashCode());

		}
		exchange.clear();
		System.out.println("耗时:" + (System.currentTimeMillis() - st) + " list:" + list);

	}

}
