const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 문자의 개수
const RomanNumerals = [1, 5, 10, 50];

const sum = Array.from({ length: 50 * 20 + 1 }, () => 0); // 만들 수 있는 수 중복 없애기 위해 배열 이용
let count = 0; // 만들 수 있는 수의 개수

const dfs = (depth, idx, cum) => {
  // N개 다 이용했을 때
  if (depth === N) {
    // 처음 나온 결과값을 떄만 카운트 증가
    if (sum[cum] === 0) {
      sum[cum] = 1;
      count += 1;
    }
    return;
  }
  // ex) 1,5나 5,1이나 결과값을 동일하므로 중복 최소화하기 위해 idx부터 시작
  for (let i = idx; i < 4; i += 1) {
    dfs(depth + 1, i, cum + RomanNumerals[i]);
  }
};

dfs(0, 0, 0);

console.log(count);
