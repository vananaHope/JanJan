package project.JanJan.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.JanJan.VO.Alcohol;
import project.JanJan.DB;

public class AlcoholDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List<Alcohol> getAllList(){
		List<Alcohol> al = new ArrayList<Alcohol>();
		String sql = "select * from alcohol";
				
		try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 al.add(new Alcohol(
	        			 rs.getString(1),
		 	        	 rs.getString(2),
		 	        	 rs.getInt(3),
		 	        	 rs.getInt(4),
		 	        	 rs.getInt(5),
		 	        	 rs.getString(6),
		 	        	 rs.getString(7),
		 	        	 rs.getString(8),
		 	        	 rs.getString(9),
		 	        	 rs.getString(10)
	        			 
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
		
		return al;
	}
	
	public List<Alcohol> getFilter(int p1, int p2, String s) {
		List<Alcohol> al = new ArrayList<Alcohol>();
		String sql = "select * from alcohol where alcohol_price between ? and ?"
				+ "and type_name = ?";
		try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, p1);
	         pstmt.setInt(2, p2);
	         pstmt.setString(3, s);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 al.add(new Alcohol(
	        			 rs.getString(1),
		 	        	 rs.getString(2),
		 	        	 rs.getInt(3),
		 	        	 rs.getInt(4),
		 	        	 rs.getInt(5),
		 	        	 rs.getString(6),
		 	        	 rs.getString(7),
		 	        	 rs.getString(8),
		 	        	 rs.getString(9),
		 	        	 rs.getString(10)
	        			 
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
		
		return al;
	}

	public List<Alcohol> getPriceFilter(int p1, int p2) {
		List<Alcohol> al = new ArrayList<Alcohol>();
		String sql = "select * from alcohol where alcohol_price between ? and ?";
		
		try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, p1);
	         pstmt.setInt(2, p2);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 al.add(new Alcohol(
	        			 rs.getString(1),
		 	        	 rs.getString(2),
		 	        	 rs.getInt(3),
		 	        	 rs.getInt(4),
		 	        	 rs.getInt(5),
		 	        	 rs.getString(6),
		 	        	 rs.getString(7),
		 	        	 rs.getString(8),
		 	        	 rs.getString(9),
		 	        	 rs.getString(10)
	        			 
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
		
		return al;
	}

	public List<Alcohol> getTypeFilter(String s) {
		List<Alcohol> al = new ArrayList<Alcohol>();
		String sql = "select * from alcohol where type_name = ?";
		
		try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, s);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 al.add(new Alcohol(
	        			 rs.getString(1),
		 	        	 rs.getString(2),
		 	        	 rs.getInt(3),
		 	        	 rs.getInt(4),
		 	        	 rs.getInt(5),
		 	        	 rs.getString(6),
		 	        	 rs.getString(7),
		 	        	 rs.getString(8),
		 	        	 rs.getString(9),
		 	        	 rs.getString(10)
	        			 
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
		
		return al;
	}
	
	
}
