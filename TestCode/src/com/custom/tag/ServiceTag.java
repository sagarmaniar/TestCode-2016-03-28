package com.custom.tag;

import javax.servlet.jsp.tagext.*;

import com.custom.service.Condb;

import javax.servlet.jsp.*;
import java.io.*;

public class ServiceTag extends SimpleTagSupport   {
	private String message;

	   public void setMessage(String msg) {
	      this.message = msg;
	   }

	   StringWriter sw = new StringWriter();

	   public void doTag()
	      throws JspException, IOException
	    {
		   System.out.println("Inside the doTag() of CustomTag");
	       
	          /* Use message from attribute */
	          JspWriter out = getJspContext().getOut();
	         out.println( message );
	          System.out.println("inside the if tag of service tag");
          sw.append("<html>");
	          sw.append("<head>");
	          sw.append("</head>");
          sw.append("<body>");
	          sw.append("<h1>");
          sw.append("<h1>");
          sw.append("inside the service tag message not nll");
          sw.append("</body>");
        
          sw.append("<html>");
         getJspBody().invoke(sw);
          getJspContext().getOut().println(sw.toString());
	          
	     
	       
	   }



}
