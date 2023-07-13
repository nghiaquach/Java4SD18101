package com.utils;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploader
 */

@MultipartConfig(maxFileSize = 10240 * 10 , maxRequestSize = 10240 *50)
@WebServlet("/upload")
public class FileUploader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("views/upload.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part photo = request.getPart("photo");
		//UTC
		String path = "upload/" + System.currentTimeMillis() + "_" + photo.getSubmittedFileName();
		String filename = "/Users/nghiaquach/Documents/FPL/Java4/" + path;
		System.out.println(filename);
		photo.write(filename);
		request.getRequestDispatcher("views/upload.jsp").forward(request, response);
	}

}
