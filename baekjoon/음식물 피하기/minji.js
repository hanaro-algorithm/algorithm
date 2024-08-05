const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

// N: 세로, M: 가로, K: 음식물 개수
const [N, M, K] = input[0].split(' ').map(Number);

// 음식물이 떨어진 위치(NXM)
let compost = Array.from({ length: N }, () => new Array(M).fill(-1));
for (let i = 1; i <= K; i += 1) {
  const [r, c] = input[i].split(' ').map(Number);
  compost[r - 1][c - 1] = 0;
}

const direction = [
  [-1, 0],
  [0, -1],
  [1, 0],
  [0, 1],
];

const dfs = (count, curR, curC) => {
  compost[curR][curC] = count; // 방문 처리
  for (let i = 0; i < 4; i += 1) {
    const nextR = curR + direction[i][0];
    const nextC = curC + direction[i][1];
    if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;

    if (compost[nextR][nextC] === 0) {
      dfs(count, nextR, nextC);
    }
  }
};

let count = 0;
for (let i = 0; i < N; i += 1) {
  for (let j = 0; j < M; j += 1) {
    if (compost[i][j] === 0) {
      count += 1; // 영역 다르게 세기
      dfs(count, i, j);
    }
  }
}

let countArr = Array.from({ length: N * M + 1 }, () => 0);
for (let i = 0; i < N; i += 1) {
  for (let j = 0; j < M; j += 1) {
    if (compost[i][j] !== -1) countArr[compost[i][j]] += 1;
  }
}
console.log(Math.max(...countArr));
