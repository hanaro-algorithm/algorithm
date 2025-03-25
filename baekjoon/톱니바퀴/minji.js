/**
 * 문제) 톱니바퀴
 * K번의 회전 후 네 톱니바퀴의 점수 합 출력(N=0, S=1로 계산)
 *
 * 톱니바퀴 회전 조건
 * - 톱니바퀴 회전할 때 맞닿아 있는 톱니의 극이 다르면 회전 방향과 반대방향으로 회전
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const wheels = Array.from({ length: 5 }, () => []); // 1번~4번 톱니바퀴 현재 상태
for (let i = 0; i < 4; i++)
  wheels[i + 1].push(...input[i].split('').map((n) => +n));

const rotateFunc = (info, dire) => {
  // 시계방향
  if (dire === 1) {
    const last = wheels[info].pop();
    wheels[info].unshift(last);
  } else {
    const first = wheels[info].shift();
    wheels[info].push(first);
  }
};

const K = +input[4]; // 회전 횟수
for (let i = 5; i < K + 5; i++) {
  const [num, direction] = input[i].split(' ').map(Number); // num: 회전시킨 톱니바퀴 번호, direction: 방향(1이 시계, -1이 반시계)
  const rotate = [];
  // 1번 톱니바퀴 회전
  if (num === 1) {
    rotate.push(1);
    if (wheels[1][2] !== wheels[2][6]) {
      rotate.push(2);
      if (wheels[2][2] !== wheels[3][6]) {
        rotate.push(3);
        if (wheels[3][2] !== wheels[4][6]) rotate.push(4);
      }
    }
  }

  // 2번 톱니바퀴 회전
  if (num === 2) {
    rotate.push(2);
    if (wheels[1][2] !== wheels[2][6]) rotate.push(1);
    if (wheels[2][2] !== wheels[3][6]) {
      rotate.push(3);
      if (wheels[3][2] !== wheels[4][6]) rotate.push(4);
    }
  }

  // 3번 톱니바퀴 회전
  if (num === 3) {
    rotate.push(3);
    if (wheels[3][2] !== wheels[4][6]) rotate.push(4);
    if (wheels[2][2] !== wheels[3][6]) {
      rotate.push(2);
      if (wheels[1][2] !== wheels[2][6]) rotate.push(1);
    }
  }

  // 4번 톱니바퀴 회전
  if (num === 4) {
    rotate.push(4);
    if (wheels[3][2] !== wheels[4][6]) {
      rotate.push(3);
      if (wheels[2][2] !== wheels[3][6]) {
        rotate.push(2);
        if (wheels[1][2] !== wheels[2][6]) rotate.push(1);
      }
    }
  }

  rotate.forEach((r) =>
    rotateFunc(r, (num + r) % 2 === 0 ? direction : direction * -1)
  );
}

let answer = 0;
for (let w = 1; w < 5; w++) answer += wheels[w][0] * Math.pow(2, w - 1);
console.log(answer);
