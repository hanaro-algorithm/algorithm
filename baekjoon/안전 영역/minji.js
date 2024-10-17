const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 2차원 배열의 행과 열의 개수
const area = [];
let maxHeight = Number.MIN_SAFE_INTEGER; // 주어진 배열 정보 중 가장 높은 값
for (let i = 1; i <= N; i += 1) {
  const data = input[i].split(' ').map(Number);
  maxHeight = Math.max(maxHeight, ...data);
  area.push(data);
}
const direction = [
  [-1, 0],
  [0, -1],
  [1, 0],
  [0, 1],
];
const dfs = (x, y, visited, target) => {
  visited[x][y] = true; // 방문 표시
  for (let dir of direction) {
    const [nx, ny] = [x + dir[0], y + dir[1]];
    if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue; // 영역 벗어나거나 이미 방문한 경우 패스
    if (area[nx][ny] > target) dfs(nx, ny, visited, target); // 비 양보다 높은 경우만 dfs 수행
  }
  return 1;
};

let answer = 1;
// 비 양을 0부터 최대 높이까지 반복문 수행(최대 높이 이상부터는 어차피 잠기니까 안전영역이 0임)
for (let t = 0; t <= maxHeight; t += 1) {
  let cnt = 0;
  const visited = Array.from({ length: N }, () => new Array(N).fill(false));
  for (let i = 0; i < N; i += 1) {
    for (let j = 0; j < N; j += 1) {
      if (area[i][j] > t && !visited[i][j]) {
        cnt += dfs(i, j, visited, t); // dfs 수행 횟수 카운트
      }
    }
  }
  answer = Math.max(answer, cnt);
}
console.log(answer);
