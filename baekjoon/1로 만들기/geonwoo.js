const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = +input[0];
const dp = new Array(N + 1);
dp[1] = 0;

for (let i = 2; i <= N; i++) {
  dp[i] = dp[i - 1] + 1;
  if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
  if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
}

console.log(dp[N]);
