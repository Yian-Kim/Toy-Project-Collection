<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="membership.*, java.util.*"%>
   
     <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<jsp:useBean id="member" class="membership.MemberDO"/>
<jsp:getProperty name="member" property="*"/> 
<jsp:useBean id="datas" scope="request" class="java.util.ArrayList"/>
<form name="form" action="memManage_control.jsp" method="post" >

<body>
<table border="1">


  <tr> <th>아이디</th> <td><%= member.getId() %></td></tr>
  <tr> <th>이름</th> <td><%= member.getName() %></td></tr>
  <tr> <th>암호</th> <td><%= member.getPassword() %></td></tr>
  <tr><th>이름</th>
  <tr>
    <td colspan=2 align=center>
    <input type=button value="수정"> <input type=reset value="취소"> 
</tr></table></form>
</body>
</html>
