const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 상근이가 가지고 있는 숫자 카드의 개수
const numbers = input[1].split(' ').map(Number); // 상근이가 가지고 있는 숫자들
const M = +input[2]; // 찾을 숫자 개수
const findNumbers = input[3].split(' ').map(Number); // 찾아야 할 숫자들

numbers.sort((a, b) => a - b); // 상근이가 가지고 있는 숫자들 오름차순 정렬

// 작은 인덱스 구하기
const lowerBound = (start, end, target) => {
  while (start < end) {
    const mid = parseInt((start + end) / 2);
    if (numbers[mid] >= target) end = mid;
    else start = mid + 1;
  }
  return end;
};
// 큰 인덱스 구하기
const upperBound = (start, end, target) => {
  while (start < end) {
    const mid = parseInt((start + end) / 2);
    if (numbers[mid] > target) end = mid;
    else start = mid + 1;
  }
  return end;
};
// 숫자 개수 구하기
const coundByRange = (target) => {
  const minIndex = lowerBound(0, N, target);
  const maxIndex = upperBound(0, N, target);
  return maxIndex - minIndex;
};

let answer = '';
findNumbers.forEach((number, index) => {
  const count = coundByRange(number);
  answer += index !== M - 1 ? count + ' ' : count;
});

console.log(answer);
