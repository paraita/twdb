package fr.unice.twdb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import fr.unice.twdb.controller.RequestUtils;

/**
 * This class provides an url analyser for requesting all countries.
 * @author bastien
 *
 */
public class AllCountryRequest extends HttpServlet {

	private static final String forwardTo = "/getallpays"; // this is the servlet name to forward the request.
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {
		
		String[] elem = RequestUtils.querySplit(req.getRequestURI());
		if(elem.length == 2 && elem[1].equals("xml")) { // we catch the file extension to determine the type of the result.
			req.setAttribute("xml", true);
		} else {
			req.setAttribute("xml", false);
		}
		
		req.getRequestDispatcher(forwardTo).forward(req, res);

	}
}