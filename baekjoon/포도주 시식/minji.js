/**
 * 문제) 포도주 시식
 * 가장 많이 마실 수 있는 포도주의 양
 * [조건] - 연속으로 놓여 있는 3잔 모두 마실 수 X
 * 풀이 => DP 이용
 * DP[i] = Max(현재 포도주 X, 현재포도주O+이전포도주O+2번째전포도주X, 현재포도주O+이전포도주X+2번째전포도주O, 현재포도주O+이전포도주X+2번쨰전포도주X)
 * DP[i] = Max(DP[i-1], arr[i]+arr[i-1]+DP[i-3], arr[i]+DP[i-2]. arr[i]+DP[i-3])
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const n = +input[0]; // 포도주 잔의 개수
const grass = [];
for (let i = 1; i <= n; i++) grass.push(+input[i]); // 포도주의 양

const dp = Array.from({ length: n + 1 }, () => 0);
dp[1] = grass[0];
dp[2] = dp[1] + grass[1];

for (let i = 3; i <= n; i++) {
  dp[i] = Math.max(
    dp[i - 1],
    grass[i - 1] + grass[i - 2] + dp[i - 3],
    grass[i - 1] + dp[i - 2],
    grass[i - 1] + dp[i - 3]
  );
}

console.log(dp[n]);
