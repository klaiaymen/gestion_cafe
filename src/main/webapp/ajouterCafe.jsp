<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Ajouter un Café</h1>
    <form method="post" action="ServletAjouterCafe">
        <label for="nomCafe">Nom du Café :</label>
        <input type="text" id="nomCafe" name="nomCafe" required><br><br>

        <label for="foId">ID Fournisseur :</label>
        <input type="number" id="foId" name="foId" required><br><br>

        <label for="prix">Prix :</label>
        <input type="number" id="prix" name="prix" step="0.01" required><br><br>

        <label for="ventes">Nombre de Ventes :</label>
        <input type="number" id="ventes" name="ventes" required><br><br>

        <button type="submit">Enregistrer</button>
    </form>

    <br>
    <a href="ServletListeCafe">Retour</a>
</body>
</html>