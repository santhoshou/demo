package com.example.demo.model;

import java.util.List;

public class EmployeeResponseModel {
	private List<Person> employees;
	private ResultStatus resultStatus;

	public List<Person> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Person> employees) {
		this.employees = employees;
	}

	public ResultStatus getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(ResultStatus resultStatus) {
		this.resultStatus = resultStatus;
	}
}
