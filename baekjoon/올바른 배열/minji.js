const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 배열의 크기
const numbers = [];
for (let i = 1; i <= N; i++) numbers.push(+input[i]); // 배열
numbers.sort((a, b) => a - b); // 오름차순 정렬

let [start, end] = [0, 1]; // 투 포인터 시작값
let minCnt = 4; // 필요한 원소의 최댓값
while (end < N) {
  const sub = numbers[end] - numbers[start]; // 두 수의 차
  if (sub <= 4) {
    minCnt = Math.min(minCnt, 5 - (end - start + 1));
    end++;
  } else {
    minCnt = Math.min(minCnt, 5 - (end - start));
    start++;
    end++;
  }
}

console.log(minCnt);
