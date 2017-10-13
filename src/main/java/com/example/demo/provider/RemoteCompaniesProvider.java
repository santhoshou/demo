package com.example.demo.provider;

import com.example.demo.common.DemoException;
import com.example.demo.model.Company;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RemoteCompaniesProvider implements IRemoteCompaniesProvider {
	List<Company> companyList = null;
	private String resourceName;

	public RemoteCompaniesProvider(String resourceName) {
		this.resourceName = resourceName;
	}

	@Override
	public List<Company> getCompanyList() throws DemoException {
		if (companyList != null) {
			return companyList;
		}
		try {
			Resource resource = new ClassPathResource(resourceName);
			InputStream resourceInputStream = resource.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			companyList = mapper.readValue(resourceInputStream, TypeFactory.defaultInstance().constructCollectionType(List.class,
					Company.class));
		} catch (IOException e) {
			throw new DemoException(e);
		} catch (Exception e) {
			throw new DemoException(e);
		}
		return companyList;
	}
}
