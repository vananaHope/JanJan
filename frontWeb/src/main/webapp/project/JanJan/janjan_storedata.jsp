<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="project.JanJan.VO.*"
	import="project.JanJan.DAO.*" import="java.util.*"%>

<%
AlcoholDao dao = new AlcoholDao();
double ranRate = (double) (Math.random() * 0.6);

String filterPriceS = request.getParameter("filter-price");
if(filterPriceS==null) filterPriceS="";
String filterTypeS = request.getParameter("filter-type");
if(filterTypeS==null) filterTypeS="";
List<Alcohol> alList = new ArrayList<Alcohol>();

if (filterPriceS.equals("") && filterTypeS.equals("")) {
	alList = dao.getAllList();
} else if (filterPriceS != null && filterTypeS.equals("")) {
	String[] arry = filterPriceS.split(",");
	int price1 = Integer.parseInt(arry[0]);
	int price2 = Integer.parseInt(arry[1]);
	alList = dao.getPriceFilter(price1, price2);
} else if (filterPriceS.equals("") && filterTypeS != null) {
	alList = dao.getTypeFilter(filterTypeS);
} else if (filterPriceS != null && filterTypeS != null) {
	String[] arry = filterPriceS.split(",");
	int price1 = Integer.parseInt(arry[0]);
	int price2 = Integer.parseInt(arry[1]);
	alList = dao.getFilter(price1, price2, filterTypeS);
}

for (Alcohol a : alList) {
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
				<h5 class="fw-bolder" name = "al_name"><%=a.getAlcoholName()%></h5>
				<!-- Product price-->
				<%=String.format("%,d",a.getPrice())%>원
				<p class="text-black-50 p-1"><%=a.getAlcoholDet()%></p>
			</div>
		</div>
		<!-- Product actions-->
		<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
			<div class="text-center">
				<button class="btn btn-outline-dark mt-auto" type="submit"
				name = "al_name" value = "<%=al_name%>">
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
				<h5 class="fw-bolder" name = "al_name"><%=a.getAlcoholName()%></h5>
				<!-- Product price-->
				<span class="text-muted text-decoration-line-through"><%=String.format("%,d",a.getPrice())%>원</span>
				<%int pri = (int)(a.getPrice() - (a.getPrice() * ranRate));%>
				<%=String.format("%,d",pri)%>원
				<p class="text-black-50 p-1"><%=a.getAlcoholDet()%></p>
			</div>
		</div>
		<!-- Product actions-->
		<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
			<div class="text-center">
				<button class="btn btn-outline-dark mt-auto" type="submit"
				name = "al_name" value = "<%=al_name%>">
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
