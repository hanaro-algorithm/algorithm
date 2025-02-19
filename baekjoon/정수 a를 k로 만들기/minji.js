const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [A, K] = input[0].split(' ').map(Number);

let currentK = K;
let operationCnt = 0;
while (currentK >= A) {
  if (currentK < A * 2) return console.log(operationCnt + currentK - A);
  if (currentK % 2 === 0) currentK /= 2;
  else currentK -= 1;
  operationCnt += 1;
}

// 1. BFS 풀이
// class Queue {
//   constructor() {
//     this.queue = {};
//     this.headIndex = 0;
//     this.tailIndex = 0;
//   }
//   enqueue(item) {
//     this.queue[this.tailIndex] = item;
//     this.tailIndex++;
//   }
//   dequeue() {
//     const item = this.queue[this.headIndex];
//     delete this.queue[this.headIndex];
//     this.headIndex++;
//     return item;
//   }
//   isEmpty() {
//     return this.tailIndex === this.headIndex;
//   }
// }

// const operationCnt = Array.from({ length: K + 1 }, () => 0);
// const queue = new Queue();
// queue.enqueue(A);

// while (!queue.isEmpty()) {
//   const current = queue.dequeue();
//   if (current === K) console.log(operationCnt[K]);
//   for (const next of [current + 1, current * 2]) {
//     if (next <= K && !operationCnt[next]) {
//       operationCnt[next] = operationCnt[current] + 1;
//       queue.enqueue(next);
//     }
//   }
// }
