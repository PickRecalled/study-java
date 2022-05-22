package com.pickrecalled.study_juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者和消费者案例
 */
public class TestProducerAndConsumerLock {
	public static void main(String[] args) {
		ClerkLock clerkLock = new ClerkLock();
		ProducerLock producerLock = new ProducerLock(clerkLock);
		ConsumerLock consumerLock = new ConsumerLock(clerkLock);

		new Thread(producerLock, "生产者A").start();
		new Thread(consumerLock, "消费者B").start();

		new Thread(producerLock, "生产者C").start();
		new Thread(consumerLock, "消费者D").start();
	}

}

// 店员
class ClerkLock {
	private int product = 0;

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	/**
	 * 进货
	 */
	public void get() {
		lock.lock();
		try {
			// if (product >= 1) {
			// 为了避免wait后的虚假唤醒，应该wait()方法总使用在循环中
			while (product >= 10) {
				// 进货商品数量达到10后，说明商品已滿
				System.out.println("产品已滿！");
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// else {
			// 否则一次进一个商品
			System.out.println(Thread.currentThread().getName() + "-已有商品数量:" + (++product));

			condition.signalAll();
			// }
		} finally {
			lock.unlock();
		}
	}

	/**
	 * 卖货
	 */
	public void sale() {
		lock.lock();
		try {
			// if (product <= 0) {
			// 为了避免wait后的虚假唤醒，应该wait()方法总使用在循环中
			while (product <= 0) {
				// 告诉销售人员缺货
				System.out.println("缺货！");
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// else {
			// 有货售出一个商品
			System.out.println(Thread.currentThread().getName() + "-还有商品数量:" + (--product));

			condition.signalAll();
			// }
		} finally {
			lock.unlock();
		}
	}
}

// 生产者
class ProducerLock implements Runnable {
	// 店员
	private ClerkLock clerkLock;

	// 构造方法
	public ProducerLock(ClerkLock clerkLock) {
		this.clerkLock = clerkLock;
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
			clerkLock.get();
		}
	}
}

// 消费者
class ConsumerLock implements Runnable {
	// 店员
	private ClerkLock clerkLock;

	// 构造方法
	public ConsumerLock(ClerkLock clerkLock) {
		this.clerkLock = clerkLock;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			// 从店员买货
			clerkLock.sale();
		}
	}
}
