package com.bank.web.controller;
import com.bank.domains.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bank.web.services.AccountService;
import com.bank.web.servicesImpl.AccountServiceImpl;

@WebServlet("/account.do")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountService accs = new AccountServiceImpl();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("계좌가 맞음");
		String money = request.getParameter("money");
		AccountBean accout = new AccountBean();
		accout.setMoney(money);
		accs.createAccount(money);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
