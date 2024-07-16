function appendToDisplay(value) {
    var display = document.getElementById('display');
    if (display.innerText === '0') {
        display.innerText = value;
    }
    else {
        display.innerHTML += value;
    }
}

function clearDisplay() {
    document.getElementById('display').innerText = "0"
}

function calculateResult(){
    var display = document.getElementById('display');

    if(display.innerText){
        display.innerText = eval(display.innerText);
    }

}