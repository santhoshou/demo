package com.example.demo.model;


public class Company {
	private String index;

	private String company;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "ClassPojo [index = " + index + ", company = " + company + "]";
	}
}
