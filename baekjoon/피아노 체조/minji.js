const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 악보 개수
const pianoScore = input[1].split(' ').map(Number); // 악보 난이도
const Q = +input[2]; // 질문 개수

const mistake = Array.from({ length: N + 1 }, () => 0); // 실수한 부분 누적합 구하기
pianoScore.forEach((score, index) => {
  if (index !== 0) {
    if (score < pianoScore[index - 1]) mistake[index + 1] = mistake[index] + 1;
    else mistake[index + 1] = mistake[index];
  }
});

let answer = '';
for (let i = 3; i < Q + 3; i += 1) {
  const [start, end] = input[i].split(' ').map(Number);
  answer += mistake[end] - mistake[start] + '\n';
}

answer = answer.trimEnd();
console.log(answer);
