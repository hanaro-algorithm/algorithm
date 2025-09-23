const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];

// 자릿수 / 마지막 숫자 0, 1
const dp = Array.from({ length: N + 1 }, () => [0n, 0n]);
dp[1][1] = 1n;

for (let i = 2; i <= N; i++) {
  dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
  dp[i][1] = dp[i - 1][0];
}

console.log((dp[N][0] + dp[N][1]).toString());
