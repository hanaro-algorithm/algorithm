const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [H, W] = input[0].split(' ').map(Number); // 세계의 세로 길이와 가로 길이
const blocks = input[1].split(' ').map(Number); // 블록이 쌓인 높이

let cnt = 0;
for (let i = 1; i < W - 1; i += 1) {
  let maxLeftHeight = Math.max(...blocks.slice(0, i + 1)); // 현재 블록 기준 왼쪽에서 가장 큰 값
  let maxRightHeight = Math.max(...blocks.slice(i)); // 현재 블록 기준 오른쪽에서 가장 큰 값

  // 두 값 중 높이가 낮은거 기준으로 고인 빗물 체크
  cnt += Math.min(maxLeftHeight, maxRightHeight) - blocks[i];
}

console.log(cnt);
