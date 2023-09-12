<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/global.css">
<link rel="stylesheet" href="./css/sub.css">
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
<title>잔잔</title>
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
            <section class="successInner"><!--여기에 콘텐츠 넣으시면 됩니다.-->
               <div class="coment">
                    <img src="./img/check.png" alt="">
                    <h3>구독 신청이 완료되었습니다</h3>
               </div>
               <div class="infoBox">
                    <div class="infoBoxInner">
                        <h3>상품명 : <%=request.getParameter("pname") %></h3>
                        <h4>구독 결제일: <span id = "current_date"></span></h4>
                    </div>
                    <script>
						date = new Date();
						year = date.getFullYear();
						month = date.getMonth() + 1;
						day = date.getDate();
						document.getElementById("current_date").innerHTML = year + "년" + month + "월" + day + "일";
					</script>
                    
               </div>
				<div class="infoBox">
				    <div class="infoBoxInner">
						<h3>배송 정보</h3>
				        <h4>수령인 : <%= request.getParameter("name") %></h4>
				        <h4>연락처 : <%= request.getParameter("call_num") %></h4>
				        <h4>주소 : <%= request.getParameter("address") %></h4>
				        <h4>배송 메모 : <%= request.getParameter("add_memo") %></h4>
				    </div>
				</div>
               <div class="infoBox">
                    <div class="infoBoxInner">
                        <h3>구독 결제 정보</h3>
                        <hr>
                        <div class="subPay">
                            <p>결제방법</p>
                            <%String sel_pay = request.getParameter("paymentMethod");%>
                            <p><%=sel_pay %></p>
                        </div>
                        <div class="subPay">
                            <p>상품 금액</p>
                            <p><%=request.getParameter("price") %>/월</p>
                        </div>
                        <div class="subPay">
                            <p>상품 수량</p>
                            <p><%=request.getParameter("cnt") %></p>
                        </div>
                    <hr>
                    <div class="subPay">
                        <h3>정기 결제 금액</h3>
                        <h3><%=request.getParameter("price") %></h3>
                    </div>

                </div>
               </div>

            </section>
        </div>
    </div>
</body>
</html>