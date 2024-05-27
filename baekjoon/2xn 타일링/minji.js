const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const n = +input[0];
let dp = Array.from({ length: 1001 }, () => 0);

dp[1] = 1;
dp[2] = 2;

for (let i = 3; i <= n; i += 1) {
  dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
  // dp 테이블에 너무 큰 값이 들어가지 않도록 10007을 나눈 값을 넣기
}

console.log(dp[n]);
