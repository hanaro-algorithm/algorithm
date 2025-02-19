const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

class PriorityQueue {
  constructor() {
    this.queue = [];
  }
  getParentIndex = (childIndex) => parseInt((childIndex - 1) / 2);
  getLeftChildIndex = (parentIndex) => parentIndex * 2 + 1;
  getRightChildIndex = (parentIndex) => parentIndex * 2 + 2;

  enqueue = (priority, x, y) => {
    this.queue.push({ priority, x, y });
    this.heapifyUp();
  };
  heapifyUp = () => {
    let index = this.queue.length - 1;
    const lastInsertedNode = this.queue[index];
    while (index > 0) {
      const parentIndex = this.getParentIndex(index);
      if (this.queue[parentIndex].priority <= lastInsertedNode.priority) break;
      this.queue[index] = this.queue[parentIndex];
      index = parentIndex;
    }
    this.queue[index] = lastInsertedNode;
  };
  dequeue = () => {
    const count = this.queue.length;
    if (count <= 0) return undefined;
    if (count === 1) return this.queue.pop();
    const rootNode = this.queue[0];
    this.queue[0] = this.queue.pop();
    this.heapifyDown();
    return rootNode;
  };
  heapifyDown = () => {
    let index = 0;
    const count = this.queue.length;
    const rootNode = this.queue[index];
    while (this.getLeftChildIndex(index) < count) {
      const leftChildIndex = this.getLeftChildIndex(index);
      const rightChildIndex = this.getRightChildIndex(index);

      const smallerChildIndex =
        rightChildIndex < count &&
        this.queue[rightChildIndex].priority <
          this.queue[leftChildIndex].priority
          ? rightChildIndex
          : leftChildIndex;
      if (this.queue[smallerChildIndex].priority > rootNode.priority) break;
      this.queue[index] = this.queue[smallerChildIndex];
      index = smallerChildIndex;
    }
    this.queue[index] = rootNode;
  };
  isEmpty = () => this.queue.length <= 0;
}

const N = +input[0];
const road = [];
for (let i = 1; i <= N; i += 1) road.push(input[i].split(' ').map(Number));
const visited = Array.from({ length: N }, () =>
  new Array(N).fill(Number.MAX_SAFE_INTEGER)
);
const priorityQueue = new PriorityQueue();
priorityQueue.enqueue(0, 0, 0);
visited[0][0] = 0;
const dxdy = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

while (!priorityQueue.isEmpty()) {
  const { priority, x, y } = priorityQueue.dequeue();
  if (x === N - 1 && y === N - 1) break;
  for (const [dx, dy] of dxdy) {
    const [nx, ny] = [x + dx, y + dy];
    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
    const height = Math.abs(road[nx][ny] - road[x][y]);
    const newCost = Math.max(priority, height);
    if (visited[nx][ny] > newCost) {
      visited[nx][ny] = newCost;
      priorityQueue.enqueue(newCost, nx, ny);
    }
  }
}

console.log(visited[N - 1][N - 1]);
