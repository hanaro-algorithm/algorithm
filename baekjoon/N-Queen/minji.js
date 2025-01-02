const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];
const queens = [];

const isOkay = (x, y) => {
  for (const [queenX, queenY] of queens) {
    // 같은 행과 열에 위치하는지 확인
    if (queenX === x || queenY === y) return false;
    // 대각선 선상에 위치하는지 확인
    if (Math.abs(x - queenX) === Math.abs(y - queenY)) return false;
  }
  return true;
};

let cnt = 0;
const dfs = (row) => {
  if (row === N) cnt += 1; // 퀸 N개 배치 가능하므로 cnt 증가
  for (let col = 0; col < N; col += 1) {
    // 해당 위치에 퀸을 놓을 수 있는지 확인
    if (!isOkay(row, col)) continue;
    queens.push([row, col]); // 퀸 배치
    dfs(row + 1); // 다음 행
    queens.pop();
  }
};

dfs(0);
console.log(cnt);
