const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 수의 개수
const numbers = input[1].split(' ').map(Number);
let [add, sub, mul, div] = input[2].split(' ').map(Number);

let minValue = Number.MAX_SAFE_INTEGER;
let maxValue = Number.MIN_SAFE_INTEGER;

const backtracking = (index, sum) => {
  // 모든 수 연산처리 끝냈을 때, 최소값 최대값 갱신
  if (index === N) {
    minValue = Math.min(sum, minValue);
    maxValue = Math.max(sum, maxValue);
    return;
  }
  if (add > 0) {
    add -= 1;
    backtracking(index + 1, sum + numbers[index]);
    add += 1;
  }
  if (sub > 0) {
    sub -= 1;
    backtracking(index + 1, sum - numbers[index]);
    sub += 1;
  }
  if (mul > 0) {
    mul -= 1;
    backtracking(index + 1, sum * numbers[index]);
    mul += 1;
  }
  if (div > 0) {
    div -= 1;
    backtracking(index + 1, ~~(sum / numbers[index]));
    div += 1;
  }
};

backtracking(1, numbers[0]);

console.log(maxValue);
console.log(minValue);
