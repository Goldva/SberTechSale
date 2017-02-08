<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<script LANGUAGE="JavaScript">
    <jsp:useBean id="messageError" class="java.lang.String" scope="request"/>
    alert("${messageError}");
    <jsp:useBean id="location" class="java.lang.String" scope="request"/>
    window.location = "${location}"
</script>

</body>
</html>
