package fr.unice.twdb.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * This servlet calls the XSLT transformer on the result passed from the calling servlet
 * and print it in the response object
 * 
 * @author abdoulayebintabah
 *
 */
public class AfficherUnPays extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {

		XSLTUtils.generateResult(req, res, getServletContext().getRealPath("/WEB-INF/classes/fr/unice/twdb/view/xslt/AfficherUnPays.xsl").toString());


	}


}
