const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const n = +input[0]; // 돌 개수
const jumpLen = input[1].split(' ').map(Number); // 뛸 수 있는 거리
const s = +input[2]; // 출발점

let visited = Array.from({ length: n }, () => false); // 방문 표시
let dx = [-1, 1]; // 좌 우로 이동시키기 위함
let cnt = 0; // 갈 수 있는 돌의 개수

const dfs = (index) => {
  visited[index] = true; // 방문 처리
  cnt += 1; // 갈 수 있는 돌 카운트
  for (let pos of dx) {
    // 다음에 갈 돌의 인덱스 = 현재 인덱스 + (좌/우)*점프거리
    let nextIndex = index + pos * jumpLen[index];
    if (nextIndex < 0 || nextIndex >= n) continue; // 돌 벗어나는 경우
    if (!visited[nextIndex]) dfs(nextIndex); // 방문 하지 않은 돌일 경우만 dfs 수행
  }
};

dfs(s - 1);

console.log(cnt);
