const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 숫자의 개수 (3 ≤ N ≤ 100)
const numbers = input[1].split(' ').map(Number); // 0 이상 9 이하의 정수 N개

// DP[i][j]: i번째 숫자까지 계산했을 때 j가 나오는 경우의 수
const dp = Array.from({ length: N }, () => new Array(21).fill(BigInt(0)));

dp[0][numbers[0]] = BigInt(1); // 초기값 설정

for (let i = 1; i < N - 1; i++) {
  for (let j = 0; j < 21; j++) {
    // 이전 숫자까지 계산한 결과가 존재할 때
    if (dp[i - 1][j]) {
      if (j - numbers[i] >= 0) dp[i][j - numbers[i]] += dp[i - 1][j]; // 뺀 결과가 0 이상인 경우만
      if (j + numbers[i] <= 20) dp[i][j + numbers[i]] += dp[i - 1][j]; // 더한 결과가 20 이하인 경우만
    }
  }
}

// 최종적으로 구하고자 하는 numbers의 맨 마지막 숫자 직전까지 계산한 결과가 numbers의 맨 마지막(=N-1)이 되어야 함
console.log(dp[N - 2][numbers[N - 1]].toString());
