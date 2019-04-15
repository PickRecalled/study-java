package com.pickrecalled.study_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock锁的方式解决线程安全问题
 */
public class LockMethodWindowTicketsThreadRunnable implements Runnable {
	// 总的票有20张
	private int ticket = 20;

	// 创建锁的对象
	private Lock lock = new ReentrantLock(true);

	@Override
	public void run() {
		while (true) {
			try {
				// 手动加锁
				lock.lock();
				// 票不足退出
				if (ticket <= 0) return;
				// 输出卖票信息
				System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
				// 添加sleep方法阻塞当前线程
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 卖票
				ticket--;
			} finally {
				// 手动释放锁
				lock.unlock();
			}

		}
	}
}

class LockMethodWindowTicketsThreadRunnableMain {
	public static void main(String[] args) {
		LockMethodWindowTicketsThreadRunnable lockWindows = new LockMethodWindowTicketsThreadRunnable();

		Thread t1 = new Thread(lockWindows, "窗口1");
		Thread t2 = new Thread(lockWindows, "窗口2");
		Thread t3 = new Thread(lockWindows, "窗口3");

		t1.start();
		t2.start();
		t3.start();
	}
}