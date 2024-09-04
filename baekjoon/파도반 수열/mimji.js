const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let T = +input[0]; // 테스트케이스 개수 T

let dp = Array.from({ length: 101 }, () => 0); // dp 배열 초기화
dp[1] = 1;
dp[2] = 1;
dp[3] = 1;

// dp 배열 채워주기
for (let i = 4; i < 101; i += 1) {
  dp[i] = dp[i - 3] + dp[i - 2];
}

let line = 1;
let answer = '';
while (T > 0) {
  const N = +input[line];
  answer += dp[N] + '\n'; // 정답 구하기
  T -= 1;
  line += 1;
}

answer = answer.trimEnd();
console.log(answer);
