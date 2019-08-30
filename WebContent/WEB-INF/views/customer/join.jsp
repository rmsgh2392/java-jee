<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>은행관리시스템</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div>
	<h2>회원가입</h2>
	<form id="join_form" action="<%=request.getContextPath()%>/member.do">
	<br>아이디<br/> <input type ="text" name="id" /> <br/>	
	<br>비밀번호 <br/> <input type ="text" name="pw" /> <br/>
	<br>이름 <br/> <input type ="text" name="name"/> <br/>
	<br>주민번호<br/> <input type ="text" name="ssn"/> <br/>
	<br>신용도<br/> <input type ="text" name="credit"/> <br/>
	<input type="submit" id="root" value="전송">
	<!-- 
	// id,pw,name,ssn,credit
	                         -->
	</form>





</div>
<script>
$('#join_form').submit(function(){
	alert('테스트 맥락7');
	
});
</script>
</body>
</html>