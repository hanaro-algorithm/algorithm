/**
 * 문제) 트리의 지름
 * 트리의 지름 = 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것
 * 1. 루트 노드에서 가장 먼 지정 찾기
 * 2. 찾은 지점에서 가장 먼 지점 찾기
 */
class Queue {
  constructor() {
    this.queue = {};
    this.headIndex = 0;
    this.tailIndex = 0;
  }
  enqueue(item) {
    this.queue[this.tailIndex] = item;
    this.tailIndex++;
  }
  dequeue() {
    const item = this.queue[this.headIndex];
    delete this.queue[this.headIndex];
    this.headIndex++;
    return item;
  }
  getLength() {
    return this.tailIndex - this.headIndex;
  }
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const V = +input[0]; // 트리의 정점의 개수
const tree = Array.from({ length: V + 1 }, () => []);
// 트리의 간선 정보 넣기
for (let v = 1; v <= V; v++) {
  const [start, ...rest] = input[v].split(' ').map(Number);
  for (let r = 0; r < rest.length; r += 2) {
    if (rest[r] === -1) break;
    tree[start].push([rest[r], rest[r + 1]]);
  }
}

const bfs = (cur) => {
  const queue = new Queue();
  queue.enqueue(cur);
  visited[cur] = 0;

  while (queue.getLength()) {
    const current = queue.dequeue();
    for (const [next, len] of tree[current]) {
      if (visited[next] === -1) {
        visited[next] = visited[current] + len;
        queue.enqueue(next);
      }
    }
  }
};

// 루트 노드에서 각 정점까지 거리
let visited = Array.from({ length: V + 1 }, () => -1);
bfs(1);

const maxDistance = Math.max(...visited); // 가장 긴 거리
const maxNode = visited.findIndex((x) => x === maxDistance); // 가장 거리가 먼 노드

// maxNode에서 시작해서 각 정점까지 거리
visited = Array.from({ length: V + 1 }, () => -1);
bfs(maxNode);

console.log(Math.max(...visited));
