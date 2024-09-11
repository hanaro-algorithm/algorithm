const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 돌의 개수
let A = input[1].split(' ').map(Number); // 돌

// 힘: (j-i)*(1+|Ai-Aj|)

let dp = new Array(N + 1).fill(-1);

dp[0] = 0;
dp[1] = 1 + Math.abs(A[1] - A[0]);

for (let i = 2; i < N; i += 1) {
  let min_step = Number.MAX_SAFE_INTEGER;
  for (let j = 0; j < i; j += 1) {
    k = Math.max((i - j) * (1 + Math.abs(A[j] - A[i])), dp[j]);
    if (min_step >= k) {
      min_step = k;
    }
  }
  dp[i] = min_step;
}

console.log(dp[N - 1]);

// https://howudong.tistory.com/211 참고
