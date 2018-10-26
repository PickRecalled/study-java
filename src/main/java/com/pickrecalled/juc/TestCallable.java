package com.pickrecalled.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {

	public static void main(String[] args) {
		ThreadCallableDemo tcd = new ThreadCallableDemo();
		// 执行Callable 方式，需要FutureTask实现类的支持，用于接受运算结果
		FutureTask<Integer> futureTask = new FutureTask<>(tcd);
		new Thread(futureTask).start();
		try {
			System.out.println("线程运算后的结果：" + futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}

class ThreadCallableDemo implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += i;
		}
		return sum;
	}
}
