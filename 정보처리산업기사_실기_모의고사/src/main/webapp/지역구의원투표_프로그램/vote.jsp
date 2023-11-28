<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="./header.jsp" %>
	<div class="wrap">
		<center>
			<h1>투표하기</h1>
			<form name="voteForm" action="./voteLogic.jsp">
				<table>
					<tr>
						<td>주민번호</td><td><input type="text" name="jumin"/>예 : 8906153154726</td>
					</tr>
					<tr>
						<td>성명</td><td><input type="text" name="v_name"/></td>
					</tr>
					<tr>
						<td>투표번호</td>
						<td>
						<select name="m_no">
							<option value="0" selected></option>
							<option value="1">[1] 김후보</option>
							<option value="2">[2] 이후보</option>
							<option value="3">[3] 박후보</option>
							<option value="4">[4] 조후보</option>
							<option value="5">[5] 최후보</option>
						</select></td>
					</tr>
					<tr>
						<td>투표시간</td><td><input type="text" name="v_time"/></td>
					</tr>
					<tr>
						<td>투표장소</td><td><input type="text" name="v_area"/></td>
					</tr>
					<tr>
						<td>유권자확인</td><td><input type="radio" value="Y" name="check"/>확인 <input type="radio" value="N" name="check"/> 미확인</td>
					</tr>
					<tr>
					<td colspan='2'><button type="button" onclick="onVote()">투표하기</button><button type="button" onclick="retry()">다시하기</button></td>
				
					</tr>
				</table>
			</form>
		</center>
	
	</div>
<%@ include file="./footer.jsp" %>
<script>
	function onVote(){
		const voteForm = document.voteForm;
		if( voteForm.jumin.value === '' ){ alert('주민번호가 입력되지 않았습니다!'); voteForm.jumin.focus(); return false;}
		if( voteForm.v_name.value === '' ){ alert('성명이 입력되지 않았습니다!'); voteForm.v_name.focus(); return false;}
		if( voteForm.m_no.value === '0' ){ alert('후보번호가 선택되지 않았습니다!'); voteForm.m_no.focus(); return false;}
		if( voteForm.v_time.value === '' ){ alert('투표시간이 입력되지 않았습니다!'); voteForm.v_time.focus(); return false;}
		if( voteForm.v_area.value === '' ){ alert('투표장소가 입력되지 않았습니다!'); voteForm.v_area.focus(); return false;}
		if( voteForm.check.value === '' ){ alert('유권자확인이 선택되지 않았습니다!'); voteForm.check.focus(); return false;}
		alert('투표하기 정보가 정상적으로 등록되었습니다!')
		voteForm.submit();
	}
	function retry(){
		alert('정보를 지우고 처음부터 다시 입력합니다!')
		const voteForm = document.voteForm;
		voteForm.jumin.value = '';voteForm.v_name.value = ''; voteForm.m_no.value = '';
		 voteForm.v_time.value = '';voteForm.v_area.value = '';voteForm.check[0].checked = false;
		 voteForm.check[1].checked = false;
		voteForm.jumin.focus();
	}
</script>
</body>
</html>