/**
 * 문제) 파일 합치기
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const T = +input[0]; // 테스트 케이스 개수
let line = 1;

let answer = '';
for (let t = 0; t < T; t++) {
  const K = +input[line]; // 소설을 구성하는 장의 수
  const files = input[line + 1].split(' ').map(Number); // 수록한 파일의 크기

  // 파일 합치는 비용 누적합
  const sum = Array.from({ length: K + 1 }, () => 0);
  for (let f = 1; f <= K; f++) sum[f] = sum[f - 1] + files[f - 1];

  const dp = Array.from({ length: K + 1 }, () => new Array(K + 1).fill(0)); // dp[x][y]: x장부터 y장까지 합칠때 든 최소 비용
  // 작은 범위부터 큰 범위로 계산(Bottom-Up 방식 이용)
  for (let end = 2; end <= K; end++) {
    for (let start = end - 1; start > 0; start--) {
      let small = Number.MAX_SAFE_INTEGER;
      for (let k = 0; k < end - start; k++) {
        small = Math.min(small, dp[start][start + k] + dp[start + k + 1][end]);
      }
      dp[start][end] = small + sum[end] - sum[start - 1];
    }
  }
  answer += dp[1][K] + '\n';
  line += 2;
}

console.log(answer.trimEnd());
