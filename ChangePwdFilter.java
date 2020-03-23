package com.Bank;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class ChangePwdFilter implements Filter {


	public ChangePwdFilter() {
	}

		public void destroy() {
			// TODO Auto-generated method stub
		}


		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			String npwd=request.getParameter("npwd");
			String cnpwd=request.getParameter("cnpwd");
			if(npwd.equals(cnpwd))
			{
				chain.doFilter(request, response);
			}
			else
			{
				((HttpServletResponse) response).sendRedirect("/BANK_APP/errorPwd.jsp");
			}

		}

		public void init(FilterConfig fConfig) throws ServletException {
			// TODO Auto-generated method stub
		}

	}

