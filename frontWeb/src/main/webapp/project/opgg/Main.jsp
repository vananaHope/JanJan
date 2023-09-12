<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"    
  %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta property="og:title" content="project3 OPGG">
    <meta property="og:url" content="https://mrrobotcorp.github.io/project3_opgg/">
    <meta property="og:image" content="https://mrrobotcorp.github.io/project3_opgg//source/thumbnail.png">
    <meta property="og:description" content="1조 프로젝트 사이트 - OPGG">
    <meta name="twitter:card" content="summary">
    <meta name="twitter:title" content="project3 OPGG">
    <meta name="twitter:url" content="https://mrrobotcorp.github.io/project3_opgg/">
    <meta name="twitter:image" content="https://mrrobotcorp.github.io/project3_opgg//source/thumbnail.png">
    <meta name="twitter:description" content="1조 프로젝트 사이트 - OPGG">
    <meta name="description" content="1조 프로젝트 사이트 - OPGG">
    <meta name='keywords' content='project, OPGG, clone coding, renewal, practice'>

    <link rel="icon" href="./source/favicon-32x32.png" sizes="32x32">
    <link rel="apple-touch-icon" href="./source/apple-icon-180x180.png" sizes="180x180">

    <title>롤 전적 검색 OP.GG</title>

    <link rel="stylesheet" href="./css/common.css">
</head>

