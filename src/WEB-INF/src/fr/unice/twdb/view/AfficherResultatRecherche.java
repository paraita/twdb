package fr.unice.twdb.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author bastien
 *
 */
public class AfficherResultatRecherche extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {

		XSLTUtils.generateResult(req, res, getServletContext().getRealPath("/WEB-INF/classes/fr/unice/twdb/view/xslt/AfficherResultatRecherche.xsl").toString());

	}

}
