package model.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import model.dto.ProductDto;

public class ProductDao extends Dao{
	private static ProductDao productDao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() {return productDao;}
	
	// 1. 제품 등록
	public boolean register( ProductDto productDto ) {
		System.out.println("실행");
		// 1-1 
		try {
			String sql = "insert into product( pcno, pname, pcontent, pprice , plat, plng,mno)"
					+ " values( ? , ? , ? , ? , ? , ? , ? )";
			
			// * sql insert 후 자동생성[auto_increment]된 pk번호를 반환하는 방법
				// .prepareStatement( sql, Statement.RETURN_GENERATED_KEYS ) // 생성된 식별키를 반환
				// ps.getGeneratedKeys()									// 식별된 생성키를 반환
			ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1 , productDto.getPcno());
			ps.setString(2 , productDto.getPname());
			ps.setString(3 , productDto.getPcontent());
			ps.setInt(4 , productDto.getPprice());
			ps.setString(5 , productDto.getPlat());
			ps.setString(6 , productDto.getPlng());
			ps.setInt(7 , productDto.getMno());
			
			int count = ps.executeUpdate();
			System.out.println(count);
			rs = ps.getGeneratedKeys();
			rs.next();
			if( count == 1) { //		
				// 1-2 제품 등록 후 생성된 제품pk를 가지고[이미지 등록]
					// 1. dto에 저장된 이미지 개수만큼
						// Map<Integer,String>	: map객체명.keySet() : map객체내 모든 키 호출
						// ---- get(i) : map컬렉션 set컬렉션은 인덱스 없음.
				for( String img : productDto.getImgList().values() ) {
					sql = "insert into productimg( pimg,pno ) values( ?, ? )";
					ps = conn.prepareStatement(sql);
					ps.setString(1, img);
					ps.setInt(2, rs.getInt(1) );
					ps.executeUpdate(); 				
				}			
				return true;
			}
		}catch(Exception e) {e.printStackTrace();}
		return false;	
	}
	// 4. 제품 전체 출력
	public List<ProductDto> findByAll(){
		try {
			List<ProductDto> list = new ArrayList<>();			
			String sql = "select * from product";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {list.add( findByPno( rs.getInt("pno")));} return list; 
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// 0. 제품에 해당하는 이미지 출력하는 함수
	public Map<Integer, String > getProductImg( int pno ){
		try {
			Map<Integer , String > imgList = new HashMap<>(); // 제품별 여러개 이미지
			String sql = "select * from productimg where pno = " + pno;
			ps  = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) { imgList.put(rs.getInt("pimgno") , rs.getString("pimg"));} return imgList;	
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	// 3. 제품 조회
		public ProductDto findByPno( int pno ) {
			try {
				String sql = "select * from product p natural join pcategory pc natural join member m where p.pno = "+pno;
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					ProductDto productDto = new ProductDto(
							rs.getInt("pcno"), rs.getString("pcname"),
							rs.getInt("pno") , rs.getString("pname"),
							rs.getString("pcontent") , rs.getInt("pprice"),
							rs.getInt("pstate"), rs.getString("pdate"),
							rs.getString("plat") , rs.getString("plng"),
							rs.getInt("mno"), getProductImg(rs.getInt("pno")) , rs.getString("mid")
							);
						return productDto;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	// 1. N개 최신순 출력
	public List<ProductDto> findByTop( int count ){
		try {
			List<ProductDto> list = new ArrayList<>();
			String sql = "select * from product order by pdate desc limit "+ count;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {list.add( findByPno( rs.getInt("pno")));} return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 범위 만큼 출력
	public List<ProductDto> findByLatLng(String east, String west, String south, String north){
		try {	
			System.out.println(east + " " + west + " " + south + " " + north);
			List<ProductDto> list = new ArrayList<>();
			// 동 경도보다 크고 서 경도보다 작고 남 위도보다 크고 북 위도 보다 작고
			String sql = "select * from product where  ? >= plng and ? <= plng and ? <= plat and ? >= plat   order by pdate";
			ps = conn.prepareStatement(sql);
			ps.setString(1, east); ps.setString(2, west); ps.setString(3, south); ps.setString(4, north);
			rs = ps.executeQuery();
			while( rs.next() ) {System.out.println(rs.getInt("pno")); list.add( findByPno( rs.getInt("pno")));} return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 4. 제품 수정
	
	// 5. 제품 삭제	
}
