package model.dto;

import java.util.HashMap;
import java.util.Map;

public class ProductDto {
	int pno; 
    String pname;
    String pcontent;
    int pprice; 
    int pstate;
    String pdate; 
    String plat; 
    String plng; 
    int pcno; 
    int mno; 
    Map< Integer , String > imgList = new HashMap<>();
    String mid; // 제품 등록한 회원 아이디
    public ProductDto() {}
	public ProductDto(int pno, String pname, String pcontent, int pprice, int pstate, String pdate, String plat,
			String plng, int pcno, int mno, Map<Integer, String> imgList, String mid) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pcontent = pcontent;
		this.pprice = pprice;
		this.pstate = pstate;
		this.pdate = pdate;
		this.plat = plat;
		this.plng = plng;
		this.pcno = pcno;
		this.mno = mno;
		this.imgList = imgList;
		this.mid = mid;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getPstate() {
		return pstate;
	}
	public void setPstate(int pstate) {
		this.pstate = pstate;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public String getPlat() {
		return plat;
	}
	public void setPlat(String plat) {
		this.plat = plat;
	}
	public String getPlng() {
		return plng;
	}
	public void setPlng(String plng) {
		this.plng = plng;
	}
	public int getPcno() {
		return pcno;
	}
	public void setPcno(int pcno) {
		this.pcno = pcno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public Map<Integer, String> getImgList() {
		return imgList;
	}
	public void setImgList(Map<Integer, String> imgList) {
		this.imgList = imgList;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "ProductDto [pno=" + pno + ", pname=" + pname + ", pcontent=" + pcontent + ", pprice=" + pprice
				+ ", pstate=" + pstate + ", pdate=" + pdate + ", plat=" + plat + ", plng=" + plng + ", pcno=" + pcno
				+ ", mno=" + mno + ", imgList=" + imgList + ", mid=" + mid + "]";
	}
     
}
