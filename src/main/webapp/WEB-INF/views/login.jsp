<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="addUser" commandName="newUser">
  <table>
    <tr>
      <td><form:label path="name">
        User name
      </form:label></td>
      <td><form:input path="name"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Add user"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
