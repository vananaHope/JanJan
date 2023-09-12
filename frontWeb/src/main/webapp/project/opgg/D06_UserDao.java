package project.opgg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.opgg.VO.User;

public class D06_UserDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public User getUserInfo(String userid) {
	      User userList = new User();
	      String sql = "SELECT * FROM user_info WHERE userid=?";
	      try {
	         con = Z02_OPGG_DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, userid);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 userList = new User(rs.getString("userid"),
	            		rs.getInt("ulevel"), rs.getString("utier"));
	         }

	         rs.close();
	         pstmt.close();
	         con.close();
	      } catch (SQLException e) {
	         System.out.println("DB예외 발생 : " + e.getMessage());
	         Z02_OPGG_DB.rollback(con);
	      } catch (Exception e) {
	         System.out.println("일반 예외 처리 : " + e.getMessage());
	      } finally {
	         Z02_OPGG_DB.close(rs, pstmt, con);
	      }
	      return userList;
	   }
}
