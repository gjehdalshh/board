<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
<c:if test="${param.i_board == 0}">
글등록
</c:if>
<c:if test="${param.i_board > 0}">
글수정
</c:if>
</title>
</head>
<body>
	<div>
		<div style="color:red;">${msg}</div>
	
		<form action="/v3/bRegMod" method="post" id="frm" onsubmit="return chk();">
			<div>
				<input type="hidden" name="i_board" value="${param.i_board}">
			</div>
			<div>
				제목 : <input type="text" name="title" value="${item.title}">
			</div>
			<div>
				내용 : <textarea name="ctnt">${item.ctnt}</textarea>
			</div>
			<div>
				<c:if test="${param.i_board == 0}">
					<input type="submit" value="글등록">
				</c:if>
				<c:if test="${param.i_board > 0}">
					<input type="submit" value="글수정">
				</c:if>
			</div>
		</form>
	</div>
	<script>
		
		function chk()
		{
			console.log('chk() called');
			var frm = document.querySelector('#frm'); // form 전체가 넘어옴
			// var frm = document.getElementNyId('frm'); 이렇게도 가능
			if(frm.title.value == '')
				{
				alert('제목을 입력해 주세요.');	// alert : 창을 띄워줌
				frm.title.focus();	// focus() : 위치로 포커스 이동
				return false;
				}
			else if(frm.ctnt.value == '')
				{
				alert('내용을 입력해 주세요.');
				frm.ctnt.focus();
				return false;
				}
		}
	</script>
</body>
</html>