const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const document = input[0]; // 문서 내용
const word = input[1]; // 찾으려는 단어

console.log([...document.matchAll(word)].length);

// String.prototype.matchAll(정규식) 메서드 이용
// String에 지정한 정규표현식과 일치하는 모든 결과 배열로 반환
/*
 * document: aaaaaaa
 * word: aa
 * 결과값:
  [
    [ 'aa', index: 0, input: 'aaaaaaa', groups: undefined ],
    [ 'aa', index: 2, input: 'aaaaaaa', groups: undefined ],
    [ 'aa', index: 4, input: 'aaaaaaa', groups: undefined ]
  ]
 */
