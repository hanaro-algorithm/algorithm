const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const M = +input[0];
let contents = [];
for (let i = 1; i <= M; i += 1) contents.push(input[i].replace(/[^0-9]/g, '/'));

let numbers = [];
contents.map((content) => {
  let items = content
    .split('/')
    .filter((n) => n !== '')
    .map(Number);
  numbers.push(...items);
});

numbers.sort((a, b) => a - b).forEach((number) => console.log(number));
