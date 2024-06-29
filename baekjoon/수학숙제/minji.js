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
    .map(BigInt); // BigInt로 해야 제대로 된 값이 나옴
  numbers.push(...items);
});

numbers.sort((a, b) => (a < b ? -1 : a > b ? 1 : 0)); // BigInt의 정렬 방법
console.log(numbers.join('\n').trim());
