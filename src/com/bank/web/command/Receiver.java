package com.bank.web.command;



import javax.servlet.http.HttpServletRequest;

import com.bank.web.enums.Action;

public class Receiver {//수신자
	public static Command cmd = new Command();//반드시 초기화 클래스 변후
	
	public static void init (HttpServletRequest request) {
		cmd = Commander.order(request);
}
}