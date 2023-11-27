package 홈쇼핑_회원관리_프로그램;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao {
	
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Dao() {
		try {
		
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection
			 ("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
			System.out.println("연동성공");
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	public boolean registe( Object...data ) {
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
		System.out.println(data[3]);
		System.out.println(data[4]);
		System.out.println(data[5]);
		System.out.println(data[6]);
		try {
			ps = conn.prepareStatement("insert into member_tbl_02( custno, custname, phone, address, joindate, grade, city )"
					+ " values( ?, ?, ?, ?, ?, ?, ? )");
			ps.setString(1, (String)data[0]);
			ps.setString(2, (String)data[1]);
			ps.setString(3, (String)data[2]);
			ps.setString(4, (String)data[3]);
			ps.setString(5, (String)data[4]);
			ps.setString(6, (String)data[5]);
			ps.setString(7, (String)data[6]);
			return ps.executeUpdate() == 1;
		}catch(Exception e) {e.printStackTrace();}
		
		
		return false;
	}
	public int lastCustno() {
		try {
			ps = conn.prepareStatement("select max(custno) from member_tbl_02 ");
			rs = ps.executeQuery();
			if( rs.next() ) return rs.getInt(1);
		}catch(Exception e) {e.printStackTrace();}
		return 0;
	}
	public List<Map<String,String>> getList(){
		try {
			List<Map<String,String>> list = new ArrayList<Map<String,String>>();
			ps = conn.prepareStatement("select * from member_tbl_02 ");
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new HashMap<String,String>() {{
					put("custno",rs.getString(1)); put("custname",rs.getString(2));
					put("phone",rs.getString(3)); put("address",rs.getString(4));
					put("joindate",rs.getString(5)); put("grade",rs.getString(6));
					put("city",rs.getString(7));
				}});
				
			}
			return list;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	public List<Map<String,String>> getMoneyList(){
		try {
			List<Map<String,String>> list = new ArrayList<Map<String,String>>();
			ps = conn.prepareStatement("select "
					+ "me.custno, "
					+ "me.custname, "
					+ "me.grade, sum(mo.price) "
					+ "from member_tbl_02 me inner join money_tbl_02 mo on me.custno = mo.custno "
					+ "group by (me.custno, me.custname, me.grade ) order by sum(mo.price) desc ");
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new HashMap<String,String>() {{
					put("custno",rs.getString(1)); put("custname",rs.getString(2));
					put("grade",rs.getString(3)); put("sum",rs.getString(4));
				}});
			}
			return list;
		}catch(Exception e) {e.printStackTrace();}
		return null;
		
	}
	public Map<String, String> getMember(int custno){
		try {
			rs = conn.prepareStatement("select * from member_tbl_02 where custno = "+ custno).executeQuery();
			if( rs.next() ) 
				return new HashMap<String, String>(){{
					put("custno",rs.getString(1)); put("custname",rs.getString(2));
					put("phone",rs.getString(3)); put("address",rs.getString(4));
					put("joindate",rs.getString(5)); put("grade",rs.getString(6));
					put("city",rs.getString(7));
				}};
				
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	public boolean onUpdate( String...data ) {
		try {
			ps = conn.prepareStatement("update member_tbl_02 set"
					+ " custno = ?, custname = ?, phone = ?, address = ?, joindate = ?, grade = ?, city = ? "
					+ "where custno = ? ");
			ps.setString(1, data[0]);
			ps.setString(2, data[1]);
			ps.setString(3, data[2]);
			ps.setString(4, data[3]);
			ps.setString(5, data[4]);
			ps.setString(6, data[5]);
			ps.setString(7, data[6]);
			ps.setString(8, data[7]);
			return ps.executeUpdate() == 1;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
}
