/**
 * 문제) 이친수
 * N자리 이친수 개수 구하기
 * 이친수: 0과 1로 이루어진 수
 * - 이친수는 0으로 시작 X(1로 시작)
 * - 1이 두 번 연속 나올 수 X
 *
 * - 백트래킹 풀이: N자리 수이므로 O(2^N) N이 최대 90이므로 2^90 -> 시간초과
 * - BFS 풀이: 메모리 초과
 * - DP 풀이: dp[N자리 수][0 또는 1] = N자리까지 이친수를 구했을 때 0 혹은 1이 올 수 있는 개수
 * ex) dp[1][0]: 1자리 수에 0이 올 수 있는 개수 = 0
 * dp[1][1]: 1자리 수에 1이 올 수 있는 개수 = 1
 * dp[2][0]: 2자리 수에 0이 올 수 있는 개수(-> 앞이 0 또는 1 모두 가능) = dp[1][0] + dp[1][1] = 0 + 1
 * dp[2][1]: 2자리 수에 1이 올 수 있는 개수(-> 앞에 0이어야함) = dp[1][0] = 0
 * 따라서, dp[n][0] = dp[n-1][0] + dp[n-1][1] 이고, dp[n][1] = dp[n-1][0]
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // N자리수
const dp = Array.from({ length: N + 1 }, () => new Array(2).fill(BigInt(0))); // dp 생성

// 초기값 세팅(첫번째 자리에는 1밖에 못옴)
dp[1][0] = BigInt(0);
dp[1][1] = BigInt(1);

for (let i = 2; i <= N; i++) {
    dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
    dp[i][1] = dp[i - 1][0];
}

console.log(String(dp[N][0] + dp[N][1]));
