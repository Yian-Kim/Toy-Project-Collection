<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function admin() {
			document.form1.action.value="admin";
			document.form1.submit();
		
	}
</script>
</head>
<body>
<form name=form1 method=post action=memManage_control.jsp>
<input type=hidden name="action" value="login">
아이디 : <input type=text name=id size=15></br>
비밀번호 : <input type=text name=password size=15></br>
<input type="submit" value="로그인" >
<input type="button" value="회원가입" onClick='javascript:location.href="memManage_join.jsp" '>
<input type="button" value="관리자로그인" onClick="admin()">
</form>
</body>
</html>
