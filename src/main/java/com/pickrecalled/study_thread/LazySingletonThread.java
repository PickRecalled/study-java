package com.pickrecalled.study_thread;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 */
public class LazySingletonThread {

}

class Bank {

	// 构造方法私有化
	private Bank() {
	}

	// 提供静态当前类返回值
	private static Bank instance = null;

	// 提供静态当前类创建方法
	public static Bank getInstance() {
		if (null == instance) {
			synchronized (Bank.class) {
				if (null == instance) {
					instance = new Bank();
				}
			}
		}
		return instance;
	}

}
