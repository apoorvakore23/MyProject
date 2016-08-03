package com.niit.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID=request.getParameter("userID");
		String password=request.getParameter("password");
		LoginDAO loginDAO =new LoginDAO();
		RequestDispatcher dispatcher;
		if(loginDAO.isValidUser(userID, password)== true){
			//Navigate to home page.dispatch to home page with same req & resp
			dispatcher=request.getRequestDispatcher("Home.html");
			dispatcher.forward(request,response);
		}
		else{
			System.out.println("inavlid credentials");
			//Navigate to Login with error message
			PrintWriter writer=response.getWriter();
			writer.println("please enter valid credentials");
			dispatcher=request.getRequestDispatcher("Login.html");
			dispatcher.include(request,response);
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID=request.getParameter("userID");
		String password=request.getParameter("password");
		LoginDAO loginDAO =new LoginDAO();
		RequestDispatcher dispatcher;
		if(loginDAO.isValidUser(userID, password)== true){
			//Navigate to home page.dispatch to home page with same req & resp
			dispatcher=request.getRequestDispatcher("Home.html");
			dispatcher.forward(request,response);
		}
		else{
			System.out.println("inavlid credentials");
			//Navigate to Login with error message
			PrintWriter writer=response.getWriter();
			writer.println("please enter valid credentials");
			dispatcher=request.getRequestDispatcher("Login.html");
			dispatcher.include(request,response);
			
		}
	}

}
