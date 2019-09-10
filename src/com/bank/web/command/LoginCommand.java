package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.domains.CustomerBean;
import com.bank.web.services.MemberService;
import com.bank.web.servicesImpl.MemberServiceImpl;

public class LoginCommand extends MoveCommand{
	public LoginCommand(HttpServletRequest request)throws Exception {
		super(request);
	}
	@Override
	public void execute() {
		super.execute();
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		System.out.println("로그인 서비스 진입 후 아이디 , 비번");
		param.setId(request.getParameter("id"));
		param.setPw(request.getParameter("pw"));
		CustomerBean cust = service.login(param);
		String page = "";
		if(cust==null) {
			page = "login";
		}else {
			page = "mypage";
		}
		request.setAttribute("customer",cust);
		Receiver.cmd.setPage(page);
		System.out.println("로그인 후 갈 페이지"+Receiver.cmd.getView());

	}
}
