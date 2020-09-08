const ut = require('./util');
const obj = require('./obj');

let sudokuExample = [
    [1,7,5,2,3,4,9,6,8], [8,3,9,7,5,6,1,4,2], [2,4,6,8,9,1,3,5,7],
    [3,9,4,6,8,7,2,1,5], [6,2,7,3,1,5,4,8,9], [5,1,8,4,2,9,7,3,6],
    [9,6,2,5,4,3,8,7,1], [4,5,1,9,7,8,6,2,3], [7,8,3,1,6,2,5,9,4]
];
let initialBoard1 = [   // 초급
    [6,0,0,0,2,3,0,0,0], [0,0,7,0,5,4,0,0,9], [0,0,5,0,0,0,0,1,0],
    [7,0,1,0,3,0,8,0,0], [4,6,2,5,0,1,0,0,0], [9,8,0,0,0,2,1,4,0],
    [0,0,0,0,0,0,4,3,8], [1,3,4,6,0,8,0,5,2], [2,0,8,0,0,5,9,6,1]
];
let initialBoard2 = [   // 초급
    [0,0,9,6,3,0,7,4,5], [5,2,4,1,0,0,0,6,3], [0,7,6,8,4,5,9,2,1],
    [1,0,0,4,2,6,3,7,8], [4,8,2,0,1,0,0,5,0], [0,0,7,0,0,9,0,1,4],
    [2,0,8,9,7,1,5,3,6], [0,6,1,3,5,0,4,0,0], [0,0,0,0,0,4,0,0,0]
];
let initialBoard3 = [   // 중급
    [0,0,0,7,0,0,5,3,1], [0,2,9,0,0,0,0,0,0], [0,0,0,0,0,0,9,0,0],
    [7,1,0,3,4,8,2,9,0], [0,4,0,5,0,9,0,8,3], [9,3,8,0,2,7,0,0,0],
    [4,0,2,8,0,0,6,5,0], [0,8,0,0,0,5,0,4,9], [0,7,3,9,0,4,0,0,0]
];
let initialBoard4 = [   // 중급
    [0,0,0,0,0,0,0,4,0], [0,6,0,8,3,7,0,0,0], [0,7,1,4,5,0,0,0,0],
    [1,8,0,0,9,6,0,7,4], [0,2,0,1,7,3,5,8,9], [0,0,7,0,0,0,0,3,0],
    [0,0,0,0,0,5,0,0,7], [0,3,2,0,4,8,9,1,6], [0,0,8,9,0,2,0,5,0]
];
let initialBoard5 = [    // 고급
    [0,0,2,6,0,0,0,0,9], [8,0,3,2,1,0,0,0,0], [0,0,6,9,3,5,1,2,8],
    [7,4,0,0,0,3,2,0,1], [9,3,0,0,0,0,5,0,0], [0,0,0,0,0,8,0,0,0],
    [0,0,0,0,0,0,9,0,3], [5,2,0,0,0,0,0,0,0], [0,0,0,4,0,0,0,0,0]
];
let initialBoard = [    // 고급
    [0,0,0,0,0,0,0,0,6], [0,3,9,0,1,0,5,0,0], [0,0,0,9,0,4,0,0,0],
    [0,0,0,4,0,3,0,0,0], [7,0,0,0,0,2,0,4,0], [0,0,0,0,0,7,0,8,1],
    [8,0,0,0,0,0,3,0,5], [3,0,0,0,0,6,0,7,0], [0,1,0,0,0,0,0,0,0]
];

ut.printBoard(initialBoard);
let boardObj = obj.makeBoardObj(initialBoard);
obj.printBoardObj(boardObj);
//obj.printForbidden(boardObj);

let count = 0;
for (count=0; count<50; count++) {
    let board = obj.extractValue(boardObj);
    if (ut.isSudoku(board))
        break;
    let transBoard = ut.transpose(board);
    let miniBoard = ut.divide(board);

    let rows = [], cols = [], square = [];
    for (let i=0; i<9; i++) {
        rows.push(ut.countZero(board[i]));
        cols.push(ut.countZero(transBoard[i]));
        square.push(ut.countZero(miniBoard[i]));
    }
    for (let i=0; i<9; i++) {
        if (rows[i] == 1) {
            ut.fillOne(board, i, 0);
            break;
        }
        if (cols[i] == 1) {
            ut.fillOne(board, i, 1);
            break;
        }
        if (square[i] == 1) {
            ut.fillOne(board, i, 2);
            break;
        }
    }
    boardObj = obj.makeBoardObj(board);
    obj.printBoardObj(boardObj);
}
console.log(count);