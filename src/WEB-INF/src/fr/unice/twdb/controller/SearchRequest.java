/**
 * 
 */
package fr.unice.twdb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * This class provides an url analyzer for a standard name search.
 * @author Bastien Auda
 *
 */
public class SearchRequest extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String forwardTo = "/getSearchResult";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {
		processRequete(req, res);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {
		processRequete(req, res);
	}

	/**
	 * add an attribute to the request object depending on its parameter value
	 * 
	 * @param req the request object passed by Tomcat
	 * @param res the response object where results will be written
	 */
	protected void processRequete(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {

		if(req.getParameter("xml").compareTo("true") == 0) {
			req.setAttribute("xml", true);
		} else {
			req.setAttribute("xml", false);
		}
		
		req.getRequestDispatcher(forwardTo).forward(req, res);


	}

}
