const fs = require('fs');
const input = fs.readFileSync(0).toString().split('\n');

const n = +input[0];
const m = +input[1];
const INF = Infinity;
const distance = Array.from({ length: n + 1 }, (_, r) =>
  Array.from({ length: n + 1 }, (_, c) => (r === c ? 0 : INF))
);

for (let i = 2; i < m + 2; i += 1) {
  const [a, b, c] = input[i].split(' ').map(Number);
  distance[a][b] = Math.min(c, distance[a][b]);
}

for (let k = 1; k <= n; k += 1) {
  for (let r = 1; r <= n; r += 1) {
    for (let c = 1; c <= n; c += 1) {
      if (distance[r][k] !== INF && distance[k][c] !== INF) {
        distance[r][c] = Math.min(
          distance[r][c],
          distance[r][k] + distance[k][c]
        );
      }
    }
  }
}

let answer = '';
for (let r = 1; r <= n; r += 1) {
  answer +=
    distance[r]
      .slice(1)
      .map((cost) => (cost === INF ? 0 : cost))
      .join(' ') + ' \n';
}
answer = answer.trimEnd();
console.log(answer);
