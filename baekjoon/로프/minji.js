const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 로프의 수
const maxWeights = []; // 각 로프의 버틸 수 있는 최대 중량
for (let i = 1; i < N + 1; i += 1) maxWeights.push(+input[i]);
maxWeights.sort((a, b) => a - b);

let maxWeight = Math.max(...maxWeights);

for (let i = 0; i < N - 1; i += 1) {
  maxWeight = Math.max(maxWeight, maxWeights[i] * (N - i));
}

console.log(maxWeight);
