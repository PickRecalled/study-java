package com.pickrecalled.study_thread;
/**
 * 死锁线程测试
 */
public class DeadThreadTest {
	public static void main(String[] args) {
		// 创建两个变量，让他们充当锁
		StringBuffer lock1 = new StringBuffer();
		StringBuffer lock2 = new StringBuffer();

		// 匿名创建线程方式一
		new Thread("死锁1") {
			@Override
			public void run() {
				synchronized (lock1) {
					lock1.append("a");
					lock2.append("1");

					// 让线程阻塞，使得死锁概率加大
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					synchronized (lock2) {
						lock1.append("b");
						lock2.append("2");
						System.out.println(lock1);
						System.out.println(lock2);
					}
				}
			}
		}.start();

		// 匿名创建线程方式二
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock1) {
					lock1.append("c");
					lock2.append("3");

					// 让线程阻塞，使得死锁概率加大
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					synchronized (lock2) {
						lock1.append("d");
						lock2.append("4");
						System.out.println(lock1);
						System.out.println(lock2);
					}
				}
			}
		}, "死锁2").start();
	}
}
