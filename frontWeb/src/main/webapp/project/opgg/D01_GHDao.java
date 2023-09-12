package project.opgg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.opgg.VO.ContentTeamHistory;
import project.opgg.VO.GameHistory;
import project.opgg.VO.RecentGameHistory;
import project.opgg.VO.User;

public class D01_GHDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
   public List<RecentGameHistory> getRecentGameHistory(String userId) { // 메소드명 변경
         List<RecentGameHistory> userRGHlist = new ArrayList<RecentGameHistory>();

         String sql = "SELECT chamid, pos, kill, death, assist, kda, iswin FROM "
         		+ "(SELECT * FROM GAME_HISTORY WHERE userid=? "
         		+ "ORDER BY end_time desc) WHERE rownum<=20 ORDER BY chamid";// sql문 입력
         try {
            con = Z02_OPGG_DB.con();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
               userRGHlist.add(new RecentGameHistory(
                     rs.getString("chamid"),rs.getString("pos"),rs.getInt("kill"),
                     rs.getInt("death"),rs.getInt("assist"),rs.getString("kda"),rs.getString("iswin")
                     ));
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
         return userRGHlist;
      }
	public List<User> getUserRank() {
		List<User> userRankList = new ArrayList<User>();
		String sql = "SELECT * FROM USER_INFO ui ORDER BY UTIER, ULEVEL ";
		try {
			con = Z02_OPGG_DB.con();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
			userRankList.add(new User(rs.getString(1),rs.getInt(2),rs.getString(3)));
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
		return userRankList;
	}
	public List<ContentTeamHistory> getContentTeamHistory(String gamecode) {
		List<ContentTeamHistory> CTHlist = new ArrayList<>();
		String sql = "SELECT gh.GAMEID,gh.GAMECODE, gh.TEAMCOLOR,gh.ISWIN,gh.USERID,gh.KILL,gh.DEATH,gh.ASSIST,gh.DAMAGE, \r\n"
				+ "ui.UTIER , ci.CHAMIMG,ri.RUNEIMG ,si.SPELLIMG ,ii.ITEMIMG \r\n"
				+ "FROM GAME_HISTORY gh,USER_INFO ui,CHAM_INFO ci,RUNE_INFO ri,SPELL_INFO si,ITEM_INFO ii\r\n"
				+ "WHERE gh.USERID = ui.USERID AND gh.CHAMID = ci.CHAMID AND gh.RUNEID = ri.RUNEID AND gh.SPELLID =si.SPELLID AND gh.ITEMID = ii.ITEMID\r\n"
				+ "AND gh.gamecode=? ORDER BY gameid";
		try {
			con = Z02_OPGG_DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gamecode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CTHlist.add(new ContentTeamHistory(rs.getInt("gameid"), rs.getString("gamecode"),
						rs.getString("teamcolor"), rs.getString("iswin"), rs.getString("userid"), rs.getInt("kill"),
						rs.getInt("death"), rs.getInt("assist"), rs.getInt("damage"), rs.getString("utier"),
						rs.getString("chamimg"), rs.getString("runeimg"), rs.getString("spellimg"),
						rs.getString("itemimg")));

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
		return CTHlist;
	}
	public List<GameHistory> getUserGameHistory(String userId) { // 메소드명 변경
	      List<GameHistory> userGHlist = new ArrayList<GameHistory>();

	      String sql = "SELECT gh.*,\r\n"
	            + "ci.CHAMIMG,ri.RUNEIMG ,si.SPELLIMG ,ii.ITEMIMG, ti.TIERIMG \r\n"
	            + "FROM GAME_HISTORY gh,USER_INFO ui,CHAM_INFO ci,RUNE_INFO ri,SPELL_INFO si,ITEM_INFO ii,TIER_INFO ti\r\n"
	            + "WHERE gh.USERID = ui.USERID AND gh.CHAMID = ci.CHAMID AND gh.RUNEID = ri.RUNEID AND gh.SPELLID =si.SPELLID AND gh.ITEMID = ii.ITEMID AND ui.UTIER = ti.TIER \r\n"
	            + "AND gh.userid=? ORDER BY gameid";// sql문 입력
	      try {
	         con = Z02_OPGG_DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, userId);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	            userGHlist.add(new GameHistory(rs.getInt("gameid"), rs.getString("gamecode"), rs.getString("teamcolor"),
	                  rs.getString("userid"), rs.getString("chamid"), rs.getString("runeid"), rs.getString("spellid"),
	                  rs.getString("itemid"), rs.getString("pos"), rs.getInt("kill"), rs.getInt("death"),
	                  rs.getInt("assist"), rs.getString("kda"), rs.getInt("attack"), rs.getInt("damage"),
	                  rs.getString("isWin"), rs.getTimestamp("start_time"), rs.getTimestamp("end_time"),
	                  rs.getString("chamimg"), rs.getString("runeimg"), rs.getString("spellimg"),
	                  rs.getString("itemimg"), rs.getString("tierimg")));
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
	      return userGHlist;
	   }
	public List<GameHistory> getTeamGameHistory(String gameCode) {
		List<GameHistory> teamGHlist = new ArrayList<GameHistory>();
		String sql = "SELECT * FROM game_history WHERE gamecode=?";
		try {
			con = Z02_OPGG_DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gameCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				teamGHlist.add(new GameHistory(rs.getInt("gameid"), rs.getString("gamecode"), rs.getString("teamcolor"),
						rs.getString("userid"), rs.getString("chamid"), rs.getString("runeid"), rs.getString("spellid"),
						rs.getString("itemid"), rs.getString("pos"), rs.getInt("kill"), rs.getInt("death"),
						rs.getInt("assist"), rs.getString("kda"), rs.getInt("attack"), rs.getInt("damage"),
						rs.getString("isWin"), rs.getTimestamp("start_time"), rs.getTimestamp("end_time")));
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
		return teamGHlist;
	}
	public static void main(String[] args) {
		D01_GHDao gh = new D01_GHDao();

	}

}

