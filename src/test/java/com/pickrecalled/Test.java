package com.pickrecalled;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	@org.junit.Test
	public void test04(){
		int count = 0;
		for (int i = 0; i <=100 ; i++) {
			count = count++;
		}
		System.out.println(count);
	}


	@org.junit.Test
	public void test03(){
		for (int i = 2; i <=5 ; i++) {
			System.out.println(i);
		}
		System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+0")).toEpochMilli());
	}


	public static void main(String[] args) {
		long bt = System.currentTimeMillis();

		int target = 30;

		int[][] matrix = { { 1, 3, 5, 7, 9 }, { 2, 4, 6, 8, 10 }, { 5, 10, 12, 13, 16 } };

		int row_num = matrix.length;
		int col_num = matrix[0].length;

		int begin = 0, end = row_num * col_num - 1;

		boolean isTrue = true;
		while (begin <= end) {
			int mid = (begin + end) / 2;
			int mid_value = matrix[mid / col_num][mid % col_num];

			if (mid_value == target) {
				isTrue = false;
				System.out.println("当前值存在");
				break;
			} else if (mid_value < target) {
				// 进一步移动，否则死循环
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (isTrue) System.out.println("当前值不存在");

		System.out.println("消耗时间：" + (System.currentTimeMillis() - bt));
	}

	@org.junit.Test
	public void test01(){
		List<String> userIdList = new ArrayList<>();
		userIdList.add("AA");
		userIdList.add("BB");
		userIdList.add("CC");
		List<String> queryUserVehicleList = new ArrayList<>(userIdList);
		System.out.println(userIdList);
		System.out.println(queryUserVehicleList);
		Iterator<String> iterator = queryUserVehicleList.iterator();
		while (iterator.hasNext()){
			String next = iterator.next();
			if(next.equals("AA")||next.equals("BB")||next.equals("CC")){
				iterator.remove();
			}
		}
		System.out.println(userIdList);
		System.out.println(queryUserVehicleList);
	}

	@org.junit.Test
	public void test02(){
		List<String> userIdList2 = null;
		List<String> userIdList = new ArrayList<>();
		userIdList.add("AA");
		//userIdList.addAll(Objects.requireNonNull(userIdList2));
		userIdList.add("BB");
		System.out.println(userIdList);
		userIdList.remove(null);
		System.out.println(userIdList);

		userIdList.removeAll(userIdList2);
		System.out.println(userIdList);

	}
}
