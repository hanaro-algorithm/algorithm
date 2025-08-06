const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");
const DIV = 9901;

const N = +input[0];
// 0: 비어있음, 1: 왼쪽 배치, 2: 오른쪽 배치
const dp = Array.from(Array(N + 1), () => Array(3).fill(0));
dp[0][0] = 1;

for (let i = 1; i <= N; i++) {
  dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % DIV;
  dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % DIV;
  dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % DIV;
}

const ans = (dp[N][0] + dp[N][1] + dp[N][2]) % DIV;
console.log(ans);
