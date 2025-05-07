/**
 * 문제) 볼 모으기
 * 종류가 같은 볼끼리 위치하도록 옮길 때 볼을 이동하는 최소 횟수 구하기
 * [볼 옮기는 규칙]
 * - 한 번 선택한 종류만 옮길 수 있음
 * - 바로 옆에 다른 종류가 존재하면 한 번에 뛰어 넘음
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 볼의 총 개수
const balls = input[1].split(''); // 초기 볼 배치 상태

let result = Number.MAX_SAFE_INTEGER;

const moveLeft = (color) => {
  let anotherCnt = 0;
  let cnt = 0;
  // 해당 공을 왼쪽으로 이동시키기
  for (let b = 0; b < N; b++) {
    if (anotherCnt !== 0 && balls[b] === color) cnt += 1; // 다른 종류 공이 있는 경우 공 옮기기
    if (balls[b] !== color) anotherCnt++; // 타겟의 다른 종류 공 카운트 증가(뛰어 넘어야 하는 공 개수)
  }
  return cnt;
};
const moveRight = (color) => {
  let anotherCnt = 0;
  let cnt = 0;
  // 해당 공을 오른쪽으로 이동시키기
  for (let b = N - 1; b >= 0; b--) {
    if (anotherCnt !== 0 && balls[b] === color) cnt += 1;
    if (balls[b] !== color) anotherCnt++;
  }
  return cnt;
};

result = Math.min(result, moveLeft('R')); // 1. 빨간 공(R)을 왼쪽으로 이동시키기
result = Math.min(result, moveRight('R')); // 2. 빨간 공(R)을 오른쪽으로 이동시키기
result = Math.min(result, moveLeft('B')); // 3. 파란 공(B)을 왼쪽으로 이동시키기
result = Math.min(result, moveRight('B')); // 4. 파란 공(R)을 오른쪽으로 이동시키기

console.log(result);
