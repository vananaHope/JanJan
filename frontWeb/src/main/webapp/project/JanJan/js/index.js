// 장바구니js
function count(type)  {
    const resultElement = document.getElementById('result');

        let number = resultElement.innerText;
        if(type === 'plus') {
            number = parseInt(number) + 1;
            
        }else if(type === 'minus')  {
            if(parseInt(number) > 1 ){
                number = parseInt(number) - 1;
            }
        }
        // 결과 출력
        resultElement.innerText = number;
    }

// 체크박스
// 회원가입
// 동의 모두선택 / 해제
const agreeChkAll = document.querySelector('input[name=check_all]');
agreeChkAll.addEventListener('change', (e) => {
let agreeChk = document.querySelectorAll('input[name=agree]');
for(let i = 0; i < agreeChk.length; i++){
    agreeChk[i].checked = e.target.checked;
}
});

// 구독
function chPk() {
    var button = document.querySelector('.aloneBox');

    var currentColor = button.style.backgroundColor;

    if (currentColor === 'rgb(202, 226, 255)') {
      button.style.backgroundColor = '';
    } else {
      button.style.backgroundColor = '#CAE2FF';
    }
  }
function chPk2() {
    var button = document.querySelector('.partyBox');

        var currentColor = button.style.backgroundColor;

    if (currentColor === 'rgb(202, 226, 255)') {
      button.style.backgroundColor = '';
    } else {
      button.style.backgroundColor = '#CAE2FF';
    }
  }


