<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/global.css">
    <link rel="stylesheet" href="./css/sub.css">
    <title>잔잔</title>
    <script>
    function warning(check){
    	if(check==''){
    		if(confirm("로그인이 필요합니다. 로그인 하시겠습니까?")){
    			location.href="login.jsp"
    		}
    	}else{
    		location.href="bag.jsp"
    	}
    }
    </script>
</head>
<body>
    <div class="wrap">
        <header>
            <!--gnb-->
            <div class="inner">
                <div class="gnb">
                    <div class="gnbL">
                        <ul>
                            <li><a href="index.jsp"><img src="./img/logo.png" class="logo"></a></li>
                            <li><a href="sub.html">구독</a></li>
                            <li><a href="store.jsp">스토어</a></li>
                        </ul>
                    </div>
                    <div class="gnbR">
                        <ul>
							<c:set var="mem" value="${member}"/>
                        	<c:set var="msg" value="로그인/회원가입"/>
                        	<c:if test="${not empty mem}">
                            	<c:set var="msg" value="${mem.name}님"/>
                            </c:if>	
                            <li><a href="login.jsp">${msg}</a></li>         
                            <li><img src="./img/bag.png" onclick="warning('${mem.id}')"
								class="bag"></li>
                        </ul>
                    </div>
                </div>
            </div>
        </header>
        <div class="inner">
            <section class="sub"><!--여기에 콘텐츠 넣으시면 됩니다.-->
                <h1 class="title">매월 전통주와 안주의<br> 환상적인 조합을 맛볼 수 있는 기회</h1>
                <div class="subInner">
                    <div class="selectBox">
                            <button class="aloneBox" type="button" onclick="chPk()" id="aloneBox">
                                <div class="subBg"><img src="./img/alone.png"></div>
                                <div class="packInfo">
                                    <h1>나홀로 잔잔박스</h1>
                                    <h2>￦ 32,000/월</h2>
                                    <p>1인 ~ 2인이 즐길 수 있는 양의 술과 안주  </p>
                                </div>
                            </button>
       
         
                            <button class="partyBox" type="button" onclick="chPk2()" id="partyBox">
                                <div class="subBg"><img src="./img/with.png" alt=""></div>
                                <div class="packInfo">
                                    <h1>다같이 잔잔박스</h1>
                                    <h2>￦ 52,000/월</h2>
                                    <p>3인 ~ 4인이 즐길 수 있는 양의 술과 안주  </p>
                                </div>
                            </button>
                    </div>
                    <div class="packCh">
                        <input onclick="selPk()" type="button" id="selectPk" value="이 패키지로 할게요"></a>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <script src="./js/sub.js"></script>
</body>
</html>