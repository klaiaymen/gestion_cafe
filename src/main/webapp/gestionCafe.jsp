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
<h1>Liste des Cafés</h1>
    <table>
        <tr>
            <th>Nom du Café</th>
            <th>Fournisseur</th>
            <th>Prix</th>
            <th>Ventes</th>
            <th>Actions</th>
        </tr>
        <%
            List<Cafe> listeCafes = (List<Cafe>) request.getAttribute("listeCafes");
            if (listeCafes != null && !listeCafes.isEmpty()) {
                for (Cafe cafe : listeCafes) {
        %>
        <tr>
            <td><%= cafe.getNom() %></td>
            <td><%= cafe.getFournisseur() %></td>
            <td><%= cafe.getPrix() %></td>
            <td><%= cafe.getVentes() %></td>
            <td>
                <!-- Formulaire pour supprimer un café -->
                <form action="ServletSupprimerCafe" method="post" style="display:inline;">
                    <input type="hidden" name="nomCafe" value="<%= cafe.getNom() %>" />
                    <button type="submit">Supprimer</button>
                </form>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">Aucun café trouvé.</td>
        </tr>
        <%
            }
        %>
    </table>
    <br>
    <!-- Bouton Ajouter un café -->
    <form method="get" action="ServletAjouterCafe">
        <button type="submit">Ajouter un café</button>
    </form>

    <br>
    <a href="home.jsp">Retour à la page d'administration</a>
</body>
</html>