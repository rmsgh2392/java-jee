package com.bank.web.daoImpls;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.bank.domains.CustomerBean;
import com.bank.domains.EmployeeBean;
import com.bank.pool.Constants;
import com.bank.web.daos.MemberDAO;
public class MemberDAOImpl implements MemberDAO{

	@Override
	public void insertCustomer(CustomerBean param) {
		try {
			File file = new File(Constants.FILE_PATH+"customers0905.txt");
			 BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			 writer.write
			 (String.format("%s,%s,%s,%s,%s"
			,param.getId(),param.getPw(),param.getName(),param.getSsn(),param.getCredit()));
			 writer.newLine();
			 writer.flush();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertEmployee(EmployeeBean param) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	@Override
	public CustomerBean login() {
			CustomerBean customer = null;
		try {
			
			BufferedReader reader = new BufferedReader
			(new FileReader(Constants.FILE_PATH+"customers0905.txt"));
			String temp = reader.readLine();
			String[] arr = temp.split(",");
			System.out.println(arr[0]);
			customer = new CustomerBean();
			customer.setId(arr[0]);
			customer.setPw(arr[1]);
			customer.setName(arr[2]);
			customer.setSsn(arr[3]);
			customer.setCredit(arr[4]);
//			if(!param.getId().equals(customer.getId())
//			&&param.getPw().equals(customer.getPw())) {
//				customer = null;
//			}
//			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}