<body class="home">

    <header>
        <nav class="gnbTop">
            <a href="./index.html" class="topLogo">
                <img src="https://s-lol-web.op.gg/images/icon/opgglogo.svg?v=1685352893574">
            </a>
            <ul class="gameList">
                <li>
                    <a href="#">
                        <img src="./source/img-navi-lol-white.svg">
                        <span>리그오브레전드</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="./source/img-navi-opgg.svg">
                        <span>데스크톱</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="./source/img_navi_tft-whte.svg">
                        <span class="keyTxt">N</span>
                        <span>전략적 팀 전투</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="./source/img-navi-valorant-white.svg">
                        <span class="keyTxt">B</span>
                        <span>발로란트</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="./source/img-navi-pubg-gray.svg">
                        <span>배틀그라운드</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="./source/img-navi-overwatch-gray.svg">
                        <span class="keyTxt">N</span>
                        <span>오버워치2</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="./source/img_navi_bs.svg">
                        <span>이터널 리턴</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="./source/img_navi_esports.svg">
                        <span>이스포츠</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="./source/img-navi-talk-white.svg">
                        <span>톡피지지</span>
                    </a>
                </li>
                <!-- <li>
                    <a href="#">
                        <img src="./source/img-navi-duo-gray.svg">
                        <span>Duo</span>
                    </a>
                </li> -->
            </ul>
            <div>
                <button class="btnFaq gnbBtn"></button>
            </div>
            <div>
                <button class="mode gnbBtn"></button>
            </div>
            <div class="lang">
                <img src="./source/icon-world-light-blue.svg">
                <span class="langDrop">
                    <select name="language">
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
                    <li>
                        <a href="#">홈</a>
                    </li>
                    <li>
                        <a href="#">챔피언 분석</a>
                    </li>
                    <li>
                        <a href="#">게임 모드</a>
                    </li>
                    <li>
                        <a href="#">통계</a>
                    </li>
                    <li>
                        <a href="#">랭킹</a>
                    </li>
                    <li>
                        <a href="#">프로관전</a>
                    </li>
                    <li>
                        <a href="#">멀티서치</a>
                    </li>
                    <li>
                        <a href="#">커뮤니티</a>
                    </li>
                </ul>
            </nav>

        </div>
    </header>
    <div class="bannerTop">
        <a href="https://tft.op.gg/set/9" target="_blank">
            TFT 시즌9 미리보기! 새로운 시즌을 먼저 알아보세요!
        </a>
    </div>

    <section class="mainSch">
        <h3 class="blind">메인검색</h3>
        <img class="mainLogo" src="./source/mainLogo.png" alt="OPGG">
        <form name="userSch" class="schBox" action="UserHistory.jsp" method="post" onsubmit="return chNull()">
            <div class="boxAll">
                <div class="regionAll">
                    <label>Region</label>
                    <span class="regionDrop">
                        <select name="region">
                            <option value="NA">North America</option>
                            <option value="EW" selected>Europe West</option>
                            <option value="ENE">Europe Nordic & East</option>
                            <option value="oceania">Oceania</option>
                            <option value="kor">Korea</option>
                            <option value="Japan">Japan</option>
                            <option value="Brazil">Brazil</option>
                        </select>
                    </span>
                </div>
                <div class="inputBox">
                    <label>Search</label>
                    <input type="text" name="userId" placeholder="소환사명, 소환사명..." value="">
                </div>
                <button type="submit"></button>
            </div>
        </form>
        
        
        <form name="champSch" class="schBox">
            <div class="boxAll">
                <div class="regionAll">
                    <label>Region</label>
                    <span class="regionDrop">
                        <select name="region">
                            <option value="NA">North America</option>
                            <option value="EW">Europe West</option>
                            <option value="ENE">Europe Nordic & East</option>
                            <option value="oceania">Oceania</option>
                            <option value="kor" selected>Korea</option>
                            <option value="Japan">Japan</option>
                            <option value="Brazil">Brazil</option>
                        </select>
                    </span>
                </div>
                <div class="inputBox">
                    <label>Search</label>
                    <input type="text" name="champId" placeholder="챔피언명, 챔피언명..." value="">
                </div>
                <button type="submit"></button>
            </div>
        </form>
        <a class="download" href="https://op.gg/desktop/?utm_source=opgg&utm_medium=button&utm_campaign=korean" target="_blank">
            <img src="./source/icon-window-white.svg" alt="window">
            <span>데스크탑 무료 다운로드</span>
        </a>
    </section>

    <section class="talkRankAll">
        <h3><a href="https://talk.op.gg/s/lol/all?sort=popular" target="_blank">OP.GG Talk 인기글</a></h3>
        <article class="talkRankBox">
            <div class="postPre">
                <span class="rankNum">1</span>
                <img src="./source/thumbnail.png">
                <span class="postInfo">
                    <span>무슨무슨 인기글입니다 옵지...옵지..옵..</span>
                    <span class="comment">[30]</span>
                    <p>프랭크오션</p>
                </span>
            </div>
            <div class="postPre">
                <span class="rankNum">2</span>
                <img src="./source/thumbnail.png">
                <span class="postInfo">
                    <span>무슨무슨 인기글입니다 옵지...옵지..옵..</span>
                    <span class="comment">[30]</span>
                    <p>코난그레이</p>
                </span>
            </div>
            <div class="postPre">
                <span class="rankNum">3</span>
                <img src="./source/thumbnail.png">
                <span class="postInfo">
                    <span>무슨무슨 인기글입니다 옵지...옵지..옵..</span>
                    <span class="comment">[30]</span>
                    <p>테일러스위프트</p>
                </span>
            </div>
            <div class="postPre">
                <span class="rankNum">4</span>
                <img src="./source/thumbnail.png">
                <span class="postInfo">
                    <span>무슨무슨 인기글입니다 옵지...옵지..옵..</span>
                    <span class="comment">[30]</span>
                    <p>악틱몽키즈</p>
                </span>
            </div>
            <div class="postPre">
                <span class="rankNum">5</span>
                <img src="./source/thumbnail.png">
                <span class="postInfo">
                    <span>무슨무슨 인기글입니다 옵지...옵지..옵..</span>
                    <span class="comment">[30]</span>
                    <p>Hippo Campus</p>
                </span>
            </div>
            <div class="postPre">
                <span class="rankNum">6</span>
                <img src="./source/thumbnail.png">
                <span class="postInfo">
                    <span>무슨무슨 인기글입니다 옵지...옵지..옵..</span>
                    <span class="comment">[30]</span>
                    <p>Joji</p>
                </span>
            </div>
            <div class="postPre">
                <span class="rankNum">7</span>
                <img src="./source/thumbnail.png">
                <span class="postInfo">
                    <span>무슨무슨 인기글입니다 옵지...옵지..옵..</span>
                    <span class="comment">[30]</span>
                    <p>Foster the people</p>
                </span>
            </div>
            <div class="postPre">
                <span class="rankNum">8</span>
                <img src="./source/thumbnail.png">
                <span class="postInfo">
                    <span>무슨무슨 인기글입니다 옵지...옵지..옵..</span>
                    <span class="comment">[30]</span>
                    <p>Wallows</p>
                </span>
            </div>
            <div class="postPre">
                <span class="rankNum">9</span>
                <img src="./source/thumbnail.png">
                <span class="postInfo">
                    <span>무슨무슨 인기글입니다 옵지...옵지..옵..</span>
                    <span class="comment">[30]</span>
                    <p>악틱몽키즈</p>
                </span>
            </div>
            <div class="postPre">
                <span class="rankNum">10</span>
                <img src="./source/thumbnail.png">
                <span class="postInfo">
                    <span>무슨무슨 인기글입니다 옵지...옵지..옵..</span>
                    <span class="comment">[30]</span>
                    <p>Steve Lacy</p>
                </span>
            </div>
        </article>
        <article class="esportsBox">
            <h4></h4>
        </article>
    </section>


    <footer class="footerBox">
        <div>
            <section class="aligndiv">
                <div>
                    <div>
                        <a href="C:\java_ssangyong\workspace3\frontWeb\src\main\java\project\opgg\html\userHistory2.html">
                            <img src ="https://s-lol-web.op.gg/images/icon/icon-opgglogo-white.svg?v=1685706247738"
                            width="99" alt="OP.GG" height="24"> 
                        </a>
                    </div>
                </div>
                <div>
                    <dl class="footerList">
                        <dt>OP.GG</dt>
                        <dd><a href="https://www.op.gg/about">About OP.GG</a></dd>
                        <dd><a href="#">Company</a></dd>
                        <dd><a href="#">Blog</a></dd>
                        <dd><a href="#">로고히스토리</a></dd>
                    </dl>
                </div>
                <div>
                    <dl class="footerList">
                        <dt>Products</dt>
                        <dd><a href="#">리그오브레전드</a></dd>
                        <dd><a href="#">데스크톱</a></dd>
                        <dd><a href="#">전략적 팀 전투</a></dd>
                        <dd><a href="#">발로란트</a></dd>
                        <dd><a href="#">배틀그라운드</a></dd>
                        <dd><a href="#">오버워치2</a></dd>
                        <dd><a href="#">이터널 리턴</a></dd>
                        <dd><a href="#">이스포츠</a></dd>
                        <dd><a href="#">톡피지지</a></dd>
                        <dd><a href="#">Duo</a></dd>
                    </dl>
                </div>
                <div>
                    <dl class="footerList">
                        <dt>Apps</dt>
                        <dd><a href="#">OP.GG Android App</a></dd>
                        <dd><a href="#">OP.GG iOS App</a></dd>
                        <dd><a href="#">TFT Android App</a></dd>
                        <dd><a href="#">TFT iOS App</a></dd>
                    </dl>
                </div>
                <div>
                    <dl class="footerList">
                        <dt>Resources</dt>
                        <dd><a href="#">개인정보처리방침</a></dd>
                        <dd><a href="#">이용약관</a></dd>
                        <dd><a href="#">도움말</a></dd>
                        <dd><a href="#">이메일 문의하기</a></dd>
                        <dd><a href="#">FAQ/피드백</a></dd>
                    </dl>
                </div>
                <div>
                    <dl class="footerList">
                        <dt>More</dt>
                        <dd><a href="#">제휴</a></dd>
                        <dd><a href="#">광고</a></dd>
                        <dd><a href="#">채용</a></dd>
                    </dl>
                </div>
            </section>
            <section class="footBottom">
                <p class="footerCopyrightText">
                    © 2012-2023 OP.GG. OP.GG isn’t endorsed by Riot Games and doesn’t reflect the views or opinions of Riot Games or anyone officially involved in producing or managing League of Legends. League of Legends and Riot Games are trademarks or registered trademarks of Riot Games, Inc. League of Legends © Riot Games, Inc.
                </p>
                <div class="footSns">
                    <img src="https://s-lol-web.op.gg/images/icon/icon-logo-twitter.svg?v=1685969162609">
                    <img src="https://s-lol-web.op.gg/images/icon/icon-logo-instagram.svg?v=1685969162609">
                    <img src="https://s-lol-web.op.gg/images/icon/icon-logo-facebook.svg?v=1685969162609">
                </div>
            </section>
        </div>
    </footer>
    <%-- ----------------------추가 ------------------------ --%>
    <script>
	    const inputUser = this.document.querySelector("input[name=userId]");

	    function chNull() {
	        if(inputUser.value == "") {
	            alert("검색어를 입력해주세요");
	            return false;
	        }
	    }
    </script>

</body>

</html>