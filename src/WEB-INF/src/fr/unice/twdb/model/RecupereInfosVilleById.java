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
 * This servlet query a city from the database by its full name
 * 
 * @author Paraita Wohler
 *
 */
public class RecupereInfosVilleById extends TwdbModeleServlet {

	private static final long serialVersionUID = 1L;
	
	public RecupereInfosVilleById() {
		super();
		setToForward("printinfosville");
	}

	/**
	 * @see fr.unice.twdb.model.TwdbModeleServlet#processRequete(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void processRequete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			StringBuffer printer = new StringBuffer();
			Object param = request.getAttribute("param");
			if (param != null) {
				URL url = new URL(getServletContext().getInitParameter("urlbdd") + "getvilleinfobyid.xqy?param=" + param);
				URLConnection conn = url.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null)
					printer.append(inputLine + "\n");
				in.close();
			}
			else {
				printer.append("<erreur>");
				printer.append("parametre manquant");
				printer.append("</erreur>\n");
			}
			request.setAttribute("result", printer);
			request.getRequestDispatcher(getToForward()).forward(request, response);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}

	}

}
