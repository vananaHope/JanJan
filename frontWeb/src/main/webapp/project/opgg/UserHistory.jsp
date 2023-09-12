<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<!-- 자바 클래스 불러오기 -->
<%@page import="project.opgg.*"%>
<%@page import="project.opgg.VO.*"%>
<%@page import="java.util.*"%>
<%
// Main에서 입력한 값 가져오기
String userId = request.getParameter("userId");
D01_GHDao ghDao = new D01_GHDao();
D02_ChampionDao chDao = new D02_ChampionDao();
List<GameHistory> userGH = ghDao.getUserGameHistory(userId);
M01_GameHistoryMethod ghM = new M01_GameHistoryMethod();
User userRank = ghM.getRank(userId);

RecentPositions posPre = ghM.getPositions(userId);
int idx = 0;
%>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta property="og:title" content="project3 OPGG">
<meta property="og:url"
	content="https://mrrobotcorp.github.io/project3_opgg/">
<meta property="og:image"
	content="https://mrrobotcorp.github.io/project3_opgg//source/thumbnail.png">
<meta property="og:description" content="1조 프로젝트 사이트 - OPGG">
<meta name="twitter:card" content="summary">
<meta name="twitter:title" content="project3 OPGG">
<meta name="twitter:url"
	content="https://mrrobotcorp.github.io/project3_opgg/">
<meta name="twitter:image"
	content="https://mrrobotcorp.github.io/project3_opgg//source/thumbnail.png">
<meta name="twitter:description" content="1조 프로젝트 사이트 - OPGG">
<meta name="description" content="1조 프로젝트 사이트 - OPGG">
<meta name='keywords'
	content='project, OPGG, clone coding, renewal, practice'>

<link rel="icon" href="./source/favicon-32x32.png" sizes="32x32">
<link rel="apple-touch-icon" href="./source/apple-icon-180x180.png"
	sizes="180x180">

<title>롤 전적 검색 OP.GG</title>

<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/userHistory.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

</head>

