<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pizzariaa.Commande"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Commandes non traitées</h2>
	<% if(application.getAttribute("commandes") == null) {
		application.setAttribute("commandes", new ArrayList<>());
	}
	
	List<Commande> commandes =(List<Commande>) application.getAttribute("commandes");
	if(commandes.size()!=0) { %>
		<table><tr><th>Nom</th><th>Prénom</th><th>Adresse</th><th>Prix total</th></tr>
		<% for(Commande c : commandes) { %>
		<tr><td><%= c.getNom() %></td><td><%= c.getPrenom() %></td><td><%= c.getAdresse() %></td><td><a href="http://localhost:8088/pizzariaa/Details.jsp?commande=<%=c.getId()%>"><%= c.getPrix_total() %>€</a></td></tr>
		<% } %>
		</table>
	<% } %>
	<a href="http://localhost:8088/pizzariaa/Sauvegarder"><button type="button">Sauvegarder</button></a>
</body>
</html>