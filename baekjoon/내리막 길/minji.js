/**
 * 문제) 내리막 길
 * - 각 칸에는 그 지점의 높이가 쓰여있음
 * - 이동은 상하좌우로만 가능
 * - 이동할 때 힘을 덜 쓰기 위해 높이가 더 낮은 지점으로만 이동
 * 출력) (0,0)에서 (M-1, N-1)로 이동 가능한 경로의 수
 *
 * 풀이) DFS + DP 이용
 * 시작 지점에서 출발해서 DP 테이블이 갱신되지 않은 곳 만나면
 * 해당 지점부터 도착지점까지 갈 수 있는 경로의 수 업데이트
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [M, N] = input[0].split(' ').map(Number); // M: 세로 크기, N: 가로 크기
const map = Array.from({ length: M }, () => []);
for (let i = 1; i <= M; i++) map[i - 1] = input[i].split(' ').map(Number);

const drdc = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];
const dp = Array.from({ length: M }, () => new Array(N).fill(-1));

const dfs = (r, c) => {
  // 목적지 도착한 경우 1 리턴
  if (r === M - 1 && c === N - 1) {
    return 1;
  }

  // 이미 방문한 적 있으면 그 위치에서 출발하는 경우의 수 리턴
  if (dp[r][c] !== -1) return dp[r][c];

  let ways = 0;
  for (const [dr, dc] of drdc) {
    const [nr, nc] = [r + dr, c + dc];
    if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
    if (map[r][c] > map[nr][nc]) {
      ways += dfs(nr, nc);
    }
  }
  dp[r][c] = ways;
  return dp[r][c];
};

console.log(dfs(0, 0));
