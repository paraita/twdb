
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


    <%! String contenu =
    
    		"<form action=\"/TWDB/rechercheparam\">" +
			"<header>Recherche Approfondie</header>" +
			"<select name=typezone>" +
			"	<option value=Pays>Pays</option>" +
			"	<option value=Province>Province</option>" +
			"	<option value=Ville>Ville</option >" +
			"</select>" +
			"<input name=\"type\" hidden=\"true\" type=\"text\" value=\"0\"/>" +
			"<input name=\"xml\" hidden=\"true\" type=\"text\" value=\"false\"/>" +
			"<input type=\"text\" name=\"valeur\" />" +
			"<input type=\"submit\" value=\"Find\"/>" +
			"</form>"+
					
			"<header>Recherche Par Population</header>" +
			"<select name=typezone>" +
			"	<option value=Pays>Pays</option>" +
			"	<option value=Province>Province</option>" +
			"	<option value=Ville>Ville</option >" +
			"</select>" +
			"<select name=typezone>" +
			"	<option value=<><</option>" +
			"	<option value==>=</option>" +
			"	<option value=>></option >" +
			"</select>" +
			"<input name=\"type\" hidden=\"true\" type=\"text\" value=\"1\"/>" +
			"<input name=\"xml\" hidden=\"true\" type=\"text\" value=\"false\"/>" +
			"<input type=\"text\" name=valeur />" +
			"<input type=\"submit\" value=\"Find\"/>" +
			"</form>";
    
    %>
    
    <%@ include file="template.html" %>
    