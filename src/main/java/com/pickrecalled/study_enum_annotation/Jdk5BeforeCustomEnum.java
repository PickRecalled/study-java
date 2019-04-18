package com.pickrecalled.study_enum_annotation;

/**
 * JDK1.5以前自定义枚举
 */
public class Jdk5BeforeCustomEnum {

	public static void main(String[] args) {
		System.out.println("seasonName:" + Season.SUMMER.getSeasonName());
		System.out.println("seasonDes:" + Season.SUMMER.getSeasonDes());
		System.out.println("autumn:" + Season.AUTUMN);
	}
}

/**
 * 季节枚举类
 */
class Season {
	// 2.声明Season季节的属性，使用private final修饰
	private final String seasonName;// 季节名
	private final String seasonDes;// 季节描述

	// 1.私有化的构造器
	private Season(String seasonName, String seasonDes) {
		// 3.给实例变量（属性）赋值
		this.seasonName = seasonName;
		this.seasonDes = seasonDes;
	}

	// 4.提供当关枚举类的多个对象
	public static final Season SPRING = new Season("春天", "春暖花开");
	public static final Season SUMMER = new Season("夏天", "夏日炎炎");
	public static final Season AUTUMN = new Season("秋天", "秋高气爽");
	public static final Season WINTER = new Season("冬天", "冰天雪地");

	// 5.返回枚举对象的值
	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDes() {
		return seasonDes;
	}

	// 6.重写toString方法
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Season{");
		sb.append("seasonName='").append(seasonName).append('\'');
		sb.append(", seasonDes='").append(seasonDes).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
