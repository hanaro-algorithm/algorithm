const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 시그널 개수
const colCnt = parseInt(N / 5);

const signals = Array.from({ length: colCnt }, () => '');
for (let i = 0; i < colCnt; i++) {
  for (let j = 0; j < 5; j++) signals[i] += input[1][i + j * colCnt];
}

let answer = '';
let col = 0;
while (col < colCnt) {
  if (signals[col] === '.....') {
    col++;
    continue;
  }

  // 0, 1, 6, 8
  if (signals[col] === '#####') {
    if (col + 1 === colCnt || signals[col + 1] === '.....') {
      answer += '1';
      col += 2;
      continue;
    } else if (signals[col + 1] === '#...#') answer += '0';
    else {
      if (signals[col + 2] === '#####') answer += '8';
      else answer += '6';
    }
  } else if (signals[col] === '#.###') answer += '2';
  else if (signals[col] === '#.#.#') answer += '3';
  else if (signals[col] === '###..') answer += '4';
  else if (signals[col] === '#....') answer += '7';
  else if (signals[col] === '###.#') {
    if (signals[col + 2] === '#.###') answer += '5';
    else answer += '9';
  }
  col += 4;
}

console.log(answer);
