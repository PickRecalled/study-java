package com.pickrecalled.study_thread;

/**
 * 窗口卖票复现线程安全问题
 */
public class WindowTicketsThreadExtends extends Thread {
	// 总的票有20张
	private static int ticket = 20;
	// 对象锁
	// static Object obj = new Object();

	@Override
	public void run() {
		while (true) {
			// synchronized (obj) {
			// synchronized (this) {
			synchronized (WindowTicketsThreadExtends.class) {
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

class WindowTicketsThreadExtendsMain {
	public static void main(String[] args) {
		WindowTicketsThreadExtends wttr1 = new WindowTicketsThreadExtends();
		WindowTicketsThreadExtends wttr2 = new WindowTicketsThreadExtends();
		WindowTicketsThreadExtends wttr3 = new WindowTicketsThreadExtends();

		Class clazz = WindowTicketsThreadExtends.class;

		wttr1.setName("窗口1");
		wttr2.setName("窗口2");
		wttr3.setName("窗口3");

		wttr1.start();
		wttr2.start();
		wttr3.start();

	}
}
