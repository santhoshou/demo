package com.example.demo.controller;

import com.example.demo.model.CommonFriendsResponseModel;
import com.example.demo.model.EmployeeResponseModel;
import com.example.demo.model.PersonInterestsResponse;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private IEmployeeService employeeService;

	@Autowired
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@RequestMapping("/employees")
	public EmployeeResponseModel getEmployeesbyCompany(@RequestParam(value = "companyName") String compnayName) {
		return employeeService.getEmployeesbyCompany(compnayName);
	}


	@RequestMapping("/commonfriends")
	public CommonFriendsResponseModel getCommonFriends(@RequestParam(value = "personOne") String personOne, @RequestParam(value = "personTwo") String personTwo) {
		return employeeService.getCommonAttributes(personOne, personTwo);
	}

	@RequestMapping("/favorites")
	public PersonInterestsResponse getFavorites(@RequestParam(value = "personName") String personName) {
		return employeeService.getPersonInterests(personName);
	}

}
