const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, K] = input[0].split(' ').map(Number); // 단어의 개수 N, 가르칠 수 있는 글자 수: K

const prefix_postfix = ['a', 'n', 't', 'i', 'c']; // 반드시 가르쳐야할 글자
const words = []; // N개의 단어

if (K < 5) return console.log(0); //

for (let i = 1; i <= N; i++) words.push(input[i].split(''));

const visited = Array.from({ length: 26 }, () => false); // 배운 글자인지에 대한 여부
prefix_postfix.forEach((p) => (visited[p.charCodeAt() - 97] = true)); // 반드시 가르쳐야할 글자들 배운 글자 배열에 표시

let answer = Number.MIN_SAFE_INTEGER;
const backtracking = (idx, cnt) => {
  // 배울 수 있는 글자수가 더 이상 없는 경우
  if (!cnt) {
    let readWord = 0; // 읽을 수 있는 단어의 수
    for (const word of words) {
      let flag = true; // 읽을 수 있음
      for (const w of word) {
        // 단어의 글자를 배웠는지 확인
        if (!visited[w.charCodeAt() - 97]) {
          flag = false; // 배우지 못했으므로 이 단어는 읽을 수 없음
          break;
        }
      }
      if (flag) readWord++; // 읽을 수 있는 단어인 경우 카운트 증가
    }
    answer = Math.max(answer, readWord); // 읽을 수 있는 단어의 최댓값 갱신
  }
  for (let s = idx; s < 26; s++) {
    // 아직 배우지 않은 글자이면서, 배울 수 있는 글자의 수가 남아있는 경우
    if (!visited[s]) {
      visited[s] = true; // 해당 글자 배우기
      backtracking(s + 1, cnt - 1);
      visited[s] = false;
    }
  }
};
backtracking(0, K - 5);

console.log(answer);
