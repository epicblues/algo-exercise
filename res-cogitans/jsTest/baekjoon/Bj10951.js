let fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

for (let i = 0; i < input.length - 1; i++) {
    let aAndB = input[i].split(' ');
    const a = Number(aAndB[0]);
    const b = Number(aAndB[1]);

    if (aAndB[0] == 0 && aAndB[1] == 0) {
        break;
    }
    console.log(a + b);
}