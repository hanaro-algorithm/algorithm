const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

class priorityStack {
  constructor() {
    this.stack = [];
  }
  isEmpty() {
    return this.stack.length === 0;
  }
  push(absData, data) {
    this.stack.push([absData, data]);
    this.stack.sort((a, b) => b[0] - a[0] || b[1] - a[1]);
  }
  pop() {
    let item = this.stack.pop();
    return item[1];
  }
}

const N = +input[0]; // 연산의 개수
let stack = new priorityStack();
let answer = [];

let inputNumbers = []; // 입력한 값 담을 배열
for (let i = 1; i <= N; i += 1) inputNumbers.push(+input[i]);
inputNumbers.map((number) => {
  if (number !== 0) stack.push(Math.abs(number), number);
  else {
    if (stack.isEmpty()) answer.push(0);
    else {
      let popItem = stack.pop();
      answer.push(popItem);
    }
  }
});

answer.map((a) => console.log(a));
