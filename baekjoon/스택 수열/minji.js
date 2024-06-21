const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const n = +input[0];
let numbers = [];
for (let i = 1; i <= n; i += 1) numbers.push(+input[i]);

let stack = []; // 스택(배열)
let answer = []; // 정답 담을 배열
let current = 1; // 오름차순으로 스택에 집어 넣음
for (let i = 0; i < n; i += 1) {
  let num = numbers[i];
  // 입력한 값보다 작은 수들 push
  while (current <= num) {
    answer.push('+');
    stack.push(current);
    current += 1;
  }
  // 스택의 맨 뒤에 있는 값이 입력 값과 동일한 경우 pop
  if (stack[stack.length - 1] === num) {
    answer.push('-');
    stack.pop();
  } else {
    return console.log('NO'); // 스택을 만들 수 없는 경우
  }
}

answer.map((a) => console.log(a));
