package com.pickrecalled.study_enum_annotation;

/**
 * JDK5.0之后，使用enum关键字定义枚举类
 */
public class Jdk5AfterCustomEnum {
	public static void main(String[] args) {
		System.out.println("seasonName:" + Season1.SUMMER.getSeasonName());
		System.out.println("seasonDes:" + Season1.SUMMER.getSeasonDes());
		System.out.println("autumn:" + Season1.AUTUMN);

		System.out.println("枚举类Season1父类：" + Season1.class.getSuperclass());
	}
}

enum Season1 {
	// 1.提供枚举类的对象，多个对象用“,”分隔，末尾对象使用“:”结束
	SPRING("春天", "春暖花开"),
	SUMMER("夏天", "夏日炎炎"),
	AUTUMN("秋天", "秋高气爽"),
	WINTER("冬天", "冰天雪地");

	// 2.声明Season1对象的属性
	private final String seasonName;// 季节名
	private final String seasonDes;// 季节描述

	// 3.私有化的构造器，并给对象属性赋值
	private Season1(String seasonName, String seasonDes) {
		this.seasonName = seasonName;
		this.seasonDes = seasonDes;
	}

	// 4.返回枚举对象的值
	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDes() {
		return seasonDes;
	}

	// // 5.重写构造方法
	// @Override
	// public String toString() {
	// final StringBuffer sb = new StringBuffer("Season1{");
	// sb.append("seasonName='").append(seasonName).append('\'');
	// sb.append(", seasonDes='").append(seasonDes).append('\'');
	// sb.append('}');
	// return sb.toString();
	// }
}
