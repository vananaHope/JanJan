package project.JanJan.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.JanJan.DB;
import project.JanJan.VO.Snack;

public class SnackDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List<Snack> getAllList_s(){
		List<Snack> sall = new ArrayList<Snack>();
		String sql = "select * from snack";
				
		try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 sall.add(new Snack(
	        			 rs.getString(1),
		 	        	 rs.getString(2),
		 	        	 rs.getInt(3),
		 	        	 rs.getString(4),
		 	        	 rs.getString(5),
		 	        	 rs.getString(6),
		 	        	 rs.getString(7)
	        	));
	         }
	         rs.close();
	         pstmt.close();
	         con.close();
	      } catch (SQLException e) {
	         System.out.println("DB예외 발생 : " + e.getMessage());
	         DB.rollback(con);
	      } catch (Exception e) {
	         System.out.println("일반 예외 처리 : " + e.getMessage());
	      } finally {
	         DB.close(rs, pstmt, con);
	      }		
		
		return sall;
	}
	
	public List<Snack> getFilter_s(int p1, int p2, String s) {
		List<Snack> sn = new ArrayList<Snack>();
		String sql = "select * from snack where snack_price between ? and ?"
				+ "and category_name = ?";
		try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, p1);
	         pstmt.setInt(2, p2);
	         pstmt.setString(3, s);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 sn.add(new Snack(
	        			 rs.getString(1),
		 	        	 rs.getString(2),
		 	        	 rs.getInt(3),
		 	        	 rs.getString(4),
		 	        	 rs.getString(5),
		 	        	 rs.getString(6),
		 	        	 rs.getString(7)
	        	));
	         }
	         rs.close();
	         pstmt.close();
	         con.close();
	      } catch (SQLException e) {
	         System.out.println("DB예외 발생 : " + e.getMessage());
	         DB.rollback(con);
	      } catch (Exception e) {
	         System.out.println("일반 예외 처리 : " + e.getMessage());
	      } finally {
	         DB.close(rs, pstmt, con);
	      }	
		
		return sn;
	}

	public List<Snack> getPriceFilter_s(int p1, int p2) {
		List<Snack> sn = new ArrayList<Snack>();
		String sql = "select * from snack where snack_price between ? and ?";
		try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, p1);
	         pstmt.setInt(2, p2);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 sn.add(new Snack(
	        			 rs.getString(1),
		 	        	 rs.getString(2),
		 	        	 rs.getInt(3),
		 	        	 rs.getString(4),
		 	        	 rs.getString(5),
		 	        	 rs.getString(6),
		 	        	 rs.getString(7)
	        	));
	         }
	         rs.close();
	         pstmt.close();
	         con.close();
	      } catch (SQLException e) {
	         System.out.println("DB예외 발생 : " + e.getMessage());
	         DB.rollback(con);
	      } catch (Exception e) {
	         System.out.println("일반 예외 처리 : " + e.getMessage());
	      } finally {
	         DB.close(rs, pstmt, con);
	      }	
		
		return sn;
	}

	public List<Snack> getTypeFilter_s(String s) {
		List<Snack> sn = new ArrayList<Snack>();
		String sql = "select * from Snack where category_name = ?";
		try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, s);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 sn.add(new Snack(
	        			 rs.getString(1),
		 	        	 rs.getString(2),
		 	        	 rs.getInt(3),
		 	        	 rs.getString(4),
		 	        	 rs.getString(5),
		 	        	 rs.getString(6),
		 	        	 rs.getString(7)
	        	));
	         }
	         rs.close();
	         pstmt.close();
	         con.close();
	      } catch (SQLException e) {
	         System.out.println("DB예외 발생 : " + e.getMessage());
	         DB.rollback(con);
	      } catch (Exception e) {
	         System.out.println("일반 예외 처리 : " + e.getMessage());
	      } finally {
	         DB.close(rs, pstmt, con);
	      }	
		
		return sn;
	}
}
