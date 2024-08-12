const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, K] = input[0].split(' ').map(Number); // N: 수열 길이, K: 같은 원소 허용 갯수
const numbers = input[1].split(' ').map(Number); // 수열

let start = 0;
let end = 1;

const map = new Map();
map.set(numbers[start], 1);

let maxLen = 1;
while (end < N) {
  // 맵에 없는 경우는 그냥 넣기
  if (!map.has(numbers[end])) {
    map.set(numbers[end], 1);
    end += 1;
  } else {
    // 맵에 존재하지만 갯수가 K를 넘지 않는 경우, 갯수 추가(end 증가)
    if (map.get(numbers[end]) + 1 <= K) {
      map.set(numbers[end], map.get(numbers[end]) + 1);
      end += 1;
    }
    // 갯수가 K를 넘어가는 경우, start 갯수 감소(start 증가)
    else {
      map.set(numbers[start], map.get(numbers[start]) - 1);
      start += 1;
    }
  }
  // 최대 길이 구하기
  maxLen = Math.max(maxLen, end - start);
}

console.log(maxLen);
