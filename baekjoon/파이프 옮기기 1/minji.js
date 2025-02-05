const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];
const home = [];
for (let i = 1; i <= N; i += 1) home.push(input[i].split(' ').map(Number));

// dp 풀이(가로, 세로, 대각선 방향 총 3개의 DP 배열 필요)
const dp = Array.from({ length: N }, () =>
  Array.from({ length: N }, () => new Array(3).fill(0))
);

dp[0][1][0] = 1; // 처음에 (0,1) 1로 초기화(시작 값이니까)
for (let c = 2; c < N; c += 1) {
  // 1행의 경우 올 수 있는 방향이 가로 밖에 없으므로 가로 방향으로 들어오는 수 카운트
  if (home[0][c] === 0) dp[0][c][0] = dp[0][c - 1][0];
}
for (let r = 1; r < N; r += 1) {
  for (let c = 1; c < N; c += 1) {
    // 가로, 세로 방향으로 들어오는 파이프 카운트
    if (home[r][c] === 0) {
      dp[r][c][0] = dp[r][c - 1][0] + dp[r][c - 1][2]; // 가로 방향 = 왼쪽에서 가로로 들어오거나 + 왼쪽에서 대각선으로 들어오거나
      dp[r][c][1] = dp[r - 1][c][1] + dp[r - 1][c][2]; // 세로 방향 = 위쪽에서 세로로 들어오거나 + 위쪽에서 대각선으로 들어오거나
    }
    // 대각선 방향으로 들어오는 파이프 카운트(세 곳 모두 0이어야 함)
    if (home[r][c] === 0 && home[r - 1][c] === 0 && home[r][c - 1] === 0)
      // 대각선 방향 = 왼쪽 위 대각선에서 가로로 들어오거나 + 왼쪽 위 대각선에서 세로로 들어오거나 + 왼쪽 위 대각선에서 대각선으로 들어오거나
      dp[r][c][2] =
        dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
  }
}
console.log(dp[N - 1][N - 1].reduce((acc, cur) => acc + cur, 0)); // 최종적으로 (N,N)에 들어오는 파이프 개수 출력

// // dfs 풀이
// const directions = {
//   // 가로 방향
//   w: [
//     [0, 1, 'w'], // 가로
//     [1, 1, 'd'], // 대각선
//   ],
//   // 세로 방향
//   h: [
//     [1, 0, 'h'], // 세로
//     [1, 1, 'd'], // 대각선
//   ],
//   // 대각선 방향
//   d: [
//     [0, 1, 'w'], // 가로
//     [1, 0, 'h'], // 세로
//     [1, 1, 'd'], // 대각선
//   ],
// };

// let cnt = 0;
// const dfs = (x2, y2, direction) => {
//   if (x2 === N - 1 && y2 === N - 1) cnt += 1; // (N, N)에 도달한 경우
//   for (const dire of directions[direction]) {
//     const [nx2, ny2] = [x2 + dire[0], y2 + dire[1]];
//     // 범위 벗어나거나 꼬리 칸이 1일 때
//     if (nx2 >= N || ny2 >= N || home[nx2][ny2] === 1) continue;
//     // 대각선의 경우 꼬리 칸 기준 위칸, 왼쪽칸이 1이면 안됨
//     if (
//       dire[2] === 'd' &&
//       (home[nx2 - 1][ny2] === 1 || home[nx2][ny2 - 1] === 1)
//     )
//       continue;
//     dfs(nx2, ny2, dire[2]);
//   }
// };

// dfs(0, 1, 'w');
// console.log(cnt);
