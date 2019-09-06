package com.bank.web.servicesImpl;
import java.util.List;
import java.util.ArrayList;
import com.bank.domains.CustomerBean;
import com.bank.domains.EmployeeBean;
import com.bank.domains.MemberBean;
import com.bank.web.daoImpls.MemberDAOImpl;
import com.bank.web.daos.MemberDAO;
import com.bank.web.services.*;
public class MemberServiceImpl implements MemberService{
	
	private CustomerBean customer;
	private MemberBean member;
	private MemberDAO dao;
	public MemberServiceImpl() {
	 customer = new CustomerBean();
	 member = new MemberBean();
	 dao = new MemberDAOImpl();
	}
	
	@Override
	public void join(CustomerBean param) {
		dao.insertCustomer(param);
	}

	@Override
	public CustomerBean login(MemberBean param) {
		CustomerBean temp = dao.login();
		if(param.getId().equals(temp.getId())
		&&param.getPw().equals(temp.getPw())) {
			
		}else {
			temp = null;
		}
		return temp;
	}
	@Override
	public List<CustomerBean> findAllCustomers() {
		return null;
	}

	@Override
	public List<EmployeeBean> findAllAdmins() {
		return null;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		
		
		return null;
	}

	@Override
	public MemberBean findById(String id) {
		return null;
	}

	@Override
	public int countCustomers() {
		return 0;
	}

	@Override
	public int countAdmins() {
		return 0;
	}

	@Override
	public boolean existId(String id) {
		
		return false;
	}

	@Override
	public void updatePass(MemberBean param) {
	
	}		

	@Override
	public boolean deleteMember(MemberBean param) {
		  
		 return false;
		}
	

	@Override
	public void register(EmployeeBean param) {
		
	}

}
