class Queue {
  constructor() {
    this.queue = {};
    this.headIdx = 0;
    this.tailIdx = 0;
  }
  enqueue = (item) => {
    this.queue[this.tailIdx++] = item;
  };
  dequeue = () => this.queue[this.headIdx++];
  getLength = () => this.tailIdx - this.headIdx;
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let t = +input[0]; // 테스트 케이스 수
let line = 1;

let answer = '';
while (t--) {
  const [K, M, P] = input[line].split(' ').map(Number); // K: 테스트 케이스 번호, M: 노드의 수, P: 간선의 수
  const river = Array.from({ length: M + 1 }, () => []); // 하천 정보
  const indegree = Array.from({ length: M + 1 }, () => 0); // 해당 노드에 들어오는 노드의 수
  for (let i = line + 1; i <= line + P; i++) {
    const [start, end] = input[i].split(' ').map(Number); // 시작점과 끝점
    river[start].push(end);
    indegree[end] += 1;
  }
  const strahlerNum = Array.from({ length: M + 1 }, () => new Array(2).fill(0));
  // strahlerNum[노드 번호][0] = 노드번호의 strahler 순서
  // strahlerNum[노드 번호][1] = 노드번호로 들어오는 노드의 갯수(가장 큰 번호)

  const queue = new Queue();
  // 시작노드 먼저 큐에 넣기
  for (let node = 1; node <= M; node++) {
    if (!indegree[node]) {
      queue.enqueue(node);
      strahlerNum[node][0] = 1;
    }
  }

  while (queue.getLength()) {
    const node = queue.dequeue(); // 현재 노드
    // 동일한 순서를 가진 노드가 여러 개 들어온 경우
    if (strahlerNum[node][1] > 1) strahlerNum[node][0] += 1;
    for (const next of river[node]) {
      indegree[next] -= 1; // 연결되어 있는 노드 처리
      // 동일한 순서를 가진 노드가 또 들어온 경우
      if (strahlerNum[next][0] === strahlerNum[node][0])
        strahlerNum[next][1] += 1;
      else if (strahlerNum[next][0] < strahlerNum[node][0])
        strahlerNum[next] = [strahlerNum[node][0], 1]; // 더 큰 순서를 가진 노드가 들어온 경우
      // 연결된 노드 처리를 끝 낸 노드는 큐에 넣기
      if (indegree[next] === 0) queue.enqueue(next);
    }
  }
  answer += `${K} ${strahlerNum[M][0]}\n`; // 테스트 케이스와 M번째의 순서 출력
  line += P + 1;
}

console.log(answer.trimEnd());
