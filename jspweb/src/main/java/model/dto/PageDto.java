package model.dto;

import java.util.ArrayList;

public class PageDto {
	// DB필드X
	
	// 1. 
	private int page; 		// 현재 페이지번호
	private int listsize; 	// 페이지당 최대게시물수
	private int startrow; 	// 현재 페이지에서 시작되는 게시물 번호
	private int totalsize;	// 현재 총 게시물 수	
	private int totalpage;	// 총 페이지 수
	private int startbtn;
	private int endbtn;
	
	// * 게시물 리스트 [ 조회된 결과 ]
	ArrayList<BoardDto> boardList;
	
	// 2. 생성자
	public PageDto() {
	}

	public PageDto(int page, int listsize, int startrow, int totalsize, int totalpage, ArrayList<BoardDto> boardList) {
		super();
		this.page = page;
		this.listsize = listsize;
		this.startrow = startrow;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.boardList = boardList;
	}

	
	
	public PageDto(int page, int listsize, int startrow, int totalsize, int totalpage, int startbtn, int endbtn,
			ArrayList<BoardDto> boardList) {
		super();
		this.page = page;
		this.listsize = listsize;
		this.startrow = startrow;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.startbtn = startbtn;
		this.endbtn = endbtn;
		this.boardList = boardList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getListsize() {
		return listsize;
	}

	public void setListsize(int listsize) {
		this.listsize = listsize;
	}

	public int getStartrow() {
		return startrow;
	}

	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}

	public int getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public ArrayList<BoardDto> getBoardList() {
		return boardList;
	}

	public void setBoardList(ArrayList<BoardDto> boardList) {
		this.boardList = boardList;
	}

	@Override
	public String toString() {
		return "PageDto [page=" + page + ", listsize=" + listsize + ", startrow=" + startrow + ", totalsize="
				+ totalsize + ", totalpage=" + totalpage + ", boardList=" + boardList + "]";
	}			
}
