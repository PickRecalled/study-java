package com.pickrecalled.study_thread;

/**
 * 窗口卖票复现线程安全问题
 */
public class SyncMethodWindowTicketsExtends extends Thread {
	// 总的票有20张
	private static int ticket = 20;

	@Override
	public void run() {
		while (true) {
			if (!sellingTickets()) break;
		}
	}

	// 卖票方法
	private static synchronized boolean sellingTickets() {
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

class SyncMethodWindowTicketsExtendsMain {
	public static void main(String[] args) {
		SyncMethodWindowTicketsExtends wttr1 = new SyncMethodWindowTicketsExtends();
		SyncMethodWindowTicketsExtends wttr2 = new SyncMethodWindowTicketsExtends();
		SyncMethodWindowTicketsExtends wttr3 = new SyncMethodWindowTicketsExtends();

		wttr1.setName("窗口1");
		wttr2.setName("窗口2");
		wttr3.setName("窗口3");

		wttr1.start();
		wttr2.start();
		wttr3.start();

	}
}
