/**
 * 문제) 행성 연결
 * 제국 내 모든 행성 연결하고, 최소한의 플로우 관리 비용 출력
 *
 * 1) 각 정점이 연결된 간선 오름차순 정렬
 * 2) 사이클 형성하지 않는 간선 선택
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 행성의 수

// 1) 연결된 간선 오름차순 정렬
const connects = [];
for (let i = 1; i <= N; i++) {
  const distance = input[i].split(' ').map(Number);
  for (let d = i; d < N; d++) connects.push([i, d + 1, distance[d]]);
}
connects.sort((a, b) => a[2] - b[2]);

// 2. 선택된 간선이 N-1개 될때까지 간선 선택하기
const unf = Array.from({ length: N + 1 }, (_, idx) => idx);
const Find = (v) => {
  if (unf[v] !== v) unf[v] = Find(unf[v]);
  return unf[v];
};
const Union = (a, b) => {
  const fa = Find(a);
  const fb = Find(b);
  if (fa < fb) unf[fb] = fa;
  else unf[fa] = fb;
};

let result = 0;
let count = 0; // 선택된 간선의 수
for (const connect of connects) {
  if (count === N - 1) break; // 선택된 간선의 수가 N-1인 경우 중단
  const [a, b, cost] = connect;
  // 사이클을 만들지 않는 경우 해당 간선 선택 후 연결하기
  if (Find(a) != Find(b)) {
    Union(a, b);
    result += cost;
    count += 1;
  }
}

console.log(result);
