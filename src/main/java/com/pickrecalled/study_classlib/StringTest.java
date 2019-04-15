package com.pickrecalled.study_classlib;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class StringTest {

	@Test
	public void test() {
		String s1 = "javaEE";
		String s2 = "Hadoop";

		String s3 = "javaEEHadoop";
		String s4 = "javaEE" + "Hadoop";
		String s5 = s1 + "Hadoop";
		String s6 = "javaEE" + s2;
		String s7 = s1 + s2;

		System.out.println(s3 == s4);// true
		System.out.println(s3 == s5);// false
		System.out.println(s3 == s6);// false
		System.out.println(s3 == s7);// false
		System.out.println(s5 == s6);// false
		System.out.println(s5 == s7);// false
		System.out.println(s6 == s7);// false

		String s8 = s5.intern();
		System.out.println(s3 == s8);// true

		final String s9 = "javaEE";
		String s10 = s9 + "Hadoop";
		System.out.println(s3 == s10);// true

        StringBuffer buf = new StringBuffer(20);

		StringBuffer buf1 = new StringBuffer();
		System.out.println(buf1.length());// 0
		StringBuffer buf2 = new StringBuffer("abc");
		System.out.println(buf2.length());// 3
	}
}