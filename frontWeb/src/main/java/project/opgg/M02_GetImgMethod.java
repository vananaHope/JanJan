package project.opgg;

import java.util.List;

import project.opgg.VO.Champion;
import project.opgg.VO.Item;
import project.opgg.VO.Rune;
import project.opgg.VO.Spell;

public class M02_GetImgMethod {
	
	public void getChampionImg(String chamid) {
		D02_ChampionDao dao = new D02_ChampionDao();
		List<Champion> chamList = dao.ChampionSearch();
		
//		전체 출력
//		for(Champion c : chamList) {
//			System.out.println("챔피언 이름 : " + c.getChamId());
//			System.out.println("챔피언 이미지 : "+ c.getChamImg());
//		}
		
		// 특정 챔피언 정보 뽑기 
		for(Champion c : chamList) {
			if(chamid.equals(c.getChamId())) {
				System.out.println("챔피언 이름 : " + c.getChamId());
				System.out.println("챔피언 이미지 : "+ c.getChamImg());
			}	
		}
	}
	
	public void getRuneImg(String runeid) {
		D03_RuneDao dao = new D03_RuneDao();
		List<Rune> runeList = dao.runeSearch();
		for(Rune r : runeList) {
			if(runeid.equals(r.getRuneId())) {
				System.out.println("룬 이름 : " + r.getRuneId());
				System.out.println("룬 이미지 : "+ r.getRuneImg());
			}	
		}
	}
	
	public void getSpellImg(String spellid) {
		D04_SpellDao dao = new D04_SpellDao();
		List<Spell> spellList = dao.spellSearch();
		for(Spell s : spellList) {
			if(spellid.equals(s.getSpellId())) {
				System.out.println("룬 이름 : " + s.getSpellId());
				System.out.println("룬 이미지 : "+ s.getSpellImg());
			}	
		}
	}
	
	public void getItemInfo(String itemid) {
		D05_ItemDao dao = new D05_ItemDao();
		List<Item> itemList = dao.itemSearch();
		for(Item s : itemList) {
			if(itemid.equals(s.getItemId())) {
				System.out.println("룬 이름 : " + s.getItemId());
				System.out.println("룬 이미지 : "+ s.getItemImg());
			}	
		}
	}
	
	
	public static void main(String[] args) {
		M02_GetImgMethod m = new M02_GetImgMethod();
		m.getChampionImg("가렌");
		m.getRuneImg("영감");
	}

}
