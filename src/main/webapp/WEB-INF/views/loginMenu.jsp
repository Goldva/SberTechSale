<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
</head>
<body>
<span style="float: right">
    <a href="?lang=en">en</a>
    <a href="?lang=ru">ru</a>
</span>

<form id="loginForm" method="get" action="javascript:void(null);" onsubmit="userCheck()">
    <div>
        <table>
            <tr>
                <td><label for="userName">
                    <spring:message code="label.userName"/>
                </label></td>
                <td><input id="userName" name="userName" value="" type="text"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="<spring:message code="button.login"/>"/>
                    <input type="button" value="<spring:message code="button.registration"/>"
                           ONCLICK="location.href='/registration'"/>
                </td>
            </tr>
        </table>
    </div>
</form>

<script type="text/javascript">
    function userCheck() {
        var msg = $('#loginForm').serialize();
        $.ajax({
            method: 'GET',
            url: "/userCheck",
            data: msg
        }).done(function () {
            window.location = "/index"
        }).fail(function () {
            alert('<spring:message code="error.userDoesNotExist"/>');
        });
    }
</script>
</body>
</html>
