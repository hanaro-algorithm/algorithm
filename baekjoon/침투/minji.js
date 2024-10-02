const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [M, N] = input[0].split(' ').map(Number); // MXN 격자
let grid = []; // 격자

// 0: 흰색(전류 통할 있는 물질), 1: 검은색(전류 통하지 않는 물질)
for (let i = 1; i <= M; i += 1) grid.push(input[i].split('').map(Number));

// 상하좌우
const dx = [-1, 0, 1, 0];
const dy = [0, -1, 0, 1];

let result = false; // 결과

let visited = Array.from({ length: M }, () => new Array(N).fill(false)); // 방문 표시 배열

const dfs = (x, y) => {
  for (let i = 0; i < 4; i += 1) {
    const [nx, ny] = [x + dx[i], y + dy[i]]; // 다음 칸으로 이동
    if (nx < 0 || nx >= M || ny < 0 || ny >= N || grid[nx][ny] === 1) continue; // 범위 벗어나는 경우
    // 끝에 도달하면 전투 가능
    if (nx === M - 1) {
      result = true;
      return;
    }
    // ※ 이미 방문한 곳은 더이상 전류가 흐를 수 없으므로 방문 표시 해제 안해도됨!
    if (!visited[nx][ny]) {
      visited[nx][ny] = true; // 방문 표시
      dfs(nx, ny); // dfs 수행
      if (result) return; // 전투 가능하므로 더이상 dfs 수행 X
    }
  }
};

// 바깥쪽에서 시작할 수 있는 N개
for (let i = 0; i < N; i += 1) {
  if (result) break;
  // 0(흰색)일 때만 전류 흐를 수 있으니까 그떄만 dfs 수행
  if (grid[0][i] === 0) {
    visited[0][i] = true;
    dfs(0, i);
  }
}

result ? console.log('YES') : console.log('NO');
