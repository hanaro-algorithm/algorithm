/**
 * 문제) 극장 좌석
 * 사람들이 좌석에 앉을 수 있는 방법의 가짓수
 * 조건)
 * 1. VIP석은 무조건 해당 좌석에 앉아야함
 * 2. 다른 좌석은 본인 좌석 왼쪽, 오른쪽으로 이동 가능
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 좌석의 개수
const M = +input[1]; // 고정석 개수(VIP 석 개수)

// dp 생성 => dp[n]=dp[n-2]+dp[n-1]
const dp = Array.from({ length: N + 1 }, () => 0);
dp[0] = 1;
dp[1] = 1;
dp[2] = 2;
for (let d = 3; d <= N; d++) dp[d] = dp[d - 1] + dp[d - 2];

let result = 1; // 경우의 수(답)
let start = 1;
for (let i = 2; i < M + 2; i++) {
  const end = +input[i];
  result *= dp[end - start]; // VIP석을 기준으로 몇명있는지 확인
  start = end + 1;
}
if (start <= N) result *= dp[N - start + 1];
console.log(result);
