const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const string = input[0];

// KMP 알고리즘
const KMPTable = (pattern) => {
  const patternSize = pattern.length;
  const table = Array.from({ length: patternSize }, () => 0);
  let max = 0;
  let prefix = 0; // 접두사 비교 인덱스
  // 접미사 비교 인덱스
  for (let suffix = 1; suffix < patternSize; suffix += 1) {
    while (prefix > 0 && pattern[prefix] !== pattern[suffix])
      // 같지 않을 경우 이전 접두사 인덱스의 값으로 변경
      prefix = table[prefix - 1];
    if (pattern[prefix] === pattern[suffix]) {
      table[suffix] = ++prefix;
      max = Math.max(max, table[suffix]);
    }
  }
  return max;
};

let answer = 0;
for (let i = 0; i < string.length - 1; i += 1) {
  const str = string.substring(i, string.length);
  answer = Math.max(answer, KMPTable(str));
}

console.log(answer);
