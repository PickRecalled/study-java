package com.pickrecalled.study_juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {
	public static void main(String[] args) {
		HelloThread ht = new HelloThread();
		for (int i = 0; i < 10; i++) {
			new Thread(ht).start();
		}
	}

}

class HelloThread implements Runnable {

	// 原来解决线程安装使用如下方式
	// private static List<String> list = Collections.synchronizedList(new ArrayList<>());

	private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
	// 静态代码块儿里初始化一些数据
	static {
		list.add("AA");
		list.add("BB");
		list.add("CC");
		list.add("DD");
	}

	@Override
	public void run() {
		// 循环取数据
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());

			// 边取数据边再往集合当中写入数据
			list.add("EE");
			list.add("FF");
		}
	}
}
