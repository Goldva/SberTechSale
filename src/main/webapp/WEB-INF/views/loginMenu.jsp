<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="get" action="userCheck" commandName="loginUser">
  <table>
    <tr>
      <td><form:label path="userName">
        <spring:message code="lable.userName"/>
      </form:label></td>
      <td><form:input path="userName"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="<spring:message code="lable.login"/>"/>
        <input type="button" value="<spring:message code="lable.registration"/>" ONCLICK="location.href='/registration'"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
