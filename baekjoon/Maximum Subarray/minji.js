const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let T = +input[0];
let line = 1;

let answer = '';
while (T) {
  const N = +input[line];
  const X = input[line + 1].split(' ').map(Number);

  const dp = Array.from({ length: N }, () => 0); // dp 배열 0으로 초기화
  dp[0] = X[0]; // 맨 앞 숫자 넣기
  // 이전 누적값과 현재 값 더한 수와 현재 값 비교해서 큰 수 넣기
  for (let i = 1; i < N; i += 1) dp[i] = Math.max(dp[i - 1] + X[i], X[i]);
  answer += Math.max(...dp) + '\n';

  T -= 1;
  line += 2;
}

answer = answer.trimEnd();
console.log(answer);
