package com.ecommerce.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("navigate.html").include(request, response);
		
		// fetch input parameters
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email.equals("admin@gmail.com") && password.equals("password@123")) {
			out.println("You are successfully logged In !");
			out.println("Welcome to ABC app :: "+email);
			
			// create a cookie
			Cookie ck = new Cookie("uname", email);
			response.addCookie(ck);
		} else {
			out.print("Sorry, Invalid Credentials !");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}

}
