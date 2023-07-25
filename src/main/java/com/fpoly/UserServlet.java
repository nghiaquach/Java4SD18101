package com.fpoly;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fpoly.dao.UserDAO;
import com.fpoly.entity.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({"/UserServlet","/UserServlet/edit/*","/UserServlet/create","/UserServlet/update","/UserServlet/delete","/UserServlet/reset"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	UserDAO userDao = new UserDAO();
    	String userId = req.getParameter("id");
    	User user = new User();
    	Map<String,String[]> map = req.getParameterMap();
    	System.out.println(req.getParameterMap());
    	
    	try {
			BeanUtils.populate(user, req.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String uri = req.getRequestURI();
    	if(uri.contains("create")) {
    		userDao.create(user);
    	}
    	else if(uri.contains("edit")) {
    		user = userDao.findById(userId);
		}
    	else if(uri.contains("update")) {
    		userDao.update(user);
		}
    	else if(uri.contains("delete")) {
    		userDao.remove(user.getId());
		}
    	else if(uri.contains("reset")) {
    		user = new User();
		}
    	
    	req.setAttribute("form", user);
    	req.setAttribute("users", userDao.findAll());
    	
    	req.getRequestDispatcher("/views/users.jsp").forward(req, resp);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		UserDAO userDao = new UserDAO();
		List<User> users = userDao.findAll();
		
		request.setAttribute("users", users);
		request.getRequestDispatcher("views/users.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
