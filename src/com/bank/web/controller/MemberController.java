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
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Receiver.init(request);
		Receiver.cmd.execute();
		Carrier.forward(request, response);
		
	}

}
