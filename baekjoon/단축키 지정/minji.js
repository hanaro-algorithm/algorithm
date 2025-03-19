/**
 * 문제) 단축키 지정
 * [단축키 지정 순서(대소문자 구분 X)]
 * 1. 하나의 옵션에 대해 왼쪽 -> 오른쪽 순으로 단어 첫 글자가 단축키인지 확인, 단축키로 지정 X 그 알파벳 단축키로 지정
 * 2. 모든 단어 첫글자가 이미 단축키로 지정되어있으면 옵션 왼쪽부터 차례대로 단축키로 지정안된 것으로 지정
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const N = +input[0]; // 옵션 개수
const shortcutKey = new Set(); // 단축키 모음

let answer = '';
for (let i = 1; i <= N; i++) {
  let option = input[i].split(' ');
  let flag = false;
  // 1. 하나의 옵션에 대한 단어들의 첫 글자 단축키 지정
  for (let o = 0; o < option.length; o++) {
    // 단축키 집합에 단어 첫글자가 존재하지 않는 경우 단축키로 지정
    if (!shortcutKey.has(option[o][0].toUpperCase())) {
      shortcutKey.add(option[o][0].toUpperCase()); // 단축키 집합에 첫 글자 넣기(대소문자 구별안하므로 대문자로 넣기)
      option[o] = option[o].replace(option[o][0], `[${option[o][0]}]`); // 단어의 첫글자 [글자]로 변경
      answer += option.join(' ') + '\n';
      flag = true; // 단축키로 지정되었으므로 해당 옵션은 통과
      break;
    }
  }

  if (flag) continue;
  // 2. 옵션 전체 왼쪽부터 차례때로 단축키로 지정안된 것을 단축키로 지정
  option = option.join(' ');
  for (let o = 0; o < option.length; o++) {
    // 공백이 아니고, 단축키 집합에 포함하지 않는 경우
    if (option[o] !== ' ' && !shortcutKey.has(option[o].toUpperCase())) {
      shortcutKey.add(option[o].toUpperCase()); // 해당 단어 단축키 집합에 넣기
      answer += option.replace(option[o], `[${option[o]}]`) + '\n'; // 단축키로 변경한 문자 [] 씌우기
      flag = true;
      break;
    }
  }
  if (!flag) answer += option + '\n'; // 단어 모두가 단축키로 설정되어있을 때
}

console.log(answer.trimEnd());
