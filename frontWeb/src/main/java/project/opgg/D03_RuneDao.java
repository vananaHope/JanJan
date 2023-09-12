package project.opgg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.opgg.VO.Rune;

public class D03_RuneDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<Rune> runeSearch() {
		List<Rune> runeList = new ArrayList<Rune>();
		String sql = "SELECT * FROM RUNE_INFO";
		try {
			con = Z02_OPGG_DB.con();
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				runeList.add(new Rune(rs.getString("runeid"), 
									rs.getString("runeimg")));
			}
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("DB예외 발생 : "+e.getMessage());
			Z02_OPGG_DB.rollback(con);
		} catch (Exception e) {
			System.out.println("일반 예외 처리 : "+e.getMessage());
		} finally {
			Z02_OPGG_DB.close(rs, pstmt, con);
		}
		return runeList;
	}
	
}
