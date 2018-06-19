package com.alchits.view;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DownloadServler
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadServlet() {
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
		// response.setHeader("Cache-Control", "nostore");
		String fileName = "ALChits.xlsx";// request.getParameter("fileName");

		if (fileName == null || fileName.equals("")) {
			throw new ServletException("File Name can't be null or empty");
		}
		File file = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator + fileName);
		if (!file.exists()) {
			throw new ServletException("File doesn't exists on server.");
		}
		// out.println("File location on server::"+file.getAbsolutePath());
		ServletContext ctx = getServletContext();
		FileReader fr = new FileReader(file);
		// DataInputStream dis = new DataInputStream(new FileInputStream(file));

		String mimeType = null;// = ctx.getMimeType(file.getAbsolutePath());
		System.out.println(file.length());
		response.setContentType(
				mimeType != null ? mimeType : "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

		// byte[] bufferData = new byte[((int) file.length())];
		// char[] bufferData = new char[((int) file.length())];
		// int read = 0;
		// while((

		// read = fr.read(bufferData);// )!= -1){

		// }
		// dis.readFully(bufferData);
		// os.write(bufferData, 0, read);
		
		//out.flush();
		//out.close();
		// dis.close();
		fr.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
