const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, K] = input[0].split(' ').map(Number); // N: 고양이 수, M: 최대 무게
const weights = input[1].split(' ').map(Number); // 각 고양이 무게

weights.sort((a, b) => a - b); // 고양이 무게 오름차순 정렬

let start = 0;
let end = N - 1;
let count = 0;
while (start < end) {
  const sumWeight = weights[start] + weights[end];

  // 최대무게보다 클 경우 end값 감소
  if (sumWeight > K) end -= 1;
  // 최대무게 만족시킬 경우 카운트 증가 및 start, end 값 변경
  else {
    count += 1;
    start += 1;
    end -= 1;
  }
}
console.log(count);
