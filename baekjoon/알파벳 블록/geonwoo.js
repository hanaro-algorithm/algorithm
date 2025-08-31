class Deque {
  constructor() {
    this.queue = {};
    this.head = 0;
    this.tail = 0;
  }

  pushFront(item) {
    this.queue[--this.head] = item;
  }

  pushBack(item) {
    this.queue[this.tail++] = item;
  }

  popFront() {
    if (this.head === this.tail) return undefined;
    return this.queue[this.head++];
  }

  popBack() {
    if (this.head === this.tail) return undefined;
    return this.queue[--this.tail];
  }

  isEmpty() {
    return this.head === this.tail;
  }
}

const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = +input[0];
const deq = new Deque();
const order = [];

for (let i = 1; i <= N; i++) {
  const [cmd, c] = input[i].trim().split(" ");

  if (cmd === "1") {
    deq.pushBack(c);
    order.push("B");
  } else if (cmd === "2") {
    deq.pushFront(c);
    order.push("F");
  } else if (cmd === "3") {
    if (deq.isEmpty()) continue;

    const past = order.pop();

    if (past === "F") deq.popFront();
    else deq.popBack();
  }
}

let ans = "";

while (!deq.isEmpty()) {
  ans += deq.popFront();
}

console.log(ans.length ? ans : 0);
