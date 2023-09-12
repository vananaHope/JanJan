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