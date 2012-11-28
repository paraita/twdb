package fr.unice.twdb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class provides code used by others controller classes.
 * @author Bastien Auda
 *
 */
public class RequestUtils {

	/**
	 * Return file name and his extension from the url.
	 * @param q url to be analyzed
	 * @return A couple { filename, extension }
	 */
	static public String[] querySplit(String q) {

		String[] splitted = q.split("/");
		String file = splitted[splitted.length-1];
		return file.split("[.]");
	}

	/**
	 * Make the standard processing of a request by id.
	 * @param req
	 * @param res
	 * @param forwardTo
	 * @throws IOException
	 * @throws ServletException
	 */
	static public void standardRequest(HttpServletRequest req, HttpServletResponse res, String forwardTo) throws IOException, ServletException {
		String[] elem = RequestUtils.querySplit(req.getRequestURI());

		if(elem == null || elem.length != 2) { // if the url isn't well formed.
			res.sendRedirect("/404");
		}

		req.setAttribute("param", elem[0]);

		if(elem[1].equals("xml")) { // if we request an xml result
			req.setAttribute("xml", true);
		} else {
			req.setAttribute("xml", false);
		}

		req.getRequestDispatcher(forwardTo).forward(req, res);
	}

	/**
	 * Useful method to concat an array of strings to a simple string
	 * 
	 * @author Paraita Wohler
	 * @param s the string array that has to be merged as an array of string
	 * @return a string resulting of the merge of the array of strings
	 */
	static public String mergeStringArray(String[] s) {
		StringBuffer resultat = new StringBuffer();
		resultat.append(s[0]);
		for(int i = 1; i < s.length; i++)
			resultat.append("/" + s[i]);
		return resultat.toString();
	}

	
	/**
	 * add a string to a particular position in a array of strings
	 * 
	 * @author Paraita Wohler
	 * @param index position in which the input string will be inserted
	 * @param input the string that has to be inserted
	 * @param s the string array in which we insert the input string
	 * @return the resulting string array
	 */
	static public String[] addToArrayAt(int index,String input, String[] s) {
		String[] resultat = new String[s.length + 1];
		for (int i = 0; i < index; i++) {
			resultat[i] = s[i];
		}
		resultat[index] = input;
		for (int i = index + 1; i < resultat.length; i++) {
			resultat[i] = s[i-1];
		}
		return resultat;
	}
}
