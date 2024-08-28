const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

// 큐 자료구조 구현
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
  peek() {
    return this.queue[this.headIndex];
  }
  getLength() {
    return this.tailIndex - this.headIndex;
  }
}

// 이동할 수 있는 칸
const dx = [-2, -2, -1, -1, 1, 1, 2, 2];
const dy = [-1, 1, -2, 2, -2, 2, -1, 1];

const bfs = (len, startX, startY, targetX, targetY) => {
  const queue = new Queue();
  queue.enqueue([startX, startY]); // 시작 위치 집어 넣기
  const graph = Array.from({ length: len }, () => new Array(len).fill(0)); // 방문 여부 확인하기 위한 배열
  graph[startX][startY] = 1; // 방문 표시 => 1부터 시작
  while (queue.getLength() > 0) {
    const item = queue.dequeue();
    for (let i = 0; i < 8; i += 1) {
      // 현재 칸에서 이동할 수 있는 칸 위치 구하기
      const [nextX, nextY] = [item[0] + dx[i], item[1] + dy[i]];
      if (nextX < 0 || nextY < 0 || nextX >= len || nextY >= len) continue; // 범위 벗어난 경우
      // 방문 아직 안했다면
      if (graph[nextX][nextY] === 0) {
        queue.enqueue([nextX, nextY]); // 큐에 넣기
        graph[nextX][nextY] = graph[item[0]][item[1]] + 1; // 이동거리 누적
      }
    }
  }
  return graph[targetX][targetY] - 1; // 스타트 1 제외
};

let T = +input[0]; // 테스트 케이스 개수
let line = 1;
while (T > 0) {
  const len = +input[line]; // 체스판 한 변의 길이
  const [startX, startY] = input[line + 1].split(' ').map(Number); // 시작 위치
  const [targetX, targetY] = input[line + 2].split(' ').map(Number); // 목표 위치
  const count = bfs(len, startX, startY, targetX, targetY); // bfs 수행
  console.log(count);
  T -= 1; // 테스트 케이스 차감
  line += 3; // 줄 이동
}
