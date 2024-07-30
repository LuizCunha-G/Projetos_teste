const canvas = document.getElementById('chessBoard');
const context = canvas.getContext('2d');
const size = 100;

function drawBoard(){
    for(let row = 0; row < 8; row++){
        for(let col = 0; col < 8; col++){
        if((row + col) % 2 == 0){
            context.fillStyle = 'white';
        } else{
            context.fillStyle = 'black';
        }
        context.fillRect(col *  size, row * size, size, size);
        }
    }
}

drawBoard();

const pieces = {
    pawn: {
        white: 'peao_branco.png',
        black: 'peao_preto.png'
    },
    
    king: {
        white: 'rei_branco.png',
        black: 'rei_preto.png'
    },

    queen: {
        white: 'rainha_branco.png',
        black: 'rainha_preto.png'
    },

    horse: {
        white: 'cavalo_branco.png',
        black: 'cavalo_preto.png'
    },

    bishop: {
        white: 'bispo_branco.png',
        black: 'bispo_preto.png'
    },

    tower: {
        white: 'torre_branco.png',
        black: 'torre_preto.png'
    },

};

function loadImages(){
    for(const [pieces, colors] of Object.entries(pieces)){
        for(const[color, src] of Object.entries(colors)){
            const img = new Image();
            img.src = src;
            img.onload = () => {
                context.drawImage(img, col * size, row * size, size, size);
            
            };
            pieces[piece][color] = img;
        }
    }
}
loadImages();

const board = [
    ['t', 'h', 'b', 'q', 'k', 'b', 'h', 't'],
    ['p','p', 'p', 'p', 'p', 'p', 'p', 'p'],
    [' ',' ',' ',' ',' ',' ',' ',' '],
    [' ',' ',' ',' ',' ',' ',' ',' '],
    [' ',' ',' ',' ',' ',' ',' ',' '],
    [' ',' ',' ',' ',' ',' ',' ',' '],
    ['P','P', 'P', 'P', 'P', 'P', 'P'],
    ['T','H', 'B', 'Q', 'K', 'B', 'H', 'T']
];

function drawPieces(){
    for (let row = 0 ; row < 8; row++){
        for (let col = 0; col < 8; col++){
            const piece = board[row][col];
            if(piece){
                const color = piece === piece.toUpperCase() ? 'white' : 'black';
                const type = piece.toUpperCase();
                const img = piece[type][color];
                context.drawImage(img, col * size, row * size, size, size);
            }
        }
    }
}

img.onload = () =>{
    drawBoard();
    drawPieces();
}

let selectedPiece = null;

canvas.addEventListener('mousedown', (event) => {
    const x = event.offsetX;
    const y = event.offsetY;
    const col = Math.floor(x / size);
    const row = Math.floor(y / size);

    if(selectedPiece){
        board[selectedPiece.row][selectedPiece.col] = '';
        board[row][col] = selectedPiece.piece;
        selectedPiece = null;
        drawBoard();
        drawPieces();
    }
    else{
        selectedPiece = { row, col, piece: board[row][col]};
    }
})