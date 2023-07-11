package com.fpoly;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    //Su dung Service => DoGet va DoPost se bi bo qua
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String method = req.getMethod();
 
    	if(method.contains("GET")) {
    		req.getRequestDispatcher("views/index.jsp").forward(req, resp);
    		System.out.println(method + " in Service");
    	}
    	else {
    		System.out.println("@@@ Post in Service");
    		String fullname = req.getParameter("fullname");
    		String[] favorites = req.getParameterValues("favorites");
    		
    		System.out.println("fullname " + fullname);
    		
    		
    		for (int i = 0; i < favorites.length; i++) {
    			System.out.println("favorites " + favorites[i]);
			}
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("views/index.jsp").forward(request, response);
		System.out.println("@@@ Get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("@@@ Post");
	}

}
