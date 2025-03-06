const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, C] = input[0].split(' ').map(Number);
const house = [];
for (let i = 1; i <= N; i += 1) house.push(+input[i]);
house.sort((a, b) => a - b);

let start = 1;
let end = house.at(-1) - house[0];

let result = 0;
while (start <= end) {
  const mid = Math.floor((start + end) / 2);
  let current = house[0];
  let cnt = 1;
  for (let i = 1; i < N; i += 1) {
    if (house[i] - mid >= current) {
      current = house[i];
      cnt += 1;
    }
  }
  if (cnt >= C) {
    start = mid + 1;
    result = mid;
  } else end = mid - 1;
}

console.log(result);
