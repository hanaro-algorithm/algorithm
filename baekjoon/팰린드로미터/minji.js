const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let line = 0;
let answer = '';

// 팰린드롬인지 확인
const isPalindrome = (number) => {
  let [start, end] = [0, number.length - 1];
  while (start < end) {
    if (number[start] !== number[end]) return false;
    start += 1;
    end -= 1;
  }
  return true;
};

while (true) {
  const originNum = input[line];
  if (originNum === '0') break; // 마지막 줄이면 중단
  let palindromNum = +originNum;
  while (true) {
    if (isPalindrome(palindromNum.toString().padStart(originNum.length, 0)))
      break;
    palindromNum += 1; // 팰린드롬이 아니라면 주행거리 1km 증가
  }
  answer += palindromNum - originNum + '\n';
  line += 1; // 다음 테스트 케이스
}

answer = answer.trimEnd();
console.log(answer);
