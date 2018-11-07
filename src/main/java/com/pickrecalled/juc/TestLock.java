package com.pickrecalled.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

	public static void main(String[] args) {
		Ticket t = new Ticket();
		for (int i = 0; i < 3; i++) {
			new Thread(t, (i + 1) + "号窗口").start();
		}
	}

}

class Ticket implements Runnable {

	private int tick = 100;

	private Lock lock = new ReentrantLock();

	@Override
	public void run() {
		// 添加锁
		lock.lock();
		try {
			while (true) {
				// 为了放大问题休眠
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (tick > 0) {
					System.out.println(Thread.currentThread().getName() + " 完成售票，余票为：" + (--tick));
				}
			}
		} finally {
			// 释放锁
			lock.unlock();
		}
	}
}
