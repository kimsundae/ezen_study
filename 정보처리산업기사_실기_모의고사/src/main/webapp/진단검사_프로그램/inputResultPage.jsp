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
		<center><h2>검사결과입력</h2>
		
		<form name="registeForm" action="./registeLogic.jsp">
			<table>
				<tr>
					<td>환자번호</td><td><input type="text" name="p_no"/>예)1001</td>
				</tr>
				<tr>
					<td>검사코드</td>
					<td>
						<select name="t_code">
							<option value="" selected>검사명</option>
							<option value="T001">[T1001]결핵</option>	
							<option value="T002">[T1002]장티푸스</option>
							<option value="T003">[T1003]수두</option>
							<option value="T004">[T1004]홍역</option>
							<option value="T005">[T1005]콜레라</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>검사시작일자</td><td><input type="text" name="t_sdate"/>예)1001</td>
				</tr>
				<tr>
					<td>검사상태</td><td><input type="radio" name="checkStatus" value="1">검사중<input type="radio" name="checkStatus" value="2">검사완료</td>
				</tr>
				<tr>
					<td>검사완료일자</td><td><input type="text" name="t_ldate"/>예)20200101</td>
				</tr>
				<tr>
					<td>검사결과</td><td><input type="radio" name="checkResult" value="X"/>미입력<input type="radio" name="checkResult" value="P"/>양성
					<input type="radio" name="checkResult" value="N"/>음성</td>
				</tr>	
				<tr>
					<td colspan="2"><button type="button" onclick="registe()" >검사결과등록</button><button type="button" onclick="resetInput()">다시쓰기</button></td>
				</tr>
			</table>
		</form>
		</center>
	</div>
	<script>
		function registe(){
			
			let formData = document.registeForm;

			if(formData.p_no.value === ''){ alert('환자 번호가 입력되지 않았습니다.'); formData.p_no.focus(); return false;  }
			if(formData.t_code.value === ''){ alert('검사명이 입력되지 않았습니다.'); formData.t_code.focus(); return false;  }
			if(formData.t_sdate.value === ''){ alert('검사 시작일자가 입력되지 않았습니다.'); formData.t_sdate.focus(); return false;  }
			if(!formData.checkStatus[0].checked && !formData.checkStatus[1].checked){ alert('검사상태가 입력되지 않았습니다.'); formData.checkStatus.focus(); return false;  }
			if(formData.t_ldate.value === ''){ alert('검사 완료 일자가 입력되지 않았습니다.'); formData.t_ldate.focus(); return false;  }
			if(!formData.checkResult[0].checked && !formData.checkResult[1].checked &&
					!formData.checkResult[2].checked 	){ alert('검사결과가 입력되지 않았습니다.'); formData.checkResult.focus(); return false;  }

			alert('검색 결과가 정상적으로 등록되었습니다.');
			formData.submit();
		}
		function resetInput(){
			alert('정보를 지우고 처음부터 다시 입력합니다.')
			let formData = document.registeForm;
			formData.p_no.value = '';formData.t_code.value = ''
			formData.t_sdate.value = ''
			formData.t_ldate.value = ''
			formData.checkStatus[0].checked = false; formData.checkStatus[1].checked = false;
			formData.checkResult[0].checked = false; formData.checkResult[1].checked = false;
			formData.checkResult[2].checked = false; 	
			formData.p_no.focus();
		}
	</script>
	<%@ include file="./footer.jsp" %>
</body>
</html>