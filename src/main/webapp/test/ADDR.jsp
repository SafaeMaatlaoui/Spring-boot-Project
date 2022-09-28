<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="../script.js"></script>
</head>
<body>
<form method="post" action="addRessource" onsubmit="check(this)">
    <table>
        <tr>
            <td>Code</td>
            <td><input type="text" name="code" required></td>
        </tr>
        <tr>
            <td>Marque</td><td><input type="text"  name="marque" required></td>
        </tr>
        <tr>
            <td>Date livraison</td>
            <td><input type="date" name="date_liv" required></td>
        </tr>
        <tr>
            <td>Duree garantis (en mois)</td>
            <td><input type="number" name="duree_gar" value="6"></td>
        </tr>
        <tr>
            <td>Type ressource</td>
            <td>
                <select name="type">
                    <option value="O">Ordinateur</option>
                    <option value="I">Imprimente</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Fournisseur</td>
            <td>
                <select name="nom_soc" onchange="hide()">
                    <option selected disabled>Choisie fournisseur</option>
                    <c:forEach var="listValue" items="${listFournisseurs}">
                        <option value="${listValue}">${listValue}</option>
                    </c:forEach>
                </select>
                <div id="nom_soc" style="display:inline">
                    ou  <input type="text" name="nom_soc" required>
                </div>

            </td>
        </tr>
    </table>
    <button type="submit" >Next</button>
</form>
</body>
</html>