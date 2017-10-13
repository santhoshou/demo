package com.example.demo.service;

import com.example.demo.common.DemoException;
import com.example.demo.model.CommonFriendsResponseModel;
import com.example.demo.model.Company;
import com.example.demo.model.EmployeeResponseModel;
import com.example.demo.model.Person;
import com.example.demo.model.PersonInterestsResponse;
import com.example.demo.model.ResultStatus;
import com.example.demo.provider.IRemoteCompaniesProvider;
import com.example.demo.provider.IRemotePeopleProvider;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService implements IEmployeeService {

	private IRemoteCompaniesProvider remoteCompaniesProvider;
	private IRemotePeopleProvider remotePeopleProvider;
	private String[] fruitsList = {"aaple", "banana", "strawberry", "orange"};
	private String[] vegList = {"cucumber", "beetroot", "lettuce", "celery"};

	public EmployeeService(IRemoteCompaniesProvider remoteCompaniesProvider, IRemotePeopleProvider remotePeopleProvider) {
		this.remoteCompaniesProvider = remoteCompaniesProvider;
		this.remotePeopleProvider = remotePeopleProvider;
	}

	@Override
	public EmployeeResponseModel getEmployeesbyCompany(String companyName) {
		EmployeeResponseModel resp = new EmployeeResponseModel();
		ResultStatus resultStatus = new ResultStatus();
		try {
			List<Person> peopleList = this.remotePeopleProvider.getPeopleList();
			List<Company> companyList = this.remoteCompaniesProvider.getCompanyList();
			if (peopleList != null && peopleList.size() > 0) {
				Company filterCompany = companyList.stream().filter(company -> company.getCompany().equals(companyName)).findAny().orElse(null);
				if (filterCompany != null) {
					List<Person> filteredPeopleList = peopleList.stream().filter(person -> person.getCompany_id().equals(filterCompany.getIndex())).collect(Collectors.toList());
					resultStatus.setStatusCode("200");
					if (filteredPeopleList.size() > 0) {
						resp.setEmployees(filteredPeopleList);
					} else {
						resultStatus.setStatusMessage("No Employees working in the company");
					}
				} else {
					resultStatus.setStatusMessage("Company not found");
				}
			}
		} catch (DemoException e) {
			resultStatus.setStatusCode("500");
			resultStatus.setStatusMessage("Error in Service");
		}
		resp.setResultStatus(resultStatus);
		return resp;
	}

	@Override
	public CommonFriendsResponseModel getCommonAttributes(String personOne, String personTwo) {
		CommonFriendsResponseModel resp = new CommonFriendsResponseModel();
		ResultStatus resultStatus = new ResultStatus();
		try {
			List<Person> peopleList = this.remotePeopleProvider.getPeopleList();
			Person person1 = getPerson(personOne, peopleList);
			Person person2 = getPerson(personTwo, peopleList);
			if (person1 != null && person2 != null) {
				List<Person> person1Friends = getPersonFriendsList(person1, peopleList);
				List<Person> person2Friends = getPersonFriendsList(person2, peopleList);
				List<Person> commonFriends = person1Friends.stream()
						.filter(person2Friends::contains)
						.collect(Collectors.toList());
				List<Person> respList = new ArrayList<>();
				respList.add(person1);
				respList.add(person2);
				resultStatus.setStatusCode("200");
				resp.setPersonInfo(respList);
				resp.setCommonFriends(commonFriends);
			} else {
				resultStatus.setStatusCode("200");
				resultStatus.setStatusMessage("One or More Person data missing");
			}

		} catch (DemoException e) {
			resultStatus.setStatusCode("500");
			resultStatus.setStatusMessage("Error in Service");
		}
		resp.setResultStatus(resultStatus);
		return resp;
	}

	@Override
	public PersonInterestsResponse getPersonInterests(String personName) {
		PersonInterestsResponse resp = new PersonInterestsResponse();
		ResultStatus resultStatus = new ResultStatus();
		try {
			List<Person> peopleList = this.remotePeopleProvider.getPeopleList();
			if (peopleList != null && peopleList.size() > 0) {
				Person person = getPerson(personName, peopleList);
				if (person != null) {
					if (!StringUtils.isEmpty(person.getFavouriteFood())) {
						List<String> favFruitsList = getFavoriteVegorFruits(person, fruitsList);
						List<String> favVegList = getFavoriteVegorFruits(person, vegList);
						resp.setUserName(person.getName());
						resp.setAge(person.getAge());
						resp.setFruits(favFruitsList.stream().toArray(String[]::new));
						resp.setVegetables(favVegList.stream().toArray(String[]::new));
						resultStatus.setStatusCode("200");
					} else {
						resultStatus.setStatusCode("200");
						resultStatus.setStatusMessage("Person has no favorite food");
					}
				} else {
					resultStatus.setStatusCode("200");
					resultStatus.setStatusMessage("Person data missing");
				}
			}
		} catch (DemoException e) {
			resultStatus.setStatusCode("500");
			resultStatus.setStatusMessage("Error in Service");
		}
		resp.setResultStatus(resultStatus);
		return resp;
	}

	private Person getPerson(String personName, List<Person> peopleList) {
		return peopleList.stream().filter(person -> person.getName().equals(personName)).findAny().orElse(null);
	}

	private List<Person> getPersonFriendsList(Person person, List<Person> peopleList) {
		List<Person> personFriends = new ArrayList<>();
		Arrays.asList(person.getFriends()).forEach(friend -> {
			Person tempPer = peopleList.get(Integer.parseInt(friend.getIndex()));
			if (tempPer.getHas_died().equals("false") && tempPer.getEyeColor().equals("brown") && !tempPer.getIndex().equals(person.getIndex())) {
				personFriends.add(tempPer);
			}
		});
		return personFriends;
	}


	private List<String> getFavoriteVegorFruits(Person person, String[] favoriteFoodList) {
		List<String> favFoodList = Arrays.asList(person.getFavouriteFood()).stream()
				.filter(Arrays.asList(favoriteFoodList)::contains)
				.collect(Collectors.toList());
		return favFoodList;
	}

}
