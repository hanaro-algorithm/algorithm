const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const number = input[0].split('-'); // 뺄셈 기준으로 쪼개기

number.forEach((num, idx) => {
  // 더하기 먼저 수행
  if (num.includes('+')) {
    number[idx] = num.split('+').reduce((acc, cur) => +acc + +cur, 0);
  } else number[idx] = +num;
});
// 나머지 숫자들 뺄셈 계산
const result = number.reduce((acc, cur) => acc - cur);
console.log(result);
