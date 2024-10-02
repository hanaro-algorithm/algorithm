const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 과일 종류 수
const M = +input[1]; // 훔치려는 과일의 수

// 조합 함수 nCr = n-1Cr-1 + n-1Cr 공식 이용
function combinationFunc(n, r) {
  if (r === 0 || n === r) return 1;
  if (r === 1) return n;
  return combinationFunc(n - 1, r - 1) + combinationFunc(n - 1, r);
}

if (M - N === 0) return console.log(1);

// 종류별로 하나씩은 훔쳐야 하니까 N개 중 M-N개 중복조합구하기
const cnt = combinationFunc(M - 1, M - N); // nHr=n+r-1Cr 이용
console.log(cnt);
