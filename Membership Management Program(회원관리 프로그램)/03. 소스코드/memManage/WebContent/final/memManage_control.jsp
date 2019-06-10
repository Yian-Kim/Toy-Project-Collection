<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="membership.*, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="db" class="membership.MemberBeanDAO" />
	<jsp:useBean id="member" class="membership.MemberDO" />
	<jsp:setProperty name="member" property="*" />

	<%


	String action = request.getParameter("action");


	if(action.equals("insert")) {		
		if(db.insertDB(member)) {
			System.out.print("성공");
			pageContext.forward("start.jsp");
		}
		else
		throw new Exception("DB 입력오류");
	}
	else if(action.equals("update")) {		
		
	
		member = db.userdata(member);
			
			request.setAttribute("member", member );
			pageContext.forward("memManage_edit_form.jsp");
	}
	
	else if(action.equals("updatedata")) {		
		if(db.update(member)){
			System.out.println("수정 성공!");
			String msg = member.getId() + "\n" + member.getName() + "\n" + member.getPassword()+ "\n";
			out.println("<script>alert('"+msg+"');</script>");
			pageContext.forward("start.jsp");
		}
		else
			out.println("<script>alert('수정 오류!!');history.back();</script>");
	}
	
	else if(action.equals("login")) {		
		if(db.login(member)){
			System.out.println("로그인 성공!");
			request.setAttribute("member", member);
			pageContext.forward("memManage_login.jsp");
		}
		else
			out.println("<script>alert('로그인 오류!!');history.back();</script>");
	}
	
	
	else if(action.equals("delete")) {		
		
		String id = request.getParameter("id");
		
		
		if(db.delete(id)){
			System.out.println("삭제 성공!");
			pageContext.forward("start.jsp");
		}
		else
			out.println("<script>alert('삭제 오류!!');history.back();</script>");
		
	}
%>
</body>
</html>
