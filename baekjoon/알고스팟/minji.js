/**
 * 문제) 알고스팟
 * (1,1)에서 (N,M)으로 이동하기 위한 부숴야 하는 벽의 최소값 구하기
 * - 빈 방(0)은 자유롭게 이동 가능하지만, 벽(1)은 뚫어야 이동 가능
 * - 상하좌우로만 이동 가능
 * - (1,1)과 (N,M)은 항상 뚫려있음
 */
class Deque {
  constructor() {
    this.data = [];
    this.headIndex = 0;
    this.tailIndex = 0;
  }
  // 뒤에서 삽입
  push = (item) => {
    this.data[this.tailIndex++] = item;
  };
  // 앞에서 삽입
  unshift = (item) => {
    this.data[--this.headIndex] = item;
  };
  // 앞에서 삭제
  shift = () => this.data[this.headIndex++];
  // 뒤에서 삭제
  pop = () => this.data[this.tailIndex--];
  // 길이 출력
  getLength = () => this.tailIndex - this.headIndex;
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [M, N] = input[0].split(' ').map(Number); // M: 가로, N: 세로
const maze = []; // 미로(0: 빈 방, 1: 벽)
for (let n = 1; n <= N; n++) maze.push(input[n].split('').map(Number));

const drdc = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
]; // 상하좌우 이동 방향

// 백트래킹 이용하면 시간초과 발생!
// 가중치가 0과 1로 되어 있는 상황에서 최단 거리를 구할 때는 0-1 BFS 방식 이용
const deque = new Deque();
const visited = Array.from({ length: N }, () => new Array(M).fill(-1));

deque.push([0, 0]);
visited[0][0] = 0;

while (deque.getLength()) {
  const [curR, curC] = deque.shift();
  for (const [dr, dc] of drdc) {
    const [nr, nc] = [curR + dr, curC + dc];
    if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] === -1) {
      if (maze[nr][nc] === 0) {
        visited[nr][nc] = visited[curR][curC];
        deque.unshift([nr, nc]);
      } else {
        visited[nr][nc] = visited[curR][curC] + 1;
        deque.push([nr, nc]);
      }
    }
  }
}

console.log(visited[N - 1][M - 1]);
