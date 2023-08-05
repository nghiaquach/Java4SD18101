package com.fpoly;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.utils.XScope;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet({"/home/index","/home/contact","/home/about"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String uri = request.getRequestURI();
		String uri = request.getRequestURI();
		
		if(uri.contains("index")) {
			request.setAttribute("view", "/views/home/index.jsp");
		}
		else if(uri.contains("contact")) {
			request.setAttribute("view", "/views/home/contact.jsp");
		}
		else {
			request.setAttribute("view", "/views/home/about.jsp");
		}
		
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
