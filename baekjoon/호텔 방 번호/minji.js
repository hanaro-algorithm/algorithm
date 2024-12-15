const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let line = 0;
let answer = '';
while (true) {
  if (input[line] === '') break;
  const [N, M] = input[line].split(' ').map(Number);
  let cnt = 0; // 방의 개수
  for (let i = N; i <= M; i += 1) {
    const numbers = new Set();
    i.toString()
      .split('')
      .forEach((num) => numbers.add(num)); // 중복 제거
    if (numbers.size === i.toString().length) cnt += 1;
  }
  answer += cnt + '\n';
  line += 1;
}

answer = answer.trimEnd();
console.log(answer);
