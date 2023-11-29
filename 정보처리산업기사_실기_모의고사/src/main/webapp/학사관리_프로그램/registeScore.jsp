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
			<h2>성적입력</h2>
			<form name="scoreForm" action="./registeScoreLogic.jsp">
				<table>
					<tr>
						<td>학번</td><td><input type="text" name="sno"/></td>
					</tr>
					<tr>
						<td>국어점수</td><td><input type="text" name="ekor"/></td>
					</tr>
					<tr>
						<td>수학점수</td><td><input type="text" name="emath"/></td>
					</tr>
					<tr>
						<td>영어점수</td><td><input type="text" name="eeng"/></td>
					</tr>
					<tr>
						<td>역사점수</td><td><input type="text" name="ehist"/></td>
					</tr>
					<tr>
						<td colspan="2"><button type="button" onclick="onRegisteScore()">등록하기</button></td>
					</tr>
				</table>
			</form>
		</center>
	
	</div>
	<%@ include file="./footer.jsp" %>
	<script>
		function onRegisteScore(){
			let formData = document.scoreForm;
			
			if(formData.sno.value === ''){alert('학생번호가 입력되지 않았습니다.'); formData.sno.focus();return false;}
			if(formData.ekor.value === ''){alert('국어점수가 입력되지 않았습니다.'); formData.ekor.focus();return false;}
			if(formData.emath.value === ''){alert('수학점수가 입력되지 않았습니다.'); formData.emath.focus();return false;}
			if(formData.eeng.value === ''){alert('영어점수가 입력되지 않았습니다.'); formData.eeng.focus();return false;}
			if(formData.ehist.value === ''){alert('역사점수가 입력되지 않았습니다.'); formData.ehist.focus();return false;}
			
			alert('학생 성적이 모두 입력되었습니다.')
			formData.submit();
			
		}
	
	</script>
</body>
</html>