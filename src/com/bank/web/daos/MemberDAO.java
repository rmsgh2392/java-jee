package com.bank.web.daos;
import com.bank.domains.*;
public interface MemberDAO {
	public void insertCustomer(CustomerBean param);
	public void insertEmployee(EmployeeBean param);
	public CustomerBean login();
	
	
	
	
	
	
	
}
