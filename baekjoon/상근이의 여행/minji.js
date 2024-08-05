const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let T = +input[0];

let line = 1;
while (T) {
  const [N, M] = input[line].split(' ').map(Number); // N: 국가의 수, M: 비행기 종류
  let planes = Array.from({ length: N + 1 }, () => []);
  for (let i = 1; i <= M; i += 1) {
    const [a, b] = input[line + i].split(' ').map(Number);
    planes[a].push(b);
    planes[b].push(a);
  }
  let country = new Set();
  let countPlane = 0;

  const dfs = (target) => {
    country.add(target);
    if (country.size === N) return;
    for (let p of planes[target]) {
      if (country.has(p)) continue;
      dfs(p);
      countPlane += 1;
    }
  };

  dfs(1);
  console.log(countPlane);
  line += M + 1;
  T -= 1;
}
