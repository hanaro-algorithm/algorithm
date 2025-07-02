const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // 가로 크기: N, 세로 크기: M
const warSite = []; // 전쟁터 정보
for (let i = 1; i <= M; i++) {
  warSite.push(input[i].split(''));
}

// 이동 방향 배열
const dx = [-1, 0, 1, 0];
const dy = [0, -1, 0, 1];

const visited = Array.from({ length: M }, () => new Array(N).fill(false)); // 방문 표시
const dfs = (color, x, y, cnt) => {
  for (let i = 0; i < 4; i++) {
    const [nextX, nextY] = [x + dx[i], y + dy[i]]; // 다음 위치
    if (
      nextX < 0 ||
      nextY < 0 ||
      nextX >= N ||
      nextY >= M ||
      visited[nextY][nextX]
    )
      continue; // 영역 벗어나거나 이미 방문한 경우 다음 병사로 이동
    // 같은 팀인 경우 DFS 수행
    if (warSite[nextY][nextX] === color) {
      visited[nextY][nextX] = true;
      cnt = dfs(color, nextX, nextY, cnt + 1);
    }
  }
  return cnt;
};

const power = [0, 0];
for (let m = 0; m < M; m++) {
  for (let n = 0; n < N; n++) {
    if (!visited[m][n]) {
      visited[m][n] = true;
      const color = warSite[m][n]; // 현재 병사의 색
      const cnt = dfs(color, n, m, 1);
      color === 'W'
        ? (power[0] += Math.pow(cnt, 2))
        : (power[1] += Math.pow(cnt, 2)); // 뭉쳐있는 인원의 제곱 수 더하기
    }
  }
}

console.log(power.join(' '));
