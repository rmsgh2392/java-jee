package com.bank.web.servicesImpl;
import java.util.List;
import java.util.ArrayList;
import com.bank.domains.CustomerBean;
import com.bank.domains.EmployeeBean;
import com.bank.domains.MemberBean;
import com.bank.web.services.*;
public class MemberServiceImpl implements MemberService{
	
	private List<CustomerBean> customers;
	private List<EmployeeBean> employees;
//	private List<MemberBean> members;
	
	public MemberServiceImpl() {
		customers = new ArrayList<>();
		employees = new ArrayList<>();
//		members = new ArrayList<>();
	}
	
	@Override
	public void join(CustomerBean param) {
		customers.add(param);
	}

	@Override
	public List<CustomerBean> findAllCustomers() {
		return customers;
	}

	@Override
	public List<EmployeeBean> findAllAdmins() {
		return employees;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> m = new ArrayList<>();
		int count = 0;
		for(CustomerBean cb : customers) {
			if(name.equals(cb.getName())) {
				count++;
				break;
			}
		}
		for(EmployeeBean eb : employees) {
			if(name.equals(eb.getName())) {
				count++;
				break;
			}
		}
		int j=0;
		for(CustomerBean cb : customers) {
			if(name.equals(cb.getName())) {
				m.add(cb);
				j++;
				if(j==count) {
					return m;
				}
				
			}
		}
		for(EmployeeBean eb : employees) {
			if(name.equals(eb.getName())) {
				m.add(eb);
				j++;
				if(j == count) {
					break;
				}
			}
		}
		return m;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		for(CustomerBean c : customers) {
			if(id.equals(c.getId())) {
				member = c;
				return member;
			}
		}
		for(EmployeeBean e : employees) {
			if(id.equals(e.getId())) {
				member = e;
				break;
			}
		}
		return member;
	}

	@Override
	public boolean login(MemberBean param) {
		boolean result = false;
		MemberBean m = findById(param.getId()); 
		for(CustomerBean c : customers ) {
			if(m.equals(c.getId())) {
				result = true;
				break;
			}
		}
		for(EmployeeBean e : employees) {
			if(m.equals(e.getId())) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public int countCustomers() {
		return customers.size();
	}

	@Override
	public int countAdmins() {
		// TODO Auto-generated method stub
		return employees.size();
	}

	@Override
	public boolean existId(String id) {
		boolean result = false;
		MemberBean m = findById(id);
		
		return  (employees.contains(m)||customers.contains(m));
	}

	@Override
	public void updatePass(MemberBean param) {
		String id = param.getId();
		String oldPw = param.getPw().split(",")[0];
		String newPw = param.getPw().split(",")[1];
		MemberBean m = findById(param.getId());
		
		int idx = (employees.contains(m)) ? employees.indexOf(m):customers.indexOf(m);
		if(employees.contains(m)) {
			employees.get(idx).setPw(newPw);
		}else {
			customers.get(idx).setPw(newPw);
		}
				
			
		
			
			
	
		
	}

	@Override
	public boolean deleteMember(MemberBean param) {
		boolean b =false;
		MemberBean m = findById(param.getId());
		
		b= (employees.contains(m)) ? 
					employees.remove(m)
					:customers.remove(m);
					return b;
		}
	

	@Override
	public void register(EmployeeBean param) {
			employees.add(param);
		
	}

}
