let fs = require('fs');
const input = Number(fs.readFileSync('/dev/stdin').toString());

let stars = '';
for (let i = 0; i < input; i++) {
    for (let j = 0; j < i + 1; j++) {
        stars += '*';
    }
    stars += "\n"
}

console.log(stars);