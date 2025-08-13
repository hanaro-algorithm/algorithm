const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();
const DIV = 10007;

const N = +input;
const dp = Array.from(new Array(N), () => new Array(10).fill(0));

for (let i = 0; i <= 9; i++) {
  dp[0][i] = 1;
}

for (let i = 1; i < N; i++) {
  for (let j = 0; j <= 9; j++) {
    for (let k = 0; k <= 9; k++) {
      if (k > j) break;

      dp[i][j] = (dp[i][j] + dp[i - 1][k]) % DIV;
    }
  }
}

let sum = 0;

for (let i = 0; i <= 9; i++) {
  sum = (sum + dp[N - 1][i]) % DIV;
}

console.log(sum);
