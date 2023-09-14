package model.dao;


import java.sql.Statement;

import model.dto.ProductDto;

public class ProductDao extends Dao{
	private static ProductDao productDao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() {return productDao;}
	
	// 1. 제품 등록
	public boolean register( ProductDto productDto ) {
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
	// 2. 제품 전체 출력
	
	// 3. 제품 개별 조회
	
	// 4. 제품 수정
	
	// 5. 제품 삭제	
}
