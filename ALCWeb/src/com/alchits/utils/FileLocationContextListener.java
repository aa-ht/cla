package com.alchits.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class
 * FileLocationContextListener
 *
 */
@WebListener
public class FileLocationContextListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public FileLocationContextListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		String rootPath = System.getProperty("catalina.home");
		ServletContext ctx = servletContextEvent.getServletContext();
		String relativePath = ctx.getInitParameter("tempfile.dir");
		File file = new File(rootPath + File.separator + relativePath);
		if (!file.exists()){
			file.mkdirs();
		}
		System.out.println("File Directory created to be used for storing files");
		ctx.setAttribute("FILES_DIR_FILE", file);
		ctx.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);
		
		
		Path filePath = Paths.get(ctx.getAttribute("FILES_DIR") + File.separator +"filenames.txt");
		try {
			List<String> lines = Files.readAllLines(filePath);			
			ctx.setAttribute("ALChitsFileName", lines.get(0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
