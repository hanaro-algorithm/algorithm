const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 기타의 개수
let guitars = [];
for (let i = 1; i <= N; i += 1) guitars.push(input[i]);

// 자릿수의 합 구하는 함수
const totalSum = (serialNum) => {
  const sum = serialNum.split('').reduce((acc, cur) => {
    if (Number(cur)) acc += Number(cur);
    return acc;
  }, 0);
  return sum;
};

guitars.sort((a, b) => {
  // 1. 시리얼 번호 길이 오름차순 정렬
  if (a.length > b.length) return 1;
  else if (a.length < b.length) return -1;
  // 2. 각 시리얼 번호 자릿수의 합 기준 오름차순 정렬
  else if (totalSum(a) > totalSum(b)) return 1;
  else if (totalSum(a) < totalSum(b)) return -1;
  // 3. 사전순으로 오름차순 정렬
  else if (a > b) return 1;
  else return -1;
});

guitars = guitars.join('\n');
console.log(guitars);
