let fs = require('fs');
const n = Number(fs.readFileSync('/dev/stdin').toString());

let timesTable = '';
for (let i = 1; i <= 9; i++) {
    timesTable += n + ' * ' + i + ' = ' + (n * i) + "\n";
}

console.log(timesTable);