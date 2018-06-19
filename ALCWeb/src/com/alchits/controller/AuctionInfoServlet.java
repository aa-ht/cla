package com.alchits.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("http://www.alchits.com");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setHeader("Cache-Control", "nostore");
		PrintWriter out = response.getWriter();
		String password = request.getParameter("pwd");

		if (password != null) {
			if (password.equals("alc41021080#")) {
				String AlChitsFileName = (String) getServletContext().getAttribute("ALChitsFileName");
				if (AlChitsFileName != null) {
					out.println("<table><tr><td><a href=\"data/" + AlChitsFileName + "\">" + AlChitsFileName + "</a>&nbsp;(Please click to download.)</td></tr><tr><td></td></tr>");
				}
				out.println("<tr><td><iframe src=\"https://docs.google.com/presentation/d/e/2PACX-1vQmC6JTtpkF1x_Hq60rJTDQlMZbD4PKAMAuzQKA_WJF388rCZxtupf25oj3PQPGHCqlPX1DIS-alkJO/embed?start=false&loop=true&delayms=5000\" frameborder=\"0\" width=\"960\" height=\"569\" allowfullscreen=\"true\" mozallowfullscreen=\"true\" webkitallowfullscreen=\"true\"></iframe></td></tr></table>");
				//out.println("<script src=\"js/download.js\"></script>");

			}
			else if (password.equals("admin560110#")) {
				request.getRequestDispatcher("upload34537456834.jsp").forward(request, response);
			}
			else {
				 out.println("<p style=\"color:red\">Access Denied!!</p>");
			}
		} else {
			 out.println("<p style=\"color:red\">Access Denied!!</p>");
		}

	}

}
