package fr.unice.twdb.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Paraita Wohler
 * 
 * Main model servlet type that every model servlet should inherit
 * in order to factorize all the code.
 * A child should override the main constructor and implements
 * the processRequete() method.
 *
 */
public abstract class TwdbModeleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String toForward;
	
	protected void setToForward(String toForward) {
		this.toForward = toForward;
	}
	
	/**
	 * Getter of the toForward string that represent the servlet name
	 * which will be processing the result of the current servlet
	 * 
	 * @return the servlet's name that will process the result of the current servlet
	 */
	protected String getToForward() {
		return toForward;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequete(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequete(request, response);
	}
	
	/**
	 * the main functionality of the servlet has to be implemented in this method. The behavior is the same for every implementing servlet.
	 * 1 - retrieve the parameter from the request
	 * 2 - query the database with the parameter
	 * 3 - copy the result to the response object
	 * 4 - forward it to the corresponding view servlet (depending on the toForward string)
	 * 
	 * @param request passed from the user or the calling servlet, useful information can be found in it
	 * @param response results should be written in this response
	 */
	protected abstract void processRequete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
