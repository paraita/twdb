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
 * This servlet query the list of names of all countries in the database
 * 
 * @author Paraita Wohler
 *
 */
public class RecupereListePays extends TwdbModeleServlet {

	private static final long serialVersionUID = 1L;

	public RecupereListePays() {
		super();
		setToForward("printallpays");
	}
	
	/**
	 * @see fr.unice.twdb.model.TwdbModeleServlet#processRequete(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void processRequete(HttpServletRequest request, HttpServletResponse response) {
		try {
			StringBuffer printer = new StringBuffer();
			URL url = new URL(getServletContext().getInitParameter("urlbdd") + "getallnames.xqy");
			URLConnection conn = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				printer.append(inputLine + "\n");
			in.close();
			
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
