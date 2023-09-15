<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: abolfazl.m
  Date: 9/15/2023
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>people</title>
</head>
<body>
    <form action="/person/save.do">
        <input type="text" name="id" placeholder="Enter id">
        <input type="text" name="name" placeholder="Enter name">
        <input type="text" name="family" placeholder="Enter family">
        <input type="submit" value="save">
    </form>
    <table>
        <tr>
            <td>ID</td>
            <td>NAME</td>
            <td>FAMILY</td>
            <td>ACTION</td>
            <td>ACTION</td>
        </tr>
        <c:forEach items="${requestScope.personList}" var="person">
                <form action="/person/update.do">
                   <tr>
                       <td><input type="text" name="id" value="${person.id}" readonly></td>
                       <td><input type="text" name="name" value="${person.name}"></td>
                       <td><input type="text" name="family" value="${person.family}"></td>
                       <td><input type="submit" value="UPDATE"></td>
                       <td><input type="button" onclick="removePerson(${person.id})" value="REMOVE"></td>
                   </tr>
                </form>
        </c:forEach>
    </table>
    <script>
        function removePerson(id){
            if (confirm('Are you sure?'))
                 window.location = "/person/remove.do?id=" + id;
        }
    </script>
</body>
</html>
