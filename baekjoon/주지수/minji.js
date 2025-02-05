const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const area = Array.from({ length: N + 1 }, () => new Array(M + 1).fill(0)); // 구역 내 사람 수
for (let i = 1; i <= N; i += 1) {
  const numbers = input[i].split(' ').map(Number);
  numbers.forEach((number, idx) => (area[i][idx + 1] = number));
}

const dp = Array.from({ length: N + 1 }, () => new Array(M + 1).fill(0)); // 누적 인구 수
dp[1][1] = area[1][1]; // 첫 번째 영토의 인원수 초기화

for (let r = 2; r <= N; r += 1) dp[r][1] = dp[r - 1][1] + area[r][1]; // 1행 인원수 누적합 구하기(위 dp 배열+현재영토의 인원 수)
for (let c = 2; c <= M; c += 1) dp[1][c] = dp[1][c - 1] + area[1][c]; // 1열 인원수 누적합 구하기(옆 dp 배열+현재영토의 인원 수)
for (let r = 2; r <= N; r += 1) {
  for (let c = 2; c <= M; c += 1)
    // 나머지 누적합 구하기
    // dp[r][c] = 위 dp 배열 + 옆 dp 배열 - 대각선 dp 배열(두 번 더해졌기 때문에 한 번빼줌)+현재 영토 인원 수
    dp[r][c] = dp[r][c - 1] + dp[r - 1][c] - dp[r - 1][c - 1] + area[r][c];
}

const K = +input[N + 1];
let result = '';
for (let i = N + 2; i < K + N + 2; i += 1) {
  const [x1, y1, x2, y2] = input[i].split(' ').map(Number);
  result +=
    dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1] + '\n'; // 만든 dp 테이블 이용하여 구하고자 하는 영역의 인원 수 구하기
}

result = result.trimEnd();
console.log(result);
