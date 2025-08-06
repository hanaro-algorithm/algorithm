const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const A = [...new Set(input[1].split(' ').map(Number))].sort((a, b) => a - b);
const numbers = input[3].split(' ').map(Number);

const answer = [];
numbers.forEach((n) => {
  let start = 0;
  let end = A.length - 1;
  let flag = false;

  while (start <= end) {
    let mid = Math.floor((start + end) / 2);
    if (n === A[mid]) {
      flag = true;
      break;
    } else if (n < A[mid]) end = mid - 1;
    else start = mid + 1;
  }

  answer.push(flag ? 1 : 0);
});

console.log(answer.join('\n'));
