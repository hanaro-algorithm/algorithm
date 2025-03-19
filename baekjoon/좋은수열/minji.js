/**
 * 문제) 좋은수열
 * 1,2,3으로만 이루어진 수열에서 인접한 두 개의 부분 수열이 동일하면 나쁜 수열 ex) 33, 32121323, 나머지는 좋은 수열
 * 길이가 N인 좋은 수열들 중 가장 작은 수 나타내는 수열 구하기
 *
 * 재귀
 * 1. 1부터 시작해서 수 길이가 N이 될 떄까지
 * 2. 1, 2, 3 를 넣어서 좋은 수열인지 확인
 * 3. 좋은 수열일 경우 다시 재귀 진행
 * 4. 가장 먼저 N이 된 수가 가장 작은 좋은 수열이므로 값 출력 후 종료
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const N = +input[0];

// 좋은 수열인지 확인
const isGood = (num) => {
  const len = num.length;
  for (let i = len - 1; i >= len / 2; i--) {
    const target = num.slice(i);
    const search = num.slice(0, i);
    if (search.endsWith(target)) return false;
  }
  return true;
};

const recursion = (num) => {
  if (num.length === N) {
    console.log(num);
    process.exit();
  }

  for (const n of [1, 2, 3]) {
    const newNum = num + n;
    if (isGood(newNum)) recursion(newNum);
  }
};

recursion('1');
