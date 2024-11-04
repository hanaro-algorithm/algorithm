const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M, V] = input[0].split(' ').map(Number); // N: 정점 개수, M: 간선 개수, V: 탐색 시작 정점 번호
const array = Array.from({ length: N + 1 }, () => []); // 인접리스트 생성
for (let i = 1; i <= M; i += 1) {
  const [a, b] = input[i].split(' ').map(Number);
  array[a].push(b);
  array[b].push(a);
}
array.forEach((a) => a.sort((a, b) => a - b)); // 각 인접리스트들 오름차순 정렬(방문할 수 있는 곳 여러개인 경우 작은 수부터 방문)

const dfsAnswer = []; // dfs 수행 결과
const dfsVisited = Array.from({ length: N + 1 }, () => false);
const bfsAnswer = []; // bfs 수행 결과
const bfsVisited = Array.from({ length: N + 1 }, () => false);

// dfs 함수
const dfs = (current) => {
  dfsAnswer.push(current);
  dfsVisited[current] = true;
  for (let item of array[current]) {
    if (!dfsVisited[item]) dfs(item);
  }
  return;
};

// bfs 함수
const bfs = (current) => {
  const queue = [];
  queue.push(current);
  bfsAnswer.push(current);
  bfsVisited[current] = true;
  while (queue.length > 0) {
    const item = queue.shift();
    for (let data of array[item]) {
      if (!bfsVisited[data]) {
        queue.push(data);
        bfsAnswer.push(data);
        bfsVisited[data] = true;
      }
    }
  }
  return;
};

dfs(V);
bfs(V);

console.log(...dfsAnswer);
console.log(...bfsAnswer);
