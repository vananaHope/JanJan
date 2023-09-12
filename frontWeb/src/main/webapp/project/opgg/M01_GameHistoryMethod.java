package project.opgg;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import project.opgg.VO.ContentTeamHistory;
import project.opgg.VO.GameHistory;
import project.opgg.VO.HistoryAvg;
import project.opgg.VO.RecentGameHistory;
import project.opgg.VO.RecentPositions;
import project.opgg.VO.TopChampHistory;
import project.opgg.VO.User;

public class M01_GameHistoryMethod {
	
	// 전체 포지션 가져오기 -> 각포지션별로 카운트/전체게임수 *100 => %로 결과값 가져오기
	public RecentPositions getPositions(String userId) {
			RecentPositions rp = new RecentPositions();
			D01_GHDao gh = new D01_GHDao();
			List<RecentGameHistory> rgh = gh.getRecentGameHistory(userId);
			double top = 0;
			double jug = 0;
			double mid = 0;
			double bot = 0;
			double sup = 0;
			for (RecentGameHistory r : rgh) {
				if (r.getPos().equals("TOP")) {
					top++;
				} else if (r.getPos().equals("JUG")) {
					jug++;
				} else if (r.getPos().equals("MID")) {
					mid++;
				} else if (r.getPos().equals("BOT")) {
					bot++;
				} else {
					sup++;
				}
			}
			double tot = rgh.size();
			int topPer = (int) (top*100/ tot*100)/100;
			int jugPer = (int) (jug*100 / tot*100)/100;
			int midPer = (int) (mid*100 / tot*100)/100;
			int botPer = (int) (bot*100 / tot*100)/100;
			int supPer = (int) (sup*100 / tot*100)/100;
			rp.setTop(topPer);
			rp.setJungle(jugPer);
			rp.setMid(midPer);
			rp.setBot(botPer);
			rp.setSup(supPer);

			return rp;
		}
		
	// 최근 20게임 가져오기 -> 챔피언이름_챔피언승률_챔피언게임수_챔피언승_챔피언패_챔피언평균kda
	public User getRank(String userid){
        D01_GHDao gh = new D01_GHDao();
        Map<String,Integer> userRank = new HashMap<>();
        int point = 0;
        
        List<User> userList = gh.getUserRank();
        for(User u:userList) {
           if(u.getuTier().equals("IRON")) point = 1000+u.getuLevel(); 
           if(u.getuTier().equals("BRONZE")) point = 2000+u.getuLevel();
           if(u.getuTier().equals("SILVER")) point = 3000+u.getuLevel();
           if(u.getuTier().equals("GOLD")) point = 4000+u.getuLevel();
           if(u.getuTier().equals("PLATINUM")) point = 5000+u.getuLevel();
           if(u.getuTier().equals("DIAMOND")) point = 6000+u.getuLevel();
           if(u.getuTier().equals("MASTER")) point = 7000+u.getuLevel();
           if(u.getuTier().equals("GRANDMASTER")) point = 8000+u.getuLevel();
           if(u.getuTier().equals("CHALLENGER")) point = 9000+u.getuLevel();
           userRank.put(u.getUserId(),point);
        }
        
        double gradeP = userRank.size();
        for(String key:userRank.keySet()) {
           if(userRank.get(userid)!=userRank.get(key)) {
              if(userRank.get(userid)>userRank.get(key)) {
                 gradeP--;
              }
           }
        }
        int rankRatio = (int)(Math.round((gradeP/userRank.size())*100));
        User usergrade = new User(userid, (int)gradeP, rankRatio);
        
        return usergrade;
     }

	//평균 킬
	public double getUserAvgKill(String userId) {
		double avgKill = 0;
		D01_GHDao gh = new D01_GHDao();
		List<GameHistory> uh = gh.getUserGameHistory(userId);
		int tot=0;
		for(GameHistory g:uh) {
			tot+=g.getKill();
		}
		
		double totD = tot;
		avgKill = Math.round((totD/uh.size()*10)/10.0);
		
		return avgKill;
	}

	//평균 데스
	public double getUserAvgDeath(String userId) {
		double avgDeath = 0;
		D01_GHDao gh = new D01_GHDao();
		List<GameHistory> uh = gh.getUserGameHistory(userId);
		int tot=0;
		for(GameHistory g:uh) {
			tot+=g.getDeath();
		}
		double totD = tot;
		avgDeath = Math.round((totD/uh.size()*10)/10.0);
		
		return avgDeath;
	}
	
	//평균 어시
	public double getUserAvgAssist(String userId) {
		double avgAssist = 0;
		D01_GHDao gh = new D01_GHDao();
		List<GameHistory> uh = gh.getUserGameHistory(userId);
		int tot=0;
		for(GameHistory g:uh) {
			tot+=g.getAssist();
		}
		double totD = tot;
		avgAssist = Math.round((totD/uh.size()*10))/10.0;
		
		return avgAssist;
	}
	
