package com.fpoly.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init() T " + Thread.currentThread().getId());
	};
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service() T " + Thread.currentThread().getId());
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() T " + Thread.currentThread().getId());
	}
	
}
