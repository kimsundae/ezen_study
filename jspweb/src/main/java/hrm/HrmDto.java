package hrm;

import model.dao.Dao;

public class HrmDto {
	private int hno;
	private String hname; 
	private String hphone;
	private String hrank; 
	private String himg;
	private String hindate;
	
	public HrmDto() {
		// TODO Auto-generated constructor stub
	}

	
	public HrmDto(String hname, String hphone, String hrank, String himg, String hindate) {
		super();
		this.hname = hname;
		this.hphone = hphone;
		this.hrank = hrank;
		this.himg = himg;
		this.hindate = hindate;
	}


	public HrmDto(String hname, String hphone, String hrank, String himg) {
		super();
		this.hname = hname;
		this.hphone = hphone;
		this.hrank = hrank;
		this.himg = himg;
	}


	public HrmDto(int hno, String hname, String hphone, String hrank, String himg, String hindate) {
		super();
		this.hno = hno;
		this.hname = hname;
		this.hphone = hphone;
		this.hrank = hrank;
		this.himg = himg;
		this.hindate = hindate;
	}


	public int getHno() {
		return hno;
	}


	public void setHno(int hno) {
		this.hno = hno;
	}


	public String getHname() {
		return hname;
	}


	public void setHname(String hname) {
		this.hname = hname;
	}


	public String getHphone() {
		return hphone;
	}


	public void setHphone(String hphone) {
		this.hphone = hphone;
	}


	public String getHrank() {
		return hrank;
	}


	public void setHrank(String hrank) {
		this.hrank = hrank;
	}


	public String getHimg() {
		return himg;
	}


	public void setHimg(String himg) {
		this.himg = himg;
	}


	public String getHindate() {
		return hindate;
	}


	public void setHindate(String hindate) {
		this.hindate = hindate;
	}


	@Override
	public String toString() {
		return "HrmDto [hno=" + hno + ", hname=" + hname + ", hphone=" + hphone + ", hrank=" + hrank + ", himg=" + himg
				+ ", hindate=" + hindate + "]";
	}
	
	
	
	
	
}
