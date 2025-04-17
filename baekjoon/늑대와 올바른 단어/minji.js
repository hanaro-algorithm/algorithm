/**
 * 문제) 늑대와 올바른 단어
 * 양의 정수 n에 대해서 w*n, o*n, l*n, f*n 나온 단어는 올바른 단어
 * 올바른 단어 두 개 이은 단어도 올바른 단어
 * 답) 올바른 단어인 경우 1 출력, 아니면 0 출력
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
const word = input[0].split(''); // 단어 입력 받기
const WOLF = ['w', 'o', 'l', 'f']; // wolf 올바른 순서

let index = 0;

while (index < word.length) {
  // 'w'가 몇 번 나오는지 카운트
  let cnt = 0;
  while (word[index + cnt] === 'w') cnt++;
  if (cnt === 0) return console.log(0); // w가 없으면 잘못된 단어

  // 'w'가 cnt, 'o'가 cnt, 'l'가 cnt, 'f'가 cnt 나오는지 확인
  for (let i = 0; i < 4; i++) {
    for (let j = 0; j < cnt; j++) {
      if (word[index++] !== WOLF[i]) return console.log(0);
    }
  }
}

console.log(1);
