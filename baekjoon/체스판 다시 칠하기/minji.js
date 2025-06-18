/**
 * 문제) 체스판 다시 칠하기
 * MXN 크기 보드를 8X8 크기의 체스판으로 자른 후 칠해야하는 정사각형의 최소 개수
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // N: 세로, M: 가로
const board = [];
for (let i = 1; i <= N; i++) {
  board.push(input[i].split('').map((b) => (b === 'W' ? 0 : 1)));
} // MXN 보드 상태

// 체스판을 색칠하는 2가지 경우(W: 0, B: 1)
const chess = [
  [
    [0, 1, 0, 1, 0, 1, 0, 1],
    [1, 0, 1, 0, 1, 0, 1, 0],
    [0, 1, 0, 1, 0, 1, 0, 1],
    [1, 0, 1, 0, 1, 0, 1, 0],
    [0, 1, 0, 1, 0, 1, 0, 1],
    [1, 0, 1, 0, 1, 0, 1, 0],
    [0, 1, 0, 1, 0, 1, 0, 1],
    [1, 0, 1, 0, 1, 0, 1, 0],
  ],
  [
    [1, 0, 1, 0, 1, 0, 1, 0],
    [0, 1, 0, 1, 0, 1, 0, 1],
    [1, 0, 1, 0, 1, 0, 1, 0],
    [0, 1, 0, 1, 0, 1, 0, 1],
    [1, 0, 1, 0, 1, 0, 1, 0],
    [0, 1, 0, 1, 0, 1, 0, 1],
    [1, 0, 1, 0, 1, 0, 1, 0],
    [0, 1, 0, 1, 0, 1, 0, 1],
  ],
];

const countChange = (startR, startC) => {
  const chessR = startR;
  const chessC = startC;
  let count = [0, 0];
  // 자른 영역의 다시 색칠해야 하는 체스판 개수 카운트
  for (let i = startR; i < startR + 8; i++) {
    for (let j = startC; j < startC + 8; j++) {
      if (board[i][j] !== chess[0][i - chessR][j - chessC]) count[0]++;
      if (board[i][j] !== chess[1][i - chessR][j - chessC]) count[1]++;
    }
  }
  return Math.min(...count);
};

let answer = Number.MAX_SAFE_INTEGER;
// 8X8을 자를 수 있는 범위에서 색을 다시 칠해야하는 최소값 갱신
for (let n = 0; n <= N - 8; n++) {
  for (let m = 0; m <= M - 8; m++) {
    answer = Math.min(answer, countChange(n, m));
  }
}

console.log(answer);
