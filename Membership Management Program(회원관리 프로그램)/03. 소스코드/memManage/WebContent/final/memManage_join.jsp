<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form name="form" action="memManage_control.jsp" method="post" >
<input type=hidden name="action" value="insert">
<table border="1">
  <tr> <th>아이디</th>
    <td><input type="text" name="id" size=15 ></td>
  </tr>
  <tr><th>이름</th>
    <td><input type="text" name="name" size=15 ></td>
  </tr>
  <tr><th>암호</th>
    <td><input type="text" name="password" size=15 ></td>
  </tr>
  
  <tr>
    <td colspan=2 align=center><input type=submit value="가입"> <input type=reset value="취소"> 
</tr></table></form>
</body>
</html>
