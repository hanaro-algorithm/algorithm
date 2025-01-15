const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 먹이의 정보 개수
const preyInfo = new Map(); // 연결 정보
let start = new Set(); // 시작 위치
for (let i = 1; i <= N; i += 1) {
  const [K, prey] = [
    input[i].split(' ')[0],
    input[i]
      .split(' ')
      .slice(1)
      .map((p, idx) => '--'.repeat(idx) + p),
  ];
  start.add(prey[0]);
  for (let i = 0; i < prey.length; i += 1) {
    const parent = prey.slice(0, i).join('');
    if (!parent) {
      if (!preyInfo.has(prey[i])) preyInfo.set(prey[i], []);
      continue;
    }
    if (preyInfo.has(parent)) {
      preyInfo.set(parent, new Set([...preyInfo.get(parent), prey[i]].sort()));
    } else {
      preyInfo.set(parent, [prey[i]]);
    }
  }
}

start = [...start].sort();
const tree = new Map([...preyInfo.entries()].sort()); // 같은 층인 경우 사전순으로 정렬
// console.log(tree)

let answer = '';
const dfs = (s, cur) => {
  answer += cur + '\n';
  if (!tree.has(s)) return;
  for (const q of tree.get(s)) dfs(s + q, q);
};

for (const s of start) dfs(s, s);

answer = answer.trimEnd();
console.log(answer);
