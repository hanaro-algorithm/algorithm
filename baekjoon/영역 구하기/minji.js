const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [M, N, K] = input[0].split(' ').map(Number);
const board = Array.from({ length: M }, () => new Array(N).fill(0));

// 모눈종이 위 직사각형 표시
for (let i = 1; i <= K; i += 1) {
  const [startX, startY, endX, endY] = input[i].split(' ').map(Number);
  for (let x = startX; x < endX; x += 1) {
    for (let y = startY; y < endY; y += 1) board[y][x] = 1;
  }
}

const dxdy = [
  [-1, 0],
  [0, -1],
  [1, 0],
  [0, 1],
];

const dfs = (x, y, cnt) => {
  board[y][x] = -1; // 방문 표시
  for (const [dx, dy] of dxdy) {
    const [nx, ny] = [x + dx, y + dy];
    if (nx < 0 || ny < 0 || nx >= N || ny >= M || board[ny][nx] !== 0) continue;
    cnt = dfs(nx, ny, cnt + 1);
  }
  return cnt;
};

let area = [];
for (let x = 0; x < N; x += 1) {
  for (let y = 0; y < M; y += 1) {
    // 직사각형이 아닌 영역 DFS 수행
    if (board[y][x] === 0) {
      area.push(dfs(x, y, 1));
    }
  }
}

area.sort((a, b) => a - b);
console.log(area.length + '\n' + area.join(' '));
