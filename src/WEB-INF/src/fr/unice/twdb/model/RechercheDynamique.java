/**
 * 
 */
package fr.unice.twdb.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet is called asynchronously to retrieve countries names
 * @author Paraita Wohler
 *
 */
public class RechercheDynamique extends TwdbModeleServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * main constructor, the forwardTo string is never used
	 */
	public RechercheDynamique() {
		this.setToForward("keds");
	}
	

	@Override
	/**
	 * retrieve coutries names based on the param string in the request
	 */
	protected void processRequete(HttpServletRequest request, HttpServletResponse response) {
		try {
			StringBuffer printer = new StringBuffer();
			URL url = new URL(getServletContext().getInitParameter("urlbdd") + "recherchedyn.xqy?param=" + request.getParameter("param"));
			URLConnection conn = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
				printer.append(inputLine);
			}
			in.close();
			request.setAttribute("result", printer);
			response.getWriter().write(printer.toString());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
