

function register1(){
	
	$.ajax({
		url : "/jspweb/ProductController",
		method : "post",
		data : {
			pname1 : document.querySelector('.pname1').value,
			pcontent1 : document.querySelector('.pcontent1').value		
		} ,
		success : r=>{console.log(r)},
		error : e=>{console.log(e)}
	});
}

function register2(){
	let registerForm1 = document.querySelectorAll('.registerForm1')[0];
	let formData = new FormData(registerForm1);
	
	$.ajax({ // [form 태그 이용하는 경우 2 - 첨부파일 없음]
		url : "/jspweb/ProductController",
		method : "post",
		data :formData ,
		contentType : false,
		processData : false,
		success : r=>{console.log(r)},
		error : e=>{console.log(e)}
	});
}