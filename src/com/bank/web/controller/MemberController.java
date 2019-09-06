package com.bank.web.controller;
import com.bank.web.command.*;
import com.bank.domains.*;
import com.bank.pool.Constants;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bank.web.services.*;
import com.bank.web.servicesImpl.*;
@WebServlet("/customer.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/customer/join.jsp");
		
		CustomerBean param = new CustomerBean();
		MemberService service =  new MemberServiceImpl();				
		Receiver.init(request);
		Receiver.cmd.execute();
		if(Receiver.cmd.getAction()==null) {
			Receiver.cmd.setPage();
		}
		switch(Receiver.cmd.getAction()) {	
		case "join":
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				String ssn = request.getParameter("ssn");
				String credit = request.getParameter("credit");
				param = new CustomerBean();
				param.setId(id);
				param.setPw(pw);
				param.setName(name);
				param.setSsn(ssn);
				param.setCredit(credit);
				service =  new MemberServiceImpl();
				service.join(param);
				Receiver.cmd.setPage("login");
				break;
		
		case "login":
			System.out.println("로그인 서비스 진입 후 아이디 , 비번");
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			param.setId(id);
			param.setPw(pw);
			CustomerBean cust = service.login(param);
			if(cust==null) {
				Receiver.cmd.setPage("login");
			}else {
				Receiver.cmd.setPage("mypage");
			}
			request.setAttribute("customer",cust);
			break;
											
		case "existId":
			break;
			
		}
		
		Carrier.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
