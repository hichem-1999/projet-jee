<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pizzariaa.Pizza"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>SOUHAITEZ-VOUS COMMANDER?</h2>
	<% int prix = 0;
	if (session == null) {
		session = request.getSession(true);
		session.setAttribute("pizzas", new ArrayList<Pizza>());
	}

	List<Pizza> pizzas = (List<Pizza>) session.getAttribute("pizzas");
	if(pizzas.size()!=0) { %>
		<table><tr><th>Pizzas</th><th>Prix</th></tr>
		<% for(Pizza p : pizzas) { 
			prix+=p.getPrix();
		%>
		<tr><td><%= p.getNom() %> <a href="http://localhost:8088/pizzariaa/Supprimer?supprimer=<%=p.getNom()%>">supprimer</a></td><td><%= p.getPrix() %>€</td></tr>
		<% } %>
		</table>
	<% } 
	session.setAttribute("prix", prix);
	%> 
	<p>Le prix total à payer : <%= prix %> €</p>
	<a href="http://localhost:8088/pizzariaa/formulaire.html"><button type="button">Valider</button></a>
	<a href="http://localhost:8088/pizzariaa/menu.html"><button type="button">Afficher Menu</button></a>
</body>
</html>