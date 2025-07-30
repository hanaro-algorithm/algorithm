const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // N: 나무의 개수, M: 집에 가져갈 나무 길이
const heights = input[1]
  .split(' ')
  .map(Number)
  .sort((a, b) => a - b); // 나무들의 높이

let start = 0;
let end = heights[N - 1];

let result = 0;
while (start <= end) {
  const mid = parseInt((start + end) / 2);

  const total = heights.reduce((acc, cur) => {
    const sub = cur - mid;
    if (sub > 0) acc += sub;
    return acc;
  }, 0);

  if (total >= M) {
    result = mid;
    start = mid + 1;
  } else end = mid - 1;
}

console.log(result);
