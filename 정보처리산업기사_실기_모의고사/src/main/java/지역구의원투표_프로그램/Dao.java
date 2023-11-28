package 지역구의원투표_프로그램;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","1234" );
		System.out.println("연동 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Map<String, String>> getMemberList(){
		try {
			List<Map<String, String>> list = new ArrayList<>();
			rs = conn.prepareStatement("select m.m_no, m.m_name, p.p_name, m.p_school, "
					+ "m.m_jumin, m.m_city, p.p_tel1, p.p_tel2, p.p_tel3 "
					+ "from tbl_member_202005 m inner join tbl_party_202005 p on "
					+ "m.p_code = p.p_code").executeQuery();
			while(rs.next()) {
				list.add( new HashMap<String, String>(){{
					put( "m_no",rs.getString(1) ); put("m_name", rs.getString(2));
					put( "p_name", rs.getString(3)); put("p_school", rs.getString(4));
					put( "m_jumin", rs.getString(5)); put("m_city", rs.getString(6));
					put( "p_tel1", rs.getString(7)); put("p_tel2", rs.getString(8));
					put( "p_tel3", rs.getString(9)); 
				}});
			}
			return list;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	public boolean onVote( String...data ) {
		try {
			ps = conn.prepareStatement("insert into TBL_VOTE_202005("
				+ "	v_jumin, v_name, m_no, v_time, v_area, v_confirm "
					+ ") values( ?, ?, ?, ?, ?, ? ) " );
			ps.setString(1, data[0]); ps.setString(2, data[1]);
			ps.setString(3, data[2]); ps.setString(4, data[3]);
			ps.setString(5, data[4]); ps.setString(6, data[5]);
			return ps.executeUpdate() == 1;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	public List<Map<String,String>> voteList(){
		try {
			List<Map<String,String>> list = new ArrayList<>();
			rs = conn.prepareStatement("select * from tbl_vote_202005 where v_area = '제1투표장'").executeQuery();
			while(rs.next()) {
				list.add( new HashMap<String, String>(){{
					put( "v_jumin",rs.getString(1) ); put("v_name", rs.getString(2));
					put( "m_no", rs.getString(3)); put("v_time", rs.getString(4));
					 put("v_confirm", rs.getString(6));
				}});
			}
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Map<String,String>> getNoList(){
		try {
			List<Map<String,String>> list = new ArrayList<>();
			rs = conn.prepareStatement("select v.m_no, m.m_name, count(v.m_no) "
			+ "from tbl_vote_202005 v inner join tbl_member_202005 m on v.m_no = m.m_no "
			+ "where v.v_confirm = 'Y'"
			+ " group by (v.m_no, m.m_name ) order by count(v.m_no) desc").executeQuery();
			while(rs.next()) {
				list.add( new HashMap<String, String>(){{
					put( "m_no",rs.getString(1) ); put("m_name", rs.getString(2));
					put( "count", rs.getString(3)); 
				}});
			}
			return list;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
	
}
