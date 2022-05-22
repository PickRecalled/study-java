package com.pickrecalled.study_juc;

/**
 * 生产者和消费者案例
 */
public class TestProducerAndConsumer {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Producer producer = new Producer(clerk);
		Consumer consumer = new Consumer(clerk);

		new Thread(producer, "生产者A").start();
		new Thread(consumer, "消费者B").start();

		new Thread(producer, "生产者C").start();
		new Thread(consumer, "消费者D").start();
	}

}

// 店员
class Clerk {
	private int product = 0;

	/**
	 * 进货
	 */
	public synchronized void get() {
		// if (product >= 1) {
		// 为了避免wait后的虚假唤醒，应该wait()方法总使用在循环中
		while (product >= 1) {
			// 进货商品数量达到10后，说明商品已滿
			System.out.println("产品已滿！");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// else {
		// 否则一次进一个商品
		System.out.println(Thread.currentThread().getName() + "-已有商品数量:" + (++product));

		this.notifyAll();
		// }
	}

	/**
	 * 卖货
	 */
	public synchronized void sale() {
		// if (product <= 0) {
		// 为了避免wait后的虚假唤醒，应该wait()方法总使用在循环中
		while (product <= 0) {
			// 告诉销售人员缺货
			System.out.println("缺货！");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// else {
		// 有货售出一个商品
		System.out.println(Thread.currentThread().getName() + "-还有商品数量:" + (--product));

		this.notifyAll();
		// }
	}
}

// 生产者
class Producer implements Runnable {
	// 店员
	private Clerk clerk;

	// 构造方法
	public Producer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 生产商品后交给店员
			clerk.get();
		}
	}
}

// 消费者
class Consumer implements Runnable {
	// 店员
	private Clerk clerk;

	// 构造方法
	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			// 从店员买货
			clerk.sale();
		}
	}
}
