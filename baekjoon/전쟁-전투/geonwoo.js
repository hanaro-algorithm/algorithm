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

const [M, N] = input[0].trim().split(" ").map(Number);
const dr = [-1, 0, 1, 0];
const dc = [0, 1, 0, -1];

let map = [];
let team1 = 0;
let team2 = 0;

for (let i = 1; i <= N; i++) {
  map.push(input[i].trim().split(""));
}

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (map[i][j] === "W" || map[i][j] === "B") {
      bfs(i, j, map[i][j]);
    }
  }
}

console.log(`${team1} ${team2}`);

function bfs(sr, sc, color) {
  const q = new Queue();
  map[sr][sc] = "X";
  q.enqueue([sr, sc]);
  let cnt = 1;

  while (q.length()) {
    const [r, c] = q.dequeue();

    for (let d = 0; d < 4; d++) {
      const nr = r + dr[d];
      const nc = c + dc[d];

      if (!check(nr, nc) || map[nr][nc] !== color) continue;

      map[nr][nc] = "X";
      cnt++;
      q.enqueue([nr, nc]);
    }
  }

  if (color === "W") {
    team1 += cnt * cnt;
  } else {
    team2 += cnt * cnt;
  }
}

function check(r, c) {
  return r >= 0 && r < N && c >= 0 && c < M;
}
