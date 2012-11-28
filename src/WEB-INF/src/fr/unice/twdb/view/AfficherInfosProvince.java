package fr.unice.twdb.view;

import java.io.IOException;
import java.io.PrintWriter;

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

public class AfficherInfosProvince extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		String xml = ((StringBuffer) req.getAttribute("result")).toString();
		
		if (xml.length() == 0) {
			System.out.println("resultat vide ! :(");
			res.sendRedirect("/TWDB/noresult");
		}
		else {
			if((Boolean) req.getAttribute("xml")) {
				res.setContentType("text/xml");
				out.print(xml);
			} else {
				res.setContentType("text/html");
				String html = XSLTUtils.xml2html(xml, getServletContext().getRealPath("/WEB-INF/classes/fr/unice/twdb/view/xslt/AfficherInfosProvince.xsl").toString());
				out.print(html);
			}
		}
		
		

	}

}

