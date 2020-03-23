package com.Bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		int accno=(int) session.getAttribute("accno");
		String raccno=request.getParameter("raccno");
		String balance=request.getParameter("amt");
		int theRaccno=Integer.parseInt(raccno);
		int theBalance=Integer.parseInt(balance);
		Model model=new Model();
		model.setAccno(accno);
		model.setBalance(theBalance);
		model.setRaccno(theRaccno);
		boolean result=model.transfer();
		if(result)
		{
			response.sendRedirect("/BANK_APP/successTransfer.jsp");
		}
		else
		{
			response.sendRedirect("/BANK_APP/errorTransfer.html");
		}
		
	}

}
