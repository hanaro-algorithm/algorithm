/**
 * 문제) 욕심쟁이 판다
 * 판다가 최대한 많은 칸을 이동할 때 이동할 수 있는 칸의 수
 *
 * [조건]
 * 현재 위치에 있는 대나무 다 먹으면 상하좌우 한곳으로 이동할 때,
 * 다음 칸에 있는 대나무가 이전에 있던 칸보다 많아야함
 *
 * DFS로만 풀면 시간초과 발생! + DP랑 같이 사용
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const n = +input[0]; // 대나무 숲의 크기
const forest = [];
for (let i = 1; i <= n; i++) forest.push(input[i].split(' ').map(Number));

const drdc = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

const dp = Array.from({ length: n }, () => new Array(n).fill(-1)); // 현재 위치에서 이동할 수 있는 최대 칸의 수
let result = 1;
const dfs = (r, c) => {
  // 아직 방문하지 않은 지점만 수행
  if (dp[r][c] === -1) {
    dp[r][c] = 0;
    for (const [dr, dc] of drdc) {
      const [nr, nc] = [r + dr, c + dc];
      if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
      if (forest[r][c] < forest[nr][nc]) {
        dp[r][c] = Math.max(dp[r][c], dfs(nr, nc)); // 현재 위치에서 이동할 수 있는 거리 갱신
      }
    }
  }
  return dp[r][c] + 1;
};

for (let r = 0; r < n; r++) {
  for (let c = 0; c < n; c++) {
    result = Math.max(result, dfs(r, c));
  }
}

console.log(result);
