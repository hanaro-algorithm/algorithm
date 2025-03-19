/**
 * 문제) 공통 부분 문자열
 * 두 문자열에 모두 포함된 부분 문자열 중 가장 긴 길이 출력
 *
 * DP 이용
 * 1. 두 문자열의 값이 같으면 DP[i-1][j-1]+1
 * 2. 같지 않으면 0
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const a = input[0];
const b = input[1];

const dp = Array.from({ length: a.length + 1 }, () =>
  Array.from({ length: b.length + 1 }, () => 0)
);

let result = 0;
for (let i = 1; i <= a.length; i++) {
  for (let j = 1; j <= b.length; j++) {
    if (a[i - 1] === b[j - 1]) {
      dp[i][j] = dp[i - 1][j - 1] + 1;
      result = Math.max(result, dp[i][j]);
    }
  }
}

console.log(result);
