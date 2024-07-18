// Estado inicial do jogo
let currentPlayer = 'X';
let board = Array(9).fill('');
let gameActive = true;
let score1 = 0;
let score2 = 0;
const mensagem = document.getElementById('mensagem');
const score1Element = document.getElementById('score1');
const score2Element = document.getElementById('score2');

// Função para lidar com o clique na célula
function handleCellClick(event) {
    const clickedBox = event.target;
    const clickedBoxIndex = Array.from(document.querySelectorAll('.box')).indexOf(clickedBox);

    if (board[clickedBoxIndex] !== '' || !gameActive) {
        return;
    }

    // Atualiza o estado do jogo
    board[clickedBoxIndex] = currentPlayer;
    clickedBox.innerText = currentPlayer;
    clickedBox.classList.add(currentPlayer.toLowerCase());

    console.log(`Célula clicada: ${clickedBoxIndex}`);
    console.log(`Tabuleiro atual:`, board);

    // Verifica se há um vencedor ou empate
    if (checkWin()) {
        mensagem.innerText = `Jogador ${currentPlayer} venceu!`;
        if (currentPlayer === 'X') {
            score1++;
            score1Element.innerText = score1;
        } else {
            score2++;
            score2Element.innerText = score2;
        }
        gameActive = false;
    } else if (board.every(cell => cell !== '')) {
        mensagem.innerText = 'Empate!';
        gameActive = false;
    } else {
        currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
        mensagem.innerText = `Vez do jogador ${currentPlayer}`;
    }
}

// Função para verificar as combinações vencedoras
function checkWin() {
    const winPatterns = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8], // Linhas
        [0, 3, 6], [1, 4, 7], [2, 5, 8], // Colunas
        [0, 4, 8], [2, 4, 6]             // Diagonais
    ];

    return winPatterns.some(pattern => {
        return pattern.every(index => board[index] === currentPlayer);
    });
}

// Função para reiniciar o jogo
function reiniciarJogo() {
    currentPlayer = 'X';
    board = Array(9).fill('');
    gameActive = true;
    mensagem.innerText = `Vez do jogador ${currentPlayer}`;
    document.querySelectorAll('.box').forEach(box => {
        box.innerText = '';
        box.classList.remove('x', 'o');
    });

    console.log('Jogo reiniciado!');
    console.log('Tabuleiro resetado:', board);
}

// Adiciona eventos de clique a todas as células
document.querySelectorAll('.box').forEach(box => box.addEventListener('click', handleCellClick));

// Inicializa a mensagem do jogo
mensagem.innerText = `Vez do jogador ${currentPlayer}`;
