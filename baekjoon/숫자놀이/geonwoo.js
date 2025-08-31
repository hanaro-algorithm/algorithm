const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = +input[0];
const nums = input[1].trim().split(" ").map(Number);
const K = +input[2];

const max = Math.max(...nums);
const dp = new Array(max * K + 1).fill(Number.MAX_SAFE_INTEGER);
dp[0] = 0;

let ans = 0;

for (let i = 1; i <= dp.length; i++) {
  for (let j = 0; j < N; j++) {
    const num = nums[j];

    if (i < num) continue;

    dp[i] = Math.min(dp[i], dp[i - num] + 1);
  }

  if (dp[i] > K) {
    ans = i;
    break;
  }
}

const winner = ans % 2 === 0 ? "holsoon" : "jjaksoon";

console.log(`${winner} win at ${ans}`);
