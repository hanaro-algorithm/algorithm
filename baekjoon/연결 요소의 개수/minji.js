const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // N: 정점의 개수, M: 간선의 개수
const nodes = Array.from({ length: N + 1 }, () => []);
const visited = Array.from({ length: N + 1 }, () => false);
// 인접 리스트 생성
for (let i = 1; i <= M; i += 1) {
  const [u, v] = input[i].split(' ').map(Number);
  nodes[u].push(v);
  nodes[v].push(u);
}

// 연결 요소 확인
const dfs = (node) => {
  visited[node] = true;
  for (const nextNode of nodes[node]) {
    if (!visited[nextNode]) dfs(nextNode);
  }
  return 1;
};

let answer = 0;
for (let node = 1; node <= N; node += 1) {
  if (!visited[node]) answer += dfs(node);
}
console.log(answer);
