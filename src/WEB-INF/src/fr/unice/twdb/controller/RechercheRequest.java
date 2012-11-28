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
 * This servlet is called from the form and calls the right model servlet
 * depending on the criteria of the research
 * 
 * @author Paraita Wohler
 */
public class RechercheRequest extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String requetePaysByName = "/ipbn";
	private static final String requeteVilleByName = "/getinfovillebyname";
	private static final String requeteProvinceByName = "/getinfoprovincebyname";
	
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
	 * Dispatch the query depending on the type in the request object
	 * type1: search by name: city/country/province
	 * type2: not yet implemented
	 * 
	 * @param req request object passed by Tomcat
	 * @param res response object to pass to the next servlet
	 */
	protected void processRequete(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {
		
		String[] bidouille = req.getRequestURI().split("/");
		bidouille = RequestUtils.addToArrayAt(2, "rp", bidouille);
		
		if(req.getParameter("xml").compareTo("true") == 0) {
			req.setAttribute("xml", true);
		} else {
			req.setAttribute("xml", false);
		}
		
		switch (Integer.parseInt(req.getParameter("type"))) {
		case 0:
			rechercheType1(req, res);
			break;
		default:
			break;
		}
	}
	
	
	protected void rechercheType1(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {
		
		req.setAttribute("param", req.getParameter("valeur"));
		
		if(req.getParameter("typezone").compareTo("Pays") == 0) {
			req.getRequestDispatcher(requetePaysByName).forward(req, res);
		}
		if(req.getParameter("typezone").compareTo("Ville") == 0) {
			req.getRequestDispatcher(requeteVilleByName).forward(req, res);
		}
		if(req.getParameter("typezone").compareTo("Province") == 0) {
			req.getRequestDispatcher(requeteProvinceByName).forward(req, res);
		}
		
		
	}
	
}
