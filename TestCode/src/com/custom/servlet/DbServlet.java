package com.custom.servlet;


	import java.io.*;
	import java.sql.*;
	import javax.servlet.*;
	import javax.servlet.http.*;
	import javax.servlet.jsp.*;

	/**
	* An example of a JSP superclass that can be selected with
	* the <code>extends</code> attribute of the page
	* directive.  This servlet automatically loads the
	* JDBC-ODBC driver class when initialized and establishes
	* a connection to the USDA nutrient database.
	*/
	public abstract class DbServlet
	   extends HttpServlet
	   implements HttpJspPage
	{
	   Connection con;
	   String connectionUrl = "jdbc:mysql://localhost:3306/my_schema";
	    String dbUser = "root";
	    String dbPwd = "mysqladmin";

	   /**
	   * Initialize a servlet with the driver
	   * class already loaded and the database
	   * connection established.
	   */
	   public void init(ServletConfig config)
	      throws ServletException
	   {
	      super.init(config);
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      }
	      catch (Exception e) {
	         throw new UnavailableException(e.getMessage());
	      }

	      jspInit();
	   }

	   /**
	   * Closes the database connection when
	   * the servlet is unloaded.
	   */
	   public void destroy()
	   {
	      try {
	         if (con != null) {
	            con.close();
	            con = null;
	         }
	      }
	      catch (Exception ignore) {}

	      jspDestroy();
	      super.destroy();
	   }

	   /**
	   * Called when the JSP is loaded.
	   * By default does nothing.
	   */
	   public void jspInit() {}

	   /**
	   * Called when the JSP is unloaded.
	   * By default does nothing.
	   */
	   public void jspDestroy() {}

	   /**
	   * Invokes the JSP's _jspService method.
	   */
	   public final void service(
	         HttpServletRequest request,
	         HttpServletResponse response)
	      throws ServletException, IOException
	   {
	      _jspService(request, response);
	   }

	   /**
	   * Handles a service request.
	   */
	   public abstract void _jspService(
	         HttpServletRequest request,
	         HttpServletResponse response)
	      throws ServletException, IOException;
	}

