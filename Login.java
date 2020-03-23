package com.Bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custid=request.getParameter("CUSTID");
		String pwd=request.getParameter("PWD");
		Model model=new Model();
		model.setCustid(custid);
		model.setPwd(pwd);
		boolean result=model.login();
		if(result)
		{
			int accno=model.getAccno();
			String name=model.getName();
			HttpSession session=request.getSession(true);
			session.setAttribute("accno", accno);
			session.setAttribute("name", name);
			response.sendRedirect("/BANK_APP/home.jsp");
		}
		else
		{
			response.sendRedirect("/BANK_APP/error.html");
		}
	
	}

}
