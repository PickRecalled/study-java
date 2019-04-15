package com.pickrecalled.study_thread;

/**
 * 窗口卖票复现线程安全问题
 */
public class WindowTicketsThreadRunnable implements Runnable {

	// 总的票有20张
	private int ticket = 20;

	// 锁对象
	// Object obj = new Object();
	@Override
	public void run() {

		while (true) {
			// synchronized (obj) {
			synchronized (this) {
				// 票不足退出
				if (ticket <= 0) break;
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
			}
		}
	}
}

/**
 * 测试Mani方法
 */
class WindowTicketsMain {
	public static void main(String[] args) {
		WindowTicketsThreadRunnable wtt = new WindowTicketsThreadRunnable();

		Thread t1 = new Thread(wtt, "窗口1");
		Thread t2 = new Thread(wtt, "窗口2");
		Thread t3 = new Thread(wtt, "窗口3");

		t1.start();
		t2.start();
		t3.start();

	}
}
