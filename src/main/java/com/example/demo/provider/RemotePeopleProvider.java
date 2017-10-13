package com.example.demo.provider;

import com.example.demo.common.DemoException;
import com.example.demo.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RemotePeopleProvider implements IRemotePeopleProvider {
	List<Person> peopleList = null;
	private String resourceName;

	public RemotePeopleProvider(String resourceName) {
		this.resourceName = resourceName;
	}

	@Override
	public List<Person> getPeopleList() throws DemoException {
		if (peopleList != null) {
			return peopleList;
		}
		try {
			Resource resource = new ClassPathResource(resourceName);
			InputStream resourceInputStream = resource.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			peopleList = mapper.readValue(resourceInputStream, TypeFactory.defaultInstance().constructCollectionType(List.class,
					Person.class));
		} catch (IOException e) {
			throw new DemoException(e);
		} catch (Exception e) {
			throw new DemoException(e);
		}
		return peopleList;
	}
}
