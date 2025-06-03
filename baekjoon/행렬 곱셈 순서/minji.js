/**
 * 문제) 행렬 곱셈 순서
 * 행렬 N개를 곱할 때 필요한 곱셈 연산 횟수의 최솟값
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 행렬의 개수 N
const matrix = [];
for (let i = 1; i <= N; i++) matrix.push(input[i].split(' '));

const dp = Array.from({ length: N }, () => new Array(N).fill(Infinity));

// 초기화
for (let i = 0; i < N; i++) dp[i][i] = 0;

for (let interval = 1; interval < N; interval++) {
  for (let start = 0; start + interval < N; start++) {
    let end = start + interval;
    for (let mid = start; mid < end; mid++) {
      dp[start][end] = Math.min(
        dp[start][end],
        dp[start][mid] +
          dp[mid + 1][end] +
          matrix[start][0] * matrix[mid][1] * matrix[end][1]
      );
    }
  }
}

console.log(dp[0][N - 1]);
