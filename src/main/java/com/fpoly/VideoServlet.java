package com.fpoly;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.utils.JPAUtils;
import com.fpoly.entity.*;

/**
 * Servlet implementation class VideoServlet
 */
@WebServlet("/VideoServlet")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManager em = JPAUtils.getEntityManager();
		//List<Favorite> favorites = em.find(User.class, "1").getFavorites();
		//get favorites
		String jpql = "SELECT new Report(f.video.title, count(f.id), min(f.likeDate), max(f.likeDate))"
				+ " FROM Favorite f GROUP BY f.video.title";
		
		TypedQuery<Report> query = em.createQuery(jpql, Report.class);
		List<Report> list = query.getResultList();	
		
		//Find video title by procedure
		
		StoredProcedureQuery spQuery = em.createStoredProcedureQuery("Video.findByVideoTitle");
		spQuery.setParameter("title", "%9");
    	List<Video> videos = spQuery.getResultList();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
