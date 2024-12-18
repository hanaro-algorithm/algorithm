const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const N = +input[0]; // 사려고 하는 사람들 수
const info = []; // 정보 저장
for (let i = 1; i <= N; i += 1) info.push(input[i].split(' ').map(Number));
info.sort((a, b) => a[0] - b[0]);

const prices = info.map((price) => price[0]); // 지불 금액

let result = [0, 0];

prices.forEach((price) => {
  let sum = 0;
  info.forEach((person) => {
    // 책정 값보다 작은 금액과 책정값보다 배송비가 더 큰 것은 포기
    if (person[0] >= price && price - person[1] >= 0) sum += price - person[1];
  });
  if (result[1] < sum) result = [price, sum];
});

console.log(result[0]);
