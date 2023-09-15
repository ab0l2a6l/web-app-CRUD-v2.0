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
    <link rel="stylesheet" href="/assets/style.css">
    <link rel="stylesheet" href="/assets/bootstrap.min.css">
    <script src="/assets/jquery.min.js"></script>
    <script src="/assets/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="/WEB-INF/menu.jsp"/>

<div class="container font-familt">
    <div class="panel panel-primary">
        <div class="panel-heading">PERSON</div>
        <div class="panel-body">
            <form action="/person/save.do">
                <input class="form-control" type="text" name="id" placeholder="Enter id">
                <input class="form-control" type="text" name="name" placeholder="Enter name">
                <input class="form-control" type="text" name="family" placeholder="Enter family">
                <input class="btn btn-primary" type="submit" value="save" style="width :100%">
            </form>
            <table class="table table-hover table-striped table-bordered">
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
                            <td><input type="text" class="form-control" name="id" value="${person.id}" readonly></td>
                            <td><input type="text" class="form-control" name="name" value="${person.name}"></td>
                            <td><input type="text" class="form-control" name="family" value="${person.family}"></td>
                            <td><input type="submit" class="btn btn-primary" value="UPDATE"></td>
                            <td><input type="button" class="btn btn-danger" onclick="removePerson(${person.id})" value="REMOVE"></td>
                        </tr>
                    </form>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
    <script>
        function removePerson(id){
            if (confirm('Are you sure?'))
                 window.location = "/person/remove.do?id=" + id;
        }
    </script>
</body>
</html>
