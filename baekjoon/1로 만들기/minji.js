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

const N = +input[0];

const visited = Array.from({ length: N + 1 }, () => -1);

const queue = new Queue();
queue.enqueue(N);
visited[N] = 0;

const isDivide3 = (num) => {
  if (num % 3 === 0) return parseInt(num / 3);
  return -1;
};

const isDivide2 = (num) => {
  if (num % 2 === 0) return parseInt(num / 2);
  return -1;
};

const sub1 = (num) => {
  if (num - 1 > 0) return num - 1;
  return -1;
};

const operations = [isDivide3, isDivide2, sub1];

while (queue.getLength() > 0) {
  const item = queue.dequeue();
  if (item === 1) break;

  for (const oper of operations) {
    const result = oper(item);

    if (item !== -1 && visited[result] === -1) {
      queue.enqueue(result);
      visited[result] = visited[item] + 1;
    }
  }
}

console.log(visited[1]);
