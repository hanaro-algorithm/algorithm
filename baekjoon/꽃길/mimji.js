const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 화단의 한 변의 길이
let costs = [];
for (let i = 1; i <= N; i += 1) {
  costs.push(input[i].split(' ').map(Number));
}

let possible = Array.from({ length: N }, () => new Array(N).fill(true));

// 상하좌우
let dxdy = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

let answer = Number.MAX_SAFE_INTEGER;
const dfs = (depth, sumCost) => {
  // 최소비용보다 누적 비용이 크면 더이상 dfs 수행할 필요 없음
  if (sumCost >= answer) return;
  if (depth === 3) answer = Math.min(sumCost, answer);
  else {
    for (let row = 1; row < N - 1; row += 1) {
      for (let col = 1; col < N - 1; col += 1) {
        // 꽃이 안심어져 있고, 다른꽃들과 잎이 겹치지 않는 경우에만 수행
        if (possible[row][col] && checkPossible(row, col)) {
          let cost = costs[row][col]; // 씨앗 위치 비용
          possible[row][col] = false; // 씨앗 위치 표시
          for (let i = 0; i < 4; i += 1) {
            cost += costs[row + dxdy[i][0]][col + dxdy[i][1]]; // 꽃잎 위치 비용
            possible[row + dxdy[i][0]][col + dxdy[i][1]] = false; // 꽃잎 위치 표시
          }
          dfs(depth + 1, sumCost + cost);
          // 심지 않은 꽃에 대한 화단 다시 원상복귀
          possible[row][col] = true;
          for (let i = 0; i < 4; i += 1) {
            possible[row + dxdy[i][0]][col + dxdy[i][1]] = true;
          }
        }
      }
    }
  }
};

// 다른 꽃들과 겹치지 않는지 확인
const checkPossible = (r, c) => {
  for (let i = 0; i < 4; i += 1) {
    if (!possible[r + dxdy[i][0]][c + dxdy[i][1]]) return false;
  }
  return true;
};

dfs(0, 0);
console.log(answer);
