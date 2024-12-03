const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const K = +input[0]; // 정수 K

const numbers = []; // 장부
for (let i = 1; i <= K; i += 1) {
  const number = +input[i];
  if (number !== 0)
    numbers.push(number); // 0이 아닌 경우 장부에 숫자 넣기
  else numbers.pop(); // 0인 경우 가장 마지막에 들어간 숫자 빼내기
}

const totalSum = numbers.reduce((sum, number) => sum + number, 0); // 최종 장부 총합 구하기

console.log(totalSum);
