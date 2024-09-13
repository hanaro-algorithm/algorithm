const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, M, B] = input[0].split(' ').map(Number);
let ground = []; // 초기 땅

let maxHeight = 0; // 땅 높이가 가장 큰 값
for (let i = 1; i <= N; i += 1) {
  let rowGround = input[i].split(' ').map(Number);
  maxHeight = Math.max(maxHeight, ...rowGround);
  ground.push(rowGround);
}

let arr = [];

for (let height = maxHeight; height >= 0; height -= 1) {
  let copyB = B;
  let time = 0;
  for (let i = 0; i < N; i += 1) {
    for (let j = 0; j < M; j += 1) {
      // 원하는 땅 높이랑 현재 위치의 땅 높이랑 같은 경우 그냥 패스
      if (ground[i][j] === height) continue;
      // 원하는 땅 높이가 현재 위치 땅 높이보다 작은 경우
      // 현재 위치 땅 블록 제거 => 1번
      // '현재 위치 땅 - 원하는 땅 높이'를 인벤토리에 넣기
      else if (ground[i][j] > height) {
        let outAmount = ground[i][j] - height;
        copyB += outAmount;
        time += outAmount * 2;
      }
      // 원하는 땅 높이가 현재 위치 땅 높이보다 클 경우
      // 현재 위치 땅 블록 추가 => 2번
      // '원하는 땅 높이 - 현재 위치 땅'만큼 인벤토리에서 빼기
      else {
        let inAmount = height - ground[i][j];
        copyB -= inAmount;
        time += inAmount;
      }
    }
  }
  if (copyB >= 0) arr.push([time, height]); // 인벤토리가 음수인 경우는 제외
}

arr.sort((a, b) => a[0] - b[0] || b[1] - a[1]); // 최소시간 오름차순 정렬, 같다면 높이 내림차순 정렬
console.log(arr[0].join(' '));
