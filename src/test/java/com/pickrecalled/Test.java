package com.pickrecalled;

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
}
