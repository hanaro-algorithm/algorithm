class Queue {
  constructor() {
    this.queue = {};
    this.headIndex = 0;
    this.tailIndex = 0;
  }
  enqueue(item) {
    this.queue[this.tailIndex] = item;
    this.tailIndex += 1;
  }
  dequeue() {
    const item = this.queue[this.headIndex];
    delete this.queue[this.headIndex];
    this.headIndex += 1;
    return item;
  }
  getLength() {
    return this.tailIndex - this.headIndex;
  }
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];
const map = [];
for (let i = 1; i <= N; i += 1) map.push(input[i].split(' ').map(Number));

const dxdy = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

// 대륙별 영역 표시
const dfs = (x, y, city) => {
  for (const [dx, dy] of dxdy) {
    const [nx, ny] = [x + dx, y + dy];
    if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] === 0) continue;

    if (map[nx][ny] !== city) {
      map[nx][ny] = city;
      dfs(nx, ny, city);
    }
  }
};

let city = 2;
for (let i = 0; i < N; i += 1) {
  for (let j = 0; j < N; j += 1) {
    if (map[i][j] === 1) {
      map[i][j] = city;
      dfs(i, j, city);
      city += 1;
    }
  }
}

let minBridge = Number.MAX_SAFE_INTEGER;
const bfs = (x, y, c) => {
  const queue = new Queue();
  queue.enqueue([x, y]);

  const visited = Array.from({ length: N }, () => new Array(N).fill(0));
  while (queue.getLength()) {
    const [cx, cy] = queue.dequeue();

    if (map[cx][cy] > c) {
      minBridge = Math.min(minBridge, visited[cx][cy] - 1);
      break;
    }
    for (const [dx, dy] of dxdy) {
      const [nx, ny] = [cx + dx, cy + dy];
      if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] === c) continue;
      if (!visited[nx][ny]) {
        visited[nx][ny] = visited[cx][cy] + 1;
        queue.enqueue([nx, ny]);
      }
    }
  }
};

for (let i = 0; i < N; i += 1) {
  for (let j = 0; j < N; j += 1) {
    if (map[i][j] !== 0) bfs(i, j, map[i][j]);
  }
}

console.log(minBridge);
