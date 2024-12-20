const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const T = input[0].split(''); // 만들고자 하는 단어
const N = +input[1]; // 전공책 개수
const majorBooks = []; // 가격, 전공책
for (let i = 2; i < N + 2; i += 1) majorBooks.push(input[i].split(' '));

// 만들고자 하는 단어 개수 해시맵에 넣기
const wordMap = new Map();
T.forEach((t) => {
  wordMap.set(t, !wordMap.get(t) ? 1 : wordMap.get(t) + 1);
});

let answer = Number.MAX_SAFE_INTEGER;
const visited = Array.from({ length: N }, () => false);
const dfs = (index, selected, cost) => {
  const map = new Map();
  // 선택된 전공책 제목 해시맵에 저장
  selected.forEach((item) => {
    if (map.has(item)) map.set(item, map.get(item) + 1);
    else map.set(item, 1);
  });
  let cnt = 0;
  // 선택한 전공책에서 단어 만들 수 있는지 확인
  [...wordMap.keys()].forEach((word) => {
    if (map.get(word) >= wordMap.get(word)) cnt += 1;
  });
  if (cnt === wordMap.size) {
    answer = Math.min(answer, cost);
    return;
  }
  for (let book = index + 1; book < N; book += 1) {
    if (!visited[book] && majorBooks[book][1] !== '') {
      visited[book] = true;
      dfs(
        book,
        selected.concat(...majorBooks[book][1]),
        cost + +majorBooks[book][0]
      );
      visited[book] = false;
    }
  }
};

dfs(-1, [], 0);

console.log(answer === Number.MAX_SAFE_INTEGER ? -1 : answer);
