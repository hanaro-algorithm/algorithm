const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // 점: N, 선분: M
const dots = input[1].split(' ').map(Number); // 점의 좌표

let lines = [];
for (let i = 2; i < M + 2; i += 1) lines.push(input[i].split(' ').map(Number));
let answer = [];

dots.sort((a, b) => a - b); // 점 오름차순 정렬

// 범위 중 가장 작은 인덱스 찾기
function lowerBound(target, start, end) {
  while (start < end) {
    let mid = Math.floor((start + end) / 2);
    if (dots[mid] >= target) end = mid;
    else start = mid + 1;
  }
  return end;
}

// 범위 중 가장 큰 인덱스 찾기
function upperBound(target, start, end) {
  while (start < end) {
    let mid = Math.floor((start + end) / 2);
    if (dots[mid] > target) end = mid;
    else start = mid + 1;
  }
  return end;
}

lines.map((line) => {
  let minNum = lowerBound(line[0], 0, N);
  let maxNum = upperBound(line[1], 0, N);
  answer.push(maxNum - minNum);
});

console.log(answer.join('\n'));
