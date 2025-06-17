/**
 * 문제) 우수 마을
 * 우수 마을의 주민 수 총합 구하기
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 마을의 수
const peopleOfCity = [0];
peopleOfCity.push(...input[1].split(' ').map(Number)); // 각 마을의 주민 수
const v = Array.from({ length: N + 1 }, () => []); // 인접한 마을 정보
for (let i = 2; i < N + 1; i++) {
  const [city1, city2] = input[i].split(' ').map(Number);
  v[city1].push(city2);
  v[city2].push(city1);
}

const dp = Array.from({ length: N + 1 }, () => new Array(2).fill(0)); // dp[마을번호][우수마을인지 아닌지(우수마을: 0, 우수마을X: 1)]

const dfs = (cityNum, parentCity) => {
  for (const nearCity of v[cityNum]) {
    if (nearCity !== parentCity) {
      dfs(nearCity, cityNum);
      // 부모 마을이 우수마을인 경우, 자식 마을은 우수마을이면 X
      dp[cityNum][0] += dp[nearCity][1];
      // 부모 마을이 우수마을이 아닌 경우,
      // 자식 마을은 우수마을이거나 우수마을 아닐 수 있음
      dp[cityNum][1] += Math.max(dp[nearCity][0], dp[nearCity][1]);
    }
  }
  dp[cityNum][0] += peopleOfCity[cityNum]; // 우수마을의 주민 수 더하기
};

dfs(1, 0);
console.log(Math.max(dp[1][0], dp[1][1]));
