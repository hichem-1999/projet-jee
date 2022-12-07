<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pizzariaa.Pizza"%>
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
	<h2>Détails de la commande</h2>
	<% List<Commande> commandes =(List<Commande>) application.getAttribute("commandes");
	for(Commande c : commandes) {
		if(c.getId().equals(request.getParameter("commande"))) {
			List<Pizza> pizzas = c.getPizzas();
			if(pizzas.size()!=0) { %>
				<table><tr><th>Pizzas</th><th>Prix</th></tr>
				<% for(Pizza p : pizzas) { %>
				<tr><td><%= p.getNom() %></td><td><%= p.getPrix() %>€</td></tr>
				<% } %>
				</table>
			<% } %> 
			<p>Le prix total : <%= c.getPrix_total() %> €</p>
			<% break;
		}
	} %>
	<a href="http://localhost:8088/pizzariaa/Commandes.jsp"><button type="button">Retour</button></a>
</body>
</html>