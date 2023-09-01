package model.dto;

public class BoardDto { // 게시물 , 카테고리   

	// 필드
	private int bno;
	private String btitle;
	private String bcontent;
	private String bimg;
	private String bwriteTime;
	private int bview;
	private int mno;
	private int cno; 
	// - 게시물에 추가적으로 표시할 필드들
	private String mid; // 작성자 회원아이디
	private String bcname; // 카테고리명
	
	// 생성자
	public BoardDto() {}
	// 생성자 [ 1.빈생성자 2.풀생성자 3.(추후에)작업하면 필요한 생성자들 ]
	public BoardDto(int bno, String btitle, String bcontent, String bimg, String bwriteTime, int bview, int mno,
			int cno, String mid, String bcname) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bimg = bimg;
		this.bwriteTime = bwriteTime;
		this.bview = bview;
		this.mno = mno;
		this.cno = cno;
		this.mid = mid;
		this.bcname = bcname;
	}
	
	

	public BoardDto(String btitle, String bcontent, String bimg, int mno, int cno) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bimg = bimg;
		this.mno = mno;
		this.cno = cno;
	}
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBimg() {
		return bimg;
	}

	public void setBimg(String bimg) {
		this.bimg = bimg;
	}

	public String getBwriteTime() {
		return bwriteTime;
	}

	public void setBwriteTime(String bwriteTime) {
		this.bwriteTime = bwriteTime;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getBcname() {
		return bcname;
	}

	public void setBcname(String bcname) {
		this.bcname = bcname;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bimg=" + bimg
				+ ", bwriteTime=" + bwriteTime + ", bview=" + bview + ", mno=" + mno + ", cno=" + cno + ", mid=" + mid
				+ ", bcname=" + bcname + "]";
	}	
}
