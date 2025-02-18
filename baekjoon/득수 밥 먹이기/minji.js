const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];

const planner = Array.from({ length: N }, () => new Array(5).fill(0));
const MOD = 1000000007;

for (let i = 0; i < 5; i += 1) planner[0][i] = 1;

for (let day = 1; day < N; day += 1) {
  planner[day][0] =
    (planner[day - 1][1] +
      planner[day - 1][2] +
      planner[day - 1][3] +
      planner[day - 1][4]) %
    MOD;
  planner[day][1] =
    (planner[day - 1][0] + planner[day - 1][3] + planner[day - 1][4]) % MOD;
  planner[day][2] = (planner[day - 1][0] + planner[day - 1][4]) % MOD;
  planner[day][3] = (planner[day - 1][0] + planner[day - 1][1]) % MOD;
  planner[day][4] =
    (planner[day - 1][0] + planner[day - 1][1] + planner[day - 1][2]) % MOD;
}

console.log(planner[N - 1].reduce((acc, cur) => acc + cur, 0) % MOD);
