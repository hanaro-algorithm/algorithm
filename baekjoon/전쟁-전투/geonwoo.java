class Queue {
  constructor() {
    this.queue = {};
    this.head = 0;
    this.tail = 0;
  }

  enqueue = (item) => {
    this.queue[this.tail++] = item;
  };
  dequeue = () => this.queue[this.head++];
  length = () => this.tail - this.head;
}

const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");
const dr = [-1, 0, 1, 0];
const dc = [0, 1, 0, -1];

const [N, M] = input[0].split(" ").map(Number);
const map = [];
let sheep = 0;
let wolf = 0;

for (let i = 1; i <= N; i++) {
  map.push(input[i].trim().split(""));
}

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (map[i][j] !== "#") bfs(i, j);
  }
}

console.log(`${sheep} ${wolf}`);

function bfs(sr, sc) {
  let sheepCnt = 0;
  let wolfCnt = 0;

  if (map[sr][sc] === "v") wolfCnt++;
  else if (map[sr][sc] === "k") sheepCnt++;

  const q = new Queue();
  q.enqueue([sr, sc]);
  map[sr][sc] = "#";

  while (q.length()) {
    const [r, c] = q.dequeue();

    for (let d = 0; d < 4; d++) {
      let nr = r + dr[d];
      let nc = c + dc[d];

      if (!check(nr, nc) || map[nr][nc] === "#") continue;

      if (map[nr][nc] === "v") wolfCnt++;
      else if (map[nr][nc] === "k") sheepCnt++;
      map[nr][nc] = "#";
      q.enqueue([nr, nc]);
    }
  }

  if (sheepCnt > wolfCnt) sheep += sheepCnt;
  else wolf += wolfCnt;
}

function check(r, c) {
  return r >= 0 && r < N && c >= 0 && c < M;
}
