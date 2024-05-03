const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = +input[0]; // 보드 크기
const K = +input[1]; // 사과 개수

let board = Array.from({ length: N }, () => Array.from({ length: N }, () => 0));
board[0][0] = -1;

for (let i = 0; i < K; i += 1) {
  const [x, y] = input[i + 2].split(" ").map(Number);
  board[x - 1][y - 1] = 1;
}

const L = +input[2 + K]; // 뱀의 방향 변환 횟수
let direction = [];
for (let i = 0; i < L; i += 1) {
  const [X, C] = input[i + 3 + K].split(" ");
  direction.push([Number(X), C]);
}

let dx = [1, 0, -1, 0];
let dy = [0, 1, 0, -1];
let direct = 0;
let time = 0;
let snake = [[0, 0]];
let head = [0, 0];

while (true) {
  if (direction.length > 0 && direction[0][0] === time) {
    let [_, value] = direction.shift();
    direct = value === "D" ? direct + 1 : direct - 1;
    if (direct === -1) direct = 3;
    else if (direct === 4) direct = 0;
  }

  head[0] += dx[direct];
  head[1] += dy[direct];

  let [x, y] = head;
  if (x < 0 || y < 0 || x > N - 1 || y > N - 1 || board[y][x] === -1) break;

  if (board[y][x] === 0) {
    let [dx, dy] = snake.pop();
    board[dx][dy] = 0;
  }
  snake.unshift([y, x]);
  board[y][x] = -1;

  time += 1;
}

console.log(time + 1);
