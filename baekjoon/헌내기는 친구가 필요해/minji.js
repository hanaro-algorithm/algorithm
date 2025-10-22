/**
 * 주어진 캠퍼스 정보를 통해 만날 수 있는 사람의 수 출력
 * BFS 이용
 * 1. 상하좌우로 이동(영역 벗어나지 않는 선에서), 방문 표시(재방문 X)
 * 2. P를 만나면 사람 카운트
 * 3. Queue에 들어있는 좌표 데이터가 없을 때까지 반복
 */
class Queue {
  constructor() {
    this.queue = {};
    this.headIdx = 0;
    this.tailIdx = 0;
  }
  enqueue = (data) => {
    this.queue[this.tailIdx++] = data;
  };
  dequeue = () => this.queue[this.headIdx++];
  getLength = () => this.tailIdx - this.headIdx;
}

const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const [N, M] = input[0].split(" ").map(Number);
const campusInfo = [];

const dr = [-1, 0, 1, 0];
const dc = [0, -1, 0, 1];

const visited = Array.from({ length: N }, () => new Array(M).fill(false));

const queue = new Queue();
for (let i = 1; i <= N; i++) {
  const info = input[i].split("");
  campusInfo.push(info);
  if (queue.getLength() > 0) continue;
  for (let j = 0; j < M; j++) {
    if (info[j] === "I") {
      visited[i - 1][j] = true;
      queue.enqueue([i - 1, j]);
    }
  }
}

let answer = 0;
while (queue.getLength() > 0) {
  const [curR, curC] = queue.dequeue();

  if (campusInfo[curR][curC] === "P") answer++;

  for (let i = 0; i < 4; i++) {
    const [nextR, nextC] = [curR + dr[i], curC + dc[i]];
    if (
      nextR < 0 ||
      nextC < 0 ||
      nextR >= N ||
      nextC >= M ||
      campusInfo[nextR][nextC] === "X"
    )
      continue;
    if (!visited[nextR][nextC]) {
      visited[nextR][nextC] = true;
      queue.enqueue([nextR, nextC]);
    }
  }
}

if (answer === 0) console.log("TT");
else console.log(answer);
