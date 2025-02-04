const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 계단 수
const stairs = []; // 계단 별 점수
for (let i = 1; i <= N; i += 1) stairs.push(+input[i]);

// 계단 수가 2 이하일 경우 모든 계단의 합 출력
if (N <= 2) return console.log(stairs.reduce((acc, cur) => acc + cur, 0));

stairs.reverse(); // 계단 역정렬(마지막 계단은 무조건 밟아야 하므로)
const dp = Array.from({ length: N }, () => 0);
dp[0] = stairs[0];
dp[1] = stairs[0] + stairs[1]; // 마지막 계단과 바로 전 계단 밟았을 때의 점수
dp[2] = stairs[0] + stairs[2]; // 마지막 계단과 전전 계단 밟았을 때의 점수

for (let i = 3; i < N; i += 1) {
  // 현재 계단 위치에서 다다음 계단 밟았을 때의 점수와
  // 현재 계단 위치에서 다음 계단 밟았을 때(다다음 계단은 밟으면 안됨)의 점수 중 큰 값으로 밟기
  dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
}

console.log(Math.max(...dp));
