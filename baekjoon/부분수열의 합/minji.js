const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const [N, S] = input[0].split(" ").map(Number);
const sequence = input[1]
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b); // 수열 정보 오름차순 정렬

let answer = 0; // S를 만드는 부분 수열의 개수
const backtracking = (idx, acc) => {
  if (acc === S) answer++; // 해당 부분수열의 합이 S인 경우 카운트 증가

  for (let i = idx + 1; i < N; i++) {
    acc += sequence[i];
    backtracking(i, acc); // 더한 수로 백트래킹 수행
    acc -= sequence[i];
  }
};

for (let i = 0; i < N; i++) backtracking(i, sequence[i]);

console.log(answer);
