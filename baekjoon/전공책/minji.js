const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const T = input[0].split(''); // 만들고자 하는 단어
const N = +input[1]; // 전공책 개수
const majorBooks = []; // 가격, 전공책
for (let i = 2; i < N + 2; i += 1) majorBooks.push(input[i].split(' '));

// 만들고자 하는 단어 개수 해시맵에 넣기
const wordMap = new Map();
T.forEach((t) => wordMap.set(t, (wordMap.get(t) || 0) + 1));

majorBooks.sort((a, b) => +a[0] - +b[0]); // 전공책 가격 오름차순 정렬
let answer = Number.MAX_SAFE_INTEGER;
const visited = Array.from({ length: N }, () => false);
const dfs = (index, selectedMap, cost) => {
  if (cost >= answer) return; // 현재 비용이 최소 비용 이상이면 종료
  let isAvailable = true;
  // 선택한 전공책에서 단어 만들 수 있는지 확인
  for (const [alphabet, count] of wordMap.entries()) {
    if ((selectedMap.get(alphabet) || 0) < count) {
      isAvailable = false;
      break;
    }
  }
  // 만들 수 있는 경우 최소값 갱신
  if (isAvailable) {
    answer = Math.min(answer, cost);
    return;
  }
  for (let book = index + 1; book < N; book += 1) {
    if (!visited[book]) {
      visited[book] = true;
      const [price, title] = majorBooks[book];
      const newMap = new Map(selectedMap);
      // 기존 해시맵에 새로운 전공책 제목 추가
      for (const t of title) {
        newMap.set(t, (newMap.get(t) || 0) + 1);
      }
      dfs(book, newMap, cost + +price);
      visited[book] = false;
    }
  }
};

dfs(-1, new Map(), 0);

console.log(answer === Number.MAX_SAFE_INTEGER ? -1 : answer);
