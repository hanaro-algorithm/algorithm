const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const n = +input[0]; // 전체 사람의 수
const [a, b] = input[1].split(' ').map(Number); // 촌수 계산할 두 사람
const m = +input[2]; // 부모 자식들 간의 관계의 개수
const array = Array.from({ length: n + 1 }, () => []); // 인접리스트 생성
for (let i = 3; i < 3 + m; i += 1) {
  const [parent, child] = input[i].split(' ').map(Number);
  array[parent].push(child);
  array[child].push(parent);
}

let answer = -1;
const visited = Array.from({ length: n + 1 }, () => false); // 방문표시
const dfs = (current, depth) => {
  // 촌수계산할 b 찾은 경우
  if (current === b) {
    answer = depth; // 정답에 촌수 넣기(depth)
    return;
  }
  for (let item of array[current]) {
    if (!visited[item]) {
      visited[item] = true; // 방문 표시
      dfs(item, depth + 1); // depth 증가시켜서 dfs 수행하며 해당 값 찾기
      visited[item] = false; // 방문 해제
    }
    if (answer !== -1) return; // 촌수 계산 가능한 경우 dfs 수행 종료
  }
};

visited[a] = true;
dfs(a, 0); // a부터 시작
console.log(answer);
