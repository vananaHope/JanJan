package project.opgg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InsertDB {
	
	public static void main(String[] args) {
		// 중복되면 안되는 값 List / 중복되어도 되는 값 배열
		List<String> cham = new ArrayList<String>();	// 챔피언명 리스트
		cham.add("가렌"); cham.add("애니"); cham.add("탈론");
		cham.add("밀리오"); cham.add("카이사"); cham.add("제드");
		cham.add("이즈리얼"); cham.add("워윅"); cham.add("세트");
		cham.add("카직스"); cham.add("소나"); cham.add("소라카");
		cham.add("코그모"); cham.add("오공"); cham.add("사이온");
		List<String> user = new ArrayList<String>();	// 유저id 리스트
		user.add("다솜"); user.add("준규"); user.add("현우");
		user.add("석민"); user.add("지우"); user.add("준혁");
		user.add("상우"); user.add("영재"); user.add("학수");
		user.add("동현"); user.add("경웅"); user.add("윤아");
		user.add("은서"); user.add("혜원"); user.add("선영");
		List<String> isWin = new ArrayList<String>();	// 승패여부 리스트
		isWin.add("Win");  isWin.add("Lose");
		List<String> tier = new ArrayList<String>();	// 유저 티어 리스트
		tier.add("IRON"); tier.add("BRONZE"); tier.add("SILVER");
		tier.add("GOLD"); tier.add("PLATINUM"); tier.add("DIAMOND");
		tier.add("MASTER"); tier.add("GRANDMASTER"); tier.add("CHALLENGER");
		tier.add("IRON"); tier.add("BRONZE"); tier.add("SILVER");
		tier.add("GOLD"); tier.add("BRONZE"); tier.add("IRON");
		
		String []position = {"TOP","JUG","MID","BOT","SUP","TOP","JUG","MID","BOT","SUP"};
		String []gameMode = {"솔로랭크","자유랭크","일반게임","칼바람"};
		String []spell = {"방어막","정화","점멸","유체화","점화","강타","탈진","회복","텔레포트"};
		String []items1 = {"부패물약","도란의 검","도란의 반지","수확의 낫","도란의 방패","사냥꾼의 마체테","암흑의 인장","주문도둑의 검","여신의 눈물","고대유물 방패"};
		String []runes = {"결의", "정밀", "지배", "마법", "영감"};

		String team = "";
		String teamIsWin = "";
		String chamId = "";
		String userId = "";
		int gHisNum = 1;
		int gIdNum = 0;
		int hour = 1;
		int day = 0;
		String sTime = "";
		String eTime = "";
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("a. 유저id 생성");
			System.out.println("b. 내역id 생성");
			System.out.println("c. 아이템id 생성");
			System.out.println("d. 룬id 생성");
			System.out.println("e. 스펠id 생성");
			System.out.println("f. 챔피언id 생성");
			System.out.println("Q. 종료");
			String cho = sc.nextLine();
			if(cho.equals("a")) {
				Collections.shuffle(user);
				Collections.shuffle(tier);
				Collections.shuffle(user);
				for(int i=0;i<cham.size();i++) {
					int level = (int)(Math.random()*150+50);
					System.out.println("INTO USER_INFO VALUES (\'"+user.get(i)+"\',"+level+",\'"+tier.get(i)+"\')");
				}
			}
				
			if(cho.equals("b")) {	// 게임 내역 생성
				while(true) {
					// 챔피언, 유저, 승패 리스트 섞기
					Collections.shuffle(cham);
					Collections.shuffle(user);
					Collections.shuffle(isWin);
					
					// 게임 내역마다 한시간씩 추가/gameid 넘버 증가
					hour++;
					gIdNum++;
					if(hour==25) {	// hour가 25/24 가 되었을 때 hour값 초기화 및 일 수 추가
						hour = 2;
						day++;
					}
					sTime = "sysdate"+"+"+(hour-1)+"/24+"+day;
					eTime = "sysdate"+"+"+hour+"/24+"+day;
					// 게임 타입 리스트의 인덱스에 랜덤 수 생성
					int gId = (int)(Math.random()*4);
					String gameCode = gameMode[gId]+"-"+gIdNum;	// 게임 타입 + gameid를 더하여 내역 별 고유 넘버 생성
					
					
									
					
					
					for(int i=0; i<10; i++) {	// 1게임 = 10명 유저의 게임내역
						if(i<5) {				// 1팀당 5명씩 팀명, 승패 할당
							team ="BLUE";
							teamIsWin = isWin.get(0);
						} else {
							team = "RED";
							teamIsWin = isWin.get(1);
						}
						int dam = (int)(Math.random()*1000+1)*100;
						int att = (int)(Math.random()*1000+1)*100;
						int sran = (int)(Math.random()*9);
						int rran = (int)(Math.random()*5);
						int iran1 = (int)(Math.random()*10);
						int iran2 = (int)(Math.random()*8);
						int kill = (int)(Math.random()*20);
						int death = (int)(Math.random()*20);
						int assist = (int)(Math.random()*20);	// 랜덤 인덱스, 랜덤값 생성
						
						
						if(death!=0) {		// (kill+assist)/death = 평점, death가 0일 경우 'Perfect' 출력
							double tot = ((kill+assist+0.0)/death)*100;
							double avg = Math.round(tot);
							System.out.println("INTO GAME_HISTORY VALUES ("+gHisNum+",\'"+gameCode+"\',\'"+team+"\',\'"+user.get(i)+
									"\',\'"+cham.get(i)+"\',\'"+runes[rran]+"\',\'"+spell[sran]+"\',\'"+
									items1[iran1]+"\',\'"+position[i]+"\',"+kill+","+death+","+assist+",\'"+
									(avg/100.0)+"\',"+att+","+dam+",\'"+teamIsWin+"\',"+sTime+","+eTime+")");	
									
									
						} else {
							System.out.println("INTO GAME_HISTORY VALUES ("+gHisNum+",\'"+gameCode+"\',\'"+team+"\',\'"+user.get(i)+
									"\',\'"+cham.get(i)+"\',\'"+runes[rran]+"\',\'"+spell[sran]+"\',\'"+
									items1[iran1]+"\',\'"+position[i]+"\',"+kill+","+death+","+assist+",\'"+
									"Perfect"+"\',"+att+","+dam+"\',\'"+teamIsWin+"\',"+sTime+","+eTime+")");	
						}
									
						gHisNum++;	// 한 게임에 10명의 유저. 유저 1row 당 내역번호 증가
					}
					if(gIdNum==50) {
						break;
					}
				}
			}
			if(cho.equals("c")) {	// 아이템 테이블의 itemid 생성.
				for(int i=0;i<items1.length;i++) {
					System.out.println("INTO ITEM_INFO (ITEMID) VALUES(\'"+items1[i]+"\')");
				}
			}
			if(cho.equals("d")) {
				for(int i=0;i<runes.length;i++) {
					System.out.println("INTO RUNE_INFO (RUNEID) VALUES(\'"+runes[i]+"\')");
				}
			}
			if(cho.equals("e")) {
				for(int i=0;i<spell.length;i++) {
					System.out.println("INTO SPELL_INFO (SPELLID) VALUES(\'"+spell[i]+"\')");
				}
			}
			if(cho.equals("f")){
				for(int i=0;i<cham.size();i++) {
					System.out.println("INTO CHAM_INFO VALUES(\'"+cham.get(i)+"\',\'"+cham.get(i)+".img"+"\')");
				}
					
			}
			if(cho.equals("Q")) break;
		}

		
		
	}
}