	//평점
	public double getUserAvgRatio(String userId) {
		M01_GameHistoryMethod m = new M01_GameHistoryMethod();
		double avgKill = m.getUserAvgKill(userId);
		double avgDeath = m.getUserAvgDeath(userId);
		double avgAssist = m.getUserAvgAssist(userId);
		double avgRatio = 0;
		double avg = (avgKill+avgAssist)/avgDeath;
		avgRatio = Math.round(avg*100)/100.0;
		
		return avgRatio;
	}

	// 티어
	public String getUserTier(String userId) {
			D06_UserDao udao = new D06_UserDao();
			User gq = udao.getUserInfo(userId);
			String tier = gq.getuTier();

			return tier;
		}

	// 게임모드
	public String getGameQue(String userId, int idx) {
			D01_GHDao dao = new D01_GHDao();
			List<GameHistory> gq = dao.getUserGameHistory(userId);
			String[] gc = gq.get(idx).getGameCode().split("-");
			String gameCode = gc[0];

			return gameCode;
		}

	// 시작 시간
	public String getTime(String userId, int idx) {
			SimpleDateFormat sf = new SimpleDateFormat("MM월 dd일 HH시 mm분");
			D01_GHDao dao = new D01_GHDao();
			List<GameHistory> gq = dao.getUserGameHistory(userId);

			String st = sf.format(gq.get(idx).getStart_time());

			return st;
		}

	// 게임 시간
	public String getGameTime(String userId, int idx) {
			D01_GHDao dao = new D01_GHDao();
			List<GameHistory> gq = dao.getUserGameHistory(userId);

			Date d1 = gq.get(idx).getStart_time();
			Date d2 = gq.get(idx).getEnd_time();

			long timeResult = d1.getTime() - d2.getTime();

			long gameTimeMin = timeResult / (60 * 1000);
			long gameTimeSec = timeResult % (60 * 1000);

			return gameTimeMin + "분" + gameTimeSec + "초";

		}

	public void userGameHistory(String userId) {
		D01_GHDao dao = new D01_GHDao();
		Scanner sc = new Scanner(System.in);
		List<GameHistory> userGameHistory = dao.getUserGameHistory(userId);
		System.out.println(userId + "의 전적 리스트");
		int jdx = 0;
		for (GameHistory g : userGameHistory) {
			System.out.println("★" + (jdx + 1) + "번★ 게임 정보(낮을수록 최근게임)");
			System.out.println(" ▶ 게임 유형 : " + g.getGameCode().substring(0, 4));
			System.out.println(" ▶ 플레이한 챔피언 : " + g.getChampId());
			System.out.println(" ▶ 유저의 포지션: " + g.getPos());
			System.out.println(" ▶ 플레이한 팀 : " + g.getTeamColor() + " 팀");
			System.out.println(" ▶ 플레이 시작시간 : " + g.getStart_time());
			System.out.println(" ▶ 플레이 종료시간 : " + g.getEnd_time());
			System.out.println(
					" ▶ 유저의 kill/death/assist : " + g.getKill() + " / " + g.getDeath() + " / " + g.getAssist());
			System.out.println(" ◆◆◆ " + g.getTeamColor() + " team " + g.getIsWin() + "s !! ◆◆◆ ");
			jdx++;
		}
		while (true) {
			System.out.println("게임 번호를 입력하세요 >> ");
			int inputNum = Integer.parseInt(sc.next());
			List<GameHistory> chosenUGH = dao.getTeamGameHistory(userGameHistory.get(inputNum - 1).getGameCode());
			String gameCode = chosenUGH.get(0).getGameCode();
			System.out.println(gameCode.length());
			if (gameCode.length() == 5) {
				gameCode = gameCode.substring(0, 2);
			} else {
				gameCode = gameCode.substring(0, 3);
			}
			System.out.println("게임 유형 : " + gameCode);
			String teamColor1 = chosenUGH.get(0).getTeamColor();
			String teamColor2 = chosenUGH.get(5).getTeamColor();
			System.out.println("◎ " + teamColor1 + "팀 유저 ◎");
			for (int idx = 0; idx < 5; idx++) {
				GameHistory gh = chosenUGH.get(idx);
				System.out.println(" ▶ " + gh.getUserId() + " : " + gh.getPos() + " : " + gh.getChampId());
			}

			System.out.println("◎ " + teamColor2 + "팀 유저 ◎");
			for (int idx = 5; idx < 10; idx++) {
				GameHistory gh = chosenUGH.get(idx);
				System.out.println(" ▶ " + gh.getUserId() + " : " + gh.getPos() + " : " + gh.getChampId());
			}
			System.out.println(teamColor1 + " 팀이 " + chosenUGH.get(0).getIsWin() + "했습니다");
			break;
		}
	}

