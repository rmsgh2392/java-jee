package com.bank.web.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.pool.Constants;

import lombok.Data;
@Data
public class Command implements Order{
	protected HttpServletRequest request;
	//A request is wrapped under an object as command
	protected String action,domains,page,view;
	
	@Override
	public void execute()  {
		setDomains();
		setPage();
		System.out.println
		("리퀘스트가 가야할 길"+String.format(Constants.VIEW_PATH,domains,page));
		this.view = String.format(Constants.VIEW_PATH,domains,page);

//		move command
	}
	public void setDomains() {
		String path = request.getServletPath();
		System.out.println("서블릿 패스가 뭘까?"+path);
		domains = path.replace(".do","");
		domains = domains.substring(1);
	}
	public void setPage() {
		page = request.getParameter("page");
	}

}







/*request.getRequestDispatcher
(String.format(
		Constants.VIEW_PATH,
		"customer"
		,request.getParameter("dest")))
.forward(request);*/