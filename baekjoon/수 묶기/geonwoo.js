const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

// 1. 0이 존재하면 isZero = true
// 2-1. 음수가 홀수개면? isZero가 있으면 절댓값이 가장 작은수 삭제 후 나머지는 절댓값이 큰 숫자부터 묶기
// 2-2. 음수가 짝수개면? 그냥 바로 절댓값이 큰 숫자부터 묶기
// 3. 양수중에 1은 ans에 바로 더한다. (묶으면 손해)
// 4-1. 양수가 홀수개면? 제일 작은 숫자는 더하고 나머지는 큰수부터 묶기
// 4-2. 양수가 짝수개면? 큰수부터 묶기

const N = +input[0];
const plus = [];
const minus = [];
let isZero = false;
let ans = 0;

for (let i = 1; i <= N; i++) {
  const num = +input[i];

  if (num === 0) isZero = true;
  else if (num === 1) ans++;
  else if (num < 0) minus.push(num);
  else plus.push(num);
}

plus.sort((o1, o2) => o2 - o1);
minus.sort((o1, o2) => o1 - o2);

if (plus.length % 2 !== 0) {
  ans += plus[plus.length - 1];
  plus.splice(-1);
}

for (let i = 0; i < plus.length; i += 2) {
  const a = plus[i];
  const b = plus[i + 1];

  ans += a * b;
}

if (minus.length % 2 !== 0) {
  if (!isZero) ans += minus[minus.length - 1];
  minus.splice(-1);
}

for (let i = 0; i < minus.length; i += 2) {
  const a = minus[i];
  const b = minus[i + 1];

  ans += a * b;
}

console.log(ans);
