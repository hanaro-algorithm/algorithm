const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [R, C] = input[0].split(' ').map(Number);
const currentMap = [];
for (let i = 1; i <= R; i += 1) currentMap.push(input[i].split('')); // 현재 섬 지도

const dx = [-1, 0, 1, 0];
const dy = [0, -1, 0, 1];

const futureMap = Array.from({ length: R }, () => new Array(C).fill('.')); // 미래 지도 리스트
for (let r = 0; r < R; r += 1) {
  for (let c = 0; c < C; c += 1) {
    let cnt = 0; // 인접한 영역에 바다가 몇개있는지 카운트하기 위한 변수
    for (let direction = 0; direction < 4; direction += 1) {
      const [nx, ny] = [dx[direction] + r, dy[direction] + c]; // 인접한 영역 확인
      // 인접한 영역이 바다('.')이거나 영역 벗어나는 경우(영역 벗어난 부분도 바다임) 카운트 증가
      if (nx < 0 || nx >= R || ny < 0 || ny >= C || currentMap[nx][ny] === '.')
        cnt += 1;
    }
    if (currentMap[r][c] === 'X' && cnt < 3) futureMap[r][c] = 'X'; // 현재 위치가 땅이고, 인접한 영역의 바다 수가 3 이하인 경우만 섬 생존
  }
}

let [minC, maxC] = [Number.MAX_SAFE_INTEGER, Number.MIN_SAFE_INTEGER]; // 미래의 섬 위치의 최소 열과 최대 열
let [minR, maxR] = [Number.MAX_SAFE_INTEGER, Number.MIN_SAFE_INTEGER]; // 미래의 섬 위치의 최소 행과 최대 행
// 출력값에서 섬 위치와 인접한 부분만 출력하면 되기 때문에 필요 없는 영역 제거하기 위해 최소, 최대 구하기
futureMap.forEach((_, idxR) => {
  futureMap[idxR].forEach((c, idxC) => {
    if (c === 'X') {
      minC = Math.min(minC, idxC);
      maxC = Math.max(maxC, idxC);
      minR = Math.min(minR, idxR);
      maxR = Math.max(maxR, idxR);
    }
  });
});

// 정답 출력
let answer = '';
for (let r = minR; r <= maxR; r += 1) {
  for (let c = minC; c <= maxC; c += 1) {
    answer += futureMap[r][c];
  }
  if (r !== maxR) answer += '\n';
}

console.log(answer);
