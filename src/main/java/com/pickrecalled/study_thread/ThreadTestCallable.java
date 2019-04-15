package com.pickrecalled.study_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口创建一个线程
 */
public class ThreadTestCallable implements Callable {

	@Override
	public Object call() throws Exception {
		// 循环累加1到100的数并返回
		int countNumber = 0;
		for (int i = 0; i <= 100; i++) {
			countNumber += i;
		}
		return countNumber;
	}
}

class ThreadTestCallableMain {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// 创建Callable接口实现对象
		ThreadTestCallable ttc = new ThreadTestCallable();
		// 将Callable接口实现对象传入到FutureTask构造器当中，创建FutureTask的对象
		FutureTask futureTask = new FutureTask(ttc);
		// 将FutureTask对象传入Thread类的构造器中
		Thread t = new Thread(futureTask);
		// 调用start方法进入线程就绪状态
		t.start();

		Object o = futureTask.get();
		System.out.println("获取线程执行结果值：" + o);

	}
}
