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

const Dfunc = (num) => {
  let result = num * 2;
  if (result > 9999) result %= 10000;
  return result;
};

const Sfunc = (num) => {
  const result = num === 0 ? 9999 : num - 1;
  return result;
};

const Lfunc = (num) => ((num * 10) % 10000) + Math.floor(num / 1000); // 1000의 자리 정수를 맨 뒤에 붙이기

const Rfunc = (num) => (num % 10) * 1000 + Math.floor(num / 10); // 1의 자리 정수를 맨 앞에 붙이

let T = +input[0]; // 테스트 케이스 개수
let line = 1; // 입력 라인
let answer = ''; // 정답 문자열

const operations = [Dfunc, Sfunc, Lfunc, Rfunc];
const orders = ['D', 'S', 'L', 'R'];

while (T--) {
  const [A, B] = input[line++].split(' ').map(Number); // 두 개의 정수

  const visited = Array.from({ length: 10000 }, () => false); // 나올 수 있는 정수들의 방문 표시 배열
  const queue = new Queue();
  queue.enqueue([A, '']);
  visited[A] = true;

  search: while (queue.getLength() > 0) {
    let [origin, order] = queue.dequeue();

    for (let o = 0; o < 4; o++) {
      const cal = operations[o](origin);
      // B를 만들었을 때, 지금까지 수행한 연산 정보 저장
      if (cal === B) {
        answer += `${order + orders[o]}\n`;
        break search;
      }
      // 아직 수행하지 않은 정수인 경우, 큐에 넣고 방문 표시
      if (!visited[cal]) {
        queue.enqueue([cal, order + orders[o]]);
        visited[cal] = true;
      }
    }
  }
}
console.log(answer.trimEnd());
