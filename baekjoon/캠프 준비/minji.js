const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

// N: 문제의 수, L: 최소 난이도, R: 최대 난이도, X: (가장 어려운 문제 난이도 - 가장 쉬운 문제 난이도)의 최소값
const [N, L, R, X] = input[0].split(' ').map(Number);
const problems = input[1].split(' ').map(Number); // 각 문제의 난이도

problems.sort((a, b) => a - b); // 난이도 오름차순 정렬

let answer = 0;
const backtracking = (idx, depth, sum, max, min) => {
  // 조건에 부합하는지 확인
  if (depth >= 2 && sum >= L && sum <= R && max - min >= X) answer += 1;

  for (let i = idx; i < N; i += 1) {
    backtracking(
      i + 1,
      depth + 1,
      sum + problems[i],
      Math.max(max, problems[i]),
      Math.min(min, problems[i])
    );
  }
};

backtracking(0, 0, 0, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER);

console.log(answer);
