/**
 * 문제) 말이 되고픈 원숭이
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const K = +input[0]; // 말의 움직임 이동 횟수
const [W, H] = input[1].split(' ').map(Number); // 가로길이 W, 세로길이 H
const road = [];
for (let i = 2; i < H + 2; i++) road.push(input[i].split(' ').map(Number));

// 말의 움직임 이동 방향
const horseMove = [
  [-1, -2],
  [-2, -1],
  [-2, 1],
  [-1, 2],
  [2, -1],
  [1, -2],
  [2, 1],
  [1, 2],
];

// 상하좌우 이동 방향
const drdc = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

const visited = Array.from({ length: H }, () => new Array(W).fill(-1)); // [y좌표][x좌표]의 잔여 말의 이동 횟수

const queue = [];
queue.push([0, 0, K, 0]); // [y좌표, x좌표, 잔여 말 이동 횟수, 이동 거리]
visited[0][0] = K;

// 범위 벗어나거나 장애물이 있는지 확인
const isAvailable = (r, c) => {
  if (r < 0 || r >= H || c < 0 || c >= W || road[r][c]) return false;
  return true;
};

let index = 0;
while (index < queue.length) {
  const [curR, curC, k, dist] = queue[index++];
  if (curR === H - 1 && curC === W - 1) return console.log(dist);

  // K가 아직 남아있으면 말이 움직임으로 이동하기
  if (k > 0) {
    for (const [moveR, moveC] of horseMove) {
      const [nextR, nextC] = [curR + moveR, curC + moveC];
      // 다음에 이동하려는 칸의 잔여 말의 이동 횟수보다 현재 잔여 말의 이동 횟수-1이 더 큰 경우 갱신
      if (isAvailable(nextR, nextC) && visited[nextR][nextC] < k - 1) {
        visited[nextR][nextC] = k - 1;
        queue.push([nextR, nextC, k - 1, dist + 1]);
      }
    }
  }
  for (const [moveR, moveC] of drdc) {
    const [nextR, nextC] = [curR + moveR, curC + moveC];
    // 다음에 이동하려는 칸의 잔여 말의 이동 횟수보다 현재 잔여 말의 이동 횟수가 더 큰 경우 갱신
    if (isAvailable(nextR, nextC) && visited[nextR][nextC] < k) {
      visited[nextR][nextC] = k;
      queue.push([nextR, nextC, k, dist + 1]);
    }
  }
}

console.log(-1);
