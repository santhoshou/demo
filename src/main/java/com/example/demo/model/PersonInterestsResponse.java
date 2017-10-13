package com.example.demo.model;

public class PersonInterestsResponse {
	private String userName;
	private String age;
	private String[] fruits;
	private String[] vegetables;
	private ResultStatus resultStatus;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String[] getFruits() {
		return fruits;
	}

	public void setFruits(String[] fruits) {
		this.fruits = fruits;
	}

	public String[] getVegetables() {
		return vegetables;
	}

	public void setVegetables(String[] vegetables) {
		this.vegetables = vegetables;
	}

	public ResultStatus getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(ResultStatus resultStatus) {
		this.resultStatus = resultStatus;
	}
}
