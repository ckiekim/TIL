const ut = require('./util');

module.exports = {
    printBoardObj:  function(boardObj) {
        let count = 0;
        for (let rowObj of boardObj) {
            let str = '';
            for (let cellObj of rowObj) {
                str += ' ' + cellObj.value;
                if (cellObj.value == 0)
                    count++;
            }
            console.log(str);
        }
        console.log(count);
    },
    printForbidden: function(boardObj) {
        for (let rowObj of boardObj) {
            for (let cellObj of rowObj) {
                if (cellObj.value == 0)
                    console.log(cellObj.row, cellObj.col, ':', cellObj.forbidden);
            }
            console.log();
        }
        console.log();
    },
    printAvail: function(boardObj) {
        for (let rowObj of boardObj) {
            for (let cellObj of rowObj) {
                if (cellObj.value == 0)
                    console.log(cellObj.row, cellObj.col, ':', cellObj.avail);
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
                let cellObj = {row: i, col: k, value: board[i][k], forbidden: [], avail: []};
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
                        boardObj[i][k].avail = [];
                    } else {
                        boardObj[i][k].forbidden = numbers;
                        let tmpArr = this.findAvail(numbers);
                        for (let tmp of tmpArr)
                            boardObj[i][k].avail.push(tmp);
                    }
                }
            }
        }
        return boardObj;
    },

    findAvail:  function(forbidden) {
        let avail = [];
        let numberStr = '123456789';
        for (let n of forbidden)
            numberStr = numberStr.replace(String(n), '');
        for (let i=0; i<numberStr.length; i++)
            avail.push(parseInt(numberStr.charAt(i)));
        return avail;
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
    },

    commonAvailable:    function(orgObj, tmpObj, mode) {
        for (let rowObj of tmpObj) {
            let numberStr = '123456789';
            let blankCells = [];
            for (let cellObj of rowObj) {
                if (cellObj.value != 0) {
                    numberStr = numberStr.replace(String(cellObj.value), '');
                } else {
                    blankCells.push(cellObj);
                    if (mode == 0)
                        console.log(cellObj.row, cellObj.col, ':', cellObj.forbidden, cellObj.avail);
                }
            }
            if (numberStr.length == 0)
                continue;
            //console.log(blankCells.length, numberStr);
            for (let i=0; i<numberStr.length; i++) {
                let number = parseInt(numberStr.charAt(i));
                let count = 0;
                for (let cellObj of blankCells) {
                    //console.log(number, cellObj.avail);
                    for (let anum of cellObj.avail) {
                        //console.log(anum, number);
                        if (anum == number)
                            count++;
                    }
                }
                //console.log(count);
                if (count == 1) {
                    //console.log("Found count==1,", mode);
                    for (let cellObj of blankCells) {
                        for (let anum of cellObj.avail) {
                            if (anum == number) {
                                orgObj[cellObj.row][cellObj.col].value = number;
                                orgObj[cellObj.row][cellObj.col].forbidden = [];
                                orgObj[cellObj.row][cellObj.col].avail = [];
                                return true;
                            }                                
                        }
                    }
                }
            }
        }
        return false;
    },

    setFromAvailable:   function(boardObj) {
        //console.log('Row');
        if (this.commonAvailable(boardObj, boardObj, 1))
            return;
        //console.log('Column'); 
        let transObj = ut.transpose(boardObj);
        if (this.commonAvailable(boardObj, transObj, 2))
            return;
        //console.log('Square'); 
        let squareObj = ut.divide(boardObj);
        //this.printAvail(squareObj);
        if (this.commonAvailable(boardObj, squareObj, 3))
            return;
    }
}