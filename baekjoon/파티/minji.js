// 다익스트라 알고리즘 이용
class Queue {
  constructor() {
    this.queue = {};
    this.headIdx = 0;
    this.tailIdx = 0;
  }
  enqueue = (item) => {
    this.queue[this.tailIdx] = item;
    this.tailIdx++;
  };
  dequeue = () => {
    const item = this.queue[this.headIdx];
    delete this.queue[this.headIdx];
    this.headIdx++;
    return item;
  };
  getLength = () => this.tailIdx - this.headIdx;
}

const fs = require('fs');
const input = fs.readFileSync(0).toString().split('\n');
const INF = Infinity;

const [N, M, X] = input[0].split(' ').map(Number);
const goToX = Array.from({ length: N + 1 }, () => []);
const backToX = Array.from({ length: N + 1 }, () => []);

for (let i = 1; i <= M; i += 1) {
  const [start, end, time] = input[i].split(' ').map(Number);
  goToX[start].push([end, time]);
  backToX[end].push([start, time]);
}

// 최단 거리 구하기
const bfs = (start, graph) => {
  const cost = Array.from({ length: N + 1 }, () => INF);
  const queue = new Queue();
  queue.enqueue(start);
  cost[start] = 0;
  while (queue.getLength() > 0) {
    const current = queue.dequeue();
    for (const [connect, time] of graph[current]) {
      // 다른 곳 들렸다가 X로 가는게 더 최단거리일 경우
      // 최단거리 테이블 업데이트
      if (cost[connect] > cost[current] + time) {
        cost[connect] = cost[current] + time;
        queue.enqueue(connect);
      }
    }
  }
  return cost;
};

const go = bfs(X, goToX); // X -> 모든 마을(X 제외)
const back = bfs(X, backToX); // 모든 마을(X 제외) -> X

let answer = 0;
for (let i = 1; i <= N; i += 1) answer = Math.max(answer, go[i] + back[i]);
console.log(answer);

// 플로이드-워셜 알고리즘
// const distance = Array.from({ length: N + 1 }, (_, r) =>
//   Array.from({ length: N + 1 }, (_, c) => (r !== c ? INF : 0))
// );

// for (let i = 1; i <= M; i += 1) {
//   const [start, end, time] = input[i].split(' ').map(Number);
//   distance[start][end] = Math.min(distance[start][end], time);
// }

// for (let k = 1; k <= N; k += 1) {
//   for (let r = 1; r <= N; r += 1) {
//     for (let c = 1; c <= N; c += 1) {
//       if (distance[r][k] !== INF && distance[k][c] !== INF) {
//         distance[r][c] = Math.min(
//           distance[r][c],
//           distance[r][k] + distance[k][c]
//         );
//       }
//     }
//   }
// }

// let answer = Number.MIN_SAFE_INTEGER;
// for (let student = 1; student <= N; student += 1) {
//   if (student !== X) {
//     answer = Math.max(answer, distance[X][student] + distance[student][X]);
//   }
// }

// console.log(answer);
