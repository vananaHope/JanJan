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
    <link rel="stylesheet" href="./css/main.css">
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
function logout(){
	if(confirm("로그아웃 하시겠습니까?")){
		location.href='logout.jsp'
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
                            <li><a href="sub.jsp">구독</a></li>
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
                            <c:if test="${not empty mem}">
                            	<li onclick="logout()" style="cursor:pointer">로그아웃</li>
                            </c:if>         
                            <li><img src="./img/bag.png" onclick="warning('${mem.id}')"
								class="bag"></li>
                        </ul>
                    </div>
                </div>
            </div>
        </header>
            <section id="main"><!--여기에 콘텐츠 넣으시면 됩니다.-->

                    <div class="inner">
                        <div class="bgInner">
                            <div class="ment">
                                <h1>오늘도 <img src="./img/bgLogo.png" class="bgImg"> 하게</h1>
                                <h3>: 혼술에는 잔잔하게 혼자만의 시간 <br>
                                    함께 마실 때는 잔과 잔이 마주하는 시간</h3>
                            </div>
     
                            <div class="infoBox">
                                
                                <div class="infoContent">
                                    <h2>한 달에 한 번, <br> 집 앞으로 찾아오는 인생술 </h2>
                                </div>                             
                                <div class="infoContent">
                                    <img src="./img/subBox.png" alt="">
                                </div>
                                <div class="infoContent">
                                    <p>수많은 분들이 경험하고 있는 <br> <strong>‘굉장히 신경 쓴’</strong> 구독서비스,
                                        한번 구경해볼까요?</p>
                                </div>
                                <div class="infoContent">
                                    <div class="subBtn">
                                        <a href="./sub.html">구독하러 가기 ></a>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
   
            </section>
    </div>

</body>
</html>