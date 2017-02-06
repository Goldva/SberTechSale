<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="get" action="userCheck" commandName="loginUser">
  <table>
    <tr>
      <td><form:label path="userName">
        User name
      </form:label></td>
      <td><form:input path="userName"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Login"/>
        <input type="button" value="Registration" ONCLICK="location.href='/registration'"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
