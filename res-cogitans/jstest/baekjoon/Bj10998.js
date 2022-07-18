let fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split(' ');

const a = Number(input[0]);
const b = Number(input[1]);

console.log(a * b);