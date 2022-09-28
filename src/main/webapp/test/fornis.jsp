<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="../script.js"></script>
</head>
<body>
<table>
    <tr>
        <th>Nom Societé</th>
        <th>Email</th>
        <th>Adress</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="fr" items="${fournisseurs}">
        <tr>
            <td>${fr.getNom_soc()}</td>
            <td>${fr.getEmail()}</td>
            <td>${fr.getAddress()}</td>
            <td>
                <form method="post" action="FournisseurAction">
                    <input type="hidden" name="id" value="${fr.getNom_soc()}">
                    <button type="submit" name="action" value="edite">Modifier</button>
                    <c:if test="${fr.isDeletable()}">
                        <button type="submit" name="action" value="delete">Supprimer</button>
                    </c:if>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>