<body>

	<header>
		<nav class="gnbTop">
			<a href="./index.html" class="topLogo"> <img
				src="https://s-lol-web.op.gg/images/icon/opgglogo.svg?v=1685352893574">
			</a>
			<ul class="gameList">
				<li><a href="#"> <img src="./source/img-navi-lol-white.svg">
						<span>리그오브레전드</span>
				</a></li>
				<li><a href="#"> <img src="./source/img-navi-opgg.svg">
						<span>데스크톱</span>
				</a></li>
				<li><a href="#"> <img src="./source/img_navi_tft-whte.svg">
						<span class="keyTxt">N</span> <span>전략적 팀 전투</span>
				</a></li>
				<li><a href="#"> <img
						src="./source/img-navi-valorant-white.svg"> <span
						class="keyTxt">B</span> <span>발로란트</span>
				</a></li>
				<li><a href="#"> <img src="./source/img-navi-pubg-gray.svg">
						<span>배틀그라운드</span>
				</a></li>
				<li><a href="#"> <img
						src="./source/img-navi-overwatch-gray.svg"> <span
						class="keyTxt">N</span> <span>오버워치2</span>
				</a></li>
				<li><a href="#"> <img src="./source/img_navi_bs.svg">
						<span>이터널 리턴</span>
				</a></li>
				<li><a href="#"> <img src="./source/img_navi_esports.svg">
						<span>이스포츠</span>
				</a></li>
				<li><a href="#"> <img
						src="./source/img-navi-talk-white.svg"> <span>톡피지지</span>
				</a></li>
			</ul>
			<div>
				<button class="btnFaq gnbBtn"></button>
			</div>
			<div>
				<button class="mode gnbBtn"></button>
			</div>
			<div class="lang">
				<img src="./source/icon-world-light-blue.svg"> <span
					class="langDrop"> <select name="language">
						<option>English</option>
						<option selected>한국어</option>
						<option>English</option>
						<option>English</option>
						<option>English</option>
				</select>
				</span>
			</div>
			<div>
				<a href="./" id="login">로그인</a>
			</div>
		</nav>

		<div class="gnbBottom">
			<nav>
				<ul>
					<li><a href="#">홈</a></li>
					<li><a href="#">챔피언 분석</a></li>
					<li><a href="#">게임 모드</a></li>
					<li><a href="#">통계</a></li>
					<li><a href="#">랭킹</a></li>
					<li><a href="#">프로관전</a></li>
					<li><a href="#">멀티서치</a></li>
					<li><a href="#">커뮤니티</a></li>
				</ul>
				<form name="userSch" class="uhSch" action="UserHistory.jsp" method="post">
                    <div class="uhSchAll">
                        <div class="region">
                            <span class="regionDrop">
                                <select name="region">
                                    <option value="NA">North America</option>
                                    <option value="EW">Europe West</option>
                                    <option value="ENE">Europe Nordic & East</option>
                                    <option value="oceania">Oceania</option>
                                    <option value="kor" selected>Kor</option>
                                    <option value="Japan">Japan</option>
                                    <option value="Brazil">Brazil</option>
                                </select>
                            </span>
                        </div>
                        <div class="inputBox">
                            <input type="text" name="userId" placeholder="소환사명, 소환사명..." value="">
                        </div>
                        <button type="submit"></button>
                    </div>
                </form>
			</nav>

		</div>
	</header>

	<div class="bannerTop">
		<a href="https://tft.op.gg/set/9"> TFT 시즌9 미리보기! 새로운 시즌을 먼저 알아보세요!
		</a>
	</div>

	<!-- -------------------- userProfile ------------------- -->
	<section class="userprofile">
		<div class="userinfo">
			<div class="icon">
				<a href=#>
					<img src="<%=userGH.get(0).getTierImg() %>">
					<p class="tierLev">489</p>
				</a>
			</div>
			<div class="text">
				<span class="userName"><%=userId%></span> 
				<span class="rank">
					래더 랭킹 <%=userRank.getGrade() %> 위 (상위 <%=userRank.getRankratio() %> %)
					</span> 
					<a href="#"> <span class="mystyle"> 
					<img class="riotImg" src="./source/riot.png">
						<p>라이엇 계정 연동하고 나만의 프로필을 설정해보세요.</p> <img
						src="https://s-lol-web.op.gg/images/icon/icon-arrow-right.svg?v=1685969162384">
				</span>
				</a>
				<div class="btndiv">
					<div>
						<button class="sycbtn">전적갱신</button>
					</div>
					<div>
						<button class="tierbtn">티어 그래프</button>
					</div>
				</div>
				<p class="sycinfo">
					최근 업데이트:
					<%=userGH.get(0).getEnd_time()%></p>
			</div>
		</div>

		<div class="tap">
			<div>
				<button class="totbtn">종합</button>
				<button class="chambtn">챔피언</button>
				<button class="gameinfobtn">인게임 정보</button>
			</div>
		</div>
	</section>

	<!-- ------------------ contentTop ---------------------- -->
	<section class="contentTop">
		<div class="contentTopMenu">
			<ul>
				<li>
					<button value="TOTAL" class="ctTopBtn ctTopBtnAct">전체</button>
				</li>
				<li>
					<button value="SOLORANKED" class="ctTopBtn">솔로랭크</button>
				</li>
				<li>
					<button value="FLEXRANKED" class="ctTopBtn">자유랭크</button>
				</li>
				<li><select class="queType">
						<option>큐 타입</option>
						<option>일반(비공개 선택)</option>
						<option>무작위 총력전</option>
						<option>AI 상대 대전</option>
						<option>격전</option>
						<option>이벤트 게임</option>
						<option>우르프</option>
				</select></li>
			</ul>
			<div>
				<img src="./source/icon-search.svg" class="schImg"> <input
					type="text" class="chamSch" placeholder="챔피언 검색">
			</div>
		</div>

		<div class="contentTopInfo">
			<div class="stats">
                <% HistoryAvg avg = ghM.historyAvg(userId); 
               int tot = avg.getTotGame();
               int win = avg.getTotWin();%>
                
                <div class="win-lose">
					<span>
						<%=tot%>전 <%=win%>승 <%=tot-win%>패
					</span>
					<%
					double totD = tot;
					double winD = win;
					double lostD = tot-win;
					%>
					<script>
						var winNum = <%= winD/totD*100%>;
						var lostNum = <%= lostD/totD*100%>;
						
                        var percentageArray = [winNum, lostNum];
                    </script>
                    <div id="live-poll-area">
                        <div class="graph-container">
                            <div class="graph"></div>
                        </div>
                        <div class="answer-list"></div>
                    </div>
				</div>
                <div class="kda">
                    <div class="info">
                        <div class="k-d-a">
                            <span class="kill"><%=avg.getAvgKill() %></span>/
                            <span class="death"><%=avg.getAvgDeath() %></span>/
                            <span class="assist"><%=avg.getAvgAssist() %></span>
                        </div>
                        <div class="ratio">
                            <%=avg.getAvgKda() %> : 1
                        </div>
                        <div class="killParticipation">
                            킬 관여율 <%=avg.getKillInvolvement() %> %
                        </div>
                    </div>
                </div>
            </div>
			<div class="champions">
				<div class="title">플레이한 챔피언(최근 20게임)</div>
				<ul>
				<%
               	List<TopChampHistory> tch = ghM.recentGameHistory(userId);
                for(TopChampHistory t : tch){ %>
                    <li>
                    	
                        <img src="<%=chDao.getChamImg(t.getChamid()) %>" alt="<%=t.getChamid()%>">
                        
                        <div class="champWL">
                            <div class="playChampWinrate">
                                <span><%=t.getChamWinRatio()%>%</span>
                                (<%=t.getTotWin() %>승<%=t.getTotLose() %>패)
                            </div>
                        </div>
                        <div class="playKDA playKDA1"><%=t.getAvgKda() %> 평점</div>
                    </li>
                   <% } %>
				</ul>
			</div>
			<div class="positions">
				<div class="title">선호하는 포지션 (랭크)</div>
				<ul>
					<li>
						<div class="bar">
							<div class="gauge" style="height: <%=posPre.getTop()%>%"></div>
						</div>
						<div class="positionImg">
							<img src="./source/icon-position-top.svg" alt="탑">
						</div>
					</li>
					<li>
						<div class="bar">
							<div class="gauge" style="height: <%=posPre.getJungle()%>%"></div>
						</div>
						<div class="positionImg">
							<img src="./source/icon-position-jungle.svg" alt="정글">
						</div>
					</li>
					<li>
						<div class="bar">
							<div class="gauge" style="height: <%=posPre.getMid()%>%"></div>
						</div>
						<div class="positionImg">
							<img src="./source/icon-position-mid.svg" alt="미드">
						</div>
					</li>
					<li>
						<div class="bar">
							<div class="gauge" style="height: <%=posPre.getBot()%>%"></div>
						</div>
						<div class="positionImg">
							<img src="./source/icon-position-adc.svg" alt="바텀">
						</div>
					</li>
					<li>
						<div class="bar">
							<div class="gauge" style="height: <%=posPre.getSup()%>%"></div>
						</div>
						<div class="positionImg">
							<img src="./source/icon-position-support.svg" alt="서포터">
						</div>
					</li>
				</ul>
			</div>
		</div>

	</section>
	<%
	for (GameHistory gh : userGH) { // contentHistory + contentTeamHistory 전체 반복
		List<ContentTeamHistory> teamGH = ghDao.getContentTeamHistory(gh.getGameCode());
		Map<String, String> uka = ghM.getUserKAA(gh.getGameCode());
	%>

	<!-- ------------------- contentHistory --------------------- -->

	<section class="conHistoryAll">
		<%
		if (gh.getIsWin().equals("Win")) {
		%>
		<div class="contentUserHistory">
		<%
		} else {
		%>
		<div class="contentUserHistoryRd">
		<%
		}
		%>
			<li class="resultList">
				<div class="shortResult">
					<div class="content">
						<div class="game-content">
							<div class="game">
								<p><%=ghM.getGameQue(userId, idx) %></p>
								<p><%=ghM.getTime(userId, idx)%></p>
								<p><%=gh.getIsWin()%></p>
								<p><%=ghM.getGameTime(userId, idx) %></p>
							</div>
							<div class="info">
								<div class="upper">
									<div class="champion">
										<div class="icon">
											<img src="<%=gh.getChamimg()%>" alt="KogMaw">
										</div>

										<div class="runes">
											<img src="<%=gh.getRuneimg()%>" width="22" height="22">
										</div>
										<div></div>
									</div>
									<div class="kda">
										<div class="k-d-a">
											<span><%=gh.getKill()%></span> <span class="d"><%=gh.getDeath()%></span>
											<span><%=gh.getAssist()%></span>
										</div>
										<div class="ratio">
											<span> <%=gh.getKda()%> : 1
											</span> 평점
										</div>
									</div>
									<div class="after"></div>
									<div class="stats">
										<span class="p-kill"> 
										킬 관여 <%=uka.get(userId)%>
										</span> 
										<span class="p-tier">
										<%=ghM.getUserTier(userId) %>
										</span>
									</div>
								</div>
								<div class="bottom">
									<div>
										<img class="sideIcon" src="<%=gh.getItemimg()%>">
									</div>
									<div class="spells">
										<img class="sideIcon" src="<%=gh.getSpellimg()%>">
									</div>
								</div>
							</div>
							<div class="participants">
								<ul>
									<li>
										<div class="teamIcon">
											<img src="<%=teamGH.get(0).getChamimg()%>">
										</div>
										<div class="name">
											<span><%=teamGH.get(0).getUserid()%></span>
										</div>
									</li>
									<li>
										<div class="teamIcon">
											<img src="<%=teamGH.get(1).getChamimg()%>">
										</div>
										<div class="name">
											<span><%=teamGH.get(1).getUserid()%></span>
										</div>
									</li>
									<li>
										<div class="teamIcon">
											<img src="<%=teamGH.get(2).getChamimg()%>">
										</div>
										<div class="name">
											<span><%=teamGH.get(2).getUserid()%></span>
										</div>
									</li>
									<li>
										<div class="teamIcon">
											<img src="<%=teamGH.get(3).getChamimg()%>">
										</div>
										<div class="name">
											<span><%=teamGH.get(3).getUserid()%></span>
										</div>
									</li>
									<li>
										<div class="teamIcon">
											<img src="<%=teamGH.get(4).getChamimg()%>">
										</div>
										<div class="name">
											<span><%=teamGH.get(4).getUserid()%></span>
										</div>
									</li>
								</ul>
								
								<ul>
									<li>
										<div class="teamIcon">
											<img src="<%=teamGH.get(5).getChamimg()%>">
										</div>
										<div class="name">
											<span><%=teamGH.get(5).getUserid()%></span>
										</div>
									</li>
									<li>
										<div class="teamIcon">
											<img src="<%=teamGH.get(6).getChamimg()%>">
										</div>
										<div class="name">
											<span><%=teamGH.get(6).getUserid()%></span>
										</div>
									</li>
									<li>
										<div class="teamIcon">
											<img src="<%=teamGH.get(7).getChamimg()%>">
										</div>
										<div class="name">
											<span><%=teamGH.get(7).getUserid()%></span>
										</div>
									</li>
									<li>
										<div class="teamIcon">
											<img src="<%=teamGH.get(8).getChamimg()%>">
										</div>
										<div class="name">
											<span><%=teamGH.get(8).getUserid()%></span>
										</div>
									</li>
									<li>
										<div class="teamIcon">
											<img src="<%=teamGH.get(9).getChamimg()%>">
										</div>
										<div class="name">
											<span><%=teamGH.get(9).getUserid()%></span>
										</div>
									</li>

								</ul>
							</div>
						</div>
					</div>
					<div class="action">
						<button class="teamDropBtn">
							<img src="https://s-lol-web.op.gg/images/icon/icon-arrow-down-blue.svg?v=1685969162384">
						</button>
					</div>
				</div>
			</li>
		</div>
	</section>

	<!-- ---------------- contentTeamHistory ------------------- -->

	<section>
		<div class="contentTeamHistory">
			<div class="tabBox">
				<button class="chBtn">종합</button>
				<button>팀 분석</button>
				<button>빌드</button>
				<button>etc</button>
			</div>
			<%
			int cnt = 0;
			for (ContentTeamHistory cth : teamGH) {
				if (cnt == 0) {
			%>
			<ul class="contentBox">
				<li class="contentAll">
					<div>
						<ul class="conTitle">
							<li>레드팀</li>
							<li>Kill</li>
							<li>Death</li>
							<li>Assist</li>
							<li>킬 관여율</li>
							<li class="damTxt">피해량</li>
							<li>아이템</li>
						</ul>
			<%}%>
			<%
			if (cnt == 5) {
			%>
			<ul class="contentBox">
				<li class="contentAll">
					<div>
						<ul class="conTitle">
							<li>블루팀</li>
							<li>Kill</li>
							<li>Death</li>
							<li>Assist</li>
							<li>킬 관여율</li>
							<li>피해량</li>
							<li>아이템</li>
						</ul>
			<%}%>
			<%
			if (!cth.getIswin().equals("Lose")) {
			%>
			<ul class="conTeamInfoWin">
				<%
				} else {
				%>
			<ul class="conTeamInfoLose">
				<%
				}
				%>
				<li class="conUser"><a
					href="https://www.op.gg/champions/malphite/top/build?region=euw">
						<img src="<%=cth.getChamimg()%>">
						<p class="conLevel">18</p>
				</a>
					<div class="conSpells">
						<div>
							<div class="spellInfo">
								<img class="spellImg" src="<%=cth.getSpellimg()%>">
							</div>
						</div>
						<div>
							<img src="<%=cth.getRuneimg()%>">
						</div>
					</div>
					<div class="conName">
						<a href="#"><%=cth.getUserid()%></a>
						<p><%=cth.getUtier()%></p>
					</div></li>
				<li class="conTxt"><%=cth.getKill()%></li>
				<li class="conTxt"><%=cth.getDeath()%></li>
				<li class="conTxt"><%=cth.getAssist()%></li>
				<li class="conTxt"><%=uka.get(cth.getUserid())%></li>
				<li class="getDamage">
                  <div class="damAll">
                      <span class="damPer" style="width: calc(<%=cth.getDamage()%> / 100000 * 100%)"></span>
                  </div>
                  <span class="damTxtAll">
                      <strong>총 피해량</strong>
                      <p><%=cth.getDamage()%></p>
                      <span class="arrow"></span>
                  </span>
                </li>   
				<li class="conItem"><img src="<%=cth.getItemimg()%>"></li>
			</ul>
			<%
			cnt++;
			}
			%>
		</div>			
	</section>
	<%
	 idx++;} // 전체 반복 종료
	%>

	<footer class="footerBox">
		<div>
			<section class="aligndiv">
				<div>
					<div>
						<a href="#">
							<img
							src="https://s-lol-web.op.gg/images/icon/icon-opgglogo-gray.svg?v=1685955517817"
							width="99" alt="OP.GG" height="24">
						</a>
					</div>
				</div>
				<div>
					<dl class="footerList">
						<dt>OP.GG</dt>
						<dd>
							<a href="https://www.op.gg/about">About OP.GG</a>
						</dd>
						<dd>
							<a href="#">Company</a>
						</dd>
						<dd>
							<a href="#">Blog</a>
						</dd>
						<dd>
							<a href="#">로고히스토리</a>
						</dd>
					</dl>
				</div>
				<div>
					<dl class="footerList">
						<dt>Products</dt>
						<dd>
							<a href="#">리그오브레전드</a>
						</dd>
						<dd>
							<a href="#">데스크톱</a>
						</dd>
						<dd>
							<a href="#">전략적 팀 전투</a>
						</dd>
						<dd>
							<a href="#">발로란트</a>
						</dd>
						<dd>
							<a href="#">배틀그라운드</a>
						</dd>
						<dd>
							<a href="#">오버워치2</a>
						</dd>
						<dd>
							<a href="#">이터널 리턴</a>
						</dd>
						<dd>
							<a href="#">이스포츠</a>
						</dd>
						<dd>
							<a href="#">톡피지지</a>
						</dd>
						<dd>
							<a href="#">Duo</a>
						</dd>
					</dl>
				</div>
				<div>
					<dl class="footerList">
						<dt>Apps</dt>
						<dd>
							<a href="#">OP.GG Android App</a>
						</dd>
						<dd>
							<a href="#">OP.GG iOS App</a>
						</dd>
						<dd>
							<a href="#">TFT Android App</a>
						</dd>
						<dd>
							<a href="#">TFT iOS App</a>
						</dd>
					</dl>
				</div>
				<div>
					<dl class="footerList">
						<dt>Resources</dt>
						<dd>
							<a href="#">개인정보처리방침</a>
						</dd>
						<dd>
							<a href="#">이용약관</a>
						</dd>
						<dd>
							<a href="#">도움말</a>
						</dd>
						<dd>
							<a href="#">이메일 문의하기</a>
						</dd>
						<dd>
							<a href="#">FAQ/피드백</a>
						</dd>
					</dl>
				</div>
				<div>
					<dl class="footerList">
						<dt>More</dt>
						<dd>
							<a href="#">제휴</a>
						</dd>
						<dd>
							<a href="#">광고</a>
						</dd>
						<dd>
							<a href="#">채용</a>
						</dd>
					</dl>
				</div>
			</section>
			<section class="footBottom">
				<p class="footerCopyrightText">© 2012-2023 OP.GG. OP.GG isn’t
					endorsed by Riot Games and doesn’t reflect the views or opinions of
					Riot Games or anyone officially involved in producing or managing
					League of Legends. League of Legends and Riot Games are trademarks
					or registered trademarks of Riot Games, Inc. League of Legends ©
					Riot Games, Inc.</p>
				<div class="footSns">
					<img
						src="https://s-lol-web.op.gg/images/icon/icon-logo-twitter.svg?v=1685969162609">
					<img
						src="https://s-lol-web.op.gg/images/icon/icon-logo-instagram.svg?v=1685969162609">
					<img
						src="https://s-lol-web.op.gg/images/icon/icon-logo-facebook.svg?v=1685969162609">
				</div>
			</section>
		</div>
	</footer>

	<script src="./js/userHistory.js"></script>
</body>

</html>