let initialBoard = [
    [1,7,5,2,3,4,9,6,8],[8,3,9,7,5,6,1,4,2],[2,4,6,8,9,1,3,5,7],
    [3,9,4,6,8,7,2,1,5],[6,2,7,3,1,5,4,8,9],[5,1,8,4,2,9,7,3,6],
    [9,6,2,5,4,3,8,7,1],[4,5,1,9,7,8,6,2,3],[7,8,3,1,6,2,5,9,4]
];

function printArray(arr) {
    let str = '';
    for (let element of arr)
        str += element + ' ';
    console.log(str)
}

function transpose(a) {
    // Calculate the width and height of the Array
    var w = a.length || 0;
    var h = a[0] instanceof Array ? a[0].length : 0;
  
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
            t[i][j] = a[j][i];
        }
    }
  
    return t;
}

function divide(a) {
    let cell = [];
    for (let i=0; i<9; i++) {
        cell[i] = [];
        for (let k=0; k<9; k++) {
            cell[i][k] = a[parseInt(i/3)*3 + parseInt(k/3)][(i%3)*3 + k%3]
        }
    }
    return cell;
}

function isSudoku(board) {
    let transBoard = transpose(board);
    let miniBoard = divide(board);
    for (let i = 0; i < 9; i++) {
        let row = board[i];
        printArray(row);
        row.sort(function(a, b) {
            return(a - b);
        });
        //printArray(row);
        for (let k = 0; k < 8; k++) {
            if (row[k] == row[k+1])
            return false;
        }
    }
    console.log();
    for (let i = 0; i < 9; i++) {
        let column = transBoard[i];
        printArray(column);
        column.sort(function(a, b) {
            return(a - b);
        });
        for (let k = 0; k < 8; k++) {
            if (column[k] == column[k+1])
                return false;
        }
    }
    console.log();
    for (let i = 0; i < 9; i++) {
        let cell = miniBoard[i];
        printArray(cell);
        cell.sort(function(a, b) {
            return(a - b);
        });
        for (let k = 0; k < 8; k++) {
            if (cell[k] == cell[k+1])
                return false;
        }
    }
    return true;
}

console.log(initialBoard.length);
console.log(isSudoku(initialBoard));