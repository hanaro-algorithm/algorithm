const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const n = +input[0];
let dp = Array.from({ length: 1001 }, () => 0);

dp[1] = 1n;
dp[2] = 2n;

for (let i = 3; i <= n; i += 1) {
  dp[i] = dp[i - 1] + dp[i - 2];
}

console.log(Number(dp[n]));
