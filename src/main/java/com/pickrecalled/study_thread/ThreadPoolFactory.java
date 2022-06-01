package com.pickrecalled.study_thread;


import sun.nio.ch.ThreadPool;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 线程池工厂方法
 */
public class ThreadPoolFactory {
	// 核心池的大小
	private static int corePoolSize = Runtime.getRuntime().availableProcessors();
	// 线程池最大线程数，它表示在线程池中最多能创建多少个线程
	private static int maximumPoolSize = 50;
	// 表示线程没有任务执行时最多保持多久时间会终止
	private static long keepAliveTime = 10;
	// 队列最大数
	private static int queueMaxSize = 10000;
	private ConcurrentHashMap<String, ThreadPool> threadMap;

	public ThreadPoolFactory() {
		this.threadMap = new ConcurrentHashMap<>();
	}

	public static ThreadPoolFactory getInstance(){
	    return null;
    }
}
