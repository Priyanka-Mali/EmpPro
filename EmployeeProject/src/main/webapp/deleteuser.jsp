<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="UserInfo.*"%>
<jsp:useBean id="u" class="UserInfo.UserData"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
int i=UserDAO.delete(u);  
response.sendRedirect("viewusers.jsp");  
%>  