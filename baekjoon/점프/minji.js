/**
 * 문제) 점프
 * (0,0)에서 (N,N)으로 점프해서 이동할 수 있는 경로의 개수 출력
 * - 각 칸에 적혀있는 수만큼 이동 가능
 * - 이동은 오른쪽이나 아래쪽으로만 이동 가능
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 게임 판의 크기
const board = [];
for (let n = 1; n <= N; n++) board.push(input[n].split(' ').map(Number));

const dp = Array.from({ length: N }, () =>
  Array.from({ length: N }, () => BigInt(0))
); // 각 칸에 올 수 있는 경우의 수
dp[0][0] = BigInt(1); // (0, 0) 위치 1로 초기화

const drdc = [
  [1, 0], // 아래로
  [0, 1], // 오른쪽으로
];

for (let r = 0; r < N; r++) {
  for (let c = 0; c < N; c++) {
    if (board[r][c] === 0) continue; // 더 이상 이동 불가능한 경우

    const moveNum = board[r][c];
    for (const [dr, dc] of drdc) {
      const [nextR, nextC] = [r + dr * moveNum, c + dc * moveNum];
      if (nextR < N && nextC < N) {
        dp[nextR][nextC] += dp[r][c]; // 직전 칸의 경우의 수로 갱신
      }
    }
  }
}

console.log(dp[N - 1][N - 1].toString());
