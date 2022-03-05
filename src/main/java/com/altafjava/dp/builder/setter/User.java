package com.altafjava.dp.builder.setter;

/**
 * Immutable class
 */
public final class User {
	private String firstName;
	private String lastName;
	private int age;
	private String phone;
	private String address;

	public User(String firstName, String lastName, int age, String phone, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}
}
