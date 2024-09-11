const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 행렬 NXN
let paper = [];
for (let i = 1; i <= N; i += 1) {
  paper.push(input[i].split(' ').map(Number));
}

// 종이 내 다 같은 숫자인지 확인
function isTrue(row, col, size, num) {
  for (let i = row; i < row + size; i += 1) {
    for (let j = col; j < col + size; j += 1) {
      // 같은 숫자가 아닌 경우
      if (paper[i][j] !== num) return false;
    }
  }
  return true;
}

let result = Array.from({ length: 3 }, () => 0);
function divide(row, col, size) {
  let num = paper[row][col];
  if (isTrue(row, col, size, num)) {
    // 모두 다 같은 숫자로만 이루어진 종이인 경우
    if (num === -1) result[0] += 1;
    else if (num === 0) result[1] += 1;
    else if (num === 1) result[2] += 1;
  } else {
    // 같은 숫자가 아닌 경우 9개로 나누기
    // 9개로 나누려면 3*3형태로 나눠줘야함
    let newSize = parseInt(size / 3);
    for (let i = 0; i < 3; i += 1) {
      for (let j = 0; j < 3; j += 1)
        divide(row + i * newSize, col + j * newSize, newSize);
    }
  }
}
divide(0, 0, N);

result.forEach((r) => console.log(r));
