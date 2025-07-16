const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const W = +input[0]; // 추의 개수(<=30)
const weights = input[1].split(' ').map(Number); // 추의 무게들(<=500g)
const M = +input[2]; // 구슬의 개수(<=7)
const marble = input[3].split(' ').map(Number); // 구슬의 무게들(<=40,000)

// dp[i][j]: i번째 추 까지 사용했을 때 j 무게를 만들 수 있는지 판별
const dp = Array.from({ length: W + 1 }, () =>
  Array.from({ length: 30 * 500 + 1 }, () => false)
);
const compare = (index, weight) => {
  // 추의 개수를 넘었을 때 혹은 이미 만들 수 있는지 확인한 경우 리턴
  if (index > W || dp[index][weight]) return;
  dp[index][weight] = true; // 해당 무게 만들 수 있음 표시

  compare(index + 1, weight + weights[index]); // 추를 더했을 때(오른쪽에 두었을 때)
  compare(index + 1, Math.abs(weight - weights[index])); // 추들의 크기 비교(왼쪽에 두었을 때)
  compare(index + 1, weight); // 올리지 않았을 때
};

compare(0, 0); // 0개의 추 사용, 현재 추 무게 0

let answer = [];
for (const m of marble) {
  if (m > 15000) answer.push('N'); // 만들 수 있는 추의 무게를 넘었을 때
  else if (dp[W][m]) answer.push('Y');
  else answer.push('N');
}

console.log(answer.join(' '));
