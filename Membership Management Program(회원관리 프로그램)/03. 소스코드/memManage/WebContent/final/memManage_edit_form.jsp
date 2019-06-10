<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="membership.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<jsp:useBean id="member" scope="request" class="membership.MemberDO" />
<body>
<div align="center">
<form name=form1 method=post action=memManage_control.jsp>
<input type=hidden name="action" value="updatedata">
<table border="1">
  <tr><th>아이디</th>
    <td><input type="text" name="id" value="<%=member.getId() %>"></td></tr> 
  <tr><th>이  름</th>
    <td><input type="text" name="name" value="<%=member.getName() %>"></td></tr>
  <tr><th>비밀번호</th>
    <td><input type="text" name="password" value="<%=member.getPassword() %>"></td>
  <tr>
    <td colspan=2 align=center>
    <input type=submit value="수정"> <input type=reset value="취소"></td>
</tr>
</table></form></div>
</body>
</html>
