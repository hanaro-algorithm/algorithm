const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 전체 용액의 수
const solutions = input[1].split(' ').map(Number); // 용액의 특성값

solutions.sort((a, b) => a - b); // 용액의 특성값 오름차순 정렬

let min = Number.MAX_SAFE_INTEGER; // 혼합 용액의 최소 특성값
let answer = [];

let [start, end] = [0, N - 1];
while (start < end) {
  const sum = solutions[start] + solutions[end]; // 두 용액 혼합

  // 혼합한 특성값이 최소 특성값보다 작은 경우 최소 특성값 갱신
  if (min > Math.abs(sum)) {
    min = Math.abs(sum);
    answer = [solutions[start], solutions[end]];
  }

  if (sum > 0)
    end -= 1; // 두 용액 합한 값이 양수인 경우 end값 감소
  else if (sum < 0)
    start += 1; // 두 용액 합한 값이 음수인 경우 start값 감소
  else {
    end -= 1;
    start += 1;
  }
}

console.log(answer[0], answer[1]);
