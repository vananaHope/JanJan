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
<link rel="stylesheet" href="./css/sub_app.css">
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
            <section><!--여기에 콘텐츠 넣으시면 됩니다.-->
            <form action="success.jsp" method="POST">
                <div class = "sub_top"><br>
                    <h2>구독 신청하기</h2>
                </div>
                <div class = "box01">
                    <div class = "info_title">
                        <h3>구독 상품 정보</h3>
                    </div>
                    <div>
                        <img class = "sub_img" src = "./img/with.png"/>
                    </div>
                    <div><br>
					    <input type="hidden" name="pname" value="다함께 잔잔박스">
					    <h2 class="name">다함께 잔잔박스</h2>
                        <div>
                        	<input type="hidden" name="cnt" value="1개">
                            <h2 class = "cnt" name = "cnt">1개</h2>
                            <input type="hidden" name="price" value="52,000원">
                            <h2 class = "pay" name = "price">52,000원/월</h2>
                        </div>
                    </div>
                    <div class = "day">
                        <div>
                            <h4>첫 구독 결제일:</h4>
                            <h4 class = "day_p" id = "current_date"></h4>
                        </div><br>
                        <div>
                            <h4>다음 배송 결제일:</h4>
                            <h4 class = "day_p" id = "current_date2"></h4>
                        </div>
						<script>
						date = new Date();
						year = date.getFullYear();
						month = date.getMonth() + 1;
						day = date.getDate();
						document.getElementById("current_date").innerHTML = year + "년" + month + "월" + day + "일";
						document.getElementById("current_date2").innerHTML = year + "년" + (month+1) + "월" + day + "일";
						</script>
                    </div>
                </div>
                <div class = "box02">
                    <div class = "info_title">
                        <h3>배송지</h3>
                    </div>
                    <div>
                        <h3 class = "in_p">수령인</h3>
                        <input class = "in_box" 
                        type = "text" name = "name" id = "name" placeholder = "성함을 입력해 주세요">
                    </div>
                    <div>
                        <h3 class = "in_p2">연락처</h3>
                        <input class = "in_box" 
                        type = "text" name = "call_num" id = "call_num" placeholder = "'-'을 제외한 숫자만 입력해 주세요.">
                    </div>
                    <div>
                        <h3 class = "in_p2">배송지</h3>
                        <input class = "in_box" 
                        type = "text" name = "address" id = "address" placeholder = "주소를 입력해 주세요">
                    </div>
                    <div>
                        <h3 class = "in_p2">배송 메모(선택)</h3>
                        <input class = "in_box2" 
                        type = "text" name = "add_memo" id = "add_memo" placeholder = "배송 메모를 입력해 주세요(50자 이내)">
                    </div>
                    
                </div>
                <div class = "box03">
                    <div class = "info_title">
                        <h3>결제 방법</h3>
                    </div>
                    <div class = "btu_pay">
                        <button class = "btu_pay1" onclick = "change_pay('신용/체크카드'); event.preventDefault();" >
                        신용/체크카드</button>
                        <button class = "btu_pay2" onclick = "change_pay('카카오Pay'); event.preventDefault();">
                        카카오Pay</button>
                        <button class = "btu_pay3" onclick = "change_pay('네이버Pay'); event.preventDefault();">
                        네이버Pay</button>
                        <input type="hidden" id="paymentMethodInput" name="paymentMethod" value="">
                    </div><br><br><br>
                    <input type="hidden" id="paymentMethodInput" name="paymentMethod" value="">
                    <div class = "info_title">
                        <h3>구독 결제 정보</h3>
                    </div>
                    <div class = "tab">
                        <div>
                            <h5 class = "left_p">결제방법</h5>
                            <h5 class = "rigth_p" id = "paymentMethod">-</h5>
                        </div><br><br>
                        <div>
                            <h5 class = "left_p">상품 금액</h5>
                            <h5 class = "rigth_p">52,000원/월</h5>
                        </div><br><br>
                        <div>
                            <h5 class = "left_p">상품 수량</h5>
                            <h5 class = "rigth_p">1개</h5>
                        </div><br><br>
                    </div>
                    <hr>
                    <div>
                        <h3 class = "left_p_b">정기 결제 금액</h3>
                        <h3 class = "rigth_p_b">52,000원</h3>
                    </div><br>
					<div class="agree_check">
					  <label>
					    <input type="checkbox" id="agreeCheckbox">구매자의 정보수집 이용에 동의(필수)*
					  </label>
					</div>
					<button class="del_btu" onclick="submitForm()">구독 신청하기</button>
					<script>
					function submitForm() {
					    var agreeCheckbox = document.getElementById("agreeCheckbox");
					    if (agreeCheckbox.checked) {
					        var paymentMethodElement = document.getElementById("paymentMethod");
					        var paymentMethod = paymentMethodElement.innerText;
					        if (paymentMethod !== "-") {
					            document.forms[0].submit();
					        } else {
					            alert("결제 방법을 선택해주세요.");
					            event.preventDefault();
					        }
					    } else {
					        alert("구매자 정보수집 이용에 동의해야 합니다.");
					        event.preventDefault();
					    }
					}

					function change_pay(method) {
					    var paymentMethodElement = document.getElementById("paymentMethod");
					    var paymentMethodInput = document.getElementById("paymentMethodInput"); // Get the hidden input field
					    paymentMethodElement.innerText = method;
					    paymentMethodInput.value = method; // Set the value of the hidden input field to the selected payment method
					}
					  
					</script>
		    </form>
            </section>
        </div>
    </div>
</body>
</html>