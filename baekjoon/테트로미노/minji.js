/**
 * 문제) 테트로미노
 * 종이 위에 테트로미노 하나를 놓았을 때 쓰여 있는 수들의 합의 최댓값
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // NXM 종이
const paper = []; // 종이 위에 쓰여있는 수
let maxNumber = Number.MIN_SAFE_INTEGER; // 종이 위에 쓰여있는 수 중 가장 큰 수
for (let i = 1; i <= N; i++) {
  const row = input[i].split(' ').map(Number);
  paper.push(row);
  maxNumber = Math.max(maxNumber, ...row);
}

// 영역 벗어나는지 확인하는 함수
const isIn = (r, c) => r >= 0 && c >= 0 && r < N && c < M;

const drdc = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];
const visited = Array.from({ length: N }, () => new Array(M).fill(false));
let answer = Number.MIN_SAFE_INTEGER;

const backtracking = (cnt, sum, selected) => {
  // 남은 값들을 모두 더해도 answer보다 작은 경우 더 이상 수행 안해도됨
  if (sum + (4 - cnt) * maxNumber <= answer) return;
  if (cnt === 4) {
    // 테트로미노인 경우 합들의 최댓값 갱신
    answer = Math.max(answer, sum);
    return;
  }
  // 선택된 좌표들 기준으로 상하좌우 이동
  for (const [r, c] of selected)
    for (const [dr, dc] of drdc) {
      const [nr, nc] = [r + dr, c + dc];
      // 종이 범위를 벗어나지 않고 아직 방문하지 않은 경우 백트래킹 수행
      if (isIn(nr, nc) && !visited[nr][nc]) {
        visited[nr][nc] = true;
        selected.push([nr, nc]);
        backtracking(cnt + 1, sum + paper[nr][nc], selected);
        selected.pop();
        visited[nr][nc] = false;
      }
    }
};

for (let r = 0; r < N; r++) {
  for (let c = 0; c < M; c++) {
    visited[r][c] = true;
    backtracking(1, paper[r][c], [[r, c]]);
  }
}

console.log(answer);
