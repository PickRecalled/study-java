package com.pickrecalled.study_thread;

/**
 * 线程通信息：使用两个线程打印 1-100。线程1, 线程2 交替打印
 */
public class ThreadCommunicationTest implements Runnable {
	// 共享变量
	private int number = 1;
	// 创建唯一对象锁
	private Object obj = new Object();

	@Override
	public void run() {
		while (true) {
			synchronized (obj) {
				obj.notify();
				if (number > 100) break;
				System.out.println(Thread.currentThread().getName() + "--->" + number);
				number++;
				try {
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class ThreadCommunicationTestMain {
	public static void main(String[] args) {
		ThreadCommunicationTest tct = new ThreadCommunicationTest();

		Thread t1 = new Thread(tct, "线程1");
		Thread t2 = new Thread(tct, "线程2");

		t1.start();
		t2.start();
	}
}
