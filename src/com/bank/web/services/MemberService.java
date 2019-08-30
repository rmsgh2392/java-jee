package com.bank.web.services;
import com.bank.domains.*;
import java.util.List;
public interface MemberService {
	void join(CustomerBean param);
	public List<CustomerBean> findAllCustomers();
	public List<EmployeeBean> findAllAdmins();
	public List<MemberBean> findByName(String name); // 고객, 사원 공용메소드
	MemberBean findById(String id); // 고객, 사원 공용메소드
	boolean login(MemberBean param); // 고객, 사원 공용메소드
	int countCustomers(); // 고객수
	int countAdmins(); // 직원수
	boolean existId(String id);
	void updatePass(MemberBean param);
	boolean deleteMember(MemberBean param);
	public void register(EmployeeBean param);
	
	
	
	
}
