package com.pickrecalled.reflection;

public class Person {

	public String name;

	Integer age;

	protected String email;

	private String nickName;

	/**
	 * 元参构造器
	 */
	public Person() {
	}

	/**
	 * 输出方法
	 */
	public void helloPerson() {
		System.out.println("Hello");
	}

	/**
	 * 输出方法
	 * @param name
	 */
	public void helloPerson(String name) {
		System.out.println("Hello " + name);
	}

	/**
	 * 有参构造器
	 * @param name
	 * @param age
	 * @param email
	 * @param nickName
	 */
	public Person(String name, Integer age, String email, String nickName) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Person{");
		sb.append("name='").append(name).append('\'');
		sb.append(", age=").append(age);
		sb.append(", email='").append(email).append('\'');
		sb.append(", nickName='").append(nickName).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
