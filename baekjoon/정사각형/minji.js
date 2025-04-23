/**
 * 문제) 정사각형
 * 네 점 주어졌을 때, 네 점으로 정사각형 만들 수 있는지(1), 없는지(0) 출력
 *
 * [정사각형 조건]
 * 1. 네 변의 길이가 동일함
 * 2. 두 대각선 길이 동일함
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const T = +input[0]; // 테스트 케이스 개수
let line = 1;

let result = '';
for (let t = 0; t < T; t++) {
  const points = [];
  for (let l = 0; l < 4; l++) {
    const [x, y] = input[line + l].split(' ').map(Number);
    points.push([x, y]);
  }
  points.sort((a, b) => a[0] - b[0] || a[1] - b[1]); // 오름차순 정렬
  // 1. 두 대각선의 길이가 동일해야함
  const diagonal1 =
    Math.pow(points[0][0] - points[3][0], 2) +
    Math.pow(points[0][1] - points[3][1], 2);
  const diagonal2 =
    Math.pow(points[1][0] - points[2][0], 2) +
    Math.pow(points[1][1] - points[2][1], 2);
  if (diagonal1 !== diagonal2) result += 0 + '\n';
  else {
    // 2. 네 변의 길이가 동일
    const len1 =
      Math.pow(points[0][0] - points[1][0], 2) +
      Math.pow(points[0][1] - points[1][1], 2);
    const len2 =
      Math.pow(points[0][0] - points[2][0], 2) +
      Math.pow(points[0][1] - points[2][1], 2);
    const len3 =
      Math.pow(points[1][0] - points[3][0], 2) +
      Math.pow(points[1][1] - points[3][1], 2);
    const len4 =
      Math.pow(points[2][0] - points[3][0], 2) +
      Math.pow(points[2][1] - points[3][1], 2);

    if (len1 !== len2 || len2 !== len3 || len3 !== len4 || len4 !== len1)
      result += 0 + '\n';
    else result += 1 + '\n';
  }

  line += 4;
}

console.log(result.trimEnd());
