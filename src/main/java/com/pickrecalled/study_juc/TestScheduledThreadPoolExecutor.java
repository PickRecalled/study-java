package com.pickrecalled.study_juc;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 线程调度
 */
public class TestScheduledThreadPoolExecutor {
	public static void main(String[] args) throws Exception {
		// 1.创建线程池
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
		for (int i = 0; i < 5; i++) {
			// 2.为线程池中的线程分配任务,创建内部类的Callable
			ScheduledFuture<Integer> schedule = pool.schedule(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int num = new Random().nextInt(100);
					System.out.println(Thread.currentThread().getName() + ":" + num);
					return num;
				}
			}, 2, TimeUnit.SECONDS);
			System.out.println("线程执行结果：" + schedule.get());
		}
		// 3.关闭线程池
		pool.shutdown();
	}
}
