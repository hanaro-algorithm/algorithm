const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 과일의 개수
const fruits = input[1].split(' ').map(Number); // 탕후루에 꽂힌 과일

let start = 0;
let end = fruits.findIndex((fruit) => fruits[0] !== fruit); // 맨 처음 과일이랑 다른 과일의 첫 인덱스 찾기

if (end === -1) return console.log(fruits.length); // 종류가 1개인 경우이므로 그대로 과일 수 리턴
let maxCnt = end - start + 1;

const sliceFruits = new Map();
sliceFruits.set(fruits[start], end - start); // start 과일 해시 Map에 넣기
sliceFruits.set(fruits[end], 1); // end 과일 해시 Map에 넣기

end += 1;
while (end < N) {
  // Map에 있는 과일의 종류가 2개이고, 새로운 과일이 추가될 경우
  if (sliceFruits.size === 2 && !sliceFruits.has(fruits[end])) {
    sliceFruits.set(fruits[start], sliceFruits.get(fruits[start]) - 1); // 앞에 있던 과일 하나 제거
    if (sliceFruits.get(fruits[start]) === 0) sliceFruits.delete(fruits[start]); // 해당 과일 개수가 0개가 되면 Map에서 삭제
    start += 1; // 시작점 변경
    continue;
  }
  // Map에 이미 존재하는 과일 종류인 경우
  else if (sliceFruits.has(fruits[end])) {
    sliceFruits.set(fruits[end], sliceFruits.get(fruits[end]) + 1); // 개수 추가
  }
  // 새로운 과일인데 Map에 과일 종류가 1개인 경우
  else {
    sliceFruits.set(fruits[end], 1);
  }
  maxCnt = Math.max(maxCnt, end - start + 1); // 최대 과일의 수 갱신
  end += 1;
}

console.log(maxCnt);
