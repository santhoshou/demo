package com.example.demo.model;

import java.util.List;

public class CommonFriendsResponseModel {
	private List<Person> personInfo;
	private List<Person> commonFriends;
	private ResultStatus resultStatus;

	public List<Person> getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(List<Person> employees) {
		this.personInfo = employees;
	}

	public ResultStatus getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(ResultStatus resultStatus) {
		this.resultStatus = resultStatus;
	}

	public List<Person> getCommonFriends() {
		return commonFriends;
	}

	public void setCommonFriends(List<Person> friendsList) {
		this.commonFriends = friendsList;
	}
}
