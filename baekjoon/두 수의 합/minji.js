const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const n = +input[0]; // 수열 크기 n
const numbers = input[1].split(' ').map(Number); // 수열에 포함되는 수들
const x = +input[2]; // x -> ai+aj=x

// 1. 숫자들 오름차순 정렬
numbers.sort((a, b) => a - b);

let count = 0; // x를 만족시키는 쌍의 개수
// 투포인터 이용 => start와 end를 잡고 이동시키면서 x를 만족하는 쌍 구하기
// 2. start+end > x 인 경우, 인덱스 end-1
//    start+end <= x인 경우, 인덱스 start+1
let start = 0;
let end = n - 1;
while (start < end) {
  const sum = numbers[start] + numbers[end];
  if (sum < x) start += 1;
  else if (sum > x) end -= 1;
  else {
    start += 1;
    count += 1;
  }
}

console.log(count);
