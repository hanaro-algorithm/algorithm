const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];
const numbers = input[1]
  .split(' ')
  .map(Number)
  .sort((a, b) => a - b);

let answer = 0;
for (let i = 0; i < N; i += 1) {
  let [start, end] = [0, N - 1];
  while (start < end) {
    if (i === start) {
      start += 1;
      continue;
    }
    if (i === end) {
      end -= 1;
      continue;
    }

    const sum = numbers[start] + numbers[end];
    if (sum === numbers[i]) {
      answer += 1;
      break;
    } else if (sum > numbers[i]) end -= 1;
    else start += 1;
  }
}

console.log(answer);
