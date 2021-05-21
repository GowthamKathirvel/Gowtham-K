package com.cts.main;

import com.cts.daoimpl.EmployeeDaoImpl;
import com.cts.model.Employee;

public class Main {

	public static void main(String[] args) {
		
		EmployeeDaoImpl employeeDaoImplObj=new EmployeeDaoImpl();
		
		Employee empObj=new Employee();
		
		empObj.setEmployeeId(1122);
		empObj.setEmployeeName("Rajinikanth");
		empObj.setSalary(150000.00);
		empObj.setAge(55);
        
		employeeDaoImplObj.addEmployee(empObj);
	}

}
