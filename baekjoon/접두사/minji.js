const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 단어의 개수
const words = [];
for (let i = 1; i <= N; i++) words.push(input[i]);
words.sort(); // 문자 오름차순 정렬

let cnt = 0;
for (let i = 0; i < N; i++) {
  let flag = false; // 접두어가 되는지 판별
  for (let j = i + 1; j < N; j++) {
    // 다른 단어의 접두어이면 flag 변경
    if (words[j].startsWith(words[i])) {
      flag = true;
      break;
    }
  }
  if (!flag) cnt++; // 접두어X 이면 개수 증가
}
console.log(cnt);
