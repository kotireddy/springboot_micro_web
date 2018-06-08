package com.springboot.micro.web.service;

import com.springboot.micro.web.bean.Employee;
import com.springboot.micro.web.bean.EmployeeJson;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService{

	@Override
	public EmployeeJson getIndexData() {
		EmployeeJson employeeJson = new EmployeeJson();
		Employee employee = new Employee();
		employee.setName("Hello");
		employee.setEmail("hello@gmail.com");
		employee.setPhone(789456);
		employeeJson.setEmployee(employee);
		
		employeeJson.setName("Suresh");
		employeeJson.setCity("HYD");
		employeeJson.setPhone("5678");
		employeeJson.setMobile("567889909877");
		
		return employeeJson;
	}

}
