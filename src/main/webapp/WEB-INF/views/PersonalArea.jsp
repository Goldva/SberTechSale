<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
  <tbody>
  <tr>
    <td>
      <form:form method="post" action="addBid" commandName="newBid">
        <table>
          <tr>
            <td><form:label path="item.id">
              Item id
            </form:label></td>
            <td><form:input path="item.id"/></td>
          </tr>
          <tr>
            <td><form:label path="user.id">
              User id
            </form:label></td>
            <td><form:input path="user.id"/></td>
          </tr>
          <tr>
            <td colspan="2">
              <input type="submit" value="Add bid"/>
            </td>
          </tr>
        </table>
      </form:form>
    </td>
  </tr>
  <tr>
    <td>
      <jsp:useBean id="bids" class="java.util.ArrayList" scope="request"/>
      <table>
        <tbody>
        <tr>
          <th>id</th>
          <th>UserName</th>
          <th>ItemName</th>
        </tr>
        <c:forEach items="${bids}" var="bid">
          <tr onclick="location.href='/login'">
            <td align="left">${bid.id}</td>
            <td align="left">${bid.user.name}</td>
            <td align="left">${bid.item.name}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </td>
  </tbody>
</table>

</body>
</html>
