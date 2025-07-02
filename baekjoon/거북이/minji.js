const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

// 방향 배열 생성(동, 서, 남, 북 순으로 저장)
const directions = [
  { dx: 1, dy: 0, left: 3, right: 2 },
  { dx: -1, dy: 0, left: 2, right: 3 },
  { dx: 0, dy: -1, left: 0, right: 1 },
  { dx: 0, dy: 1, left: 1, right: 0 },
];

let t = +input[0]; // 테스트 케이스
let line = 1; // 입력 라인

let result = ''; // 정답 문자열
while (t--) {
  const order = input[line++].split(''); // 명령 정보
  let currentP = [0, 0]; // 현재 좌표 정보(x좌표, y좌표)
  let currentDIdx = 3; // 초기에는 북쪽 방향 바라보고 있음

  let maxX = 0,
    minX = 0,
    maxY = 0,
    minY = 0;

  for (const o of order) {
    // 앞으로 전진 or 뒤로 후진
    if (o === 'F') {
      currentP[0] += directions[currentDIdx].dx;
      currentP[1] += directions[currentDIdx].dy;
    } else if (o === 'B') {
      currentP[0] -= directions[currentDIdx].dx;
      currentP[1] -= directions[currentDIdx].dy;
    } else if (o === 'L') {
      currentDIdx = directions[currentDIdx].left;
    } else if (o === 'R') {
      currentDIdx = directions[currentDIdx].right;
    }
    maxX = Math.max(maxX, currentP[0]);
    minX = Math.min(minX, currentP[0]);
    maxY = Math.max(maxY, currentP[1]);
    minY = Math.min(minY, currentP[1]);
  }
  result += (maxX - minX) * (maxY - minY) + '\n';
}
console.log(result.trimEnd());
