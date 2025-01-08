const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const board = [];
for (let i = 0; i < 5; i += 1) board.push(input[i].split(' ').map(Number));
const [r, c] = input[5].split(' ').map(Number);

const dxdy = [
  [-1, 0],
  [0, -1],
  [1, 0],
  [0, 1],
];

let answer = 0;
const visited = Array.from({ length: 5 }, () => new Array(5).fill(false));

const dfs = (x, y, apple, move) => {
  // 이동 횟수가 3번 초과이거나 현재 사과 수가 2개 이상인 경우
  if (move === 0 || apple >= 2) {
    if (apple >= 2) answer = 1;
    return;
  }
  for (const [dx, dy] of dxdy) {
    const [nx, ny] = [x + dx, y + dy];
    // 범위 벗어나는 경우
    if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || board[nx][ny] === -1)
      continue;
    // 방문하지 않은 위치인 경우
    if (!visited[nx][ny]) {
      visited[nx][ny] = true;
      dfs(nx, ny, apple + (board[nx][ny] === 1 ? 1 : 0), move - 1);
      visited[nx][ny] = false;
    }
    if (answer) return;
  }
  return;
};

visited[r][c] = true;
dfs(r, c, 0, 3);

console.log(answer);
