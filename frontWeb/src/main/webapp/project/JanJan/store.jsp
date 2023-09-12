<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="project.JanJan.VO.Alcohol"
	import="project.JanJan.DAO.AlcoholDao" import="java.util.*"%>
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
	
	var page = "janjan_storedata.jsp?filter-price="+filter_price+"&filter-type="+filter_type
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
AlcoholDao dao = new AlcoholDao();

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
				<p class="lead fw-normal text-white-50 mb-0">ALCOHOL</p>
			</div>
		</div>
		<div class="inner">
			<section class="py-2">
				<div class="container px-4 px-lg-5 mt-5">
					<form method="post">
						<select id="filter-price" name="filter-price"
							class="select mb-5 me-3">
							<option value="">==가격 선택==</option>
							<option value="0,10000">1만원 이하</option>
							<option value="10000,30000">1~3만원</option>
							<option value="30000,50000">3~5만원</option>
							<option value="50000,100000">5~10만원</option>
							<option value="100000,1000000">10만원 이상</option>
						</select> <select id="filter-type" name="filter-type"
							class="select mb-5 me-3">
							<option value="">==주종 선택==</option>
							<option value="탁주">탁주</option>
							<option value="청주">청주</option>
							<option value="증류주">증류주</option>
							<option value="약주">약주</option>
							<option value="과실주">과실주</option>
							<option value="와인">와인</option>
						</select>
						<button type="button" onclick="filter()"
							class="btn btn-outline-dark mt-auto">필터 적용</button>
					</form>
					<div id="prdList"
						class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
						<%
						for (Alcohol a : dao.getAllList()) {
							String al_name = a.getAlcoholName();
							if (a.getSaleYN().equals("N")) {
						%>
						<form action="./item.jsp" method="post">
						<div class="col mb-5">
							<div class="card h-100">
								<!-- Product image-->
								<img class="card-img-top" src="<%=a.getAlcoholImg()%>" alt="..." />
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h5 class="fw-bolder" id = "al_name" name = "al_name">
										<%=a.getAlcoholName()%></h5>
										<!-- Product price-->
										<%=a.getPrice()%>원
										<p class="text-black-50 p-1"><%=a.getAlcoholDet()%></p>
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<button class="btn btn-outline-dark mt-auto" 
										type="submit" name = "al_name" value = "<%=al_name%>">
											구매하기</button>
									</div>
								</div>
							</div>
						</div>
						</form>
						<%
						} else if (a.getSaleYN().equals("Y")) {
						%>
						<form action="./item.jsp" method="post">
						<div class="col mb-5">
							<div class="card h-100">
								<!-- Sale badge-->
								<div class="badge bg-dark text-white position-absolute"
									style="top: 0.5rem; right: 0.5rem">Sale</div>
								<!-- Product image-->
								<img class="card-img-top" src="<%=a.getAlcoholImg()%>" alt="..." />
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h5 class="fw-bolder" id = "al_name" name = "al_name">
										<%=a.getAlcoholName()%></h5>
										<!-- Product price-->
										<span class="text-muted text-decoration-line-through"><%=String.format("%,d",a.getPrice())%>원</span>
										<%int pri =  (int) (a.getPrice() - (a.getPrice() * 0.2));%>
										<%=String.format("%,d",pri)%>원
										<p class="text-black-50 p-1"><%=a.getAlcoholDet()%></p>
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<button class="btn btn-outline-dark mt-auto" 
										type="submit" name = "al_name" value = "<%=al_name%>">
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