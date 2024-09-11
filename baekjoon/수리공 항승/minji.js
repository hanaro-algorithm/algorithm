const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, L] = input[0].split(' ').map(Number); // N: 물이 새는 곳, L: 테이프 길이
const positions = input[1].split(' ').map(Number); // 물이 새는 위치

positions.sort((a, b) => a - b); // 물이 새는 위치 오름차순 정렬

let start = positions[0]; // 처음부터 시작

let result = 1; // 필요한 테이프 개수
for (let i = 1; i < N; i += 1) {
  // 현재 물 새는 위치가 시작점+테이프 길이 내에 존재하는 경우 패스
  if (positions[i] > start && positions[i] < start + L) continue;
  // 범위 내에 없는 경우 시작점 변경 후 테이프 개수 증가
  else {
    start = positions[i];
    result += 1;
  }
}

console.log(result);
