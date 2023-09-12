<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="project.JanJan.VO.Snack"
	import="project.JanJan.DAO.SnackDao" 
	import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="stylesheet" href="./css/store.css">
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/global.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>잔잔</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<title>잔잔 스토어</title>
<script>
function getSync(page){
	var xhr = new XMLHttpRequest();
	xhr.open("get",page,false);
	xhr.send();
	return xhr.responseText;
}

function filter() {
	var filter_price = document.querySelector("#filter-price").value;
	var filter_type = document.querySelector("#filter-type").value;
	var listObj = document.querySelector("#prdList");
	
	var page = "janjan_storedata02.jsp?filter-price="+filter_price+"&filter-type="+filter_type
	listObj.innerHTML = getSync(page)
	
}
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
<%
SnackDao dao = new SnackDao();

%>
	<div class="wrap">
		<header>
			<div class="inner">
				<div class="gnb">
					<div class="gnbL">
						<ul>
							<li><a href="index.jsp"><img src="./img/logo.png"
									class="logo"></a></li>
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
							<li><img src="./img/bag.png" onclick="warning('${mem.id}')"
									class="bag"></li>
						</ul>
					</div>
				</div>
			</div>
		</header>
		<header>
			<div class="inner">
				<div class="gnb">
					<div class="gnbL">
						<ul>
							<li><a href="store.jsp">술</a></li>
							<li><a href="store02.jsp">안주</a></li>
						</ul>
					</div>
				</div>
			</div>
		</header>
		<header>
			<div class="inner">
				<div class="gnb">
					<div class="gnbL">
						<ul>
							<li><a href="">전체상품</a></li>
							<li><a href="">신상품</a></li>
							<li><a href="">베스트</a></li>
						</ul>
					</div>
				</div>
			</div>
		</header>
		<img class="img-fluid" src="./img/alcoholImg.jpg">
		<div class="position-absolute translate-middle start-50 bottom-50">
			<div class="text-center text-white">
				<h1 class="display-5 fw-bolder">전체 상품</h1>
				<p class="lead fw-normal text-white-50 mb-0">SNACK</p>
			</div>
		</div>
		<div class="inner">
			<section class="py-2">
				<div class="container px-4 px-lg-5 mt-5">
					<form method="post">
						<select id="filter-price" name="filter-price"
							class="select mb-5 me-3">
							<option value="">==가격 선택==</option>
							<option value="0,5000">5000원 이하</option>
							<option value="0,10000">5천원~1만원</option>
							<option value="10000,20000">1~2만원</option>
							<option value="20000,30000">2~3만원</option>
						</select> <select id="filter-type" name="filter-type"
							class="select mb-5 me-3">
							<option value="">==카테고리 선택==</option>
							<option value="국/탕/찌개">국/탕/찌개</option>
							<option value="구이/볶음">구이/볶음</option>
							<option value="마른 안주">마른 안주</option>
							<option value="튀김">튀김</option>
						</select>
						<button type="button" onclick="filter()"
							class="btn btn-outline-dark mt-auto">필터 적용</button>
					</form>
					<div id="prdList"
						class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
						<%
						for (Snack s : dao.getAllList_s()) {
							String s_name = s.getSnack_name();
							if (s.getSale_YN().equals("N")) {

						%>
						<form action="./item02.jsp" method="post">
						<div class="col mb-5">
							<div class="card h-100">
								<!-- Product image-->
								<img class="card-img-top" src="<%=s.getSnack_img()%>" alt="..." />
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h5 class="fw-bolder" id = "s_name" name = "s_name">
										<%=s.getSnack_name()%></h5>
										<!-- Product price-->
										<%=String.format("%,d",s.getSnack_price())%>원
										<p class="text-black-50 p-1"><%=s.getSnack_des()%></p>
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<button class="btn btn-outline-dark mt-auto" 
										type="submit" name = "s_name" value = "<%=s_name%>">
											구매하기</button>
									</div>
								</div>
							</div>
						</div>
						</form>
						<%
						} else if (s.getSale_YN().equals("Y")) {
						%>
						<form action="./item02.jsp" method="post">
						<div class="col mb-5">
							<div class="card h-100">
								<!-- Sale badge-->
								<div class="badge bg-dark text-white position-absolute"
									style="top: 0.5rem; right: 0.5rem">Sale</div>
								<!-- Product image-->
								<img class="card-img-top" src="<%=s.getSnack_img()%>" alt="..." />
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h5 class="fw-bolder" id = "s_name" name = "s_name">
										<%=s.getSnack_name()%></h5>
										<!-- Product price-->
										<span class="text-muted text-decoration-line-through"><%=String.format("%,d",s.getSnack_price())%>원</span>
										<%int pri =  (int) (s.getSnack_price() - (s.getSnack_price() * 0.2));%>
										<%=String.format("%,d",pri)%>원
										<p class="text-black-50 p-1"><%=s.getSnack_des()%></p>
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<button class="btn btn-outline-dark mt-auto" 
										type="submit" name = "s_name" value = "<%=s_name%>">
											구매하기</button>
									</div>
								</div>
							</div>
						</div>
						</form>
						<%
						}
					}
						%>
					</div>
			</section>
		</div>
	</div>

</body>
</html>