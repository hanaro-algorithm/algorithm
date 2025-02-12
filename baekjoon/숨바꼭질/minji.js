/* Queue를 배열로 만들어서 shift함수를 사용하는 것보다 객체로 구현한 큐를 사용하는게 훨씬 시간복잡도가 효율적임 */
class Queue {
  constructor() {
    this.headIndex = 0;
    this.tailIndex = 0;
    this.queue = {};
  }
  enqueue(data) {
    this.queue[this.tailIndex] = data;
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

const [N, K] = input[0].split(' ').map(Number);

const visited = Array.from({ length: 100001 }, () => false);
const queue = new Queue();
queue.enqueue([N, 0]);
visited[N] = true;

while (queue.getLength() > 0) {
  const [x, time] = queue.dequeue();
  if (x === K) return console.log(time);
  for (let next of [x - 1, x + 1, x * 2]) {
    if (next < 0 || next > 100000) continue;
    if (!visited[next]) {
      visited[next] = true;
      queue.enqueue([next, time + 1]);
    }
  }
}
