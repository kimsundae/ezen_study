package model.dto;

public class mpointDto {
	private String mpno;						
	private int mno; 				
    private long mpamount; 
    private String mpcomment;		
    private String mpdata;
    
    public mpointDto() {}

	public String getMpno() {
		return mpno;
	}

	public void setMpno(String mpno) {
		this.mpno = mpno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public long getMpamount() {
		return mpamount;
	}

	public void setMpamount(long mpamount) {
		this.mpamount = mpamount;
	}

	public String getMpcomment() {
		return mpcomment;
	}

	public void setMpcomment(String mpcomment) {
		this.mpcomment = mpcomment;
	}

	public String getMpdata() {
		return mpdata;
	}

	public void setMpdata(String mpdata) {
		this.mpdata = mpdata;
	}

	@Override
	public String toString() {
		return "mpointDto [mpno=" + mpno + ", mno=" + mno + ", mpamount=" + mpamount + ", mpcomment=" + mpcomment
				+ ", mpdata=" + mpdata + "]";
	}
    
		   
}
