<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<form method="post" action="AddLab">
  <table>
    <tr>
      <td>Department</td>
      <td>
        <select name="name" required>
          <option selected disabled>Choisie Department</option>
          <c:forEach var="listValue" items="${deps}">
            <option value="${listValue}">${listValue}</option>
          </c:forEach>
        </select>
      </td>
    </tr>
    <tr>
      <td>Laboratoir</td>
      <td>
        <select name="nom" onchange="hide()">
          <option selected disabled>Choisie Lab</option>
          <c:forEach var="listValue" items="${labs}">
            <option value="${listValue}">${listValue}</option>
          </c:forEach>
        </select>
        <div id="nom_soc" style="display:inline">
          ou  <input type="text" name="nom" required>
        </div>
      </td>
    </tr>
  </table>
  <button type="submit" name="action" value="addUser">Valider</button>
</form>
</body>
</html>