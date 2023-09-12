<%request.setCharacterEncoding("utf-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="project.JanJan.VO.*"
    import="project.JanJan.DAO.*"
    %>
<%
/* session.setAttribute("member",new Member("vanana","!Rho7777")); */
Member m1 = (Member)session.getAttribute("member");

String s_name = request.getParameter("s_name");
if(s_name==null) s_name="";
log(s_name);

String re_priS = request.getParameter("re_pri");
int repri=0;
if(re_priS!=null && !re_priS.equals("")) {
	repri = Integer.parseInt(re_priS.replaceAll(",",""));
}
String resultS = request.getParameter("result");
int result=0;
if(resultS!=null && !resultS.equals("")) {
	result = Integer.parseInt(resultS.replaceAll(",",""));
}
String prn = "N";

//String snackName, String memId, int cnt, int totalPrice
if(s_name!=null && !s_name.equals("")){
	Bag bg = new Bag (
			result,
			repri,
			s_name,
			m1.getId()
		);	
	BagDao dao = new BagDao();
	dao.insBag(bg);
	prn="Y";
}
%>
<%=prn%>