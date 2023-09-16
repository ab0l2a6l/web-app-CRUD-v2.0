<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: abolfazl.m
  Date: 9/16/2023
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>students</title>
    <link rel="stylesheet" href="/assets/style.css">
    <link rel="stylesheet" href="/assets/bootstrap.min.css">
    <script src="/assets/jquery.min.js"></script>
    <script src="/assets/bootstrap.min.js"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/menu.jsp"/>

    <div class="container">
        <div class="panel panel-primary">
            <div class="panel-heading">student</div>
            <div class="panel-body">
                <form action="/student/save.do">
                    <input class="form-control" type="text" name="id" placeholder="Enter id">
                    <input class="form-control" type="text" name="name" placeholder="Enter name">
                    <input type="text" class="form-control" name="family" placeholder="Enter family">
                    <input type="submit" value="save" class="btn btn-primary"style="width: 100%" >
                </form>
                <table class="table table-hover table-bordered">
                    <tr>
                        <td>ID</td>
                        <td>NAME</td>
                        <td>FAMILY</td>
                        <td>ACTION</td>
                        <td>ACTION</td>
                    </tr>
                    <c:forEach items="${requestScope.studentList}" var="student">
                        <form action="/student/update.do">
                            <td><input type="text" name="id" readonly class="form-control" value="${student.id}"></td>
                            <td><input type="text" name="name" class="form-control" value="${student.name}"></td>
                            <td><input type="text" name="family" class="form-control" value="${student.family}"></td>
                            <td><input type="submit" value="UPDATE" class="btn btn-primary"></td>
                            <td><input type="button" value="DELETE" class="btn-danger btn" onclick="studentDelete(${student.id})"></td>
                        </form>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
<script>
    function studentDelete(id){
        if(confirm('are you sure ? '))
            window.location = "/student/remove.do?id=" + id;
    }
</script>
</body>
</html>
