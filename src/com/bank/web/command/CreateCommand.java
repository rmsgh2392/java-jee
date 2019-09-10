package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.domains.CustomerBean;
import com.bank.web.services.MemberService;
import com.bank.web.servicesImpl.MemberServiceImpl;

public class CreateCommand extends MoveCommand{
	public CreateCommand(HttpServletRequest request) throws Exception{
		super(request);
	}
	@Override
	public void execute() {
		CustomerBean param = new CustomerBean();
		MemberService service =  new MemberServiceImpl();
		super.execute();
		param = new CustomerBean();
		param.setId(request.getParameter("id"));
		param.setPw(request.getParameter("pw"));
		param.setName(request.getParameter("name"));
		param.setSsn(request.getParameter("ssn"));
		param.setCredit(request.getParameter("credit"));
		service.join(param);
		Receiver.cmd.setPage("login");
		System.out.println("회원가입 후 갈 페이지"+Receiver.cmd.getView());
	}
}
