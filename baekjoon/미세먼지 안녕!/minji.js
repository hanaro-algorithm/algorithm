/**
 * 문제) 미세먼지 안녕!
 * T초가 지난 후 구사과의 방에 남아있는 미세먼지 양 구하기
 * 확산) 상하좌우로 퍼짐 -> 주변은 5로 나눈 몫이고, 원래 있던 미세먼지는 기존 값-5로 나눈 몫*확산된 방향의 개수
 * 공기청정기) 위는 반시계방향, 아래는 시계방향으로 순환됨 -> 바람이 불면 바람 방향대로 모두 한 칸씩 이동
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let [R, C, T] = input[0].split(' ').map(Number);
let room = Array.from({ length: R }, () => []);
for (let r = 1; r <= R; r++) room[r - 1] = input[r].split(' ').map(Number); // 기존 상태
const dxdy = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

while (T) {
  const spread = Array.from({ length: R }, () => new Array(C).fill(0));
  // 공기 청정기 위치 찾기
  let [pTop, pDown] = [0, 0];
  // 미세먼지 확산
  for (let r = 0; r < R; r++) {
    for (let c = 0; c < C; c++) {
      // 공기 청정기인 경우
      if (room[r][c] === -1 && pTop === 0) {
        pTop = r;
        pDown = r + 1;
        continue;
      }
      // 미세먼지가 있는 영역
      else if (room[r][c] > 0) {
        let cnt = 0; // 확산된 방향의 개수
        const num = Math.floor(room[r][c] / 5);
        for (const [dx, dy] of dxdy) {
          const [nx, ny] = [r + dx, c + dy];
          // 영역 벗어나거나 공기청정기가 있는 경우 패스
          if (nx < 0 || ny < 0 || nx >= R || ny >= C || room[nx][ny] === -1)
            continue;
          spread[nx][ny] += num;
          cnt += 1;
        }
        spread[r][c] += room[r][c] - num * cnt;
      }
    }
  }
  // 공기청정기 작동
  // 시계 방향 순환
  for (let r = pTop - 1; r > 0; r--) spread[r][0] = spread[r - 1][0];
  for (let c = 0; c < C - 1; c++) spread[0][c] = spread[0][c + 1];
  for (let r = 0; r < pTop; r++) spread[r][C - 1] = spread[r + 1][C - 1];
  for (let c = C - 1; c > 0; c--) spread[pTop][c] = spread[pTop][c - 1];
  spread[pTop][1] = 0;
  // 반시계 방향 순환
  for (let r = pDown + 1; r < R - 1; r++) spread[r][0] = spread[r + 1][0];
  for (let c = 0; c < C - 1; c++) spread[R - 1][c] = spread[R - 1][c + 1];
  for (let r = R - 1; r > pDown; r--) spread[r][C - 1] = spread[r - 1][C - 1];
  for (let c = C - 1; c > 0; c--) spread[pDown][c] = spread[pDown][c - 1];
  spread[pDown][1] = 0;

  room = spread;
  // 공기 청정기 위치 표시
  room[pTop][0] = -1;
  room[pDown][0] = -1;
  T -= 1;
}

let answer = 0;
for (let r = 0; r < R; r++) {
  for (let c = 0; c < C; c++) {
    if (room[r][c] !== -1) answer += room[r][c];
  }
}

console.log(answer);
