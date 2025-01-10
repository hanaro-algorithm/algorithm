const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
// 알파벳 획수
const NumberOfStrokes = {
  A: 3,
  B: 2,
  C: 1,
  D: 2,
  E: 3,
  F: 3,
  G: 2,
  H: 3,
  I: 3,
  J: 2,
  K: 2,
  L: 1,
  M: 2,
  N: 2,
  O: 1,
  P: 2,
  Q: 2,
  R: 2,
  S: 1,
  T: 2,
  U: 1,
  V: 1,
  W: 1,
  X: 2,
  Y: 2,
  Z: 1,
};
const A = input[0].split('');
const B = input[1].split('');

const strokes = [];
for (let i = 0; i < A.length; i += 1)
  strokes.push(NumberOfStrokes[A[i]], NumberOfStrokes[B[i]]);

for (let i = strokes.length; i > 2; i -= 1) {
  for (let j = 0; j < i - 1; j += 1)
    strokes[j] = (strokes[j] + strokes[j + 1]) % 10; // 궁합 계산
}

console.log(strokes[0].toString() + strokes[1].toString()); // 맨 앞 두자리만 더해주기
