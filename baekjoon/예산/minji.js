const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 지방의 수
const budgets = input[1].split(' ').map(Number); // 각 지방의 예산
const maxBudget = +input[2]; // 총예산

let [start, end] = [1, Math.max(...budgets)];
let result = 0;
while (start <= end) {
  const mid = parseInt((start + end) / 2);
  // 배정 예산으로 지방들의 총 예산 합
  const total = budgets.reduce(
    (prev, current) => (prev += Math.min(mid, current)),
    0
  );
  // 총예산을 넘지 않는 경우 mid기준 오른쪽 탐색
  if (total <= maxBudget) {
    result = mid;
    start = mid + 1;
  } else end = mid - 1; // 총예산 넘는 경우 mid기준 왼쪽 탐색
}

console.log(end);
