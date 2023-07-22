package com.fpoly;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fpoly.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Duyet gia tri cookies
//		Cookie[] cookies = request.getCookies();
//		
//		for (Cookie cookie : cookies) {
//			System.out.println(cookie.getName());
//			System.out.println(cookie.getValue());
//		}
		
		request.getRequestDispatcher("views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Email " + request.getParameter("email"));
		//System.out.println("Password " + request.getParameter("password"));
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
			
		if(email.equals("fpoly@gmail.com") && password.equals("Cantho")) {
//			//save cookie
//			Cookie ck = new Cookie("email", email);
//			ck.setMaxAge(10*3600);
//			ck.setPath("/");
//			response.addCookie(ck);
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			user.setFullname("Tran Van C");
			
			HttpSession session=request.getSession();  
		    session.setAttribute("user",user);
		    
		    //Xoá session = logout
		    //session.removeAttribute("user");
		}
		
	}

}
