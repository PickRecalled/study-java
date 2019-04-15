package com.pickrecalled.study_thread;

/**
 * 窗口卖票复现线程安全问题
 */
public class SyncMethodWindowTicketsThreadRunnable implements Runnable {

	// 总的票有20张
	private int ticket = 20;

	@Override
	public void run() {
		while (true) {
			if (!sellingTickets()) break;
		}
	}

	// 卖票方法
	private synchronized boolean sellingTickets() {
		// 票不足退出
		if (ticket <= 0) return false;
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
		return true;
	}
}

/**
 * 测试Mani方法
 */
class SyncMethodWindowTicketsThreadRunnableMain {
	public static void main(String[] args) {
		SyncMethodWindowTicketsThreadRunnable smtrr = new SyncMethodWindowTicketsThreadRunnable();

		Thread t1 = new Thread(smtrr, "窗口1");
		Thread t2 = new Thread(smtrr, "窗口2");
		Thread t3 = new Thread(smtrr, "窗口3");

		t1.start();
		t2.start();
		t3.start();

	}
}