	public void getUserChampionPreference(String userId) {
		D01_GHDao dao = new D01_GHDao();
		List<GameHistory> userGameHistory = dao.getUserGameHistory(userId);
		ArrayList<String> positions = new ArrayList<String>();
		for (int idx = 0; idx < userGameHistory.size(); idx++) {
			String position = userGameHistory.get(idx).getPos();
			positions.add(position);
//			System.out.println(position);
		}
		Map<String, Double> champPer = new HashMap<String, Double>();
		for (int idx = 0; idx < positions.size(); idx++) {
			String position = positions.get(idx);
			double usedNum = Collections.frequency(positions, position);
			System.out.println(positions.get(idx) + " : " + Collections.frequency(positions, positions.get(idx)));
			champPer.put(position, usedNum);
		}
		double wholeGame = userGameHistory.size();
		Double midUsed = champPer.get("MID");
		Double topUsed = champPer.get("TOP");
		Double jugUsed = champPer.get("JUG");
		Double supUsed = champPer.get("SUP");
		Double botUsed = champPer.get("BOT");

		if (midUsed != null) {
			System.out.println("MID " + midUsed / wholeGame * 100 + " %");
		}
		if (topUsed != null) {
			System.out.println("TOP " + topUsed / wholeGame * 100 + " %");
		}
		if (jugUsed != null) {
			System.out.println("JUG " + jugUsed / wholeGame * 100 + " %");
		}
		if (supUsed != null) {
			System.out.println("SUP " + supUsed / wholeGame * 100 + " %");
		}
		if (botUsed != null) {
			System.out.println("BOT " + botUsed / wholeGame * 100 + " %");
		}
	}

	public int getWin(String userid) {
		D01_GHDao gh = new D01_GHDao();
		List<GameHistory> ghlist = gh.getUserGameHistory(userid);
		int win = 0;

		for (int i = 0; i < ghlist.size(); i++) {
			if ((ghlist.get(i).getIsWin()).equals("Win")) {
				win++;
			}
		}
		return win;
	}

	public int getLost(String userid) {
		D01_GHDao gh = new D01_GHDao();
		List<GameHistory> ghlist = gh.getUserGameHistory(userid);
		int lost = 0;

		for (int i = 0; i < ghlist.size(); i++) {
			if ((ghlist.get(i).getIsWin()).equals("Lose")) {
				lost++;
			}
		}
		return lost;
	}
	
	public Map<String,String> getUserKAA(String gamecode){
		D01_GHDao gh = new D01_GHDao();
		Map<String,String> userKaMap = new HashMap<>();
		
		List<ContentTeamHistory> CTHlist = new ArrayList<>();
		CTHlist = gh.getContentTeamHistory(gamecode);
		
		double bteamKill = 0;
		double rteamKill = 0;
		
		for(ContentTeamHistory ct:CTHlist) {
			if(ct.getTeamcolor().equals("BLUE")) {
				bteamKill += ct.getKill();
			} else {
				rteamKill += ct.getKill();
			}
		}
		
		int userka = 0;
		for(ContentTeamHistory ct:CTHlist) {
			double kill = ct.getKill();
			double assi = ct.getAssist();
			if(ct.getTeamcolor().equals("BLUE")) {
				userka = (int)((kill+assi)/bteamKill*100);
			} else {
				userka = (int)((kill+assi)/rteamKill*100);
			}
			userKaMap.put(ct.getUserid(), userka+"%");
		}
		
		return userKaMap;
	}
	
