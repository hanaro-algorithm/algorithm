const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const N = +input[0]; // 전구 묶음의 개수
const listOfBulb = []; // 전구 묶음의 각 전구의 앞과 뒤
let changeCnt = 0; // 이어 붙이지 않았을 때 전구의 변경 횟수
for (let i = 1; i < N + 1; i += 1) {
  const blubs = input[i].split('');
  blubs.reduce((prev, blub, idx) => {
    if (idx > 0 && prev !== blub) changeCnt += 1;
    return blub;
  }, blubs[0]);
  listOfBulb.push([+blubs[0], +blubs.at(-1)]);
}

const visited = new Array(N).fill(false);
let count = Number.MAX_SAFE_INTEGER;
const backtracking = (depth, prev, cnt) => {
  if (depth === N) count = Math.min(count, cnt);

  for (let i = 0; i < N; i += 1) {
    if (!visited[i]) {
      visited[i] = true;
      backtracking(
        depth + 1,
        listOfBulb[i][1],
        // 이어붙였을 때 앞의 전구의 맨 뒤와 같지 않으면 전구 횟수 카운트 증가
        cnt + (prev !== listOfBulb[i][0] ? 1 : 0)
      );
      visited[i] = false;
    }
  }
};

backtracking(0, -1, -1);
console.log(changeCnt + count);
