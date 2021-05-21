package com.cts.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cts.dao.EmployeeDao;
import com.cts.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	//database info
	private final String db__username="root";
	private final String db__password="root";
	private final String db__driver="com.mysql.jdbc.Driver";
	private final String db__url="jdbc:mysql://localhost:3306/adm017";
	
	Connection connectionObj=null;
	PreparedStatement pStatement=null;
	
	@Override
	public void addEmployee(Employee empObj) {
		
		try {
			//step-1: load the driver
			Class.forName(db__driver);
			
			//step-2: get the connection
		    connectionObj=DriverManager.getConnection(db__url, db__username, db__password);
		    
		    //step-3: Write Your Queries
		    String insertQuery="insert into employee_table2 values(?,?,?,?)";
		    pStatement=connectionObj.prepareStatement(insertQuery);
		
		    empObj.setEmployeeId(1122);
		    empObj.setEmployeeName("Rajinikanth");
		    empObj.setSalary(150000.00);
		    empObj.setAge(55);
		    
		    pStatement.setInt(1,empObj.getEmployeeId());
		    pStatement.setString(1,empObj.getEmployeeName());
		    pStatement.setDouble(1,empObj.getSalary());
		    pStatement.setInt(1,empObj.getAge());
		    
		    //step-4: execute Statements
		    pStatement.executeUpdate();
		    System.out.println("Data has been successfully inserted.");
		    
		}catch(Exception exception) {
			exception.printStackTrace();
		}finally {
			//step-5: close the statement and connection
			if(pStatement!=null) {
				try {
					pStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connectionObj!=null) {
				try {
					connectionObj.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
