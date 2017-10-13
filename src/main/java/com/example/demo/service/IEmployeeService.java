package com.example.demo.service;

import com.example.demo.model.CommonFriendsResponseModel;
import com.example.demo.model.EmployeeResponseModel;
import com.example.demo.model.PersonInterestsResponse;

public interface IEmployeeService {
	EmployeeResponseModel getEmployeesbyCompany(String companyName);

	CommonFriendsResponseModel getCommonAttributes(String personOne, String personTwo);

	PersonInterestsResponse getPersonInterests(String personName);
}
