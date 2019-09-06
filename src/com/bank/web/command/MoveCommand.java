package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	
	public MoveCommand(HttpServletRequest request) throws Exception {
		setRequest(request);
		setDomains(domains);
		setAction
		(request.getParameter("action")==null ?
			"move" : request.getParameter("action"));
//		action=move를 default로 처리한다
//		왜냐하면 단순이동이 form태그 이동(데이터에대한 이동)보다 훨씬 많다. 
		execute();
		
	}
	@Override
	public void execute()  {
		super.execute();
		request.setAttribute("page",request.getParameter("page"));
		
	}
}
