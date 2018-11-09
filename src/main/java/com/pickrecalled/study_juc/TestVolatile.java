package com.pickrecalled.study_juc;

/**
 * volatile 关键字与内存可见性
 */
public class TestVolatile {

	public static void main(String[] args) {
		// 启动线程修改值
		ThreadDemo td = new ThreadDemo();
		new Thread(td).start();

		// 查看while的次数
		long i = 1L;
		// 判断标识是否被修改
		while (true) {
			// 使用了volatile关键字来替换synchronized（同步）锁
			// synchronized (td) {
			if (td.isFlag()) {
				System.out.println("---------true--------");
				break;
				// }
			}
			i++;
		}
		System.out.println(i);
	}

}

class ThreadDemo implements Runnable {

	// 共享标识
	private volatile boolean flag = false;

	@Override
	public void run() {
		// 为了看到效果休眠200毫秒
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		flag = true;
		System.out.println("flag=" + isFlag());
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
