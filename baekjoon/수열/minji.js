const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, K] = input[0].split(' ').map(Number); // N: 전체 일수, K: 연속적인 일수
const temperatures = input[1].split(' ').map(Number); // 온도

let start = 0; // 시작점
let end = K; // 끝점

let sum = 0;
for (let i = start; i < end; i += 1) sum += temperatures[i]; // 처음 온도 합
let answer = sum;

while (start < N - K) {
  sum -= temperatures[start]; // 앞 온도 빼기
  sum += temperatures[end]; // 뒤 온도 더하기
  start += 1;
  end += 1;
  answer = Math.max(answer, sum);
}

console.log(answer);
