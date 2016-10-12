package jp.co.mforce.samples;

public class User {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public User name(String name) {
		this.name = name;
		return this;
	}

	public int getAge() {
		return age;
	}

	public User age(int age) {
		this.age = age;
		return this;
	}

}
