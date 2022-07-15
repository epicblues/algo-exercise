let fs = require('fs');
const input = Number(fs.readFileSync('/dev/stdin').toString());

let stars = '';

for (let i = 0; i < input; i++) {
    for (let j = 0; j < input - i - 1; j++) {
        stars += ' ';
    }

    for (let j = 0; j <=i; j++) {
        stars += '*';
    }
    stars += '\n';
}

console.log(stars);