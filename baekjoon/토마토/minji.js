/**
 * 문제) 토마토
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [M, N] = input[0].split(' ').map(Number); // M: 가로 칸의 수, N: 세로 칸의 수
const box = []; // 토마토 담겨있는 박스 정보
for (let n = 1; n <= N; n++) box.push(input[n].split(' ').map(Number));

// 인접한 칸 이동방향
const drdc = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

const visited = Array.from({ length: N }, () => new Array(M).fill(-1)); // 지난 일수
const queue = [];

let none = 0; // 토마토가 없는 칸 개수(-1)
// 익은 토마토가 있는 곳 큐에 넣기
for (let r = 0; r < N; r++) {
  for (let c = 0; c < M; c++) {
    if (box[r][c] === 1) {
      queue.push([r, c]);
      visited[r][c] = 0; // 이미 익어있으니까 0일
    } else if (box[r][c] === -1) none++;
  }
}

// 박스 안에 있는 토마토가 전부 익은 토마토인 경우 바로 0 출력
if (queue.length === M * N - none) return console.log(0);

let index = 0;
let max = Number.MIN_SAFE_INTEGER; // 토마토 익기까지 걸리는 시간 최대값
while (index < queue.length) {
  const [cr, cc] = queue[index++];
  max = visited[cr][cc];

  for (const [dr, dc] of drdc) {
    const [nr, nc] = [cr + dr, cc + dc];
    // 영역 벗어나지 않고 이미 익은 토마토이거나 토마토가 없는 경우 패스
    if (nr < 0 || nr >= N || nc < 0 || nc >= M || box[nr][nc] !== 0) continue;
    if (visited[nr][nc] === -1) {
      queue.push([nr, nc]);
      visited[nr][nc] = visited[cr][cc] + 1;
    }
  }
}

if (index < M * N - none)
  console.log(-1); // 안익은 토마토가 존재하는 경우 -1 리턴
else console.log(max);
