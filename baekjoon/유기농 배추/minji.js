/**
 * 문제) 유기농 배추
 * 최소의 배추흰지렁이 마리 수 출력하기
 * 배추흰지렁이는 인접한 배추가 있는 곳 모두 해충 잡아 먹음 => 1이 배추가 심어있는 곳, 0이 비어있는 곳
 * DFS 풀이
 * 1. 배추 밭 중 1인 곳이고 아직 배추흰지렁이가 해충 먹지 않은 경우 DFS 수행
 * 2. 현재 밭의 상하좌우로 방문하지 않았고 1인 경우 DFS 수행
 * 3. 최종적으로 DFS 수행 횟수가 출력값이 됨
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let T = +input[0]; // 테스트 케이스 개수
let line = 1;

// 상하좌우
const dxdy = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

let answer = '';
while (T--) {
  const [M, N, K] = input[line].split(' ').map(Number); // M: 가로 길이, N: 세로 길이, K: 배추 심어있는 위치 개수
  const farm = Array.from({ length: N }, () => new Array(M).fill(0));
  const visited = Array.from({ length: N }, () => new Array(M).fill(false)); // 배추 흰지렁이가 방문했는가

  // 배추밭에 심어져있는 배추 표시(1)
  for (let k = line + 1; k < line + K + 1; k++) {
    const [x, y] = input[k].split(' ').map(Number);
    farm[y][x] = 1;
  }

  // dfs 함수
  const dfs = (curY, curX) => {
    for (const [dy, dx] of dxdy) {
      const [ny, nx] = [curY + dy, curX + dx];
      if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue; // 영역 벗어나거나 이미 흰지렁이가 방문했으면 넘어가기
      // 배추밭에 배추가 존재할 경우 DFS 수행
      if (farm[ny][nx] === 1) {
        visited[ny][nx] = true;
        dfs(ny, nx);
      }
    }
    return 1;
  };

  let cnt = 0;
  for (let n = 0; n < N; n++) {
    for (let m = 0; m < M; m++) {
      // 아직 방문하지 않았거나 배추가 있으면 흰지렁이 놓기
      if (farm[n][m] === 1 && !visited[n][m]) {
        visited[n][m] = true;
        cnt += dfs(n, m);
      }
    }
  }
  answer += cnt + '\n';
  line += K + 1;
}

console.log(answer.trimEnd());
