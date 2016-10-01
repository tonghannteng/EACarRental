package mum.cs544.project.view;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class UITag extends SimpleTagSupport {
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void doTag() throws JspException, IOException {

		JspWriter out = getJspContext().getOut();
		if (type.equals("dependency")) {
			out.print(
				"<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css'>"
							+ "<link rel='stylesheet' href='/EACarRental/resources/css/model.css'>"
							+ "<script src='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js'></script>");
		}
		else if(type.equals("header")){
			out.print(
			"<nav>"+
			"<div class='nav-wrapper'>"+
				"<a href='#' class='brand-logo'>Car Rental</a>"+
			"</div>"+
			"</nav>");
		}
		else if(type.equals("startContainer"))
			out.print("<div class='containerBase'>");			
		else if(type.equals("endContainer"))
			out.print("</div>");	
	 }
}