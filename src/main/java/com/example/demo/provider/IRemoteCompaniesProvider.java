package com.example.demo.provider;

import com.example.demo.common.DemoException;
import com.example.demo.model.Company;

import java.util.List;

public interface IRemoteCompaniesProvider {
	List<Company> getCompanyList() throws DemoException;
}
