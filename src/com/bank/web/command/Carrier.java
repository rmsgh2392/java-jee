package com.bank.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {//전송자
	public static void forward(HttpServletRequest request
			,HttpServletResponse response){
		System.out.println("캐리어 내부:"+Receiver.cmd.getView());
		
		try {
			request.getRequestDispatcher(Receiver.cmd.getView())
			       .forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
