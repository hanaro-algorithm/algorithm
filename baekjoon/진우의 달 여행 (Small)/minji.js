/**
 * 문제) 진우의 달 여행 (Small)
 * → 진우가 달에 도달하기 위해 필요한 연료의 최솟값
 *
 * [지구 → 달 이동 조건]
 * 1. 아래 방향으로만 이동 가능! 즉, 왼쪽 대각선 아래, 아래, 오른쪽 대각선 아래 세가지 방향으로만 이동 가능
 * 2. 전에 움직인 방향을 연속해서 이동 불가능
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // 행렬 크기
const space = []; // 지구와 달 사이 공간
for (let n = 1; n <= N; n++) space.push(input[n].split(' ').map(Number));

// 움직일 수 있는 방향
const directions = [
  [1, -1], // 대각선 왼쪽 아래
  [1, 0], // 아래
  [1, 1], // 대각선 오른쪽 아래
];

/* DFS로 풀이 */
let result = Number.MAX_SAFE_INTEGER;
const dfs = (r, c, direction, totalFuel) => {
  // 달에 도착한 경우, 연료의 최솟값 갱신
  if (r === N - 1) {
    result = Math.min(result, totalFuel);
    return;
  }
  for (let d = 0; d < 3; d++) {
    // 이전 방향과 다른 방향으로만 이동
    if (d !== direction) {
      const [nextR, nextC] = [r + directions[d][0], c + directions[d][1]];
      if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
        dfs(nextR, nextC, d, totalFuel + space[nextR][nextC]);
      }
    }
  }
  return;
};

for (let m = 0; m < M; m++) dfs(0, m, -1, space[0][m]);

console.log(result);

/* DP로 풀이 */
// 3차원 DP 배열 만들기(0: 왼쪽 대각선, 1: 위, 2: 오른쪽 대각선)
const dp = Array.from({ length: N }, () =>
  Array.from({ length: M }, () => new Array(3).fill(Number.MAX_SAFE_INTEGER))
);

// 초기값 세팅
for (let m = 0; m < M; m++) {
  // 1. 0 행은 모두 본인 값으로 초기화
  for (let d = 0; d < 3; d++) dp[0][m][d] = space[0][m];
}

// 범위 벗어나는지 확인하는 함수
const isValid = (r, c) => {
  return r >= 0 && r < N && c >= 0 && c < M;
};

for (let n = 1; n < N; n++) {
  for (let m = 0; m < M; m++) {
    // 위 오른쪽 대각선에서 들어올때(왼쪽 대각선 방향)
    if (isValid(n - 1, m + 1))
      dp[n][m][0] =
        Math.min(dp[n - 1][m + 1][1], dp[n - 1][m + 1][2]) + space[n][m];
    // 위에서 들어올때(아래 방향)
    if (isValid(n - 1, m))
      dp[n][m][1] = Math.min(dp[n - 1][m][0], dp[n - 1][m][2]) + space[n][m];
    // 위 왼쪽 대각선에서 들어올때(오른쪽 대각선 방향)
    if (isValid(n - 1, m - 1))
      dp[n][m][2] =
        Math.min(dp[n - 1][m - 1][0], dp[n - 1][m - 1][1]) + space[n][m];
  }
}

for (let m = 0; m < M; m++) {
  for (let d = 0; d < 3; d++) result = Math.min(result, ...dp[N - 1][m]);
}
console.log(result);
