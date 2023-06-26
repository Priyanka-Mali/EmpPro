<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="UserInfo.UserData,UserInfo.UserDAO"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Users</title>
</head>
<body>
<%@page import="UserInfo.UserDAO,UserInfo.UserData.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>User List</h1>
<%  
List<UserData> list = UserDAO.getAllRecords();
request.setAttribute("list", list);
%>  

 <table  border="1" width="90%">
 <tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Sex</th><th>Country</th></tr>
   <c:forEach items="${list}" var="u">
      <tr><td>${u.getId()}</td><td>${u.getName()}</td><td>${u.getPassword()}</td><td>${u.getEmail()}</td><td>${u.getSex()}</td><td>${u.getCountry()}</td><td><a href="UpdateForm.jsp?id=${u.getId()}">Edit</a></td><td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td></tr>
   </c:forEach>
 </table> 
 <br/><a href="AddUserForm.jsp">Add New User</a>
 
</body>
</html>