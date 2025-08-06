const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 사자 우리의 크기

const dp = Array.from({ length: N }, () => new Array(3).fill(0));

// N=1일 때, 사자 배치 경우의 수 초기화
dp[0][0] = 1; // 사자를 놓지 않을 때
dp[0][1] = 1; // 사자를 왼쪽에 배치했을 때
dp[0][2] = 1; // 사자를 오른쪽에 배치했을 때

for (let i = 1; i < N; i++) {
  dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
  dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
  dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
}

const total = dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2];
console.log(total % 9901);
