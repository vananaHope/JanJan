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
  
  
function selPk() {
    var aloneBoxSelected = document.querySelector('.aloneBox').style.backgroundColor === 'rgb(202, 226, 255)';
    var partyBoxSelected = document.querySelector('.partyBox').style.backgroundColor === 'rgb(202, 226, 255)';
    if (aloneBoxSelected) {
            window.location.href = "sub_app_alone.jsp";
    } else if(partyBoxSelected) {
            window.location.href = "sub_app_with.jsp";
    }
}