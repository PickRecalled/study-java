package com.pickrecalled.study_juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {

	public static void main(String[] args) {
		ReadWriteLockDemo rw = new ReadWriteLockDemo();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1);// 为了测试出效果添加
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				rw.writeNumber((int) (Math.random() * 101));
			}
		}, "Write").start();

		for (int i = 0; i < 20; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					rw.readNumber();
				}
			}, "Read").start();
		}
	}

}

class ReadWriteLockDemo {

	/**
	 * 多线程同时需要操作的值
	 */
	private Integer number = 0;

	private ReadWriteLock lock = new ReentrantReadWriteLock();

	/**
	 * 读数字
	 */
	public void readNumber() {
		lock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + ":" + number);
		} finally {
			lock.readLock().unlock();
		}
	}

	/**
	 * 写数字
	 * @param num
	 */
	public void writeNumber(int num) {
		lock.writeLock().lock();
		try {
			this.number = num;
			System.out.println(Thread.currentThread().getName() + ":" + num);
		} finally {
			lock.writeLock().unlock();
		}
	}
}