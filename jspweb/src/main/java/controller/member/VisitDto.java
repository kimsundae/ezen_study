package controller.member;

public class VisitDto {
	// 1. 필드
	private int vno;	
	private String vwriter;
	private String vpw;		
	private String vcontent;	
	private String vwritedate;
	// 2. 생성자 [ 기본셋팅 : 1.빈생성자 2.풀생성자 3.그 외 추가]
	public VisitDto() {	}
	
	public VisitDto(String vwriter, String vpw, String vcontent) {
		super();
		this.vwriter = vwriter;
		this.vpw = vpw;
		this.vcontent = vcontent;
	}

	
	public VisitDto(int vno, String vwriter, String vcontent, String vwritedate) {
		super();
		this.vno = vno;
		this.vwriter = vwriter;
		this.vcontent = vcontent;
		this.vwritedate = vwritedate;
	}

	public VisitDto(int vno, String vwriter, String vpw, String vcontent, String vwritedate) {
		super();
		this.vno = vno;
		this.vwriter = vwriter;
		this.vpw = vpw;
		this.vcontent = vcontent;
		this.vwritedate = vwritedate;
	}
	// 3. 메소드[ 기본셋팅 : 1.get , set 2.toString() 3.그외추가]
	public int getVno() {
		return vno;
	}
	public void setVno(int vno) {
		this.vno = vno;
	}
	public String getVwriter() {
		return vwriter;
	}
	public void setVwriter(String vwriter) {
		this.vwriter = vwriter;
	}
	public String getVpw() {
		return vpw;
	}
	public void setVpw(String vpw) {
		this.vpw = vpw;
	}
	public String getVcontent() {
		return vcontent;
	}
	public void setVcontent(String vcontent) {
		this.vcontent = vcontent;
	}
	public String getVwritedate() {
		return vwritedate;
	}
	public void setVwritedate(String vwritedate) {
		this.vwritedate = vwritedate;
	}
	@Override
	public String toString() {
		return "VisitDto [vno=" + vno + ", vwriter=" + vwriter + ", vpw=" + vpw + ", vcontent=" + vcontent
				+ ", vwritedate=" + vwritedate + "]";
	}
	
	
	
}
