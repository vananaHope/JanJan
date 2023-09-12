package project.opgg;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import project.opgg.VO.Champion;

public class D02_ChampionDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<Champion> ChampionSearch() {
		List<Champion> championList = new ArrayList<Champion>();
		String sql = "select * from cham_info";// sql문 입력
		try {
			con = Z02_OPGG_DB.con();
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				championList.add(new Champion(rs.getString("chamid"), 
											rs.getString("chamimg")));
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
		return championList;
	}

	   public String getChamImg(String chamId) {
		      String chamImg = "";
		      String sql = "select chamimg from cham_info where chamid=?";// sql문 입력
		      try {
		         con = Z02_OPGG_DB.con();
		         pstmt = con.prepareStatement(sql);
		         pstmt.setString(1, chamId);
		         rs = pstmt.executeQuery();
		         while(rs.next())
		         {
		            chamImg = rs.getString("chamimg");
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

		      return chamImg;
		   }
	
	public static void main(String args[]) {
		D02_ChampionDao dao = new D02_ChampionDao();
		List<Champion> champInfo = dao.ChampionSearch();
		for(Champion c : champInfo) {
			System.out.println("championId : "+c.getChamId());
			System.out.println("championimg : "+c.getChamImg());
		}
	}
	
}
