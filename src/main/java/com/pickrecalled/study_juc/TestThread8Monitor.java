package com.pickrecalled.study_juc;

public class TestThread8Monitor {
	public static void main(String[] args) {
		Number number = new Number();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					number.one();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				number.two();
			}
		}).start();

	}
}

class Number {

	public static synchronized void one() throws Exception {
		Thread.sleep(3000);// 休眠
		System.out.println("one");
	}

	public synchronized void two() {
		System.out.println("two");
	}

}

// new Thread(new Runnable() {
// @Override
// public void run() {
// number.three();
// }
// }).start();
//
//
//
// public void three() {
// System.out.println("three");
// }