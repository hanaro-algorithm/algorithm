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

let t = +input[0]; // 테스트 케이스 수
let line = 1;

let answer = '';
while (t--) {
  const [N, M] = input[line++].split(' ').map(Number);
  const papers = input[line++].split(' ').map((p, idx) => [idx, +p]); // 문서의 우선순위

  const queue = new Queue(); // 프린터 큐 생성
  papers.forEach((paperCost) => queue.enqueue(paperCost));

  while (queue.getLength()) {
    const [idx, paperCost] = queue.dequeue();
    let flag = true;
    for (let i = queue.headIndex; i < queue.tailIndex; i++) {
      // 현재 문서의 우선순위보다 더 큰 우선순위를 갖는 문서가 프린터 큐에 있는 경우
      // 해당 문서 프린터 큐 맨 뒤로 보내기
      if (queue.queue[i][1] > paperCost) {
        flag = false;
        queue.enqueue([idx, paperCost]);
        break;
      }
    }
    // 해당 문서보다 우선순위가 큰 문서가 없고, 찾고자 하는 문서인 경우 정답에 추가
    if (flag && idx === M) {
      answer += N - queue.getLength() + '\n';
      break;
    }
  }
}
console.log(answer.trimEnd());
