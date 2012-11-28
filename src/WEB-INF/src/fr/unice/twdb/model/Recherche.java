package fr.unice.twdb.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet query the database for a search by name.
 * @author bastien
 *
 */
public class Recherche extends TwdbModeleServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * main constructor, it set up the forwardTo string
	 */
	public Recherche() {
		super();
		setToForward("printSearchResult");
	}
	
	protected void processRequete(HttpServletRequest request, HttpServletResponse response) {
		try {
			StringBuffer printer = new StringBuffer();
			Object param = request.getParameter("valeur"); // we get the value to search
			if (param != null) {
				URL url = new URL(getServletContext().getInitParameter("urlbdd") + "recherche.xqy?param=" + param); // connection to the database
				URLConnection conn = url.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null) // retrieving data from eXist server
					printer.append(inputLine + "\n");
				in.close();
			}
			else { // if there is no value to search
				printer.append("<erreur>");
				printer.append("parametre manquant");
				printer.append("</erreur>\n");
			}
			request.setAttribute("result", printer); // add the result to the request for the view
			request.getRequestDispatcher(getToForward()).forward(request, response); // and we forward to the view
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
}
