const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 수열 A의 크기
const A = input[1].split(' ').map(Number); // 수열 A

let dp = new Array(N).fill(1);

for (let i = 1; i < N; i += 1) {
  for (let j = 0; j < i; j += 1) {
    if (A[j] < A[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
  }
}
console.log(Math.max(...dp));
