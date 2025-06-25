/**
 * 문제) 양치기 꿍
 * 살아남게 되는 양과 늑대의 수 구하기
 * [조건]
 * - 양 > 늑대 => 양이 늑대 잡아먹음
 * - 양 <= 늑대 => 늑대가 양 잡아먹음
 * - 울타리 #, 늑대 v, 양 k, 빈 공간 .
 *
 * [풀이]
 * - 모든 좌표를 순회하면서 v, k를 발견하면 bfs 수행(이때, 방문한 곳은 다시 방문x)
 * - bfs 수행 시,  양과 늑대 수 카운트하기
 * - 양과 늑대 수 비교해서 결과 갱신
 */
class Queue {
  constructor() {
    this.queue = {};
    this.headIndex = 0;
    this.tailIndex = 0;
  }
  enqueue = (item) => {
    this.queue[this.tailIndex++] = item;
  };
  dequeue = () => this.queue[this.headIndex++];
  getLength = () => this.tailIndex - this.headIndex;
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [R, C] = input[0].split(' ').map(Number); // R: 세로 길이, C: 가로 길이
const map = []; // 영역 정보
for (let i = 1; i <= R; i++) map.push(input[i].split(''));

const dr = [-1, 0, 1, 0];
const dc = [0, -1, 0, 1];
const visited = Array.from({ length: R }, () => new Array(C).fill(false)); // 방문 여부

// 영역 벗어나는지 확인하는 함수
const isIn = (r, c) => {
  return r >= 0 && c >= 0 && r < R && c < C;
};

const bfs = (r, c) => {
  const queue = new Queue();
  queue.enqueue([r, c]);
  visited[r][c] = true;

  let vCnt = 0; // 늑대의 수
  let kCnt = 0; // 양의 수
  while (queue.getLength() > 0) {
    const [curR, curC] = queue.dequeue();
    if (map[curR][curC] === 'v') vCnt++; // 늑대 수 카운트 증가
    else if (map[curR][curC] === 'k') kCnt++; // 양 수 카운트 증가

    for (let i = 0; i < 4; i++) {
      const [nextR, nextC] = [curR + dr[i], curC + dc[i]];
      // 다음 이동할 칸이 영역을 벗어나거나, 울타리가 있거나, 이미 방문한 경우
      // 넘어가기
      if (
        !isIn(nextR, nextC) ||
        map[nextR][nextC] === '#' ||
        visited[nextR][nextC]
      )
        continue;
      visited[nextR][nextC] = true; // 방문 표시
      queue.enqueue([nextR, nextC]); // 다음 이동 칸 큐에 넣기
    }
  }
  return [vCnt, kCnt]; // 한 울타리 내에 있는 [늑대의 수, 양의 수] 리턴
};

let result = [0, 0]; // [살아있는 양의 수, 살아있는 늑대의 수]
for (let r = 0; r < R; r++) {
  for (let c = 0; c < C; c++) {
    // 현재 칸에 양이나 늑대가 있는 경우 bfs 수행
    // 이때, 양이나 늑대의 칸이 아직 방문하지 않았어야 함
    if ((map[r][c] === 'v' || map[r][c] === 'k') && !visited[r][c]) {
      const [vCnt, kCnt] = bfs(r, c);
      if (vCnt >= kCnt) result[1] += vCnt;
      // 늑대가 양보다 더 많거나 같은 경우, 살아있는 늑대의 수 증가
      else result[0] += kCnt; // 양이 늑대보다 더 많은 경우, 살아있는 양의 수 증가
    }
  }
}
console.log(result.join(' '));
