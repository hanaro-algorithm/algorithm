const fs = require('fs');
const input = fs
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n')
  .map((v) => v.trim());

const boyerMooreMajority = (arr, len) => {
  // 1. 과반수 이상이 될 수 있는 원소 찾기(후보)
  let count = 0;
  let major = 0;
  for (const item of arr) {
    if (count === 0) major = item; // 현재 선택된 원소가 없다면 현재 원소로 교체
    count += major === item ? 1 : -1; // 같은 원소이면 증가, 다른 원소이면 감소
  }

  // 2. 현재 원소가 과반수 이상인지 확인
  count = 0;
  for (const item of arr) {
    if (item === major) count++;
  }

  return count > len / 2 ? major : 'SYJKGW';
};

input.shift(); // n 값 없애기

let result = [];
input.forEach((value) => {
  const arr = value.split(' ');
  const len = arr.shift(); // 현재 땅의 총 병사 수
  result.push(boyerMooreMajority(arr, len));
});

console.log(result.join('\n'));
