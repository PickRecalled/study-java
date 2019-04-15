package com.pickrecalled.study_thread;

/**
 * 实现Runnable接口
 */
public class ThreadTestRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) System.out.println(i);
		}
	}
}

class ManTest {
	public static void main(String[] args) {
		ThreadTestRunnable threadTestRunnable = new ThreadTestRunnable();
		Thread t1 = new Thread(threadTestRunnable);
		t1.start();
	}
}
