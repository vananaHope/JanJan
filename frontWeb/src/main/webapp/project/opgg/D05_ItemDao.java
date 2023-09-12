package project.opgg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import project.opgg.VO.Item;

public class D05_ItemDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public List<Item> itemSearch(){
		List<Item> itemList = new ArrayList<Item>();
		String sql = "select * from item_info";
		try {
			con = Z02_OPGG_DB.con();
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				itemList.add(new Item(
						rs.getString("itemId"), rs.getString("itemDescription1"),
						rs.getString("itemDescription2"), rs.getInt("itemPrice"),
						rs.getString("itemImg")));

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
		return itemList;
	}
}
