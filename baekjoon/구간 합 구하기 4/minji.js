const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // N: 수의 개수, M: 합 구해야 하는 횟수
const numbers = input[1].split(' ').map(Number); // N개의 숫자들
let intervals = [];
for (let i = 2; i < M + 2; i += 1)
  intervals.push(input[i].split(' ').map(Number));

let cumulativeSum = Array.from({ length: N + 1 }, () => 0); // 누적 합 담을 배열
numbers.forEach((number, index) => {
  cumulativeSum[index + 1] = cumulativeSum[index] + number; // 이전 누적 합 + 현재 숫자 값
});

let answer = '';
intervals.forEach((interval, index) => {
  const sum = cumulativeSum[interval[1]] - cumulativeSum[interval[0] - 1]; // 구간 합 구하기
  answer += index !== M - 1 ? sum + '\n' : sum;
});
console.log(answer);
