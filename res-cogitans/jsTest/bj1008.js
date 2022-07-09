let fs = require('fs');     // Node.js의 'fs' 모듈을 불러옴
const input =fs.readFileSync('/dev/stdin').toString().trim().split(' ');    //buffer 객체를 변환하기 위한 toString

const a = input[0];
const b = input[1];

console.log(a/b);