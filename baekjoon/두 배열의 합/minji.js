/**
 * 문제) 두 배열의 합
 * 두 배열 A와 B의 부 배열의 합을 더해서 T가 되는 모든 부 배열 쌍의 개수 구하기
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
const T = +input[0]; // 합
const n = +input[1]; // A 배열의 원소 개수
const A = input[2].split(' ').map(Number); // A 배열
const m = +input[3]; // B 배열의 원소 개수
const B = input[4].split(' ').map(Number); // B 배열

const sumA = new Map(); // A 배열의 원소들로 만들 수 있는 합 종류(누적합)
for (let i = 0; i < n; i++) {
  let sum = 0;
  for (let j = i; j < n; j++) {
    sum += A[j];
    sumA.set(sum, (sumA.get(sum) || 0) + 1);
  }
}

let answer = 0;
// B의 부분 배열 합과 더해서 T를 만들 수 있는 경우만 카운트 증가
for (let i = 0; i < m; i++) {
  let sum = 0;
  for (let j = i; j < m; j++) {
    sum += B[j];
    if (sumA.has(T - sum)) answer += sumA.get(T - sum);
  }
}

console.log(answer);
