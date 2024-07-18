document.addEventListener('keydown', function(event) {
    const key = event.key;
    if (isFinite(key) || key === '/' || key === '*' || key === '-' || key === '+' || key === '.') {
        appendToDisplay(key);
    } else if (key === 'Enter') {
        calculateResult();
    } else if (key === 'Backspace') {
        clearLastEntry();
    } else if (key.toLowerCase() === 'c') {
        clearDisplay();
    }
});

function appendToDisplay(value) {
    var display = document.getElementById('display');
    if (display.innerText === '0') {
        display.innerText = value;
    } else {
        display.innerText += value;
    }
}

function clearDisplay() {
    document.getElementById('display').innerText = "0";
}

function calculateResult() {
    var display = document.getElementById('display');
    try {
        display.innerText = eval(display.innerText);
    } catch (e) {
        display.innerText = "Error";
    }
}

function clearLastEntry() {
    var display = document.getElementById('display');
    display.innerText = display.innerText.slice(0, -1) || "0";
}
