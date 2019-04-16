package com.pickrecalled.study_classlib;

/**
 * 商品对象
 */
public class Goods implements Comparable {

	private String name;

	private double price;

	@Override
	// 指明商品比较大小的方式
	public int compareTo(Object o) {
		// 判断传的对象是否为商品
		if (o instanceof Goods) {
			// 强转对象，转完后形参对象Object o与当前对象就是两个对象
			Goods goods = (Goods) o;// 形参对象
			// 按价格从低到高排序，方法一
			if (this.price > goods.price) {
				return 1;
			} else if (this.price < goods.price) {
				return -1;
			} else {
				// 价格相同按产品名称从高到低排
				int i = this.name.compareTo(goods.name);
				return -i;// 默认是从低到高排，加个负号变为从高到低排
			}
			// 按价格从低到高排序，方法二
			// return Double.compare(this.price, goods.price);
		}
		throw new RuntimeException("传入的数据类型不一致");
	}

	// 无参构造方法
	public Goods() {
	}

	// 有参构造方法
	public Goods(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Goods{");
		sb.append("name='").append(name).append('\'');
		sb.append(", price=").append(price);
		sb.append('}');
		return sb.toString();
	}

}
