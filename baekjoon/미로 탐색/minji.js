class Queue {
  constructor() {
    this.headIndex = 0;
    this.tailIndex = 0;
    this.queue = {};
  }
  enqueue(item) {
    this.queue[this.tailIndex] = item;
    this.tailIndex++;
  }
  dequeue() {
    const data = this.queue[this.headIndex];
    delete this.queue[this.headIndex];
    this.headIndex++;
    return data;
  }
  getLength() {
    return this.tailIndex - this.headIndex;
  }
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const maze = [];
for (let i = 1; i <= N; i += 1) maze.push(input[i].split('').map(Number));

const visited = Array.from({ length: N }, () =>
  Array.from({ length: M }, () => 0)
);
const queue = new Queue();
queue.enqueue([0, 0]); // (1, 1) 처음 위치 큐에 넣기
visited[0][0] = 1; // 첫 칸부터 카운트 시작

const dxdy = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

while (queue.getLength() > 0) {
  const [currentX, currentY] = queue.dequeue();
  // 목적지 도착한 경우 최소 칸 이동 출력
  if (currentX === N - 1 && currentY === M - 1)
    return console.log(visited[N - 1][M - 1]);

  for (const [dx, dy] of dxdy) {
    const [nx, ny] = [currentX + dx, currentY + dy];
    // 범위 벗어나거나 빈칸이 아닌 경우
    if (nx < 0 || ny < 0 || nx >= N || ny >= M || maze[nx][ny] === 0) continue;
    if (visited[nx][ny] === 0) {
      visited[nx][ny] = visited[currentX][currentY] + 1;
      queue.enqueue([nx, ny]);
    }
  }
}
