const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let T = +input[0]; // 테스트 케이스 개수
let line = 1;

let answer = ''; // 출력 결과
while (T > 0) {
  const word = input[line].split(''); // 단어 쪼개기
  let [index1, index2] = [-1, -1];
  // 단어 맨 뒤부터 아스키 코드 값이 감소하는 부분 찾기
  for (let i = word.length - 1; i > 0; i -= 1) {
    if (word[i - 1].charCodeAt() < word[i].charCodeAt()) {
      index1 = i - 1;
      break;
    }
  }
  // 감소하는 부분이 없다면 사전 순으로 가장 맨 마지막이므로 그냥 해당 값 출력
  if (index1 === -1) {
    answer += word.join('') + '\n';
  } else {
    // 단어 맨 뒤부터 감소하는 부분보다 큰 부분 구하기
    for (let i = word.length - 1; i > index1; i -= 1) {
      if (word[i].charCodeAt() > word[index1].charCodeAt()) {
        index2 = i;
        break;
      }
    }

    // 두 알파벳 순서 변경
    const temp = word[index1];
    word[index1] = word[index2];
    word[index2] = temp;
    // 감소하는 부분 기준으로 뒤에 부분 오름차순 정렬
    answer +=
      [...word.slice(0, index1 + 1), ...word.slice(index1 + 1).sort()].join(
        ''
      ) + '\n';
  }

  line += 1;
  T -= 1;
}

answer = answer.trimEnd();
console.log(answer);
