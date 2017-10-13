package com.example.demo.model;

public class Person {
	private String[] tags;

	private String company_id;

	private String phone;

	private String index;

	private String greeting;

	private String about;

	private String has_died;

	private String guid;

	private String picture;

	private String balance;

	private String[] favouriteFood;

	private Friends[] friends;

	private String _id;

	private String address;

	private String eyeColor;

	private String email;

	private String registered;

	private String age;

	private String name;

	private String gender;

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getHas_died() {
		return has_died;
	}

	public void setHas_died(String has_died) {
		this.has_died = has_died;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String[] getFavouriteFood() {
		return favouriteFood;
	}

	public void setFavouriteFood(String[] favouriteFood) {
		this.favouriteFood = favouriteFood;
	}

	public Friends[] getFriends() {
		return friends;
	}

	public void setFriends(Friends[] friends) {
		this.friends = friends;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "ClassPojo [tags = " + tags + ", company_id = " + company_id + ", phone = " + phone + ", index = " + index + ", greeting = " + greeting + ", about = " + about + ", has_died = " + has_died + ", guid = " + guid + ", picture = " + picture + ", balance = " + balance + ", favouriteFood = " + favouriteFood + ", friends = " + friends + ", _id = " + _id + ", address = " + address + ", eyeColor = " + eyeColor + ", email = " + email + ", registered = " + registered + ", age = " + age + ", name = " + name + ", gender = " + gender + "]";
	}
}