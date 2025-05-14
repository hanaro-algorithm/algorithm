/**
 * 문제) 에디터
 * 명령어 수행하고 난 후 편집기에 입력되어 있는 문자열 출력
 * ▶︎ 명령어 수행 전에 커서는 문자열 맨 뒤에 위치
 *
 * split() 메서드와 concat() 메서드로 풀면 최악의 경우 시간복잡도 O(NM) 발생
 * 커서 기준 왼쪽 스택 배열과 오른쪽 스택 배열 만들어서 풀어야 O(M) 시간복잡도 가능
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const leftStr = input[0].split(''); // 편집기에 입력되어 있는 문자열(소문자로만 이루어져있음), 커서 기준 왼쪽 스택 배열
const rightStr = []; // 커서 기준 오른쪽 스택 배열
const M = +input[1]; // 명령어 개수

for (let m = 2; m < M + 2; m++) {
  const [order, word] = input[m].split(' '); // 명령어, 문자

  // 커서 왼쪽으로 한 칸 옮김(커서가 문장 맨 앞이면 무시)
  if (order === 'L' && leftStr.length) rightStr.push(leftStr.pop());
  // 커서를 오른쪽으로 한 칸 옮김(커서가 문장 맨 뒤이면 무시)
  else if (order === 'D' && rightStr.length) leftStr.push(rightStr.pop());
  // 커서 왼쪽에 있는 문자 삭제(커서가 문장 맨 앞이면 무시)
  else if (order === 'B' && leftStr.length) leftStr.pop();
  // word 문자 커서 왼쪽에 추가
  else if (order === 'P') leftStr.push(word);
}

console.log(leftStr.join('') + rightStr.reverse().join(''));
