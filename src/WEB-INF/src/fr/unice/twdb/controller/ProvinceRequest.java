package fr.unice.twdb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import fr.unice.twdb.controller.RequestUtils;

/**
 * 
 * @author bastien
 *
 */
public class ProvinceRequest extends HttpServlet {
	
	private static final String forwardTo = "/getinfoprovincebyid";

	public void doGet(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {

		RequestUtils.standardRequest(req, res, forwardTo);

	}
}