	// 총게임수_총승_총패_평균킬_평균데스_평균어시_평균kda_평균킬관여율
	public HistoryAvg historyAvg(String userId) {
		D01_GHDao gh = new D01_GHDao();
		// 화면에 출력하기위한 전체 데이터 객체(return값)
		HistoryAvg avg = new HistoryAvg();
		int win = 0;
		int lost = 0;
		double avgKill = 0;
		double avgAssist = 0;
		double avgDeath = 0;
		double avgKda = 0;
		int killInvolveAll = 0;
		List<GameHistory> uh = gh.getUserGameHistory(userId);
		
		// 킬관여율을 구하기 위해서 같은 팀 전체 킬 수 필요
		// 유저가 플레이한 모든 게임의 gameCode를 구하여 팀 전체 킬 수를 구해야함
		// gcset은 gameCode(중복되지않음)를 저장하기 위한 배열
		Set<String> gcset = new HashSet<>();
		
		// 전체 (킬 + 어시 + 데스 + 승리 + 패배) 구하는 for문
		double totTeamKill = 0;
		double totKill = 0;
		double totAssist = 0;
		double totDeath = 0;
		for (GameHistory g : uh) {
			totKill += g.getKill();
			totAssist += g.getAssist();
			totDeath += g.getDeath();
			gcset.add(g.getGameCode()); // 팀의 전체 킬 구하기 위한 gameCode 저장
			if ((g.getIsWin()).equals("Win")) {
				win++;
			} else {
				lost++;
			}
		}
		
		// 팀의 전체 킬 구하기 위한 for문
		for (String s : gcset) {
			List<GameHistory> th = gh.getTeamGameHistory(s);
			for (GameHistory tgh : th) {
				totTeamKill += tgh.getKill();
			}
		}
		killInvolveAll = (int) ((totKill + totAssist) / totTeamKill * 100);
	
		// 평균(킬 + 데스 + 어시)
		avgKda = (double)(Math.round(((totKill + totAssist) / totDeath)*100)) / 100.0;
		avgKill = (double)Math.round(totKill / uh.size() *10) / 10.0;
		avgDeath = (double)Math.round(totDeath/ uh.size()*10) / 10.0;
		avgAssist = (double)Math.round(totAssist / uh.size()*10) / 10.0;
		
		// 객체에 집어넣기
		avg.setTotGame(uh.size());
		avg.setTotWin(win);
		avg.setAvgKill(avgKill);
		avg.setAvgDeath(avgDeath);
		avg.setAvgAssist(avgAssist);
		avg.setAvgKda(avgKda);
		avg.setKillInvolvement(killInvolveAll);
	
		return avg;
	
	}

	// 최근 20게임 가져오기 -> 챔피언이름_챔피언승률_챔피언게임수_챔피언승_챔피언패_챔피언평균kda
	public List<TopChampHistory> recentGameHistory(String userId) {
		D01_GHDao gh = new D01_GHDao();
		// sql문으로 최근 20게임의 정보 List형태로 가져와 rgh에 할당하기
		List<RecentGameHistory> rgh = gh.getRecentGameHistory(userId);
		// 
		ArrayList<String> chamlist = new ArrayList<String>();
		for (RecentGameHistory r : rgh) {
			chamlist.add(r.getChamId());
		}
		Set<String> chlist = new HashSet<String>(chamlist);
		ArrayList<String> clist = new ArrayList<>();
		ArrayList<Integer> nlist = new ArrayList<>();
		clist.add(chamlist.get(0));
		nlist.add(Collections.frequency(chamlist, chamlist.get(0)));
		for (int idx = 1; idx < chamlist.size(); idx++) {
			if (chamlist.get(idx).equals(chamlist.get(idx - 1))) {
				continue;
			} else {
				clist.add(chamlist.get(idx));
				nlist.add(Collections.frequency(chamlist, chamlist.get(idx)));
	
			}
		}
		List<TopChampHistory> tchlist = new ArrayList<>();
		ArrayList<String> topcham = new ArrayList<>();
		String cham = "";
		for (int jdx = 0; jdx < 3; jdx++) {
			int maxNum = 0;
			int index = 0;
			for (int cnt = 0; cnt < nlist.size(); cnt++) {
				if (nlist.get(cnt) > maxNum) {
					maxNum = nlist.get(cnt);
					cham = clist.get(cnt);
					index = cnt;
				}
			}
			topcham.add(cham);
			nlist.remove(index);
			clist.remove(cham);
		}
		String champion = "";
		
		for (int topchamCnt = 0; topchamCnt < topcham.size(); topchamCnt++) {
			TopChampHistory tch = new TopChampHistory();
			int count = 0;
			int lost = 0;
			int win = 0;
			double kda = 0;
			for (int cnt = 0; cnt < rgh.size(); cnt++) {
				if (topcham.get(topchamCnt).equals(rgh.get(cnt).getChamId())) {
					System.out.println("kda : " +rgh.get(cnt).getKda());
					kda += Double.parseDouble(rgh.get(cnt).getKda());
					String result = rgh.get(cnt).getIsWin();
					if(result.equals("Lose")) {
						lost++;
					} else {
						win++;
					}
					count++;
					champion = rgh.get(cnt).getChamId();
				} 
			}
			double avgKda = (double)(Math.round(kda/count*100))/100;
			tch.setChamid(champion);
			tch.setTotGame(count);
			tch.setTotWin(win);
			tch.setTotLose(lost);
			tch.setAvgKda(avgKda);
			int winRatio = (win*100/count*100)/100;
			tch.setChamWinRatio(winRatio);
			tchlist.add(tch);
		}
		return tchlist;
	}

	public static void main(String[] args) {
		M01_GameHistoryMethod gh = new M01_GameHistoryMethod();		
	}

}
