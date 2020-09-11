const ut = require('./util');
const obj = require('./obj');
const dt = require('./data');

ut.printBoard(dt.initialBoardH7);
let boardObj = obj.makeBoardObj(dt.initialBoardH7);
obj.printBoardObj(boardObj);
//obj.printForbidden(boardObj);

let count = 0;
for (count=0; count<30; count++) {
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
    obj.setFromAvailable(boardObj);
    obj.printBoardObj(boardObj);
    //obj.printAvail(boardObj);
}
console.log(count);