package com.example.demo;

import com.example.demo.provider.IRemoteCompaniesProvider;
import com.example.demo.provider.IRemotePeopleProvider;
import com.example.demo.provider.RemoteCompaniesProvider;
import com.example.demo.provider.RemotePeopleProvider;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.IEmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

	@Bean
	public IRemotePeopleProvider getPeopleProvider() {
		return new RemotePeopleProvider("people.json");
	}

	@Bean
	public IRemoteCompaniesProvider getCompanyProvider() {
		return new RemoteCompaniesProvider("companies.json");
	}

	@Bean
	public IEmployeeService getEmployeeService(IRemoteCompaniesProvider remoteCompaniesProvider, IRemotePeopleProvider remotePeopleProvider) {
		return new EmployeeService(remoteCompaniesProvider, remotePeopleProvider);
	}
}
