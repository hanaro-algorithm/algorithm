const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const bfs = (u, graph, visited) => {
  const queue = [];
  queue.push(u);
  visited[u] = 0;
  while (queue.length) {
    const current = queue.shift();
    for (const next of graph[current]) {
      if (visited[next] === -1) {
        visited[next] = (visited[current] + 1) % 2; // 다른 번호 부여
        queue.push(next);
      }
    }
  }
};
// 인접 그래프인지 확인
const isBinaryGraph = (v, graph, visited) => {
  for (let node = 1; node <= v; node += 1) {
    for (const next of graph[node]) {
      if (visited[node] === visited[next]) return false;
    }
  }
  return true;
};

let K = +input[0]; // 테스트 케이스
let line = 1;
let answer = '';
while (K) {
  const [V, E] = input[line].split(' ').map(Number); // 정점: V, 간선: E
  const graph = Array.from({ length: V + 1 }, () => []); // 그래프 생성
  for (let i = 0; i < E; i += 1) {
    const [u, v] = input[line + 1 + i].split(' ').map(Number);
    graph[u].push(v);
    graph[v].push(u);
  }
  const visited = Array.from({ length: V + 1 }, () => -1);
  // 집합 둘로 분할하기 위해 BFS 수행
  for (let node = 1; node <= V; node += 1)
    if (visited[node] === -1) bfs(node, graph, visited);

  if (isBinaryGraph(V, graph, visited)) answer += 'YES\n';
  else answer += 'NO\n';

  line += E + 1; // 다음 테스트 케이스로 이동
  K -= 1;
}

answer = answer.trimEnd();
console.log(answer);
