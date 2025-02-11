class PriorityQueue {
  constructor() {
    this.queue = [];
  }

  getLeftChildIndex = (parentIndex) => parentIndex * 2 + 1;
  getRightChildIndex = (parentIndex) => parentIndex * 2 + 2;
  getParentIndex = (childIndex) => parseInt((childIndex - 1) / 2);

  enqueue = (priority, value) => {
    const node = { priority, value };
    this.queue.push(node);
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

    const rootNode = this.queue[0];

    if (count === 1) return this.queue.pop();
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

const fs = require('fs');
const input = fs.readFileSync(0).toString().split('\n');

const [V, E] = input[0].split(' ').map(Number);
const K = +input[1];
const node = Array.from({ length: V + 1 }, () => []);
for (let i = 2; i <= E + 2; i += 1) {
  const [u, v, w] = input[i].split(' ').map(Number);
  node[u].push([v, w]);
}

const distance = Array.from({ length: V + 1 }, () => Number.MAX_SAFE_INTEGER);

const priorityQueue = new PriorityQueue();
priorityQueue.enqueue(0, K);
distance[K] = 0;

while (!priorityQueue.isEmpty()) {
  const { priority, value } = priorityQueue.dequeue();
  if (distance[value] < priority) continue; // 이미 처리된 노드이면 무시
  for (const connectedNode of node[value]) {
    let cost = priority + connectedNode[1];
    if (cost < distance[connectedNode[0]]) {
      distance[connectedNode[0]] = cost;
      priorityQueue.enqueue(cost, connectedNode[0]);
    }
  }
}

let answer = '';
for (let i = 1; i <= V; i += 1) {
  if (distance[i] === Number.MAX_SAFE_INTEGER) answer += 'INF\n';
  else answer += distance[i] + '\n';
}

answer = answer.trimEnd();
console.log(answer);
