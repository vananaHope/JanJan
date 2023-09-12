package project.JanJan.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.JanJan.DB;
import project.JanJan.VO.Bag;

public class BagDao {
	private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
	public List<Bag> getBags(String id) {
	    List<Bag> blist = new ArrayList<Bag>();
	    String sql = "SELECT product_name, cnt, TOTAL_PRICE\r\n"
	    		+ "FROM CART where memid = ?";
	    System.out.println("# DB 접속 #");
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql); 
	        pstmt.setString(1, id);
	        rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	blist.add(new Bag(
	        			rs.getInt("CNT"),
	        			rs.getInt("TOTAL_PRICE"),
	        			rs.getString("PRODUCT_NAME")
	        			
	            ));
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 관련 오류: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }
	    return blist;
	}
	// INSERT INTO cart1 VALUES ('C-'||cart_seq.nextval, 1, 5900, '신애유자', 'vanana')
	public void insBag(Bag ins) {
		
		String sql = "INSERT INTO CART(cart_num,cnt,total_price,product_name,memid)"
				+ "VALUES ('C-'||cart_seq.nextval, ?, ?, ?, ?)";
		
	    try {
	        con = DB.con();
	        con.setAutoCommit(false);
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, ins.getCnt());
	        pstmt.setInt(2, ins.getTotalPrice());
	        pstmt.setString(3, ins.getProductName());
	        pstmt.setString(4, ins.getMemId());
	        int result = pstmt.executeUpdate();
	        if (result == 1) {
	            con.commit();
	            System.out.println("등록 성공");
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 오류: " + e.getMessage());
	        DB.rollback(con);
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }
	}

}
