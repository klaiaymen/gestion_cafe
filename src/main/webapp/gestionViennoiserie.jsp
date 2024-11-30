<%@page import="models.Viennoiserie"%>
<%@page import="models.Cafe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Liste des Viennoiseries</h1>
    <table>
        <tr>
            <th>Nom du viennoiserie</th>
            <th>Fournisseur</th>
            <th>Prix</th>
            <th>Ventes</th>
            <th>Actions</th>
        </tr>
        <%
            List<Viennoiserie> listeViennoiseries = (List<Viennoiserie>) request.getAttribute("listeViennoiseries");
            if (listeViennoiseries != null && !listeViennoiseries.isEmpty()) {
                for (Viennoiserie viennoiserie : listeViennoiseries) {
        %>
        <tr>
            <td><%= viennoiserie.getNom() %></td>
            <td><%= viennoiserie.getFournisseur() %></td>
            <td><%= viennoiserie.getPrix() %></td>
            <td><%= viennoiserie.getVentes() %></td>
            <td>
                <!-- Formulaire pour supprimer un café -->
                <form action="ServletSupprimerViennoiserie" method="post" style="display:inline;">
                    <input type="hidden" name="nomViennoiserie" value="<%= viennoiserie.getNom() %>" />
                    <button type="submit">Supprimer</button>
                </form>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">Aucun Viennoiserie trouvé.</td>
        </tr>
        <%
            }
        %>
    </table>
    <br>
    <!-- Bouton Ajouter un café -->
    <form method="get" action="ServletAjouterViennoiserie">
        <button type="submit">Ajouter un viennoiserie</button>
    </form>

    <br>
    <a href="home.jsp">Retour à la page d'administration</a>
</body>
</html>