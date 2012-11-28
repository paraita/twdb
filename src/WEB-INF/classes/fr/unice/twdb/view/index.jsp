
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


    <%! String contenu =
    
    		"<form action='/TWDB/search'>" +
			"<header>Rechercher : </header>" +
			"<input name='xml' hidden='true' type='text' value='false'/>" +
			"<input type='text' name='valeur' />" +
			"<input type='submit' value='Find'/>" +
			"</form>";
    
    %>
    
    <%@ include file="template.html" %>
    