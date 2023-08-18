package com.pickrecalled;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
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
		List<String> list = new ArrayList<>();
		list.add("b:svr:auz:");
		list.add("b:svr:auz:v::");
		// 用户授权设备
		list.add("b:svr:auz:d::");


		List<String> list2 = new ArrayList<>();
		list2.add("b:svr:auz:1133.55::4");
		list2.add("b:svr:auz:v::7:1");
		list2.add("b:svr:auz:d::99:1");

		for (String s : list2) {
			for (String s1 : list) {
				String substring = s.substring(0, s1.length());
				if(substring.contains(s1)){
					System.out.println(s);
				}
			}
//			if(list.contains(s)){
//				System.out.println(s);
//			}else{
//				System.out.println("----------");
//			}
		}
	}



}
