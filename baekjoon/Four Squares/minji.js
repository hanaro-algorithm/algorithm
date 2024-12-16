const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const n = +input[0];
const dp = Array.from({ length: n + 1 }, () => 4);

// dp 초기값 설정
dp[0] = 0;
dp[1] = 1;

for (let i = 2; i <= n; i += 1) {
  for (let j = 1; j * j <= i; j += 1) {
    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
  }
}
console.log(dp[n]);
