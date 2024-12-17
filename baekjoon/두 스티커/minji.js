const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [H, W] = input[0].split(' ').map(Number);
const N = +input[1]; // 스티커 개수
const stickers = []; // 스티커 길이
for (let i = 2; i < N + 2; i += 1)
  stickers.push(input[i].split(' ').map(Number));

let area = 0; // 최대 넓이 값
for (let i = 0; i < N; i += 1) {
  const [r1, c1] = [stickers[i][0], stickers[i][1]]; // 첫 번째 스티커
  // 모눈종이(HXW) 안에 들어올 때만 수행
  if ((r1 <= H && c1 <= W) || (c1 <= H && r1 <= W)) {
    for (let j = i + 1; j < N; j += 1) {
      const [r2, c2] = [stickers[j][0], stickers[j][1]]; // 두 번째 스티커
      // 모눈종이(HXW) 안에 들어올 때만 수행
      if ((r2 <= H && c2 <= W) || (c2 <= H && r2 <= W)) {
        if (
          // 1. 회전 X(가로로 이어 붙일 때, 세로로 이어 붙일 때)
          (c1 + c2 <= W && r1 <= H && r2 <= H) ||
          (r1 + r2 <= H && c1 <= W && c2 <= W) ||
          // 2. 1번째꺼 회전(가로로 이어 붙일 때, 세로로 이어 붙일 때)
          (r1 + c2 <= W && c1 <= H && r2 <= H) ||
          (c1 + r2 <= H && r1 <= W && c2 <= W) ||
          // 3. 2번째꺼 회전(가로로 이어 붙일 때, 세로로 이어 붙일 때)
          (c1 + r2 <= W && r1 <= H && c2 <= H) ||
          (r1 + c2 <= H && c1 <= W && r2 <= W) ||
          // 4. 둘 다 회전(가로로 이어 붙일 때, 세로로 이어 붙일 때)
          (r1 + r2 <= W && c1 <= H && c2 <= H) ||
          (c1 + c2 <= H && r1 <= W && r2 <= W)
        ) {
          area = Math.max(area, r1 * c1 + r2 * c2); // 최대 넓이 값 갱신
        }
      }
    }
  }
}

console.log(area);
