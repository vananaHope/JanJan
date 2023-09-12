<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="project.JanJan.VO.*"
	import="project.JanJan.DAO.*" import="java.util.*"%>

<%
SnackDao dao = new SnackDao();
double ranRate = (double) (Math.random() * 0.6);

String filterPriceS = request.getParameter("filter-price");
if(filterPriceS==null) filterPriceS="";
String filterTypeS = request.getParameter("filter-type");
if(filterTypeS==null) filterTypeS="";
List<Snack> snList = new ArrayList<Snack>();

if (filterPriceS.equals("") && filterTypeS.equals("")) {
	snList = dao.getAllList_s();
} else if (filterPriceS != null && filterTypeS.equals("")) {
	String[] arry = filterPriceS.split(",");
	int price1 = Integer.parseInt(arry[0]);
	int price2 = Integer.parseInt(arry[1]);
	snList = dao.getPriceFilter_s(price1, price2);
} else if (filterPriceS.equals("") && filterTypeS != null) {
	snList = dao.getTypeFilter_s(filterTypeS);
} else if (filterPriceS != null && filterTypeS != null) {
	String[] arry = filterPriceS.split(",");
	int price1 = Integer.parseInt(arry[0]);
	int price2 = Integer.parseInt(arry[1]);
	snList = dao.getFilter_s(price1, price2, filterTypeS);
}

for (Snack s : snList) {
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
				<h5 class="fw-bolder" name = "s_name"><%=s.getSnack_name()%></h5>
				<!-- Product price-->
				<%=String.format("%,d",s.getSnack_price())%>원
				<p class="text-black-50 p-1"><%=s.getSnack_des()%></p>
			</div>
		</div>
		<!-- Product actions-->
		<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
			<div class="text-center">
				<button class="btn btn-outline-dark mt-auto" type="submit"
				name = "s_name" value = "<%=s_name%>">
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
				<h5 class="fw-bolder" name = "s_name"><%=s.getSnack_name()%></h5>
				<!-- Product price-->
				<span class="text-muted text-decoration-line-through"><%=String.format("%,d",s.getSnack_price())%>원</span>
				<%int pri =  (int) (s.getSnack_price() - (s.getSnack_price() * ranRate));%>
				<%=String.format("%,d",pri)%>원
				<p class="text-black-50 p-1"><%=s.getSnack_des()%></p>
			</div>
		</div>
		<!-- Product actions-->
		<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
			<div class="text-center">
				<button class="btn btn-outline-dark mt-auto" type="submit"
				name = "s_name" value = "<%=s_name%>">
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