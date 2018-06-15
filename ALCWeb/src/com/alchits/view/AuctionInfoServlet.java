package com.alchits.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuctionInfoServlet
 */
@WebServlet("/info")
public class AuctionInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuctionInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String password = request.getParameter("pwd");
		
		if(password!=null && password.equals("alc41021080#")){	
			<iframe width="84%" height="400px" src="https://docs.google.com/spreadsheets/d/e/2PACX-1vSQn8bDfW5SxXLVftz_bfDjpG-64oQm66qwpAsR_wmOVRskbdFpqIiVa9twpvpy6H6tPFM3W0Y04Rt5/pubhtml?widget=true&amp;headers=false"></iframe>
			<br /><br /><br />
			<iframe src="https://docs.google.com/presentation/d/e/2PACX-1vQmC6JTtpkF1x_Hq60rJTDQlMZbD4PKAMAuzQKA_WJF388rCZxtupf25oj3PQPGHCqlPX1DIS-alkJO/embed?start=false&loop=true&delayms=5000" frameborder="0" width="960" height="569" allowfullscreen="true" mozallowfullscreen="true" webkitallowfullscreen="true"></iframe>
			out.println("Done");
		}
		else{
			out.println("Access Denied!!"); 
		}
		
		
	}

}
