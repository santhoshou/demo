package com.example.demo.provider;

import com.example.demo.common.DemoException;
import com.example.demo.model.Person;

import java.util.List;

public interface IRemotePeopleProvider {
	List<Person> getPeopleList() throws DemoException;
}
