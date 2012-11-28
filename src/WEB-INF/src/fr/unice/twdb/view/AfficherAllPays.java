package fr.unice.twdb.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Display all the countries.
 * @author bastien
 *
 */
public class AfficherAllPays extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {
		
		XSLTUtils.generateResult(req, res, getServletContext().getRealPath("/WEB-INF/classes/fr/unice/twdb/view/xslt/AfficherAllPays.xsl").toString());	
		
	}

}
