module.exports = {
    printArray:     function (arr) {
        let str = '';
        for (let element of arr)
            str += element + ' ';
        console.log(str)
    },
    printBoard:     function (board) {
        for (let arr of board) 
            this.printArray(arr);
        console.log();
    },
    
    transpose:      function (board) {
        // Calculate the width and height of the Array
        var w = board.length || 0;
        var h = board[0] instanceof Array ? board[0].length : 0;
      
        // In case it is a zero matrix, no transpose routine needed.
        if(h === 0 || w === 0) { return []; }
      
        /**
         * @var {Number} i Counter
         * @var {Number} j Counter
         * @var {Array} t Transposed data is stored in this array.
         */
        var i, j, t = [];
      
        // Loop through every item in the outer array (height)
        for(i=0; i<h; i++) {
            // Insert a new row (array)
            t[i] = [];
    
            // Loop through every item per item in outer array (width)
            for(j=0; j<w; j++) {
                // Save transposed data.
                t[i][j] = board[j][i];
            }
        }
      
        return t;
    },
    
    divide:     function (board) {
        let square = [];
        for (let i=0; i<9; i++) {
            square[i] = [];
            for (let k=0; k<9; k++) {
                square[i][k] = board[parseInt(i/3)*3 + parseInt(k/3)][(i%3)*3 + k%3]
            }
        }
        return square;
    },
    
    isMiniSudoku:   function (arr) {
        for (let i = 0; i < 9; i++) {
            let mini = JSON.parse(JSON.stringify(arr[i]));
            //this.printArray(mini);
            mini.sort(function(a, b) {
                return(a - b);
            });
            if (mini[0] == 0)
                return false;
            for (let k = 0; k < 8; k++) {
                if (mini[k] == mini[k+1])
                    return false;
            }
        }
        return true;
    },
    
    isSudoku:       function (board) {
        let transBoard = this.transpose(board);
        let squareBoard = this.divide(board);
        if (!this.isMiniSudoku(board))
            return false;
        //console.log();
        if (!this.isMiniSudoku(transBoard))
            return false;
        //console.log();
        if (!this.isMiniSudoku(squareBoard))
            return false;
        return true;
    },

    countZero:      function(arr) {
        let count = 0;
        for (let element of arr) {
            if (element == 0)
                count++;
        }
        return count;
    },

    findOneNumber:     function(arr) {
        let numbers = '123456789';
        for (let element of arr) {
            if (element != 0) {
                numbers = numbers.replace(String(element), '');
            }
        }
        return parseInt(numbers);
    },

    fillOne:        function(board, index, kind) {
        if (kind == 0) {
            for (let i=0; i<9; i++) {
                if (board[index][i] == 0) {
                    board[index][i] = this.findOneNumber(board[index]);
                }
            }
        } else if (kind == 1) {
            let transBoard = this.transpose(board);
            for (let i=0; i<9; i++) {
                if (board[i][index] == 0) {
                    board[i][index] = this.findOneNumber(transBoard[index]);
                }
            }
        } else {
            let squareBoard = this.divide(board);
            for (let i=0; i<9; i++) {
                if (squareBoard[index][i] == 0) {
                    board[parseInt(index/3)*3 + parseInt(i/3)][(index%3)*3 + i%3] = this.findOneNumber(squareBoard[index]);
                }
            }
        }
    }
}
