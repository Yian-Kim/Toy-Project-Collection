<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function change() {
			document.form1.action.value="update";
			document.form1.submit();
		
	}
</script>
<title>로그인 창</title>
<jsp:useBean id="member" scope="request" class="membership.MemberDO" />
</head>
<body>
<form name=form1 method=post action=memManage_control.jsp>
<input type=hidden name="action" value="delete">
<input type=hidden name="id" value="<%=member.getId()%>">
<input type=hidden name="password" value="<%=member.getPassword()%>">
<input type=hidden name="name" value="<%=member.getName()%>">

아이디 : <%=member.getId()%></br>
<input type="button" value="로그아웃" onClick='javascript:location.href="start.jsp"'>
<input type="button" value="내 정보 수정" onClick="change()">
<input type="submit" value="회원탈퇴">
</form>
</body>
</html>
