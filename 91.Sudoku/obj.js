const ut = require('./util');

module.exports = {
    printBoardObj:  function(boardObj) {
        for (let rowObj of boardObj) {
            let str = '';
            for (let cellObj of rowObj) {
                str += cellObj.value + ' ';
            }
            console.log(str);
        }
        console.log();
    },
    printForbidden:     function(boardObj) {
        for (let rowObj of boardObj) {
            for (let cellObj of rowObj) {
                if (cellObj.value == 0)
                    console.log(cellObj.row, cellObj.col, ':', cellObj.forbidden);
            }
            console.log();
        }
        console.log();
    },

    makeBoardObj:    function(board) {
        let boardObj = [];
        for (let i=0; i<9; i++) {
            let row = [];
            for (let k=0; k<9; k++) {
                let cellObj = {row: i, col: k, value: board[i][k], forbidden: []};
                row.push(cellObj);
            }
            boardObj.push(row)
        }

        for (let i=0; i<9; i++) {
            for (let k=0; k<9; k++) {
                if (board[i][k] != 0) {
                    for (let c=0; c<9; c++) {
                        if (k != c)
                            boardObj[i][c].forbidden.push(board[i][k]);
                    }
                    for (let r=0; r<9; r++) {
                        if (i != r)
                            boardObj[r][k].forbidden.push(board[i][k]);
                    }
                    for (let r=0+parseInt(i/3)*3; r<3+parseInt(i/3)*3; r++) {
                        for (let c=0+parseInt(k/3)*3; c<3+parseInt(k/3)*3; c++) {
                            if (i != r && k != c)
                                boardObj[r][c].forbidden.push(board[i][k]);
                        }
                    }
                }
            }
        }

        for (let i=0; i<9; i++) {
            for (let k=0; k<9; k++) {
                if (boardObj[i][k].value == 0) {
                    let len = boardObj[i][k].forbidden.length;
                    if (len <= 1)
                        continue;
                    boardObj[i][k].forbidden.sort(function(a, b) {
                        return(a - b);
                    });
                    let numbers = [];
                    let index = 0;
                    numbers.push(boardObj[i][k].forbidden[0]);
                    for (let f=1; f<len; f++) {
                        if (boardObj[i][k].forbidden[f] != numbers[index]) {
                            numbers.push(boardObj[i][k].forbidden[f]);
                            index++;
                        }
                    }
                    if (numbers.length == 8) {
                        boardObj[i][k].value = ut.findOneNumber(numbers);
                        boardObj[i][k].forbidden = [];
                    } else 
                        boardObj[i][k].forbidden = numbers;
                }
            }
        }
        return boardObj;
    },

    extractValue:   function(boardObj) {
        let board = [];
        for (let i=0; i<9; i++) {
            board[i] = [];
            for (let k=0; k<9; k++) {
                board[i][k] = boardObj[i][k].value;
            }
        }
        return board;
    }
}