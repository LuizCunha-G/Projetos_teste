const playBoard = document.querySelector(".play-board");
const scoreElement = document.querySelector(".score");
const highScoreElement = document.querySelector(".high-score");
const controls = document.querySelectorAll(".controls i");
const settingsScreen = document.querySelector(".settings-screen");
const wrapper = document.querySelector(".wrapper");

let gameOver = false;
let foodX, foodY;
let snakeX = 5, snakeY = 5;
let velocityX = 0, velocityY = 0;
let snakeBody = [];
let setIntervalId;
let score = 0;

let highScore = localStorage.getItem("high-score") || 0;
highScoreElement.innerText = `High Score: ${highScore}`;

const updateFoodPosition = () => {
    foodX = Math.floor(Math.random() * 30) + 1;
    foodY = Math.floor(Math.random() * 30) + 1;
}

const handleGameOver = () => {
    clearInterval(setIntervalId);
    alert("Game Over! Pressione OK para jogar novamente...");
    location.reload();
}

const changeDirection = e => {
    if(e.key === "ArrowUp" && velocityY != 1) {
        velocityX = 0;
        velocityY = -1;
    } else if(e.key === "ArrowDown" && velocityY != -1) {
        velocityX = 0;
        velocityY = 1;
    } else if(e.key === "ArrowLeft" && velocityX != 1) {
        velocityX = -1;
        velocityY = 0;
    } else if(e.key === "ArrowRight" && velocityX != -1) {
        velocityX = 1;
        velocityY = 0;
    }
}

controls.forEach(button => button.addEventListener("click", () => changeDirection({ key: button.dataset.key })));

const initGame = () => {
    if(gameOver) return handleGameOver();
    let html = `<div class="food" style="grid-area: ${foodY} / ${foodX}"></div>`;

    if(snakeX === foodX && snakeY === foodY) {
        updateFoodPosition();
        snakeBody.push([foodY, foodX]);
        score++;
        highScore = score >= highScore ? score : highScore;
        localStorage.setItem("high-score", highScore);
        scoreElement.innerText = `Score: ${score}`;
        highScoreElement.innerText = `High Score: ${highScore}`;
    }

    snakeX += velocityX;
    snakeY += velocityY;

    for (let i = snakeBody.length - 1; i > 0; i--) {
        snakeBody[i] = snakeBody[i - 1];
    }
    snakeBody[0] = [snakeX, snakeY];

    if(snakeX <= 0 || snakeX > 30 || snakeY <= 0 || snakeY > 30) {
        return gameOver = true;
    }

    let headRotation = 0;
    if (velocityX === 1) headRotation = 90;
    else if (velocityX === -1) headRotation = 270;
    else if (velocityY === 1) headRotation = 180;
    else if (velocityY === -1) headRotation = 0;

    for (let i = 0; i < snakeBody.length; i++) {
        html += `<div class="head" style="grid-area: ${snakeBody[i][1]} / ${snakeBody[i][0]}; transform: rotate(${headRotation}deg);"></div>`;
        if (i !== 0 && snakeBody[0][1] === snakeBody[i][1] && snakeBody[0][0] === snakeBody[i][0]) {
            return gameOver = true;
        }
    }

    playBoard.innerHTML = html;
}

const snakeColorInput = document.getElementById("snake-color");
const difficultySelect = document.getElementById("difficulty");
const themeSelect = document.getElementById("theme");
const startGameButton = document.getElementById("start-game");

startGameButton.addEventListener("click", () => {
    const snakeColor = snakeColorInput.value;
    const difficulty = difficultySelect.value;
    const theme = themeSelect.value;

    // Definir a cor da cobra
    document.documentElement.style.setProperty('--snake-color', snakeColor);

    // Definir o tema
    document.body.classList.remove('light', 'dark'); // Remove qualquer tema anterior
    document.body.classList.add(theme); // Adiciona o tema selecionado

    // Definir o intervalo do jogo com base na dificuldade
    let intervalTime;
    switch(difficulty) {
        case "easy":
            intervalTime = 200;
            break;
        case "medium":
            intervalTime = 125;
            break;
        case "hard":
            intervalTime = 80;
            break;
    }

    // Ocultar a tela de configurações e mostrar o jogo
    settingsScreen.style.display = "none";
    wrapper.style.display = "flex";
    updateFoodPosition();
    setIntervalId = setInterval(initGame, intervalTime);
});

document.addEventListener("keydown", changeDirection);
