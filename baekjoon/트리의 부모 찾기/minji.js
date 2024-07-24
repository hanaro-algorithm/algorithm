const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 노드의 개수
let nodes = Array.from({ length: N + 1 }, () => []);

for (let i = 1; i < N; i += 1) {
  const [a, b] = input[i].split(' ').map(Number);
  nodes[a].push(b);
  nodes[b].push(a);
}

let visited = Array.from({ length: N + 1 }, () => false);
let parent = Array.from({ length: N + 1 }, () => 0);

function dfs(prev, num) {
  parent[num] = prev;
  for (let i of nodes[num]) {
    if (!visited[i]) {
      visited[num] = true;
      dfs(num, i);
    }
  }
}

dfs(0, 1);

parent.map((data, index) => {
  if (index >= 2) console.log(data);
});
