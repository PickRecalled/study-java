package com.pickrecalled.study_juc;

import java.util.concurrent.*;

public class TestThreadPool {
	public static void main(String[] args) throws Exception {
		// 1.创建线程池
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		int countNum = 0;
		for (int i = 0; i < 5; i++) {
			// 2.为线程池中的线程分配任务,创建内部类的Callable
			Future<Integer> submit = executorService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					// 计算100以内的数相加
					int sum = 0, n = 100;
					sum = (1 + n) * n / 2;
					return sum;
				}
			});
			countNum += submit.get();
		}
		System.out.println("5次100以内的数相加:" + countNum);

		// 3.关闭线程池
		executorService.shutdown();

		// ------单线程提交Callable的任务
		// // 1.创建线程池
		// ExecutorService executorService = Executors.newFixedThreadPool(5);
		//
		// // 2.为线程池中的线程分配任务,创建内部类的Callable
		// Future<Integer> submit = executorService.submit(new Callable<Integer>() {
		// @Override
		// public Integer call() throws Exception {
		// // 计算100以内的数相加
		// int sum = 0, n = 100;
		// sum = (1 + n) * n / 2;
		// return sum;
		// }
		// });
		//
		// System.out.println("100以内的数相加:" + submit.get());
		//
		// // 3.关闭线程池
		// executorService.shutdown();

		// ------提交Runnable的任务
		// // 1.创建线程池
		// ExecutorService executorService = Executors.newFixedThreadPool(5);
		//
		// ThreadPoolDemo tpd = new ThreadPoolDemo();
		//
		// for (int i = 0; i < 8; i++) {
		// // 2.为线程池中的线程分配任务
		// executorService.submit(tpd);
		// }
		//
		// // 3.关闭线程池
		// executorService.shutdown();
	}
}

class ThreadPoolDemo implements Runnable {
	private int i = 0;

	@Override
	public void run() {
		while (i < 10) {
			++i;
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}
