
// * 게시판상세페이지, 제품상세페이지 등등에서는 클릭된 식별자[제품번호]
// URL(인터넷주소) 에서 매개변수 
let pno = new URL( location.href ).searchParams.get("pno");
// new URL( location.href ).searchParams.get("키")
// <a href="/jspweb/product/View.jsp?키=값&키=값&=값">"

findByPno(pno)
// 1. pno에 해당하는 제품 1개 호출
function findByPno( pno ){
		$.ajax({
		url: "/jspweb/ProductInfoController",
		method: "get",
		data : {type:'findByPno',pno: pno},
		success: r=>{
			
			// ------------ 캐러셀에 이미지 여러개 대입
			let imgbox = document.querySelector('.imgbox')
			
			let html = ``;
			
			Object.values( r.imgList ).forEach( (img,i) =>{
				
				html += `			   
				 <div class="carousel-item ${ i == 0 ? 'active' : ''}"> <!-- carousel-item : 이미지1개당 -->
			      <img src="/jspweb/product/img/${img}" class="d-block w-100" alt="...">
			    </div>`			
			})
			imgbox.innerHTML = html;
		},
		error: e=>{console.log(e)}
	})
	
	
}

