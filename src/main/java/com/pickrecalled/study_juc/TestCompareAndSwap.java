package com.pickrecalled.study_juc;

/**
 * 模拟CAS算法
 */
public class TestCompareAndSwap {

	public static void main(String[] args) {
		final CompareAndSwap cas = new CompareAndSwap();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int expectedValue = cas.getValue();
					int newValue = (int) (Math.random() * 101);
					// System.out.println("expectedValue:" + expectedValue + " , newValue:" + newValue);
					boolean b = cas.compareAndSet(expectedValue, newValue);
					System.out.println("b:" + b);
				}
			}).start();
		}
	}

}

class CompareAndSwap {

	// 内存值
	private int value;

	/**
	 * 获取内存值
	 * @return
	 */
	public synchronized int getValue() {
		return value;
	}

	/**
	 * 预估值与旧值比较方法，比较不管成功与失败都返回旧值
	 * @param expectedValue
	 *        预估值
	 * @param newValue
	 *        要替换的新值
	 * @return
	 */
	public synchronized int compareAndSwap(int expectedValue, int newValue) {
		// 读取原来的内存值
		int oldValue = this.value;

		// 预估值 == 旧值
		if (oldValue == expectedValue) {
			this.value = newValue;
		}
		return oldValue;
	}

	/**
	 * 设置方法
	 * @param expectedValue
	 *        预估值
	 * @param newValue
	 *        新值
	 * @return
	 */
	public synchronized boolean compareAndSet(int expectedValue, int newValue) {
		return expectedValue == compareAndSwap(expectedValue, newValue);
	}

}