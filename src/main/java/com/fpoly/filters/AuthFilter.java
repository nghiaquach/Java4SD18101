package com.fpoly.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.entity.User;


/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter({"/video/like","video/share","/admin/"})
public class AuthFilter implements HttpFilter {
       


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		String uri = request.getRequestURI();
		User user = (User) request.getSession().getAttribute("user");
		String error = "";
		
		if (user == null) {
			error = response.encodeURL("Please login to use this function!");
			System.out.println("Vui lòng đăng nhập!");
		} else if (!user.isAdmin() && uri.contains("/admin/")) {
			System.out.println("Vui lòng đăng nhập với vai trò admin");
			error = response.encodeURL("Please login with admin role");
		}
		if (!error.isEmpty()) {
			request.setAttribute("message", error);
			System.out.println("Error!");
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

}
