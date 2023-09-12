package project.opgg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.opgg.VO.Rune;
import project.opgg.VO.Spell;

public class D04_SpellDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<Spell> spellSearch() {
		List<Spell> spellList = new ArrayList<Spell>();
		String sql = "select * from spell_info";
		try {
			con = Z02_OPGG_DB.con();
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				spellList.add(new Spell(rs.getString("spellid"), 
										rs.getString("spellimg")));
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
		return spellList;
	}
	
}
