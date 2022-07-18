let fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');    //buffer 객체를 변환하기 위한 toString
const[n,...arr] = input;
let count = 0;

input.forEach(str => {          // 공백 검사
        if (str != '') {
            count++;
        }
}); 

console.log(count);