const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const s1 = input[0].trim();
const s2 = input[1].trim();

const l1 = s1.length;
const l2 = s2.length;

const dp = Array.from(new Array(l1 + 1), () => new Array(l2 + 1).fill(0));

for (let i = 1; i <= l1; i++) {
  for (let j = 1; j <= l2; j++) {
    const c1 = s1[i - 1];
    const c2 = s2[j - 1];

    if (c1 === c2) {
      dp[i][j] = dp[i - 1][j - 1] + 1;
    } else {
      dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    }
  }
}

console.log(dp[l1][l2]);
