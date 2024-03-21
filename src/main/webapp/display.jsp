<%@page import="studentwithjsp.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String name1=(String)request.getAttribute("name1"); %>
<%String name=(String)request.getAttribute("name"); %>
<%if(name!=null){ %>
<h1><%=name1 %>Details is ChangedBy::<%=name %></h1>
<%} %>
<%List<Student> students=(List)request.getAttribute("list"); %>
<table border="2px">
<tr>
<th>Id</th>
<th>Name</th>
<th>Address</th>
<th>Email</th>
<th>Password</th>
<th>Phone</th>
<th>Fees</th>
<th>Update</th>
<th>Delete</th>
</tr>

<%for(Student student:students){ %>
<tr>
<td><%=student.getId() %></td>
<td><%=student.getName() %></td>
<td><%=student.getAddress() %></td>
<td><%=student.getEmail() %></td>
<td><%=student.getPassword() %></td>
<td><%=student.getPhone() %></td>
<td><%=student.getFees() %></td>
<td><a href="update?id=<%=student.getId()%>">UPDATE</a></td>
<td><a href="remove?id=<%=student.getId()%>">Delete</a></td>
</tr>

<%} %>





</table>
</body>
</html>