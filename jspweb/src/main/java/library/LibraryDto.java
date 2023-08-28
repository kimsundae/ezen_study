package library;

public class LibraryDto {
   
   // 필드
   private int lno ;
   private String lname ;
   private String lphone;
   private int lseatno;
   private String lindate;
   private String loutdate;
   private boolean lisuse;

   
   
   public LibraryDto(String lname, String lphone, int lseatno, boolean lisuse) {
	super();
	this.lname = lname;
	this.lphone = lphone;
	this.lseatno = lseatno;
	this.lisuse = lisuse;
}



// 생성자
   public LibraryDto() {    }

   
   
   public LibraryDto(int lseatno, boolean lisuse) {
	super();
	this.lseatno = lseatno;
	this.lisuse = lisuse;
}



public LibraryDto(int lno, String lname, String lphone, int lseatno, String lindate, String loutdate,
         boolean lisuse) {
      super();
      this.lno = lno;
      this.lname = lname;
      this.lphone = lphone;
      this.lseatno = lseatno;
      this.lindate = lindate;
      this.loutdate = loutdate;
      this.lisuse = lisuse;
   }

      // 입퇴실 정보 입력시 
   public LibraryDto(String lname, String lphone, int lseatno, String lindate, boolean lisuse) {
      super();
      this.lname = lname;
      this.lphone = lphone;
      this.lseatno = lseatno;
      this.lisuse = lisuse;
   }

   // 메소드
   public int getLno() {
      return lno;
   }

   public void setLno(int lno) {
      this.lno = lno;
   }

   public String getLname() {
      return lname;
   }

   public void setLname(String lname) {
      this.lname = lname;
   }

   public String getLphone() {
      return lphone;
   }

   public void setLphone(String lphone) {
      this.lphone = lphone;
   }

   public int getLseatno() {
      return lseatno;
   }

   public void setLseatno(int lseatno) {
      this.lseatno = lseatno;
   }

   public String getLindate() {
      return lindate;
   }

   public void setLindate(String lindate) {
      this.lindate = lindate;
   }

   public String getLoutdate() {
      return loutdate;
   }

   public void setLoutdate(String loutdate) {
      this.loutdate = loutdate;
   }

   public boolean isLisuse() {
      return lisuse;
   }

   public void setLisuse(boolean lisuse) {
      this.lisuse = lisuse;
   }

   @Override
   public String toString() {
      return "LibraryDto [lno=" + lno + ", lname=" + lname + ", lphone=" + lphone + ", lseatno=" + lseatno
            + ", lindate=" + lindate + ", loutdate=" + loutdate + ", lisuse=" + lisuse + "]";
   }

}