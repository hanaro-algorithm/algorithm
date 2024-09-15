const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // N: 단어개수, M: 단어 최소 길이
let words = new Map();
for (let i = 1; i <= N; i += 1) {
  const word = input[i];
  if (!words.has(word)) words.set(word, 1);
  else words.set(word, words.get(word) + 1);
}

words = [...words]; // 맵을 배열로 바꾸기

// 단어장 순서에 따른 정렬
words.sort(
  (a, b) => b[1] - a[1] || b[0].length - a[0].length || a[0].localeCompare(b[0])
);

let result = '';
// 단어 길이가 M이상인 단어만 단어장에 넣기
words.forEach((word) => {
  if (word[0].length >= M) result += word[0] + '\n';
});

result = result.trimEnd();
console.log(result);
