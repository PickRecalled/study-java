package com.pickrecalled.study_collection;

public class Test01 {

	public static void main(String[] args) {
		int count1 = 13;
		int count2 = count1++ + count1++;
		System.out.println(count2);

		int count3 = 20;
		int count4 = ++count3 + ++count3;
		System.out.println(count4);
	}
}
