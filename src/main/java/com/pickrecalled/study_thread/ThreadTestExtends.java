package com.pickrecalled.study_thread;

/**
 * 继承Thread类的方式
 */
public class ThreadTestExtends extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) System.out.println(i);
		}
	}
}

class MainTest {
	public static void main(String[] args) {
		ThreadTestExtends tt = new ThreadTestExtends();
		tt.start();

		ThreadTestExtends tt2 = new ThreadTestExtends();
		tt2.start();
	}

}

/**
 * 匿名的方式创建一个线程
 */
class ManTestIncognitoThread {
	public static void main(String[] args) {
		new Thread("incognito-thread") {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + ":匿名的方式创建一个线程");
			}
		}.start();
	}
}