const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let T = +input[0]; // 테스트 케이스 개수
let line = 1;

// 두 사람의 리적 거리 구하기
const distanceFunc = (mbti1, mbti2) => {
  let sum = 0;
  for (let i = 0; i < 4; i += 1) {
    if (mbti1[i] !== mbti2[i]) sum += 1;
  }
  return sum;
};

let answer = '';
while (T > 0) {
  const N = +input[line];
  const listOfMBTI = input[line + 1].split(' ');
  let result = Number.MAX_SAFE_INTEGER;
  // MBTI가 총 16가지 이므로 N이 33 이상이면 같은 MBTI를 가진 사람이 3명이상 존재
  // 따라서 MBTI가 같은 세 사람을 선택하면 최소 심리적 거리는 0
  if (N > 32) result = 0;
  else {
    const visited = new Array(N).fill(false);
    // 백트래킹 수행(조합)
    const backtracking = (idx, selected) => {
      if (selected.length === 3) {
        let sum = 0;
        sum +=
          distanceFunc(selected[0], selected[1]) +
          distanceFunc(selected[1], selected[2]) +
          distanceFunc(selected[2], selected[0]);
        result = Math.min(result, sum);
        return;
      }
      for (let i = idx + 1; i < N; i += 1) {
        if (!visited[i]) {
          visited[i] = true;
          backtracking(i, [...selected, listOfMBTI[i]]);
          visited[i] = false;
        }
      }
    };
    backtracking(-1, []);
  }
  answer += result + '\n';
  line += 2;
  T -= 1;
}

answer = answer.trimEnd();
console.log(answer);
