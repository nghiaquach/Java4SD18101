package com.fpoly;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

/**
 * Servlet implementation class ELServlet
 */
@WebServlet("/ELServlet")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ELServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("x", 1000);
		request.getSession().setAttribute("y", 5000);
		request.getServletContext().setAttribute("z", 7000);
		request.getServletContext().setAttribute("x", 10000);
		
		request.setAttribute("now", new Date());
		
		
		Map<String, Double> map = new HashedMap();
		map.put("Nhap Mon Lap Trinh", 9.0);
		map.put("Java 1", 7.0);
		map.put("Java 2", 6.0);
		
		List<String> students = new ArrayList<>();
		students.add("Nguyễn Văn An");
		students.add("Trần Tuấn Khang");
		students.add("Nguyễn Thị Bé");
		
		request.setAttribute("map", map);
		request.setAttribute("students", students);
		
		request.getRequestDispatcher("views/EL.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
