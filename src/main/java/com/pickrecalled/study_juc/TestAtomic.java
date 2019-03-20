package com.pickrecalled.study_juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子变量与 CAS 算法
 */
public class TestAtomic {

	public static void main(String[] args) {
		AtomicDemo ad = new AtomicDemo();
		for (int i = 0; i < 10; i++) {
			new Thread(ad).start();
		}
	}

}

class AtomicDemo implements Runnable {

	// private volatile int serialNumber = 0;

	// 原子变量
	private AtomicInteger serialNumber = new AtomicInteger();

	@Override
	public void run() {

		// 为了放大问题看到效果
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
	}

	public int getSerialNumber() {
		return serialNumber.getAndIncrement();
	}
}
