<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<form method="post" action="AffecterEnseignant">
  <table>
    <tr>
      <td>Enseignant</td>
      <td>
        <select name="user" required>
          <option selected disabled>Choisie Enseignant</option>
          <c:forEach var="user" items="${users}">
            <option value="${user.getUser_id()}">${user.getNom()} ${user.getPrenom()} </option>
          </c:forEach>
        </select>
      </td>
    </tr>
  </table>
  <button type="submit">Valider</button>
</form>
</body>
</html>