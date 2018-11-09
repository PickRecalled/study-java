package com.pickrecalled.study_juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockDemo {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			LockDemo lockDemo = new LockDemo();
			new Thread(new Runnable() {
				@Override
				public void run() {
					lockDemo.loopA();
				}
			}).start();

			new Thread(new Runnable() {
				@Override
				public void run() {
					lockDemo.loopB();
				}
			}).start();

			new Thread(new Runnable() {
				@Override
				public void run() {
					lockDemo.loopC();
				}
			}).start();
		}

	}
}

class LockDemo {

	private int flag = 1;

	private Lock lock = new ReentrantLock();

	private Condition conditionA = lock.newCondition();

	private Condition conditionB = lock.newCondition();

	private Condition conditionC = lock.newCondition();

	public void loopA() {
		lock.lock();
		try {
			while (flag != 1) {
				conditionA.await();
			}
			System.out.print("A");

			flag = 2;
			conditionB.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void loopB() {
		lock.lock();
		try {
			while (flag != 2) {
				conditionB.await();
			}
			System.out.print("B");

			flag = 3;
			conditionC.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void loopC() {
		lock.lock();
		try {
			while (flag != 3) {
				conditionC.await();
			}
			System.out.print("C");

            System.out.print("|");
			flag = 1;
			conditionA.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
