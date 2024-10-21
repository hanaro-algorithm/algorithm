const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const [r, c, d] = input[1].split(' ').map(Number);

const state = []; // 0: 청소되지 않은 빈칸, 1: 벽이 있는 경우
for (let i = 2; i < N + 2; i += 1) state.push(input[i].split(' ').map(Number));

// 북(0), 동(1), 남(2), 서(3)
const dx = [-1, 0, 1, 0];
const dy = [0, 1, 0, -1];

let answer = 0;

const dfs = (x, y, dire) => {
  // 청소 안한 영역이면 청소하기
  if (state[x][y] === 0) {
    state[x][y] = -1; // 청소 표시
    answer += 1;
  }

  for (let i = 0; i < 4; i += 1) {
    dire = (dire + 3) % 4; // 왼쪽 방향으로 회전
    const [nx, ny] = [x + dx[dire], y + dy[dire]];
    // 4개의 방향 중 청소 안한 구간 존재하면 dfs 수행
    if (nx >= 0 && ny >= 0 && nx < N && ny < M && state[nx][ny] === 0) {
      dfs(nx, ny, dire);
      return;
    }
  }

  // 주변 4개 공간이 모두 청소되어 있는 경우
  const [backX, backY] = [x - dx[dire], y - dy[dire]];
  // 뒤로 후진 가능한 경우 dfs 수행
  if (
    backX >= 0 &&
    backY >= 0 &&
    backX < N &&
    backY < M &&
    state[backX][backY] !== 1
  )
    dfs(backX, backY, dire);
};

dfs(r, c, d);

console.log(answer);
