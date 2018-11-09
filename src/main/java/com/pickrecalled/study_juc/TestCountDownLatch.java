package com.pickrecalled.study_juc;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch（闭锁）：在完成某些运算时，只有其它所有线程的运算全部完成，当前运算才断续执行
 */
public class TestCountDownLatch {
	public static void main(String[] args) throws InterruptedException {
		// 有多少个线程，初始值就是多少
		CountDownLatch cdl = new CountDownLatch(10);

		LatchDemo ld = new LatchDemo(cdl);
		long st = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			new Thread(ld).start();
		}

		// 如果CountDownLatch没有减为0时，主线程必须等待
		cdl.await();

		long et = System.currentTimeMillis();
		System.out.println("线程执行完消耗时间：" + (et - st));
	}
}

class LatchDemo implements Runnable {

	private CountDownLatch latch;

	public LatchDemo(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 50000; i++) {
				if (i % 2 == 0) {
					System.out.println("当前偶数：" + i);
				}
			}
		} finally {
			// 每次必须执行都减1
			latch.countDown();
		}
	}
}