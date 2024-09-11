const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // N: 숫자 개수, M: 수열 크기
let numbers = [];
for (let i = 1; i <= N; i += 1) numbers.push(i);

const visited = Array.from({ length: N + 1 }, () => false);
let selected = [];

let answer = '';
const dfs = (depth) => {
  console.log('selected', selected);
  console.log('visited', visited);
  // 수열 길이 M을 채운 경우
  if (depth === M) {
    for (let num of selected) answer += num + ' '; // 정답에 추가
    answer += '\n';
    return;
  }
  for (let n = 1; n <= N; n += 1) {
    if (visited[n]) continue; // 이미 수열 선택 배열에 추가된 경우 패스
    visited[n] = true; // 방문 처리
    selected.push(n); // 수열 선택 배열에 해당 숫자 넣기
    dfs(depth + 1); // dfs 수행(depth는 selected 길이)
    selected.pop(); // 수열 선택 배열에서 빼내기
    visited[n] = false; // 방문 처리 취소
  }
};

dfs(0);
answer = answer.trimEnd(); // 맨 마지막 공백 제거
console.log(answer);
