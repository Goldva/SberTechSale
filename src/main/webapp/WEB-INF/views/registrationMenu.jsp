<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <title></title>
</head>
<body>
<form:form method="post" action="registration" commandName="newUser">
  <table>
    <tr>
      <td><form:label path="userName">
        <spring:message code="lable.userName"/>
      </form:label></td>
      <td><form:input path="userName"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="<spring:message code="lable.add"/>"/>
        <input type="button" value="<spring:message code="lable.back"/>" ONCLICK="location.href='/'"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
