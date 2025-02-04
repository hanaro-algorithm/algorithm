const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 병사 수
const soldiers = input[1].split(' ').map(Number); // 병사 전투력
const dp = Array.from({ length: N }, () => 1); // DP 배열 생성

for (let i = 1; i < N; i += 1) {
  for (let j = 0; j < i; j += 1) {
    // 앞에 배치된 병사의 전투력이 현재 병사의 전투력보다 클 경우 내림차순 병사 수 업데이트
    if (soldiers[i] < soldiers[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
  }
}

console.log(N - Math.max(...dp));
