class Queue {
  constructor() {
    this.queue = {};
    this.headIndex = 0;
    this.tailIndex = 0;
  }
  enqueue = (item) => {
    this.queue[this.tailIndex++] = item;
  };
  dequeue = () => this.queue[this.headIndex++];
  getLength = () => this.tailIndex - this.headIndex;
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // N: 세로, M: 가로
const mapInfo = [];
for (let i = 1; i <= N; i++) mapInfo.push(input[i].split('').map(Number));

const visited = Array.from(
  { length: N },
  () => Array.from({ length: M }, () => new Array(2).fill(-1)) // 벽 안 부숨 0, 벽 부숨 1
);

const queue = new Queue();
queue.enqueue([0, 0, 0]); // 현재위치(R, C), 벽 부순 여부, 벽 부술 횟수
visited[0][0][0] = 1;

const dr = [-1, 0, 1, 0];
const dc = [0, -1, 0, 1];
while (queue.getLength() > 0) {
  const [r, c, broken] = queue.dequeue();

  // 목적지 도달했을 때 이동 횟수 반환
  if (r === N - 1 && c === M - 1) {
    return console.log(visited[r][c][broken]);
  }

  for (let i = 0; i < 4; i++) {
    const [nr, nc] = [r + dr[i], c + dc[i]];
    if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue; // 범위 벗어난 경우
    if (visited[nr][nc][broken] !== -1) continue; // 이미 방문한 경우

    // 벽을 부수지 않아도 되는 경우, 이전 상태 + 1
    if (mapInfo[nr][nc] === 0) {
      visited[nr][nc][broken] = visited[r][c][broken] + 1;
      queue.enqueue([nr, nc, broken]);
    }
    // 벽을 부숴야 하는 경우(부술 횟수가 남아있어야함)
    else if (mapInfo[nr][nc] === 1 && broken === 0) {
      visited[nr][nc][1] = visited[r][c][broken] + 1;
      queue.enqueue([nr, nc, 1]);
    }
  }
}

console.log(-1); // 이동할 수 없는 경우
