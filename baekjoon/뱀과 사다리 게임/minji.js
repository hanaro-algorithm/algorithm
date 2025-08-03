class Queue {
  constructor() {
    this.queue = {};
    this.headIdx = 0;
    this.tailIdx = 0;
  }
  enqueue = (item) => {
    this.queue[this.tailIdx++] = item;
  };
  dequeue = () => this.queue[this.headIdx++];
  getLength = () => this.tailIdx - this.headIdx;
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // N: 사다리의 수, M: 뱀의 수
const gameBoard = Array.from({ length: 100 }, (_, i) => i); // 게임판 상태
for (let i = 1; i <= N + M; i++) {
  const [x, y] = input[i].split(' ').map(Number);
  gameBoard[x - 1] = y - 1; // 뱀/사다리 존재하고, 이동할 칸 번호 저장
}

const visited = Array.from({ length: 100 }, () => -1); // 방문 배열
const queue = new Queue();
queue.enqueue(0); // 0번 칸
visited[0] = 0;

while (queue.getLength() > 0) {
  const current = queue.dequeue();

  for (let num = 1; num <= 6; num++) {
    const next = gameBoard[current + num]; // 이동할 다음 칸
    if (next === 99) {
      visited[next] = visited[current] + 1;
      return console.log(visited[99]);
    }
    // 영역 벗어나거나, 이미 방문한 경우 패스
    if (visited[next] !== -1 || next >= 100) continue;

    queue.enqueue(next);
    visited[next] = visited[current] + 1;
  }
}
